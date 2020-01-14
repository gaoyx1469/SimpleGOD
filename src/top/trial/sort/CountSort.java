package top.trial.sort;

/**
 * 计数排序代码实现
 * 
 * @author Gaoyx
 *
 */
public class CountSort {
	/**
	 * 计数排序未优化版，仅能排序正整数数组
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}
		int max = nums[0];
		// 找到最大值
		for (int i = 1; i < len; i++) {
			if (nums[i] > max)
				max = nums[i];
		}

		int[] countArray = new int[max + 1];

		for (int i = 0; i < len; i++)
			countArray[nums[i]]++;

		int l = 0;
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j < countArray[i]; j++)
				nums[l++] = i;
		}
	}

	/**
	 * 计数排序优化版，仅优化新构造数组的长度
	 * 
	 * @param nums
	 */
	public static void sortE2(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}
		int max = nums[0];
		int min = nums[0];
		// 找到最大值
		for (int i = 1; i < len; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}

		int[] countArray = new int[max + 1 - min];

		for (int i = 0; i < len; i++)
			countArray[nums[i] - min]++;

		int l = 0;
		for (int i = 0; i <= max - min; i++) {
			for (int j = 0; j < countArray[i]; j++)
				nums[l++] = i + min;
		}
	}

	/**
	 * 计数排序优化版，优化新构造数组的长度以及稳定性
	 * 
	 * @param nums
	 */
	public static void sortE3(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}
		int max = nums[0];
		int min = nums[0];
		// 找到最大值
		for (int i = 1; i < len; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}

		int[] countArray = new int[max + 1 - min];

		for (int i = 0; i < len; i++)
			countArray[nums[i] - min]++;

		// 进一步优化countArray
		int sum = 0;
		for (int i = 0; i <= max - min; i++) {
			sum += countArray[i];
			countArray[i] = sum;
		}

		// 倒序遍历原始数组，插入新数组的正确位置
		int[] sortedArray = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			sortedArray[countArray[nums[i] - min] - 1] = nums[i];
			countArray[nums[i] - min]--;
		}
		for (int i = 0; i < len; i++)
			nums[i] = sortedArray[i];
	}
}
