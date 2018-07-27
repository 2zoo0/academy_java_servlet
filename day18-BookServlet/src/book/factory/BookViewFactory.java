package book.factory;

import book.view.BookView;
import book.view.ErrorView;
import book.view.ListView;
import book.view.MessageView;
import book.view.SingleView;

/**
 * 매니저가 채택할 북뷰 객체 생성을 전문적으로 하는 클래스
 * @author PC38206
 *
 */
public class BookViewFactory {

	public static BookView getBookView(String type) {
		BookView view = null;
		
		if ("list".equals(type)) {
			view = new ListView();
		} else if ("single".equals(type)) {
			view = new SingleView();
		} else if ("message".equals(type)) {
			view = new MessageView();
		} else if ("error".equals(type)) {
			view = new ErrorView();
		}
		
		return view;
	} 
}