package in.ineuron.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponseInfoServlet")
public class ResponseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		
		File file = new File("E:\\Amit\\person1.jpg");
		FileInputStream fis=new FileInputStream(file);
		
		//fis.read will give the value in long format, so type cast into int
		byte[] b = new byte [(int) fis.read()];
		fis.read(b); //reading into byte[] through inputStream
		
		ServletOutputStream stream=response.getOutputStream();
		stream.write(b); //writing from byte[] to response
		stream.flush(); 
		stream.close();
		fis.close();
		
		
	}

}
