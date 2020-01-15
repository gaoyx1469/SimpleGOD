package top.trial.sort;

/**
 * 希尔排序算法实现
 * 
 * @author gaoyx
 *
 */
public class ShellSort {

	/**
	 * 第一版希尔排序
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		int d = len;

		while (d > 1) {
			d = d / 2;// 希尔增量，每次折半
			for (int x = 0; x < d; x++) {

				// 以下为插入排序
				for (int y = x + d; y < len; y = y + d) {
					int temp = nums[y];
					int z = y - d;
					for (; z >= 0 && temp < nums[z]; z = z - d) {
						nums[z + d] = nums[z];
					}
					nums[z + d] = temp;
				}
			}
		}
	}
}
