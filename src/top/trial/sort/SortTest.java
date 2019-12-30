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

		BubbleSort.sortE4(nums);

		System.out.println(Arrays.toString(nums));
	}
}
