package top.trial.path;

import org.junit.Test;

import top.util.properties.PropertiesUtil;

/**
 * 一网打尽全部文件读取，通用版
 * @author Gaoyx
 *
 */
public class PathGeneralTest {

	//非web环境下读取文件，实际使用时ClassLoader调用getResourceAsStream(url)获取输入流
	@Test
	public void getPath () {
		// 通过类加载器，获取路径，根路径就在classpath下
		String path1 = PropertiesUtil.class.getClassLoader().getResource("").toString();
		System.out.println(path1);
		String path2 = PropertiesUtil.class.getClassLoader().getResource("").getPath();
		System.out.println(path2);
		
		//如果在WebContent下,访问不到丫
		/*String path3 = PropertiesUtil.class.getClassLoader().getResource("../").getPath();
		System.out.println(path3);
		String path4 = PropertiesUtil.class.getClassLoader().getResource("../../WebContent/image/trial.bt.jpg").getPath();
		System.out.println(path4);
		String path5 = PropertiesUtil.class.getClassLoader().getResource("../../WebContent/WEB-INF/example/XMLExample.xml").getPath();
		System.out.println(path5);*/
	}
}
