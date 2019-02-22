package net.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServletŬ������ web.xml�� ������� �ʰ�
//AjaxTest ���� Ŭ������ �ܺο��� ���� �����ؼ� ȣ���Ҽ� �ִ�.
@WebServlet("/book.do")
public class BookTest extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// method=post���
		try {
			int bookIndex = Integer.parseInt(req.getParameter("book")); 
			String img[] = {"spring.jpg", "android.jpg", "jquery.jpg", "jsmasterbook.jpg"};
			
			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(img[bookIndex]);
			out.flush();
			out.close();
		}catch (Exception e) {
				System.out.println("ajax���� ����: " + e);
		}//try end
	}//doGet end
}//class end

