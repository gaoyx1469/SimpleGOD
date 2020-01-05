package top.trial.sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * ≈≈–Ú≤‚ ‘¿‡
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
		MergeSort.sortE1(nums);

		System.out.println(Arrays.toString(nums));
	}
}
