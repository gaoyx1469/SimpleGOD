package top.trial.demo.entity;

/**
 * 图书JavaBean
 * 
 * @author Gaoyx
 *
 */
public class BookEntity {

	private String bookId;
	private String bookName;
	private String bookAuther;
	private String discription;
	private float price;

	public BookEntity() {
		super();
	}

	public BookEntity(String bookId, String bookName, String bookAuther, String discription, float price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
		this.discription = discription;
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuther() {
		return bookAuther;
	}

	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", bookAuther=" + bookAuther
				+ ", discription=" + discription + ", price=" + price + "]";
	}

}
