package top.trial.sort;

/**
 * �����������ʵ��
 * 
 * @author Gaoyx
 *
 */
public class RadixSort {

	public static final int ASCII_RANGE = 128;

	/**
	 * ��������δ�Ż�����
	 * 
	 * @param arrays
	 */
	public static void sortE1(String[] arrays) {

		int len = arrays.length;
		if (len <= 1) {
			return;
		}

		// �õ���󳤶�
		int maxLength = arrays[0].length();
		for (int i = 1; i < len; i++) {
			if (arrays[i].length() > maxLength)
				maxLength = arrays[i].length();
		}

		String[] sortedArray = new String[len];
		// ����Сλ��ʼѭ���Ƚ�
		for (int i = maxLength - 1; i >= 0; i--) {

			// ����Ϊ�����������ݣ��ȶ������
			int[] countArray = new int[ASCII_RANGE];

			for (int j = 0; j < len; j++)
				countArray[getCharIndex(arrays[j], i)]++;

			// ��һ���Ż�countArray
			for (int j = 1; j < ASCII_RANGE; j++)
				countArray[j] = countArray[j] + countArray[j - 1];

			// �������ԭʼ���飬�������������ȷλ��
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
