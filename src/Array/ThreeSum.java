/*����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣
        ע�⣺���в����԰����ظ�����Ԫ�顣
        ����, �������� nums = [-1, 0, 1, 2, -1, -4]��
        ����Ҫ�����Ԫ�鼯��Ϊ��
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]

�ⷨ:������,����ÿһ��Ԫ��num[i],Ѱ��ʣ�µ����к�Ϊ-num[i]��������
ָ��j,k�ֱ�ָ����������num[i]֮���ʣ�µ�����,�ж�num[j] + num[k] �Ƿ����-num[i],
����,��i,j,k��������������뼯����;��С��,j������;������,k������*/

package Array;

import java.util.*;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> temp_res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }
            int target = 0 - nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k;){
                int plus = nums[j] + nums[k];
                if (plus == target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    j++;
                    k--;
                    temp_res.add(res);
                } else if (plus < target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        result.addAll(temp_res);

        return result;
    }

    public static void main(String[] Args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> res : result){
            for (Integer num : res){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

}
