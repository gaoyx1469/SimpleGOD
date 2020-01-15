package top.trial.sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 排序测试类
 * 
 * @author gaoyx
 *
 */
public class SortTest {

	@Test
	public void sort() {
		int[] nums = { 5, 8, 6, 3, 9, 2, 1, 7, 6 };

		// BubbleSort.sortE4(nums);
		// SelectionSort.sortE1(nums);
		// InsertionSort.sortE1(nums);
		// ShellSort.sortE1(nums);
		// QuickSort.sortE1(nums);
		// MergeSort.sortE1(nums);
		// HeapSort.sortE1(nums);
		CountSort.sortE3(nums);

		double[] numsDouble = { 5.1, 8.1, 6.1, 3.1, 9.1, 2.1, 1.1, 7.1, 6.1 };
		BucketSort.sortE1(numsDouble);

		String[] stringArray = { "acdc", "efgy", "ejhf", "savfdbr", "df" };
		RadixSort.sortE1(stringArray);

		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(numsDouble));
		System.out.println(Arrays.toString(stringArray));
	}
}
