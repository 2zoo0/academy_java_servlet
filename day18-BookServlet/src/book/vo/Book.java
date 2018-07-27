package book.vo;

public class Book {
	
	// 멤변
	private String bookId;  
	private String title;   
	private String author;  
	private int price; 
	private String isbn;    
	private String publish;
	private int ttCnt;
	
	// 생성자 
	/**
	 * 기본 생성자
	 */
	public Book() {
	}
	
	/**
	 * 
	 * @param bookId
	 */
	public Book(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * 
	 * @param bookId
	 * @param title
	 * @param author
	 * @param price
	 * @param isbn
	 * @param publish
	 */
	public Book(String bookId, String title, String author, int price, String isbn, String publish) {
		this(bookId);
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.publish = publish;
	}
	
	// 접근자들
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}

	public int getTtCnt() {
		return ttCnt;
	}

	public void setTtCnt(int ttCnt) {
		this.ttCnt = ttCnt;
	}

	public void print() {
		System.out.println("[bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price + ", isbn="
				+ isbn + ", publish=" + publish + "]");
	}
	
	
	
	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	/**
	 * equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "[bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price + ", isbn="
				+ isbn + ", publish=" + publish + "]";
	}
	
	
	
	
}
