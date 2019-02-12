package top.trial.demo.entity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数据库模拟类
 * 
 * @author 高宇翔
 *
 */
public class BookEntityDB {

	private static Map<String, BookEntity> books = new LinkedHashMap<>();

	static {
		books.put("1", new BookEntity("1", "《Linux入门》", "刘备", "刘家大叔亲笔", 8.18f));
		books.put("2", new BookEntity("2", "《微信小程序入门》", "关羽", "关家大叔亲笔", 7.18f));
		books.put("3", new BookEntity("3", "《Docker入门》", "张飞", "张家大叔亲笔", 6.18f));
		books.put("4", new BookEntity("4", "《Python入门》", "黄忠", "黄家大叔亲笔", 5.18f));
		books.put("5", new BookEntity("5", "《Spring入门》", "马超", "马家大叔亲笔", 4.18f));
		books.put("6", new BookEntity("6", "《云服务入门》", "赵云", "赵家大叔亲笔", 3.18f));
	}

	public static BookEntity getBook(String bookId) {
		return books.get(bookId);
	}

	public static Map<String, BookEntity> getAllBooks() {
		return books;
	}
}
