package top.trial.sort;

/**
 * 基数排序代码实现
 * 
 * @author Gaoyx
 *
 */
public class RadixSort {

	public static final int ASCII_RANGE = 128;

	/**
	 * 基数排序未优化代码
	 * 
	 * @param arrays
	 */
	public static void sortE1(String[] arrays) {

		int len = arrays.length;
		if (len <= 1) {
			return;
		}

		// 得到最大长度
		int maxLength = arrays[0].length();
		for (int i = 1; i < len; i++) {
			if (arrays[i].length() > maxLength)
				maxLength = arrays[i].length();
		}

		String[] sortedArray = new String[len];
		// 从最小位开始循环比较
		for (int i = maxLength - 1; i >= 0; i--) {

			// 以下为计数排序内容，稳定排序版
			int[] countArray = new int[ASCII_RANGE];

			for (int j = 0; j < len; j++)
				countArray[getCharIndex(arrays[j], i)]++;

			// 进一步优化countArray
			for (int j = 1; j < ASCII_RANGE; j++)
				countArray[j] = countArray[j] + countArray[j - 1];

			// 倒序遍历原始数组，插入新数组的正确位置
			for (int j = len - 1; j >= 0; j--) {
				sortedArray[countArray[getCharIndex(arrays[j], i)] - 1] = arrays[j];
				countArray[getCharIndex(arrays[j], i)]--;
			}
			for (int j = 0; j < len; j++)
				arrays[j] = sortedArray[j];
		}
	}

	private static int getCharIndex(String string, int i) {
		if (string.length() < i + 1)
			return 0;
		return string.charAt(i);
	}
}
