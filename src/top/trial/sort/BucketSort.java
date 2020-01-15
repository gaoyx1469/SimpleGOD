package top.trial.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序代码实现，计数排序的升级版，
 * 
 * @author Gaoyx
 *
 */
public class BucketSort {

	/**
	 * 桶排序，未优化代码，桶数等于原始序列元素个数
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
		// 找到最大值和最小值
		for (int i = 1; i < len; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}

		// 初始化桶
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(len);
		for (int i = 0; i < len; i++) {
			bucketList.add(new LinkedList<Double>());
		}

		// 遍历数组，入桶
		for (int i = 0; i < len; i++) {
			int num = (int) ((nums[i] - min) * (len - 1) / (max - min));
			bucketList.get(num).add(nums[i]);
		}

		// 桶内排序，直接使用Collections的sort方法
		for (int i = 0; i < len; i++) {
			Collections.sort(bucketList.get(i));
		}

		// 输出
		int index = 0;
		for (LinkedList<Double> list : bucketList) {
			for (Double num : list) {
				nums[index++] = num;
			}
		}
	}
}
