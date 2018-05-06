package shutDown;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class FileTree extends JFrame implements ActionListener{
	public static final ImageIcon ICON_COMPUTER = new ImageIcon("computer.jpg");
	public static final ImageIcon ICON_DISK = new ImageIcon("disk.gif");
	public static final ImageIcon ICON_FOLDER =new ImageIcon("folder.gif");
	public static final ImageIcon ICON_EXPANDEDFOLDER = new ImageIcon("folder.gif");
    public static final ImageIcon ICON_File = new ImageIcon("file.gif");
	protected JTree  m_tree;
	protected DefaultTreeModel m_model;
	protected JTextField m_display;
	protected JTextArea m_area;
	public FileTree(){
		super("文件管理器"); 
		setSize(800, 600);
        JMenuBar mBar = new JMenuBar();
		JMenu Menu1 = new JMenu("文件");
		JMenu Menu2 = new JMenu("编辑");
		JMenu Menu3 = new JMenu("查看");
		JMenu Menu4 = new JMenu("收藏");
		JMenu Menu5 = new JMenu("工具");
		JMenu Menu6 = new JMenu("帮助");
        mBar.add(Menu1);
        mBar.add(Menu2);
        mBar.add(Menu3);
        mBar.add(Menu4);
        mBar.add(Menu5);
        mBar.add(Menu6);
        JMenuItem m11=new JMenuItem("打开");
        JMenuItem m12=new JMenuItem("保存");
        JMenuItem m13=new JMenuItem("另存为");
        JMenuItem m14=new JMenuItem("新建");
        JMenuItem m15=new JMenuItem("退出");               
        JMenuItem m21=new JMenuItem("编辑");  
        JMenuItem m22=new JMenuItem("复制");  
        JMenuItem m23=new JMenuItem("粘贴");  
        JMenuItem m24=new JMenuItem("删除");
        JMenuItem m31=new JMenuItem("地址栏");
        JMenuItem m32=new JMenuItem("方式");
        JMenuItem m33=new JMenuItem("刷新");
        JMenuItem m41=new JMenuItem("添加到收藏夹");
        JMenuItem m51=new JMenuItem("文件夹选项");
        JMenuItem m61=new JMenuItem("关于主题");
        JMenuItem m62=new JMenuItem("作者信息");
        m11.addActionListener(this);
        m12.addActionListener(this);
        m13.addActionListener(this);
        m14.addActionListener(this);
        m15.addActionListener(this);
        m21.addActionListener(this);
        m22.addActionListener(this);
		m23.addActionListener(this);
		m24.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		m33.addActionListener(this);
		Menu1.add(m11);
		Menu1.add(m12);
		Menu1.add(m13);
		Menu1.add(m14);
		Menu1.add(m15);
		Menu2.add(m21);
		Menu2.add(m22);
		Menu2.add(m23);
		Menu2.add(m24);
		Menu3.add(m31);
		Menu3.add(m32);
		Menu3.add(m33);
		Menu4.add(m41);
		Menu5.add(m51);
		Menu6.add(m61);
		Menu6.add(m62);                          
		JToolBar toolBar=new JToolBar("tool");
		toolBar.setVisible(true);                                                  
		JButton btPre=new JButton("前进");
		JButton btBack=new JButton("后退");
		JButton btUp=new JButton("向上");
		JButton btFiles=new JButton("文件夹");
		JButton btSrarch=new JButton("搜索");
		toolBar.add(btPre);
		toolBar.add(btBack);
		toolBar.add(btUp);
		toolBar.add(btFiles);
		toolBar.add(btSrarch);
		setJMenuBar(mBar);
		this.getContentPane().add(toolBar,BorderLayout.NORTH);       
		toolBar.setFloatable(true);            
		this.setVisible(true);           
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(new IconData(ICON_COMPUTER, null, "我的电脑"));
		DefaultMutableTreeNode node;
		File[] roots = File.listRoots();
		for (int k=0; k<roots.length; k++){
			node = new DefaultMutableTreeNode(new IconData(ICON_DISK,null, new FileNode(roots[k])));
			top.add(node);
			node.add(new DefaultMutableTreeNode(new Boolean(true)));
		}
		m_model = new DefaultTreeModel(top);
		m_tree = new JTree(m_model);
		m_tree.putClientProperty("JTree.lineStyle", "Angled");
		TreeCellRenderer renderer = new	IconCellRenderer();
		m_tree.setCellRenderer(renderer);
		m_tree.addTreeExpansionListener(new	DirExpansionListener());
		m_tree.addTreeSelectionListener(new	DirSelectionListener());
		m_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		m_tree.setShowsRootHandles(true);
		m_tree.setEditable(false);
		JScrollPane s = new JScrollPane();
		s.getViewport().add(m_tree);
		m_area = new JTextArea();
		m_area.setEditable(false);
		JScrollPane sarea = new JScrollPane();
		sarea.getViewport().add(m_area);
		JSplitPane jp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,true,s,sarea);
		getContentPane().add(jp,BorderLayout.CENTER);  
		m_display = new JTextField();
		m_display.setEditable(false);
		getContentPane().add(m_display, BorderLayout.SOUTH);
		WindowListener wndCloser = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		addWindowListener(wndCloser);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("退出"))   
		System.exit(0);
    }
	DefaultMutableTreeNode getTreeNode(TreePath path){
		return (DefaultMutableTreeNode)(path.getLastPathComponent());
	}
	FileNode getFileNode(DefaultMutableTreeNode node){
		if (node == null)
			return null;
		Object obj = node.getUserObject();
		if (obj instanceof IconData)
			obj = ((IconData)obj).getObject();
		if (obj instanceof FileNode)
			return (FileNode)obj;
		else
			return null;
	}
	class DirExpansionListener implements TreeExpansionListener{
		public void treeExpanded(TreeExpansionEvent event){
			final DefaultMutableTreeNode node = getTreeNode(event.getPath());
			final FileNode fnode = getFileNode(node);
			Thread runner = new Thread(){
				public void run(){
					if (fnode != null && fnode.expand(node)){
						Runnable runnable = new Runnable(){
							public void run(){
								m_model.reload(node);
							}
						};
						SwingUtilities.invokeLater(runnable);
					}
				}
			};
			runner.start();
		}
		public void treeCollapsed(TreeExpansionEvent event) {}
	}
	class DirSelectionListener
	implements TreeSelectionListener{
		public void valueChanged(TreeSelectionEvent event){
			DefaultMutableTreeNode node = getTreeNode(event.getPath());
			FileNode fnode = getFileNode(node);
			if (fnode != null){
				m_display.setText(fnode.getFile().getAbsolutePath());
				File f = fnode.getFile();
				if(f.isFile() && f.getName().endsWith(".java")|| f.getName().endsWith(".txt") || f.getName().endsWith(".conf") ){
					try{
						BufferedReader in = new BufferedReader(new FileReader(f.getAbsoluteFile()));
						String line ;
						m_area.setText("");
						while( (line = in.readLine()) != null){
							m_area.append(line);
							m_area.append("\n");
							m_area.setEditable(true);
						}
					}catch(IOException e){
						e.printStackTrace();
					}
				}else{
					m_area.setText(f.toString()+f.lastModified()+f.length());
					m_area.setEditable(false);
				}
			}else{
				m_display.setText("");
			}
		}
	}	
	public static void main(String argv[]){
		new FileTree();
	}
}
class IconCellRenderer extends JLabel implements TreeCellRenderer{
	protected Color m_textSelectionColor;
	protected Color m_textNonSelectionColor;
	protected Color m_bkSelectionColor;
	protected Color m_bkNonSelectionColor;
	protected Color m_borderSelectionColor;
	protected boolean m_selected;
	public IconCellRenderer(){
		super();
		m_textSelectionColor = UIManager.getColor("Tree.selectionForeground");
		m_textNonSelectionColor = UIManager.getColor("Tree.textForeground");
		m_bkSelectionColor = UIManager.getColor("Tree.selectionBackground");
		m_bkNonSelectionColor = UIManager.getColor("Tree.textBackground");
		m_borderSelectionColor = UIManager.getColor("Tree.selectionBorderColor");
		setOpaque(false);
	}
	public Component getTreeCellRendererComponent
	(JTree tree,Object value, boolean sel, boolean expanded, boolean leaf,int row, boolean hasFocus){
		DefaultMutableTreeNode node =(DefaultMutableTreeNode)value;
		Object obj = node.getUserObject();
		setText(obj.toString());
		if (obj instanceof Boolean)
			setText("Retrieving data...");
		if (obj instanceof IconData){
			IconData idata = (IconData)obj;
			if (expanded)
				setIcon(idata.getExpandedIcon());
			else
				setIcon(idata.getIcon());
		}
		else
			setIcon(null);
			setFont(tree.getFont());
			setForeground(sel ? m_textSelectionColor :
			m_textNonSelectionColor);
			setBackground(sel ? m_bkSelectionColor :
			m_bkNonSelectionColor);
			m_selected = sel;
			return this;
	}
	public void paintComponent(Graphics g){
		Color bColor = getBackground();
		Icon icon = getIcon();
		g.setColor(bColor);
		int offset = 0;
		if(icon != null && getText() != null)
			offset = (icon.getIconWidth() + getIconTextGap());
			g.fillRect(offset, 0, getWidth() - 1 - offset,
			getHeight() - 1);
		if (m_selected){
			g.setColor(m_borderSelectionColor);
			g.drawRect(offset, 0, getWidth()-1-offset, getHeight()-1);
		}
		super.paintComponent(g);
	}
}


