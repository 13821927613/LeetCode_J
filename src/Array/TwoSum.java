/*����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
ʾ��:
���� nums = [2, 7, 11, 15], target = 9
��Ϊ nums[0] + nums[1] = 2 + 7 = 9
���Է��� [0, 1]*/
package Array;

import java.util.*;

public class TwoSum 
{
	public static int[] Search(int[] nums, int target)
	{
		int[] res = new int[2];
		boolean find = false;
		//Map�洢<��target�Ĳ�ֵ, �����±�>
		Map<Integer, Integer> dif = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (dif.get(nums[i]) != null)
			{
				res[0] = dif.get(nums[i]);
				res[1] = i;
				find = true;
				break;
			}
			dif.put(target - nums[i], i);
		}
		if (!find)
		{
			res[0] = -1;
			res[1] = -1;
		}
		return res;
	}

	public static void main(String[] args) 
	{
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res;
		res = TwoSum.Search(nums, target);
		for(int r : res){
		    System.out.println(r + " ");
        }
	}

}
