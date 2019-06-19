package top.trial.xml;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import top.trial.demo.entity.CityEntity;
import top.trial.demo.entity.ProvinceEntity;

/**
 * ʹ��XStream����JavaBean���л�Ϊxml��DEMO
 * 
 * @author Gaoyx
 *
 */
public class XStreamDemo {
	public static void main(String[] args) {

		// ��װList
		List<ProvinceEntity> provinces = getProvinces();

		// ��ȡXStream����
		XStream xstream = new XStream();
		xstream.alias("china", List.class);// ����Ԫ�ػ���china��ԭΪlist
		xstream.alias("province", ProvinceEntity.class);// ��ȫ������Ԫ�ػ�Ϊ����
		xstream.alias("city", CityEntity.class);// ��ȫ������Ԫ�ػ�Ϊ����
		xstream.useAttributeFor(ProvinceEntity.class, "name");// ��nameԪ�ش���Ԫ�ر������
		xstream.addImplicitCollection(ProvinceEntity.class, "cities");// ����Collection��������Ԫ�ر�ǩ
		xstream.omitField(CityEntity.class, "level");// ɾ��city�µ�level��ǩ����������

		// ��ʽ��List
		String xml = xstream.toXML(provinces);

		System.out.println(xml);
	}

	private static List<ProvinceEntity> getProvinces() {
		List<ProvinceEntity> provinces = new ArrayList<ProvinceEntity>();

		ProvinceEntity shandong = new ProvinceEntity();
		shandong.setName("ɽ��");
		shandong.setCities(new ArrayList<CityEntity>());
		provinces.add(shandong);

		CityEntity heze = new CityEntity();
		heze.setName("����");
		heze.setLevel(4);
		shandong.getCities().add(heze);

		CityEntity weihai = new CityEntity();
		weihai.setName("����");
		weihai.setLevel(3);
		shandong.getCities().add(weihai);

		CityEntity jinan = new CityEntity();
		jinan.setName("����");
		jinan.setLevel(2);
		shandong.getCities().add(jinan);

		ProvinceEntity guangdong = new ProvinceEntity();
		guangdong.setName("�㶫");
		guangdong.setCities(new ArrayList<CityEntity>());
		provinces.add(guangdong);

		CityEntity guangzhou = new CityEntity();
		guangzhou.setName("����");
		guangzhou.setLevel(2);
		guangdong.getCities().add(guangzhou);

		CityEntity shenzhen = new CityEntity();
		shenzhen.setName("����");
		shenzhen.setLevel(2);
		guangdong.getCities().add(shenzhen);

		CityEntity zhongshan = new CityEntity();
		zhongshan.setName("��ɽ");
		zhongshan.setLevel(3);
		guangdong.getCities().add(zhongshan);

		return provinces;
	}
}
