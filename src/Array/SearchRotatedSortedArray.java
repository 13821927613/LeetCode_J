package Array;

/**
 * @program: LeetCode_J
 * @description: ������ת��������
 * ����һ���������� nums ����һ������ target ��
 * ����������ԭ���ǰ��������У�������ʱ��Ԥ��δ֪��ĳ�����Ͻ�������ת�������磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2]
 * ���������������� target ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
 * ˼·��ʹ�ö��ֲ��ҷ������ȸ����м��������ұߵ����Ĵ�С��ϵȷ���Ĳ��ֵ�����������ģ����ж�Ŀ�������Ĳ��������С�
 * @author: huangrui
 * @create: 2020-11-17 10:30
 **/

public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > nums[high]) {
                //����м����������ұߵ���������벿���������
                if (target < nums[middle] && target >= nums[low]) {
                    //��Ŀ��������벿��
                    high = middle - 1;
                } else {
                    //Ŀ�������Ұ벿��
                    low = middle + 1;
                }
            } else {
                //����м���С�����ұߵ��������Ұ벿���������
                if (target > nums[middle] && target <= nums[high]) {
                    //��Ŀ�������Ұ벿��
                    low = middle + 1;
                } else {
                    //Ŀ��������벿��
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

        int[] nums = {5,6,7,0,1,2,4};
        int target = 0;
        int index = SearchRotatedSortedArray.search(nums, target);
        System.out.print(index);
    }
}
