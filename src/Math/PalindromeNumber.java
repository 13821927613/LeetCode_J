/*�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
ʾ�� 1:
����: 121
	��� : true
	ʾ�� 2 :
	���� : -121
	��� : false
	���� : �������Ҷ�, Ϊ - 121 �� ���������, Ϊ 121 - �����������һ����������
	ʾ�� 3 :
	���� : 10
	��� : false
	���� : ���������, Ϊ 01 �����������һ����������
	���� :
	���ܲ�������תΪ�ַ�����������������
	*/
package Math;

public class PalindromeNumber 
{
	public static boolean Judgment(int num)
	{
		boolean isPN = false;
		if (num >= 0 && num < 10)
			return true;
		if (num < 0 || num % 10 == 0)
			return false;
		int temp = 0;
		while (num != 0)
		{
			temp = temp * 10 + num % 10;
			num = num / 10;
			if (temp == num || temp == num / 10)
			{
				isPN = true;
				break;
			}
		}
		return isPN;
	}

	public static void main(String[] args) 
	{
		int num = 10;
		boolean flag = PalindromeNumber.Judgment(num);
		System.out.println(flag);
	}

}
