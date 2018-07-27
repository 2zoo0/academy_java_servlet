package book.dao;

import static java.sql.DriverManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

public class JdbcBookShelf implements BookShelf {

	private static final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	private static final String DRIVER = "oracle.jdbc.OracleDriver";

	// 2. 생성자 선언
	public JdbcBookShelf() {
		// 1. 드라이버 로드는 실행할 때 최초 1번만 수행하면 되므로
		
		try {
			Class.forName(DRIVER);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	CREATE TABLE book (
//	  bookid      VARCHAR2(5) 
//	, title       VARCHAR2(200)   NOT NULL
//	, author      VARCHAR2(50)    NOT NULL
//	, price       NUMBER(10)
//	, isbn        VARCHAR2(13)
//	, publish     VARCHAR2(30)
//	, regdate     DATE    DEFAULT sysdate
//	, moddate     DATE
//	, CONSTRAINT pk_book PRIMARY KEY(bookid)
//	);
	
	
	@Override
	public int insert(Book book) throws DuplicateException {
		
		if (isExists(book)) {
			throw new DuplicateException("추가", book);
		}
		
		int instCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			
			// 연결
			conn = getConnection(URL, USER, PASSWORD);
			
			// 쿼리 작성
			String sql = " INSERT INTO book(bookId, title, author, price, isbn, publish, moddate)"
			           + " VALUES (?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getIsbn());
			pstmt.setString(6, book.getPublish());
			
			// 쿼리 실행
			instCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 해제
			closeResources(null, pstmt, conn);
		}
		
		return instCnt;
	}

	@Override
	public int update(Book book) throws NotFoundException {
		
		if (!isExists(book)) {
			throw new NotFoundException("수정", book);
		}
		
		int upCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection(URL, USER, PASSWORD);
			
			String sql =  "UPDATE book b 			"
						+ "SET b.title = ?			"
						+ "  , b.author = ?			"
						+ "  , b.price = ?			"
						+ "  , b.isbn = ?			"
						+ "  , b.publish = ?		"
						+ "  , b.moddate = sysdate 	"
						+ " WHERE b.bookid = ? 		";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getIsbn());
			pstmt.setString(5, book.getPublish());
			pstmt.setString(6, book.getBookId());
			
			upCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(null, pstmt, conn);
		}
		return upCnt;
	}

	@Override
	public int delete(Book book) throws NotFoundException {

		if (!isExists(book)) {
			throw new NotFoundException("삭제", book);
		}
		
		int deleteCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection(URL, USER, PASSWORD);
			
			String sql = "DELETE FROM book WHERE bookid = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			
			deleteCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			closeResources(null, pstmt, conn);
		}
		
