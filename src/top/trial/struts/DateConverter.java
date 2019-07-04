package top.trial.struts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * struts的Date类型转换器
 * 
 * @author Gaoyx
 *
 */
public class DateConverter extends DefaultTypeConverter {

	/**
	 * context：ognl表达式上下文 value：请求参数或返回参数 toType：转换的类型 返回值为转换后的参数
	 * 
	 */
	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {

		DateFormat df = new SimpleDateFormat("yyy/MM/dd");

		if (toType == Date.class) {// String转Date,入参是数组
			String dateString = ((String[]) value)[0];// 取到第一个输入值
			try {
				return df.parse(dateString);
			} catch (ParseException e) {
				throw new RuntimeException();
			}
			// System.out.println(dateString);
		} else {// Date转String,入参是Date类型
			Date dValue = (Date) value;
			return df.format(dValue);
		}

	}

}
