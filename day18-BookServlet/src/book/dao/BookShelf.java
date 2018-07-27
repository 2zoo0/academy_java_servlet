package book.dao;

import java.util.HashMap;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

public interface BookShelf {
	
	/**
	 * 
	 * @param book
	 * @return
	 * @throws DuplicateException
	 */
	public abstract int insert(Book book) throws DuplicateException;
	/**
	 * 
	 * @param book
	 * @return
	 * @throws NotFoundException
	 */
	public abstract int update(Book book) throws NotFoundException;
	/**
	 * 
	 * @param book
	 * @return
	 * @throws NotFoundException
	 */
	public abstract int delete(Book book) throws NotFoundException;
	/**
	 * 
	 * @param book
	 * @return
	 * @throws NotFoundException
	 */
	public abstract Book select(Book book) throws NotFoundException;
	/**
	 * 전체 도서 목록 
	 * @return List<Book>
	 */
	public abstract List<Book> select();
	
	public abstract List<Book> select(HashMap<String, Object> bounds);

	public abstract List<Book> select(String keyword);

	public abstract int totalCount();
	
	public abstract int delete();
}
