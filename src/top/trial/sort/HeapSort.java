package top.trial.sort;

import java.util.Arrays;

/**
 * ���������ʵ��
 * 
 * @author Gaoyx
 *
 */
public class HeapSort {

	/**
	 * ��һ�������δ�Ż�
	 * 
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		// �����������
		for (int i = len / 2 - 1; i >= 0; i--) {
			adjustLocation(nums, i, len);
		}
		System.out.println("����ѹ�����ϣ�" + Arrays.toString(nums));

		// ����
		for (int i = len - 1; i >= 0; i--) {
			// �Ѷ�Ϊ��������ֵ����δ�����������ֵ��
			// ���һ��Ԫ����Ѷ�����
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;

			adjustLocation(nums, 0, i);
		}
	}

	/**
	 * ������Ҷ�ӽ��λ�ã�С�ĸ�����³����ϴ��ӽ���ϸ�
	 * 
	 * @param nums
	 *            ����������
	 * @param index
	 *            ��Ҫ�³���Ԫ������
	 * @param len
	 *            ���������Ԫ�ظ���
	 */
	private static void adjustLocation(int[] nums, int index, int len) {
		int temp = nums[index];// Ҫ�����Ľ���ֵ
		int childIndex = index * 2 + 1;// ���ӽ�������
		while (childIndex < len) {// һֱ�³���ֱ��temp����ȫ���ӽ����ѳ�ΪҶ�ӽ�㣬�˴��ж��Ƿ���Ҷ�ӽڵ�

			// ����û���Һ��ӣ��ҵ������нϴ��һ��
			// ���巽ʽ�����Һ������Һ��Ӵ������ӣ���λ������
			if (childIndex + 1 < len && nums[childIndex] < nums[childIndex + 1]) {
				childIndex++;
			}

			// ���temp���ڽϴ��ӽ�㣬����ѭ��������Ҫ�����³�
			if (temp >= nums[childIndex])
				break;

			// �����³�
			nums[index] = nums[childIndex];
			index = childIndex;
			childIndex = childIndex * 2 + 1;
		}

		// �����³���index�����³�λ��
		nums[index] = temp;
	}
}
