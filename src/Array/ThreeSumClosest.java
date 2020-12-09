package Array;

import java.util.Arrays;

/**
 * @program: LeetCode_J
 * @description: ��ӽ�������֮��
 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ���
 * �������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * ˼·������˫ָ��
 * @author: huangrui
 * @create: 2020-12-09 10:20
 **/

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int minLength = 3;
        int sum = 0;
        if (nums.length <= minLength) {
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        Arrays.sort(nums);
        int result = 100000;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3,-2,-5,3,-4};
        int target = -1;
        System.out.println(threeSumClosest(nums, target));
    }
}
