package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *  이 서블릿컨텍스트 리스너가 서비스 초기화 시점에
 *  구동이 되기 위해서는 web.xml 에 
 *  <listener> 등록되어야 함.
 *  혹은 클래스 작성시 @WebListener 에노테이션으로 등록
 * @author PC38207
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

	/**
	 * 서블릿 컨텍스트가 초기화 될 때
	 * 자동으로 수행되는 초기화 메소드
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 1. 이 서비스의 저체 정보를 다믄 컨텍스트 객체를 얻음
		ServletContext context;
		context = event.getServletContext();
		
		// 2. context 객체에서 이 서비스의 정보를 추출
		// (1) 실제 물리 경로를 확인
		String realPath = context.getRealPath("/");
		System.out.println("realPath : " + realPath);
		// (2) 논리 경로를 확인
		String ctxPath = context.getContextPath();
		System.out.println("ContextPath : " + ctxPath);
		// 3. web.xml 에 작성된 컨텍스트 초기화 파라미터 추출
		String dao = context.getInitParameter("dao");
		String appName = context.getInitParameter("appName");
		
		System.out.println("dao : " + dao + "\nappName : " + appName);
		
	}
	
	/**
	 * 서블릿 컨텍스트가 종료 될 때
	 * 자동으로 수행되는 정리 메소드
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {

		// 1. 종료하고 있는 서블릿 컨텍스트 객체를 얻어냄
		ServletContext context = event.getServletContext();
		
		// 2. appName 을 사용해서 종료메시지 출력
		String appName = context.getInitParameter("appName");
		System.out.printf("현재 %s 서비스를 종료합니다. %n", appName);
		
	}

}
