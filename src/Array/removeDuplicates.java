/*����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
ʾ�� 1:
�������� nums = [1, 1, 2],
����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��
ʾ�� 2:
���� nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4],
����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�*/
package Array;

public class removeDuplicates 
{
	public static int remove(int[] nums)
	{
		int len_res = 0, len = nums.length;
		int i = 0, j = 1;
		if (len == 0)
			return 0;
		else if (len == 1)
			return 1;
		while (j < len)
		{		
			if (nums[i] != nums[j])
			{
				i++;
				j++;
			}
			else
			{
				i++;
				while (j < len && nums[i - 1] == nums[j])
					j++;
				if (j < len)
					nums[i] = nums[j];
			}
		}
		if (nums[j -1] == nums[i - 1])
			len_res = i;
		else
			len_res = i + 1;
		return len_res;
	}

	public static void main(String[] args) 
	{
		int[] nums = {1};
		int len = remove(nums);
		System.out.println("len = " + len);
		for (int i = 0; i < len; i ++)
			System.out.print(nums[i] + " ");
	}

}
