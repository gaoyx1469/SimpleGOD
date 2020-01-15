package top.trial.sort;

import java.util.Arrays;

/**
 * 插入排序代码实现
 * 
 * @author gaoyx
 *
 */
public class InsertionSort {

	/**
	 * 第一版排序代码实现，未优化
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return;
		for (int i = 1; i < len; i++) {
			int index = i;
			for (int j = i - 1; j >= 0 && nums[index] < nums[j]; j--) {
				int temp = nums[index];
				nums[index] = nums[j];
				nums[j] = temp;
				index = j;
			}
		}
	}

	/**
	 * 第二版排序代码实现，优化交换部分，减少交换次数
	 * 
	 * @param nums
	 */
	public static void sortE2(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return;
		for (int i = 1; i < len; i++) {
			int index = nums[i];
			int j = i - 1;
			for (; j >= 0 && index < nums[j]; j--) {
				nums[j + 1] = nums[j];
			}
			nums[j + 1] = index;
		}
	}
}
