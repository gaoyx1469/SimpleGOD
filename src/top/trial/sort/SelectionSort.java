package top.trial.sort;

/**
 * 选择排序代码实现
 * 
 * @author gaoyx
 *
 */
public class SelectionSort {

	/**
	 * 第一版选择排序，未优化
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return;
		for (int i = 0; i < len - 1; i++) {
			// 选出i到len-1中的最小元素
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			// 最小元素与i交换
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
	}
}
