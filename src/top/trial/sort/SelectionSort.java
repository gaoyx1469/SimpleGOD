package top.trial.sort;

/**
 * ѡ���������ʵ��
 * 
 * @author gaoyx
 *
 */
public class SelectionSort {

	/**
	 * ��һ��ѡ������δ�Ż�
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return;
		for (int i = 0; i < len - 1; i++) {
			// ѡ��i��len-1�е���СԪ��
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			// ��СԪ����i����
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
	}
}
