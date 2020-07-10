package DynamicProgramming;

/**
 * @program: LeetCode_J
 * @description: ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�
 * Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 * @author: huangrui
 * @create: 2020-07-10 11:23
 **/

public class HouseRob {

    /**
     * ˼·��ά��һ������robMoney, robMoney[i]��ʾ���ٴ�0��i����������õ�����Ǯ,
     * ��֪robMoney[0]=nums[0],robMoney[1]=Max(nums[0], nums[1]);
     * ÿ�����������벻������״̬,��Ϊ�������������ڵķ���,�ʶԵ�i��������,��:num[i]+robMoney[i-2],����:robMoney[i-1]
     * ����robMoney[i]=Max(num[i]+robMoney[i-2],robMoney[i-1])
     * ��nums������ɺ�,robMoney�����һ��Ԫ�ؼ�Ϊ���ý�Ǯ���ֵ
     */

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] robMoney = new int[nums.length];
        robMoney[0] = nums[0];
        robMoney[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            robMoney[i] = Math.max(nums[i] + robMoney[i - 2], robMoney[i - 1]);
        }
        return robMoney[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
