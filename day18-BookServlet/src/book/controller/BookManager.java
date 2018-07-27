package book.controller;

import java.util.HashMap;
import java.util.List;

import book.dao.BookShelf;
import book.dao.ListBookShelf;
import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.view.BookView;
import book.view.ErrorView;
import book.view.ListView;
import book.view.MessageView;
import book.view.SingleView;
import book.vo.Book;

public class BookManager {

	private BookShelf bookShelf;
	private BookView bookView;
	
	
	// 생성자
	public BookManager() {
		bookShelf = new ListBookShelf();
	}
	
	public BookManager(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	// 접근 수정자
	public BookShelf getBookShelf() {
		return bookShelf;
	}

	public void setBookShelf(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	
	
	// 메소드들
	public void insert(Book book) {
		String message = null;
		
		try {
			bookShelf.insert(book);
			
			message = String.format("도서정보[%s]추가에 성공하였습니다."
					, book.getBookId());
			
			bookView = new MessageView();
				
		} catch (DuplicateException e) {
			message = String.format("도서정보[%s]추가에 실패하였습니다."
					, book.getBookId());
			
			bookView = new MessageView();
			e.printStackTrace();
			
		} finally {
			bookView.display(message);
		}
	}
	public void update(Book book) {
		int upIdx = 0;
		String message = null;
		try {
			upIdx = bookShelf.update(book);
			// 수정이 성공한 경우
			message = String.format("도서정보[%s]수정에 성공하였습니다.", book.getBookId());
			bookView = new MessageView();
			
		} catch (NotFoundException e) {
			// 수정이 실패한 경우
			message = String.format("도서정보[%s]수정에 실패하였습니다.", book.getBookId());
			bookView = new MessageView();
			e.printStackTrace();
		} finally {
			bookView.display(message);
		}
	}
	public void delete(Book book) {
		int delIdx = 0;
		String message = null;
		try {
			delIdx = bookShelf.delete(book);
			
			message = String.format("도서정보[%s]삭제에 성공하였습니다.", book.getBookId());
			
			bookView = new MessageView();
			
		} catch (NotFoundException e) {
			e.printStackTrace();
			message = String.format("도서정보[%s]삭제에 실패하였습니다.", book.getBookId());
			
			bookView = new ErrorView();
		} finally {
			bookView.display(message);
		}
	}
	public void select(Book book) {
		Book found = null;
		
		try {
			found = bookShelf.select(book);
			
			bookView = new SingleView();
			bookView.display(found);
			
		} catch (NotFoundException e) {
			bookView = new ErrorView();
			bookView.display("찾는 책[" +book.getBookId()+ "]이(가) 없습니다.");
			e.printStackTrace();
		}
	}
	
	
	
	public void select() {
		List<Book> books = bookShelf.select();
		bookView = new ListView();
		bookView.display(books);
	}
	
	public void select(HashMap<String, Object> bounds) {
		List<Book> books = bookShelf.select(bounds);
		bookView = new ListView();
		bookView.display(books);
	}
	
	public void select(String keyword) {
		List<Book> books = bookShelf.select(keyword);
		bookView = new ListView();
		bookView.display(books);
	}
	
	public void totalCount() {
		int ttCnt = bookShelf.totalCount();
		bookView = new MessageView();
		bookView.display("전체 책은 총 " + ttCnt + "권 입니다.");
	}
	
	public void delete() {
		int ddCnt = bookShelf.delete();
		bookView = new MessageView();
		bookView.display("삭제한 책은 총 " + ddCnt + "권 입니다.");
	}
	
}
