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
@WebServlet("/test.do")
public class AjaxTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// method=get���
		try {
			resp.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = resp.getWriter(); //��°�ü
			out.println("�������� �������� �޼���:");
			out.println("����ȭ ���� �Ǿ����ϴ�");
			//buffer�� �ִ� �����͸� ���� �����ҷ� �о�� �޼ҵ�
			out.flush();
			//��°�ü �ݳ�
			out.close();
		}catch (Exception e) {
				System.out.println("ajax���� ����: " + e);
		}//try end
	}//doGet end
}//class end
