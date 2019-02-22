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
@WebServlet("/test.do")
public class AjaxTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// method=get방식
		try {
			resp.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = resp.getWriter(); //출력객체
			out.println("서버에서 응답해준 메세지:");
			out.println("무궁화 꽃이 피었습니다");
			//buffer에 있는 데이터를 최종 출력장소로 밀어내는 메소드
			out.flush();
			//출력객체 반납
			out.close();
		}catch (Exception e) {
				System.out.println("ajax응답 실패: " + e);
		}//try end
	}//doGet end
}//class end