class IconData{
	protected Icon   m_icon;
	protected Icon   m_expandedIcon;
	protected Object m_data;
	public IconData(Icon icon, Object data){
		m_icon = icon;
		m_expandedIcon = null;
		m_data = data;
	}
	public IconData(Icon icon, Icon expandedIcon, Object data){
		m_icon = icon;
		m_expandedIcon = expandedIcon;
		m_data = data;
	}
	public Icon getIcon(){
		return m_icon;
	}
	public Icon getExpandedIcon(){
		return m_expandedIcon!=null ? m_expandedIcon : m_icon;
	}
	public Object getObject(){
		return m_data;
	}
	public String toString(){
		return m_data.toString();
	}
}



class FileNode{
	protected File m_file;
	public FileNode(File file){
		m_file = file;
	}
	public File getFile(){
		return m_file;
	}
	public String toString(){
		return m_file.getName().length() > 0 ? m_file.getName() :
		m_file.getPath();
	}
	public boolean expand(DefaultMutableTreeNode parent){
		DefaultMutableTreeNode flag =(DefaultMutableTreeNode)parent.getFirstChild();
		if (flag==null)
			return false;
		Object obj = flag.getUserObject(); 
		if (!(obj instanceof Boolean))
			return false;      
		parent.removeAllChildren(); 
		File[] files = listFiles();                                     
		if (files == null)
			return true;
		Vector v = new Vector();
		for (int k=0; k<files.length; k++){
			File f = files[k];
			FileNode newNode = new FileNode(f);
			boolean isAdded = false;
			for (int i=0; i<v.size(); i++){
				FileNode nd = (FileNode)v.elementAt(i);
				if (newNode.compareTo(nd) < 0){
					v.insertElementAt(nd, i);
					isAdded = true;
					break;
				}
			}
			if (!isAdded)
			v.addElement(newNode);
		}
		for (int i=0; i<v.size(); i++){     
			IconData idata;
			FileNode fnd = (FileNode)v.elementAt(i);
			if (fnd.hasSubDirs())
				idata = new IconData(FileTree.ICON_FOLDER,
				FileTree.ICON_EXPANDEDFOLDER, fnd);
			else
				idata = new IconData(FileTree.ICON_File,fnd);  
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(idata);
			parent.add(node);
			if (fnd.hasSubDirs())
				node.add(new DefaultMutableTreeNode(new Boolean(true)));
		}
		return true;
	}
	public boolean hasSubDirs() {
		File[] files = listFiles();
		if (files == null)
			return false;
		else
			return true;
	}
	public int compareTo(FileNode toCompare){
		return  m_file.getName().compareToIgnoreCase(toCompare.m_file.getName());
	}
	protected File[] listFiles(){
		if (!m_file.isDirectory())
			return null;
		try{
			return m_file.listFiles();
		}catch (Exception ex){
			JOptionPane.showMessageDialog
			(null,"Error reading directory "+m_file.getAbsolutePath(),"Warning", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
}