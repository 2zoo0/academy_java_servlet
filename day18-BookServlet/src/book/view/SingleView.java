package book.view;

import book.vo.Book;

public class SingleView implements BookView {

	@Override
	public void display(Object object) {
		// TODO Auto-generated method stub
		Book book = (Book)object;
		book.print();
	}

}
