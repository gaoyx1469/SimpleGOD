package top.trial.demo.entity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ݿ�ģ����
 * 
 * @author ������
 *
 */
public class BookEntityDB {

	private static Map<String, BookEntity> books = new LinkedHashMap<>();

	static {
		books.put("1", new BookEntity("1", "��Linux���š�", "����", "���Ҵ����ױ�", 8.18f));
		books.put("2", new BookEntity("2", "��΢��С�������š�", "����", "�ؼҴ����ױ�", 7.18f));
		books.put("3", new BookEntity("3", "��Docker���š�", "�ŷ�", "�żҴ����ױ�", 6.18f));
		books.put("4", new BookEntity("4", "��Python���š�", "����", "�ƼҴ����ױ�", 5.18f));
		books.put("5", new BookEntity("5", "��Spring���š�", "��", "��Ҵ����ױ�", 4.18f));
		books.put("6", new BookEntity("6", "���Ʒ������š�", "����", "�ԼҴ����ױ�", 3.18f));
	}

	public static BookEntity getBook(String bookId) {
		return books.get(bookId);
	}

	public static Map<String, BookEntity> getAllBooks() {
		return books;
	}
}
