package top.trial.sort;

/**
 * 快速排序代码实现
 * 
 * @author gaoyx
 *
 */
public class QuickSort {

	/**
	 * 第一版快排，基准元素使用第一个元素，移动方式为挖坑法/指针交换法，未优化
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		// 挖坑法快排本体
		// sortE2(nums, 0, len - 1);

		// 指针交换法快排本体
		sortE3(nums, 0, len - 1);
	}

	/**
	 * 挖坑法快排本体
	 * 
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	private static void sortE2(int[] nums, int startIndex, int endIndex) {

		// 判断是否需要快排
		if (startIndex >= endIndex) {
			return;
		}

		// 取得基准元素
		int pivot = nums[startIndex];
		// 移动，将基准元素放置到合适位置并拿到基准元素位置索引，从而分成两个数组
		int index = startIndex;// 坑位
		int left = startIndex;
		int right = endIndex;
		while (left <= right) {
			while (left <= right) {
				if (pivot > nums[right]) {
					nums[left] = nums[right];
					index = right;
					left++;
					break;
				}
				right--;
			}
			while (left <= right) {
				if (pivot < nums[left]) {
					nums[right] = nums[left];
					index = left;
					right--;
					break;
				}
				left++;
			}
		}
		nums[index] = pivot;
		// 快排两部分数组
		sortE2(nums, startIndex, index - 1);
		sortE2(nums, index + 1, endIndex);
	}

	/**
	 * 指针交换法快排本体
	 * 
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	private static void sortE3(int[] nums, int startIndex, int endIndex) {
		// 判断是否需要快排
		if (startIndex >= endIndex) {
			return;
		}

		// 取得基准元素
		int pivot = nums[startIndex];
		// 移动，将基准元素放置到合适位置并拿到基准元素位置索引，从而分成两个数组
		int left = startIndex;
		int right = endIndex;
		while (left != right) {

			while (left < right && pivot < nums[right]) {
				right--;
			}
			while (left < right && pivot >= nums[left]) {
				left++;
			}
			if (left < right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}

		nums[startIndex] = nums[left];
		nums[left] = pivot;

		// 快排两部分数组
		sortE3(nums, startIndex, left - 1);
		sortE3(nums, left + 1, endIndex);
	}
}
