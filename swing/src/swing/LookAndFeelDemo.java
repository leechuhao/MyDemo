package swing;
import java.awt.*;

import java.awt.event.*;
  
 
  
import javax.swing.*;
  
 
  
public class LookAndFeelDemo  extends JFrame {
  
 
  
    private JRadioButton radio1  = new JRadioButton("Metal");
  
    private JRadioButton radio2  = new JRadioButton("Windows");
  
    private JRadioButton radio3  = new JRadioButton("Motif");
  
    private JPanel panelNorth = new JPanel();
  
    private JPanel panelSouth = new JPanel();
  
    private JTextArea area = new JTextArea(   );
  
    private JButton btn = new JButton("button");
  
    private JCheckBox chk = new JCheckBox("checkBox");
  
    private JComboBox cmbLookAndFeel = new JComboBox(new String[] { "Metal",
  
            "Widows", "Motif", "GTK" });
  
 
  
    public LookAndFeelDemo (String title) {
  
        super(title);
  
        Container contentPane = this.getContentPane();
  
        ButtonGroup group = new ButtonGroup();
  
        group.add(radio1);
  
        group.add(radio2 );
  
        group.add(radio3 );
  
 
  
        panelNorth.add(radio1 );
  
        panelNorth.add(radio2 );
  
        panelNorth.add(radio3 );
  
 
  
        panelSouth.add(btn);
  
        panelSouth.add(chk);
  
        panelSouth.add(cmbLookAndFeel);
  
 
  
        contentPane.add(panelNorth, BorderLayout.NORTH);
  
        contentPane.add(area, BorderLayout.CENTER);
  
        contentPane.add(panelSouth, BorderLayout.SOUTH);
  
        pack();
  
 
  
        setVisible(true);
  
        setSize( 600,600);
  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
 
  
        // ����Item�¼�
  
        radio1 .addItemListener(new MyItemListener());
  
        radio2 .addItemListener(new MyItemListener());
  
        radio3 .addItemListener(new MyItemListener());
  
 
  
    }
  
 
  
    private class MyItemListener implements ItemListener {
  
 
  
        public void itemStateChanged(ItemEvent e) {
  
            // ȡ�õ����ť������
  
            String itemName = ((JRadioButton) e.getSource()).getText();
  
            changeLookAndFeel(itemName);
  
        }
  
    }
  
 
  
    // ������۵�private���ͷ���
  
 
  
    private void changeLookAndFeel(String name) {
  
 
  
        String lookAndFeel = "";
  
        if (name.equals("Metal")) {
  
            lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
  
 
  
        } else if (name.equals("Windows")) {
  
            lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
  
        } else if (name.equals("Motif")) {
  
            lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
  
        }else{
  
            //ȡ��Ĭ�ϵ�metal���
  
            lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
  
        }
  
 
  
        try {
  
            UIManager.setLookAndFeel(lookAndFeel);
  
            // ����ʱָ��LookAndFeel����ҪSwingUtilities.updateComponentTreeUI��Component
  
            // c)ʵ�ֶ�̬�ĸ���
  
            SwingUtilities.updateComponentTreeUI(this);
  
            area.setText("��ǰ���������\n" + lookAndFeel);
  
        } catch (Exception ex) {
  
            ex.printStackTrace();
  
        }
  
 
  
    }
  
 
  
    public static void main(String[] args) {
  
        new LookAndFeelDemo ("LookAndFeel");
  
    }
  
}