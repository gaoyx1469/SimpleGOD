package top.trial.sort;

import java.util.Arrays;

/**
 * �����������ʵ��
 * 
 * @author gaoyx
 *
 */
public class InsertionSort {

	/**
	 * ��һ���������ʵ�֣�δ�Ż�
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
	 * �ڶ����������ʵ�֣��Ż��������֣����ٽ�������
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
