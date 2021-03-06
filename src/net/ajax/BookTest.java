package net.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet클래스를 web.xml에 등록하지 않고
//AjaxTest 서블릿 클래스를 외부에서 직접 접근해서 호출할수 있다.
@WebServlet("/book.do")
public class BookTest extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// method=post방식
		try {
			int bookIndex = Integer.parseInt(req.getParameter("book")); 
			String img[] = {"spring.jpg", "android.jpg", "jquery.jpg", "jsmasterbook.jpg"};
			
			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(img[bookIndex]);
			out.flush();
			out.close();
		}catch (Exception e) {
				System.out.println("ajax응답 실패: " + e);
		}//try end
	}//doGet end
}//class end

