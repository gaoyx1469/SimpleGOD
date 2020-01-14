package top.trial.sort;

/**
 * �����������ʵ��
 * 
 * @author gaoyx
 *
 */
public class QuickSort {

	/**
	 * ��һ����ţ���׼Ԫ��ʹ�õ�һ��Ԫ�أ��ƶ���ʽΪ�ڿӷ�/ָ�뽻������δ�Ż�
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		// �ڿӷ����ű���
		// sortE2(nums, 0, len - 1);

		// ָ�뽻�������ű���
		sortE3(nums, 0, len - 1);
	}

	/**
	 * �ڿӷ����ű���
	 * 
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	private static void sortE2(int[] nums, int startIndex, int endIndex) {

		// �ж��Ƿ���Ҫ����
		if (startIndex >= endIndex) {
			return;
		}

		// ȡ�û�׼Ԫ��
		int pivot = nums[startIndex];
		// �ƶ�������׼Ԫ�ط��õ�����λ�ò��õ���׼Ԫ��λ���������Ӷ��ֳ���������
		int index = startIndex;// ��λ
		int left = startIndex;
		int right = endIndex;
		while (left <= right) {
			while (left <= right) {
				if (pivot > nums[right]) {
					nums[left] = nums[right];
					index = right;
					left++;
					break;
				}
				right--;
			}
			while (left <= right) {
				if (pivot < nums[left]) {
					nums[right] = nums[left];
					index = left;
					right--;
					break;
				}
				left++;
			}
		}
		nums[index] = pivot;
		// ��������������
		sortE2(nums, startIndex, index - 1);
		sortE2(nums, index + 1, endIndex);
	}

	/**
	 * ָ�뽻�������ű���
	 * 
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	private static void sortE3(int[] nums, int startIndex, int endIndex) {
		// �ж��Ƿ���Ҫ����
		if (startIndex >= endIndex) {
			return;
		}

		// ȡ�û�׼Ԫ��
		int pivot = nums[startIndex];
		// �ƶ�������׼Ԫ�ط��õ�����λ�ò��õ���׼Ԫ��λ���������Ӷ��ֳ���������
		int left = startIndex;
		int right = endIndex;
		while (left != right) {

			while (left < right && pivot < nums[right]) {
				right--;
			}
			while (left < right && pivot >= nums[left]) {
				left++;
			}
			if (left < right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}

		nums[startIndex] = nums[left];
		nums[left] = pivot;

		// ��������������
		sortE3(nums, startIndex, left - 1);
		sortE3(nums, left + 1, endIndex);
	}
}