		return deleteCnt;
	}

	@Override
	public Book select(Book book) throws NotFoundException {
		
		if (!isExists(book)) {
			throw new NotFoundException("조회", book);
		}
		
		Book found = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// 커넥
			
			conn = getConnection(URL, USER, PASSWORD);
			
			// 쿼리
			
			String sql = ""
				+ "SELECT b.bookid" + 
					"     , b.title" + 
					"     , b.author" + 
					"     , b.price" + 
					"     , b.isbn" + 
					"     , b.publish" + 
					"  FROM book b" + 
					" WHERE b.bookid = ? " ;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
		
			// ----  쿼리 준비 끝
			
			// 쿼리 실행
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				String bookid = result.getString(1);
				String title = result.getString(2);
				String author = result.getString(3);
				int price = result.getInt(4);
				String isbn = result.getString(5);
				String publish = result.getString(6);
				
				found = new Book(bookid, title, author, price, isbn, publish);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(result, pstmt, conn);
		}
		return found;
	}

	@Override
	public List<Book> select() {
		// 0. 필요 객체 선언
		List<Book> books = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 커넥션 
			conn = getConnection(URL, USER, PASSWORD);
			
			// 쿼리 준비
			String sql = "SELECT bookid" + 
					"     , title" + 
					"     , author" + 
					"     , price" + 
					"     , isbn" + 
					"     , publish" + 
					"  FROM book" + 
					" ORDER BY bookid";
			
			pstmt = conn.prepareStatement(sql);
			
			// ----- 쿼리 준비 끝
			
			// 쿼리 실행
			result = pstmt.executeQuery();
			
			// 결과 
			while (result.next()) {
				String bookid = result.getString(1);
				String title = result.getString(2);
				String author = result.getString(3);
				int price = result.getInt(4);
				String isbn = result.getString(5);
				String publish = result.getString(6);
				
				Book book =  new Book(bookid, title, author, price, isbn, publish);
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			closeResources(result, pstmt, conn);
		}
		
		return books;
	}

	/**
	 * 
	 * @param book
	 * @return
	 */
	private boolean isExists(Book book) {
		boolean isExist = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;	
		
		try {
			// 2. 커넥션
			conn = getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.bookid" 
			           + "  FROM book b" 
					   + " WHERE b.bookid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId());
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				// 조회 결과가 있다는 뜻은 동일 제품 코드가 등록되었음
				isExist = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			closeResources(result, pstmt, conn);
		}
		
		return isExist;
	}
	
	
	private void closeResources(ResultSet result, PreparedStatement stmt, Connection conn) {
		try {
			if (result != null) {
				result.close();
			}
			if (stmt != null) {
				stmt.close();					
			}
			if (conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			System.err.println("자원 반납 에러");
			e.printStackTrace();
			
		}
	}

	@Override
	public List<Book> select(HashMap<String, Object> bounds) {
		
		List<Book> books = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// 커넥
			
			conn = getConnection(URL, USER, PASSWORD);
			
			// 쿼리
			
			String sql = "SELECT b.bookid" + 
					"     , b.title" + 
					"     , b.author" + 
					"     , b.price" + 
					"     , b.isbn" + 
					"     , b.publish" + 
					"  FROM book b" + 
					" WHERE b.price > ? AND b.price < ? " ;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int)bounds.get("low"));
			pstmt.setInt(2, (int)bounds.get("high"));
		
			// ----  쿼리 준비 끝
			
			// 쿼리 실행
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				String bookid = result.getString(1);
				String title = result.getString(2);
				String author = result.getString(3);
				int price = result.getInt(4);
				String isbn = result.getString(5);
				String publish = result.getString(6);
				Book book =  new Book(bookid, title, author, price, isbn, publish);
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(result, pstmt, conn);
		}
		return books;
	}

	@Override
	public List<Book> select(String keyword) {
		List<Book> books = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// 커넥
			
			conn = getConnection(URL, USER, PASSWORD);
			
			// 쿼리
			
			String sql = "SELECT b.bookid" + 
					"     , b.title" + 
					"     , b.author" + 
					"     , b.price" + 
					"     , b.isbn" + 
					"     , b.publish" + 
					"  FROM book b" + 
					" WHERE b.title LIKE '% " + keyword + "%'" ;
			
			pstmt = conn.prepareStatement(sql);
		
			// ----  쿼리 준비 끝
			
			// 쿼리 실행
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				String bookid = result.getString(1);
				String title = result.getString(2);
				String author = result.getString(3);
				int price = result.getInt(4);
				String isbn = result.getString(5);
				String publish = result.getString(6);
				Book book =  new Book(bookid, title, author, price, isbn, publish);
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(result, pstmt, conn);
		}
		return books;
	}

	@Override
	public int totalCount() {
		int rownum = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// 커넥
			
			conn = getConnection(URL, USER, PASSWORD);
			
			// 쿼리
			
			String sql = "select count(*) from book";
			
			pstmt = conn.prepareStatement(sql);
		
			// ----  쿼리 준비 끝
			
			// 쿼리 실행
			
			result = pstmt.executeQuery();
			while (result.next()) {
			rownum = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(result, pstmt, conn);
		}
		return rownum;
	}

	@Override
	public int delete() {
				
		int deleteCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			
			conn = getConnection(URL, USER, PASSWORD);
			
			String sql = "DELETE FROM book ";
			
			pstmt = conn.prepareStatement(sql);
			
			deleteCnt = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(result, pstmt, conn);
		}
		
		
		return deleteCnt;
	}

}
