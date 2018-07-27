package book.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.mapper.BookMapper;
import book.mybatis.MybatisClient;
import book.vo.Book;

public class MybatisBookShelf implements BookShelf {

	private SqlSessionFactory factory;
	
	public MybatisBookShelf() {
		factory = MybatisClient.getFactory();
	}

	@Override
	public int insert(Book book) throws DuplicateException {
		
		if (isExists(book)) {
			throw new DuplicateException("추가", book);
		}
		
		SqlSession session = factory.openSession(true);
		int instCnt = 0;
		
		
		BookMapper mapper;
		mapper= session.getMapper(BookMapper.class);
		
		try {
			
			instCnt = mapper.insert(book);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return instCnt;
	}

	@Override
	public int update(Book book) throws NotFoundException {
		if(!isExists(book)) {
			throw new NotFoundException("수정", book);
		}
		
		int upCut = 0;
		
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		try {
			upCut = mapper.update(book);
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
			
		}
		
		return upCut;
	}

	@Override
	public int delete(Book book) throws NotFoundException {
		if(!isExists(book)) {
			throw new NotFoundException("삭제", book);
		}
		
		int delCut = 0;
		
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		try {
			delCut = mapper.delete(book);
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
			
		}
		
		return delCut;
	}

	@Override
	public Book select(Book book) throws NotFoundException {
		if(!isExists(book)) {
			throw new NotFoundException("조회", book);
		}
		
		Book found = null;
		
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		try {
			found = mapper.selectOne(book);
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
			
		}
		
		return found;
	}

	@Override
	public List<Book> select() {
		
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		List<Book> books = null;
		try {
			books = mapper.selectAll();
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
			
		}
		return books;
	}

	@Override
	public List<Book> select(HashMap<String, Object> bounds) {
		
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		List<Book> books = null;
		try {
			books = mapper.selectBounds(bounds);
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
			
		}
		return books;
	}

	@Override
	public List<Book> select(String keyword) {
		
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		List<Book> books = null;
		try {
			books = mapper.selectKey(keyword);
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
			
		}
		return books;
	}

	@Override
	public int totalCount() {
		SqlSession session = factory.openSession();
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		int ttCnt = 0;
		
		try {
			if (mapper.totalCount() >= 0) {
				ttCnt = mapper.totalCount();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return ttCnt;
	}

	@Override
	public int delete() {

		SqlSession session = factory.openSession(true);
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		int delCnt = 0;
		
		try {
			delCnt = mapper.delete();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return delCnt;
	}
	
	private boolean isExists(Book book) {
		boolean isExist = false;
		
		// 세션 열기
		SqlSession session = factory.openSession(true);
		// 인터페이스를 세션에서 얻기
		BookMapper mapper;
		mapper = session.getMapper(BookMapper.class);
		
		try {
			String bookId = mapper.isExists(book);
			if (bookId != null) {
				isExist = true;
			}
			
		} finally {
			
			if (session != null) {
				session.close();
			}
		}
		return isExist;
	}

}
