package top.trial.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Ͱ�������ʵ�֣���������������棬
 * 
 * @author Gaoyx
 *
 */
public class BucketSort {

	/**
	 * Ͱ����δ�Ż����룬Ͱ������ԭʼ����Ԫ�ظ���
	 * 
	 * @param nums
	 */
	public static void sortE1(double[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		double max = nums[0];
		double min = nums[0];
		// �ҵ����ֵ����Сֵ
		for (int i = 1; i < len; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}

		// ��ʼ��Ͱ
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(len);
		for (int i = 0; i < len; i++) {
			bucketList.add(new LinkedList<Double>());
		}

		// �������飬��Ͱ
		for (int i = 0; i < len; i++) {
			int num = (int) ((nums[i] - min) * (len - 1) / (max - min));
			bucketList.get(num).add(nums[i]);
		}

		// Ͱ������ֱ��ʹ��Collections��sort����
		for (int i = 0; i < len; i++) {
			Collections.sort(bucketList.get(i));
		}

		// ���
		int index = 0;
		for (LinkedList<Double> list : bucketList) {
			for (Double num : list) {
				nums[index++] = num;
			}
		}
	}
}
