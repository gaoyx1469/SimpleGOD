package top.trial.sort;

/**
 * 冒泡排序代码示例
 * 
 * @author gaoyx
 *
 */
public class BubbleSort {

	/**
	 * 第一版冒泡排序，未优化
	 * 
	 * @param nums
	 */
	public static void sortE1(int nums[]) {
		int temp = 0;

		for (int i = 0; i < nums.length; i++) {
			// 循环比较时，后面i个已经有序，不需要继续冒泡
			for (int j = 1; j < nums.length - i; j++) {
				// 大的往后排
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	/**
	 * 第二版冒泡排序，优化点：若一次循环没有交换的数据，说明完全有序，可跳出循环
	 * 
	 * @param nums
	 */
	public static void sortE2(int nums[]) {
		int temp = 0;
		boolean isSorted = true;

		for (int i = 0; i < nums.length; i++) {
			// 循环比较时，后面i个已经有序，不需要继续冒泡
			isSorted = true;
			for (int j = 1; j < nums.length - i; j++) {
				// 大的往后排
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
				}
			}
			if (isSorted) {// isSorted为true，说明内循环每次比较都未改变顺序
				return;
			}
		}
	}

	/**
	 * 第三版冒泡排序，优化点：每次内排序完成后找到已有序的临界点，而不是每次仅前进一位
	 * 
	 * @param nums
	 */
	public static void sortE3(int nums[]) {
		int temp = 0;
		boolean isSorted = true;// 是否已有序
		int sortedBorder = nums.length - 1;// 有序临界点，记录最后一个无序的位置
		int lastExchangeIndex = 0;// 记录最后交换位置的索引

		for (int i = 0; i < nums.length; i++) {
			// 循环比较时，后面i个已经有序，不需要继续冒泡
			isSorted = true;
			lastExchangeIndex = 0;
			for (int j = 1; j < sortedBorder + 1; j++) {
				// 大的往后排
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			sortedBorder = lastExchangeIndex - 1;
			if (isSorted) {// isSorted为true，说明内循环每次比较都未改变顺序
				return;
			}
		}
	}

	/**
	 * 第四版冒泡排序，鸡尾酒排序，单向冒泡变更为双向冒泡
	 * 
	 * @param nums
	 */
	public static void sortE4(int nums[]) {
		int temp = 0;
		boolean isSorted = true;// 是否已有序
		int frontSortedBorder = 0;// 有序临界点，记录第一个无序的位置
		int behindSortedBorder = nums.length - 1;// 有序临界点，记录最后一个无序的位置
		int lastExchangeIndex = 0;// 记录最后交换位置的索引

		for (int i = 0; i < nums.length / 2; i++) {
			isSorted = true;
			for (int j = frontSortedBorder + 1; j < behindSortedBorder + 1; j++) {
				// 大的往后排
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			behindSortedBorder = lastExchangeIndex - 1;
			if (isSorted) {// isSorted为true，说明内循环每次比较都未改变顺序
				return;
			}
			isSorted = true;
			for (int j = behindSortedBorder; j > frontSortedBorder; j--) {
				// 大的往后排
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			frontSortedBorder = lastExchangeIndex;
			if (isSorted) {// isSorted为true，说明内循环每次比较都未改变顺序
				return;
			}
		}

	}
}
