package top.trial.path;

import org.junit.Test;

import top.util.properties.PropertiesUtil;

/**
 * һ����ȫ���ļ���ȡ��ͨ�ð�
 * @author ������
 *
 */
public class PathGeneralTest {

	//��web�����¶�ȡ�ļ���ʵ��ʹ��ʱClassLoader����getResourceAsStream(url)��ȡ������
	@Test
	public void getPath () {
		// ͨ�������������ȡ·������·������classpath��
		String path1 = PropertiesUtil.class.getClassLoader().getResource("").toString();
		System.out.println(path1);
		String path2 = PropertiesUtil.class.getClassLoader().getResource("").getPath();
		System.out.println(path2);
		
		//�����WebContent��,���ʲ���Ѿ
		/*String path3 = PropertiesUtil.class.getClassLoader().getResource("../").getPath();
		System.out.println(path3);
		String path4 = PropertiesUtil.class.getClassLoader().getResource("../../WebContent/image/trial.bt.jpg").getPath();
		System.out.println(path4);
		String path5 = PropertiesUtil.class.getClassLoader().getResource("../../WebContent/WEB-INF/example/XMLExample.xml").getPath();
		System.out.println(path5);*/
	}
}
