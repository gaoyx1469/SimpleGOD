package top.trial.sort;

/**
 * 归并排序代码实现
 * 
 * @author gaoyx
 *
 */
public class MergeSort {

	/**
	 * 第一版归并排序，未优化
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}
		// 归并排序本体
		sortE2(nums, 0, len - 1);
	}

	/**
	 * 归并排序本体，未优化版
	 * 
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	private static void sortE2(int[] nums, int startIndex, int endIndex) {

		// 判断是否需要归并
		if (startIndex >= endIndex) {
			return;
		}

		int mid = (startIndex + endIndex) / 2;

		// 将两边排序完成
		sortE2(nums, startIndex, mid);
		sortE2(nums, mid + 1, endIndex);

		int[] tempArray = new int[endIndex - startIndex + 1];
		int p1 = startIndex;
		int p2 = mid + 1;
		int p = 0;
		// 两边按顺序填入临时数组
		while (p1 <= mid && p2 <= endIndex) {
			if (nums[p1] <= nums[p2])
				tempArray[p++] = nums[p1++];
			else
				tempArray[p++] = nums[p2++];
		}
		// 剩余元素填入临时数组
		while (p1 <= mid) {
			tempArray[p++] = nums[p1++];
		}
		while (p2 <= endIndex) {
			tempArray[p++] = nums[p2++];
		}
		// 临时数组数据填回
		for (int i = 0; i < endIndex - startIndex + 1; i++) {
			nums[startIndex + i] = tempArray[i];
		}
	}
}
