package book.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

public class ListBookShelf implements BookShelf {

	private List<Book> books;
	
	
	
	public ListBookShelf() {
		books = new ArrayList<Book>();
	}

	public ListBookShelf(List<Book> books) {
		super();
		this.books = books;
	}



	@Override
	public int insert(Book book) throws DuplicateException {
		int successCnt = 0;
		
		if (findProductIdx(book) == -1) {
			books.add(book);
			successCnt++;
		} else {
			throw new DuplicateException("insert", book);
		}
		
		return successCnt;
	}

	
	@Override
	public int update(Book book) throws NotFoundException {
		int upIdx = findProductIdx(book);
		
		if (upIdx > -1) {
			books.set(upIdx, book);
		} else {
			throw new NotFoundException("update", book);
		}
		
		return upIdx;
	}

	@Override
	public int delete(Book book) throws NotFoundException {
		int delIdx = findProductIdx(book);
		
		if (delIdx > -1) {
			books.remove(delIdx);
		} else {
			throw new NotFoundException("delete", book);
		}
		
		return delIdx;
	}

	@Override
	public Book select(Book book) throws NotFoundException {
		int selIdx = findProductIdx(book);
		Book found = null;
		
		if (selIdx > -1) {
			found = books.get(selIdx);
		} else {
			throw new NotFoundException("select", book);
		}
		
		return found;
	}
	

	@Override
	public List<Book> select(String keyword) {
		List<Book> kwdFound = new ArrayList<Book>();
		for (Book book : this.books) {
			if(book.getTitle().contains(keyword)) {
				kwdFound.add(book);
			}
		}
		return kwdFound;
	}

	@Override
	public int totalCount() {
		int ttCnt = 0;
		for (Book book : books) {
			ttCnt++;
		}
		return ttCnt;
	}
	
	@Override
	public int delete() {
		int allDelIdx = 0;
		
		for (int idx = 0; idx < books.size(); idx++) {
			books.remove(idx);
			allDelIdx++;
		}
		
		return allDelIdx;
	}
	
	@Override
	public List<Book> select() {
		return this.books;
	}

	
	
	// 리스트 안에 찾으려는 책의 인덱스를 구하는 지원 메소드
		private int findProductIdx(Book book) {
			int index = -1;

			for (int idx = 0; idx < books.size(); idx++) {
				if (books.get(idx).equals(book)) {
					index = idx;
					break;
				}
			}
			
			return index;
		}

		@Override
		public List<Book> select(HashMap<String, Object> bounds) {
			List<Book> lhFound = new ArrayList<Book>();
			for (Book book : this.books) {
				
				if ((int)bounds.get("low") < book.getPrice() && (int)bounds.get("high") > book.getPrice()) {
					lhFound.add(book);
				}
			}
			
			return lhFound;
		}



}
