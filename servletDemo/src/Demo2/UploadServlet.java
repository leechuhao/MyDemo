package Demo2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file ;
	
	public void init() {
		filePath = getServletContext().getInitParameter("file-upload");
	}
	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException{
		//检查是否有文件上传请求
		isMultipart = ServletFileUpload.isMultipartContent(request);
		
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if(!isMultipart) {
			out.print(
					"<html><head>"
					+ "<title>Servlet upload</title>"
					+ "</head><body>"
					+ "<p>No file upload</p>"
					+ "</body></html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//在内存里设定文件最大值
		factory.setSizeThreshold(maxMemSize);
		//当文件大于最大值则存放在
		factory.setRepository(new File("C:\\Users\\brain\\Desktop"));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		//允许上传的文件最大值
		upload.setSizeMax(maxFileSize);
		
		try {
			List fileItems = upload.parseRequest(request);
			
			Iterator i = fileItems.iterator();
			
			out.print(
					"<html><head>"
					+ "<title>Servlet upload</title>"
					+ "</head><body>"
					);
			while(i.hasNext()) {
				FileItem fi = (FileItem)i.next();
				if(!fi.isFormField()) {
					//以下是上传文件的参数
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					
					//写入文件
					if(fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + 
								fileName.substring(fileName.lastIndexOf("\\")));
					}else {
						file = new File(filePath +
								fileName.substring(fileName.lastIndexOf("\\"))+1);
					}
					fi.write(file);
		            out.println("Uploaded Filename: " + fileName + "<br>");
				}
			}
			
			out.println("</body></html>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void doGet(HttpServletRequest request, 
            HttpServletResponse response)throws ServletException, java.io.IOException {

			throw new ServletException("GET method used with " + getClass( ).getName( )+": POST method required.");
	} 
}
