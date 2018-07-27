package book.mapper;

import java.util.HashMap;
import java.util.List;

import book.vo.Book;

public interface BookMapper {
	

	int insert(Book book);
	int update(Book book);
	int delete();
	int delete(Book book);
	int totalCount();
	Book selectOne(Book book);
	List<Book> selectAll();
	List<Book> selectBounds(HashMap<String, Object> bounds);
	List<Book> selectKey(String keyword);
	String isExists(Book book);
	
}
