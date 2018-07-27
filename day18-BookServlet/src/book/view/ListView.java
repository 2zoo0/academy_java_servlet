package book.view;

import java.util.List;

import book.vo.Book;


public class ListView implements BookView {

	@Override
	public void display(Object object) {
		// TODO Auto-generated method stub
		List<Book> books = (List<Book>)object;
		for (Book book : books) {
			book.print();
		}
	}

}
