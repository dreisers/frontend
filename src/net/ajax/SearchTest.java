package net.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search.do")
public class SearchTest extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			String keyWord = req.getParameter("keyWord").trim();
			String message = ""; // ����޼���
			
			if(keyWord.length()>0) { //�˻�� �����ϴ���
				//��) �˻��� : ��
				// "�����α׷���" "��������" ��ȯ
				ArrayList<String> list = search(keyWord);
				
				//����޼��� -> ����|ã�����ڿ�,ã�����ڿ�,~~
				//�� -> 2|"�����α׷���","��������"
				int size = list.size();
				if(size>0) {
					message += size + "|";
					for(int idx=0; idx<size; idx++) {
						String word = list.get(idx);
						message += word;
						if(idx<size-1) {
						message += ",";
						System.out.println(message);
						System.out.println(size);
						}//if end
					}//for end
				}//if end
			}//if end
	//---------------------------------------------------------------------------
			resp.setContentType("text/plain); charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(message);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			System.out.println("ajax���� ����: " + e);
		}// try end
	}// doPost end
	
	//�˻��ϰ��� �ϴ� ���ڿ� ��� 
	public ArrayList<String> search(String keyWord){
		String[] keyWords = {"Ajax", "Ajax ���� ���α׷���", "�ڹ�", "�����α׷���", "��������", "�ڹ� ���α׷���", "������", "�ڶ�", "JSP ���α׷���", "�ڹ� �ȵ���̵�"};
		
		//keyWord�� keyWords�迭���� ù���ں��� ���غ��� ������ ArrayList�� �����ؼ� �����Ѵ�
		ArrayList<String > list = new ArrayList<>();
		for(String word : keyWords) {
			word = word.toUpperCase();
			if(word.startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}//if end
		}//for end 
		return list; //"�����α׷���" "��������"
	}//ArrayList end
}// class end
