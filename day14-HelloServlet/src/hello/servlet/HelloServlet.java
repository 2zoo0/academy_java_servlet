package hello.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
/**
 * 자바 서블릿으로  "안녕하세요, 서블릿" 메시지를 출력하는
 * 서블릿 클래스 이다.
 * 
 * 접속 주소는 2가지를 제공한다.
 * /HelloServlet, /hello
 * @author PC38207
 *
 */
@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * 상속받은 서블릿 LifeCycle 관련 메소드
	 * 
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
