package top.trial.xml;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import top.trial.demo.entity.CityEntity;
import top.trial.demo.entity.ProvinceEntity;

/**
 * 使用XStream，将JavaBean序列化为xml的DEMO
 * 
 * @author Gaoyx
 *
 */
public class XStreamDemo {
	public static void main(String[] args) {

		// 组装List
		List<ProvinceEntity> provinces = getProvinces();

		// 获取XStream对象
		XStream xstream = new XStream();
		xstream.alias("china", List.class);// 将跟元素换成china，原为list
		xstream.alias("province", ProvinceEntity.class);// 将全类名的元素换为别名
		xstream.alias("city", CityEntity.class);// 将全类名的元素换为别名
		xstream.useAttributeFor(ProvinceEntity.class, "name");// 将name元素从子元素变成属性
		xstream.addImplicitCollection(ProvinceEntity.class, "cities");// 不让Collection本身生成元素标签
		xstream.omitField(CityEntity.class, "level");// 删除city下的level标签及其子内容

		// 格式化List
		String xml = xstream.toXML(provinces);

		System.out.println(xml);
	}

	private static List<ProvinceEntity> getProvinces() {
		List<ProvinceEntity> provinces = new ArrayList<ProvinceEntity>();

		ProvinceEntity shandong = new ProvinceEntity();
		shandong.setName("山东");
		shandong.setCities(new ArrayList<CityEntity>());
		provinces.add(shandong);

		CityEntity heze = new CityEntity();
		heze.setName("菏泽");
		heze.setLevel(4);
		shandong.getCities().add(heze);

		CityEntity weihai = new CityEntity();
		weihai.setName("威海");
		weihai.setLevel(3);
		shandong.getCities().add(weihai);

		CityEntity jinan = new CityEntity();
		jinan.setName("济南");
		jinan.setLevel(2);
		shandong.getCities().add(jinan);

		ProvinceEntity guangdong = new ProvinceEntity();
		guangdong.setName("广东");
		guangdong.setCities(new ArrayList<CityEntity>());
		provinces.add(guangdong);

		CityEntity guangzhou = new CityEntity();
		guangzhou.setName("广州");
		guangzhou.setLevel(2);
		guangdong.getCities().add(guangzhou);

		CityEntity shenzhen = new CityEntity();
		shenzhen.setName("深圳");
		shenzhen.setLevel(2);
		guangdong.getCities().add(shenzhen);

		CityEntity zhongshan = new CityEntity();
		zhongshan.setName("中山");
		zhongshan.setLevel(3);
		guangdong.getCities().add(zhongshan);

		return provinces;
	}
}
