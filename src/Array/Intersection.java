package Array;

import java.util.*;

/**
 * @program: LeetCode_J
 * @description: �����������飬��дһ���������������ǵĽ�����
 * ��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ִ�������Сֵһ�¡�
 * ���ǿ��Բ�������������˳��
 * @author: huangrui
 * @create: 2020-07-13 15:48
 **/

/**
 * ˼·����������map,����keyΪnums1��nums2�е�Ԫ��,value��Ϊ��Ӧ���±��б�
 * ʹ��map�ж������Ƿ���ڽ���,Ϊ��֤Ԫ�س��ִ�����ͬ,������Ԫ�ص�һ�γ���ʱ�ż���������
 */
public class Intersection {

    public static int[] intersect(int[] nums1, int[] nums2) {

        long startTime=System.currentTimeMillis();

        //nums1ʼ��Ϊ�����н϶̵�����
        if (nums1.length >= nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        Map<Integer, List<Integer>> nums1Map = toMap(nums1);
        Map<Integer, List<Integer>> nums2Map = toMap(nums2);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums2Map.containsKey(nums1[i])) {
                List<Integer> position1 = nums1Map.get(nums1[i]);
                List<Integer> position2 = nums2Map.get(nums1[i]);
                if (i == position1.get(0)) {
                    if (position1.size() <= position2.size()) {
                        for (Integer j : position1) {
                            result.add(nums1[j]);
                        }
                    } else {
                        for (Integer j : position2) {
                            result.add(nums2[j]);
                        }
                    }
                }
            }
        }

        long endTime=System.currentTimeMillis();
        System.out.println("��������ʱ�䣺 "+(endTime - startTime)+"ms");
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<Integer, List<Integer>> toMap(int[] nums) {
        Map<Integer, List<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                List<Integer> values = numsMap.get(nums[i]);
                values.add(i);
                numsMap.put(nums[i], values);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(i);
                numsMap.put(nums[i], value);
            }
        }
        return numsMap;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[1000000];
        int[] nums2 = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < 1000000; i ++) {
            nums1[i] = r.nextInt();
            nums2[i] = r.nextInt();
        }

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
