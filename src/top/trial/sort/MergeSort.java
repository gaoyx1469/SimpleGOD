package top.trial.sort;

/**
 * �鲢�������ʵ��
 * 
 * @author gaoyx
 *
 */
public class MergeSort {

	/**
	 * ��һ��鲢����δ�Ż�
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}
		// �鲢������
		sortE2(nums, 0, len - 1);
	}

	/**
	 * �鲢�����壬δ�Ż���
	 * 
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	private static void sortE2(int[] nums, int startIndex, int endIndex) {

		// �ж��Ƿ���Ҫ�鲢
		if (startIndex >= endIndex) {
			return;
		}

		int mid = (startIndex + endIndex) / 2;

		// �������������
		sortE2(nums, startIndex, mid);
		sortE2(nums, mid + 1, endIndex);

		int[] tempArray = new int[endIndex - startIndex + 1];
		int p1 = startIndex;
		int p2 = mid + 1;
		int p = 0;
		// ���߰�˳��������ʱ����
		while (p1 <= mid && p2 <= endIndex) {
			if (nums[p1] <= nums[p2])
				tempArray[p++] = nums[p1++];
			else
				tempArray[p++] = nums[p2++];
		}
		// ʣ��Ԫ��������ʱ����
		while (p1 <= mid) {
			tempArray[p++] = nums[p1++];
		}
		while (p2 <= endIndex) {
			tempArray[p++] = nums[p2++];
		}
		// ��ʱ�����������
		for (int i = 0; i < endIndex - startIndex + 1; i++) {
			nums[startIndex + i] = tempArray[i];
		}
	}
}
