package top.trial.struts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * struts��Date����ת����
 * 
 * @author Gaoyx
 *
 */
public class DateConverter extends DefaultTypeConverter {

	/**
	 * context��ognl���ʽ������ value����������򷵻ز��� toType��ת�������� ����ֵΪת����Ĳ���
	 * 
	 */
	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {

		DateFormat df = new SimpleDateFormat("yyy/MM/dd");

		if (toType == Date.class) {// StringתDate,���������
			String dateString = ((String[]) value)[0];// ȡ����һ������ֵ
			try {
				return df.parse(dateString);
			} catch (ParseException e) {
				throw new RuntimeException();
			}
			// System.out.println(dateString);
		} else {// DateתString,�����Date����
			Date dValue = (Date) value;
			return df.format(dValue);
		}

	}

}
