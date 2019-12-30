package top.trial.sort;

/**
 * ð���������ʾ��
 * 
 * @author gaoyx
 *
 */
public class BubbleSort {

	/**
	 * ��һ��ð������δ�Ż�
	 * 
	 * @param nums
	 */
	public static void sortE1(int nums[]) {
		int temp = 0;

		for (int i = 0; i < nums.length; i++) {
			// ѭ���Ƚ�ʱ������i���Ѿ����򣬲���Ҫ����ð��
			for (int j = 1; j < nums.length - i; j++) {
				// ���������
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	/**
	 * �ڶ���ð�������Ż��㣺��һ��ѭ��û�н��������ݣ�˵����ȫ���򣬿�����ѭ��
	 * 
	 * @param nums
	 */
	public static void sortE2(int nums[]) {
		int temp = 0;
		boolean isSorted = true;

		for (int i = 0; i < nums.length; i++) {
			// ѭ���Ƚ�ʱ������i���Ѿ����򣬲���Ҫ����ð��
			isSorted = true;
			for (int j = 1; j < nums.length - i; j++) {
				// ���������
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
				}
			}
			if (isSorted) {// isSortedΪtrue��˵����ѭ��ÿ�αȽ϶�δ�ı�˳��
				return;
			}
		}
	}

	/**
	 * ������ð�������Ż��㣺ÿ����������ɺ��ҵ���������ٽ�㣬������ÿ�ν�ǰ��һλ
	 * 
	 * @param nums
	 */
	public static void sortE3(int nums[]) {
		int temp = 0;
		boolean isSorted = true;// �Ƿ�������
		int sortedBorder = nums.length - 1;// �����ٽ�㣬��¼���һ�������λ��
		int lastExchangeIndex = 0;// ��¼��󽻻�λ�õ�����

		for (int i = 0; i < nums.length; i++) {
			// ѭ���Ƚ�ʱ������i���Ѿ����򣬲���Ҫ����ð��
			isSorted = true;
			lastExchangeIndex = 0;
			for (int j = 1; j < sortedBorder + 1; j++) {
				// ���������
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			sortedBorder = lastExchangeIndex - 1;
			if (isSorted) {// isSortedΪtrue��˵����ѭ��ÿ�αȽ϶�δ�ı�˳��
				return;
			}
		}
	}

	/**
	 * ���İ�ð�����򣬼�β�����򣬵���ð�ݱ��Ϊ˫��ð��
	 * 
	 * @param nums
	 */
	public static void sortE4(int nums[]) {
		int temp = 0;
		boolean isSorted = true;// �Ƿ�������
		int frontSortedBorder = 0;// �����ٽ�㣬��¼��һ�������λ��
		int behindSortedBorder = nums.length - 1;// �����ٽ�㣬��¼���һ�������λ��
		int lastExchangeIndex = 0;// ��¼��󽻻�λ�õ�����

		for (int i = 0; i < nums.length / 2; i++) {
			isSorted = true;
			for (int j = frontSortedBorder + 1; j < behindSortedBorder + 1; j++) {
				// ���������
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			behindSortedBorder = lastExchangeIndex - 1;
			if (isSorted) {// isSortedΪtrue��˵����ѭ��ÿ�αȽ϶�δ�ı�˳��
				return;
			}
			isSorted = true;
			for (int j = behindSortedBorder; j > frontSortedBorder; j--) {
				// ���������
				if (nums[j - 1] > nums[j]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					isSorted = false;
					lastExchangeIndex = j;
				}
			}
			frontSortedBorder = lastExchangeIndex;
			if (isSorted) {// isSortedΪtrue��˵����ѭ��ÿ�αȽ϶�δ�ı�˳��
				return;
			}
		}

	}
}
