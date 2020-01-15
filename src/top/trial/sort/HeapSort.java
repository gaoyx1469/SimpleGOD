package top.trial.sort;

import java.util.Arrays;

/**
 * 堆排序代码实现
 * 
 * @author Gaoyx
 *
 */
public class HeapSort {

	/**
	 * 第一版堆排序，未优化
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		// 构造最大二叉堆
		for (int i = len / 2 - 1; i >= 0; i--) {
			adjustLocation(nums, i, len);
		}
		System.out.println("二叉堆构造完毕：" + Arrays.toString(nums));

		// 排序
		for (int i = len - 1; i >= 0; i--) {
			// 堆顶为二叉堆最大值，（未排序数组最大值）
			// 最后一个元素与堆顶交换
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;

			adjustLocation(nums, 0, i);
		}
	}

	/**
	 * 调整非叶子结点位置，小的父结点下沉，较大子结点上浮
	 * 
	 * @param nums
	 *            待排序数组
	 * @param index
	 *            需要下沉的元素索引
	 * @param len
	 *            数组待排序元素个数
	 */
	private static void adjustLocation(int[] nums, int index, int len) {
		int temp = nums[index];// 要调整的结点的值
		int childIndex = index * 2 + 1;// 左子结点的索引
		while (childIndex < len) {// 一直下沉，直至temp大于全部子结点或已成为叶子结点，此处判断是否是叶子节点

			// 看有没有右孩子，找到孩子中较大的一个
			// 具体方式是有右孩子且右孩子大于左孩子，则定位到左孩子
			if (childIndex + 1 < len && nums[childIndex] < nums[childIndex + 1]) {
				childIndex++;
			}

			// 如果temp大于较大子结点，结束循环，不需要继续下沉
			if (temp >= nums[childIndex])
				break;

			// 继续下沉
			nums[index] = nums[childIndex];
			index = childIndex;
			childIndex = childIndex * 2 + 1;
		}

		// 结束下沉后，index就是下沉位置
		nums[index] = temp;
	}
}
