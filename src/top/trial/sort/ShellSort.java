package top.trial.sort;

/**
 * ϣ�������㷨ʵ��
 * 
 * @author gaoyx
 *
 */
public class ShellSort {

	/**
	 * ��һ��ϣ������
	 * @param nums
	 */
	public static void sortE1(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return;
		}

		int d = len;

		while (d > 1) {
			d = d / 2;// ϣ��������ÿ���۰�
			for (int x = 0; x < d; x++) {

				// ����Ϊ��������
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
