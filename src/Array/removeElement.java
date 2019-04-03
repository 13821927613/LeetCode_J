/*����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 1:
���� nums = [3, 2, 2, 3], val = 3,
����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2:
���� nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2,
����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��
ע�������Ԫ�ؿ�Ϊ����˳��
�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�*/
package Array;

public class removeElement 
{
	public static int remove(int[] nums, int val)
	{
		int len_res = 0, len = nums.length;
		int i, j;
		for (i = 0; i < len && nums[i] != val; i++)
			len_res++;
		for (j = i + 1; j < len && nums[j] == val; j++);
		while(j < len)
		{
			if (nums[j] != val)
			{
				nums[i++] = nums[j++];
				len_res++;
			}
			else
				j++;
		}
		return len_res;
	}

	public static void main(String[] args) 
	{
		int[] nums = {0,4,4,0,4,4,4,0,2};
		int val = 4;
		int len = remove(nums, val);
		System.out.println("len = " + len);
		for (int i = 0; i < len; i ++)
			System.out.print(nums[i] + " ");
	}

}
