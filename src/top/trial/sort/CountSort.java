package top.trial.sort;

/**
 * �����������ʵ��
 * 
 * @author Gaoyx
 *
 */
public class CountSort {
	/**
	 * ��������δ�Ż��棬������������������
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}
		int max = nums[0];
		// �ҵ����ֵ
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
	 * ���������Ż��棬���Ż��¹�������ĳ���
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
		// �ҵ����ֵ
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
	 * ���������Ż��棬�Ż��¹�������ĳ����Լ��ȶ���
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
		// �ҵ����ֵ
		for (int i = 1; i < len; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}

		int[] countArray = new int[max + 1 - min];

		for (int i = 0; i < len; i++)
			countArray[nums[i] - min]++;

		// ��һ���Ż�countArray
		int sum = 0;
		for (int i = 0; i <= max - min; i++) {
			sum += countArray[i];
			countArray[i] = sum;
		}

		// �������ԭʼ���飬�������������ȷλ��
		int[] sortedArray = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			sortedArray[countArray[nums[i] - min] - 1] = nums[i];
			countArray[nums[i] - min]--;
		}
		for (int i = 0; i < len; i++)
			nums[i] = sortedArray[i];
	}
}
