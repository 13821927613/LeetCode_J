/*
 * �������ְ������������ַ�: I�� V�� X�� L��C��D �� M��
	�ַ�          ��ֵ
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
	ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�
	����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
	I ���Է��� V(5) �� X(10) ����ߣ�����ʾ 4 �� 9��
	X ���Է��� L(50) �� C(100) ����ߣ�����ʾ 40 �� 90��
	C ���Է��� D(500) �� M(1000) ����ߣ�����ʾ 400 �� 900��
	����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
	ʾ�� 1:
		����: "III"
		��� : 3
	ʾ�� 2 :
		���� : "IV"
		��� : 4
	ʾ�� 3 :
		���� : "IX"
		��� : 9
	ʾ�� 4 :
		���� : "LVIII"
		��� : 58
		���� : L = 50, V = 5, III = 3.
	ʾ�� 5 :
		���� : "MCMXCIV"
		��� : 1994
		���� : M = 1000, CM = 900, XC = 90, IV = 4.
 * */
package String;

import java.util.*;

public class RomanToInteger 
{ 
	public static int Conversion(String roman)
	{
		final Map<Character, Integer> ROM = new HashMap<Character, Integer>()
		{
			private static final long serialVersionUID = 1L;
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			
			}			
		};
		int val = 0;
		int p, q, len;
		len = roman.length();
		p = 0;
		q = 1;
		while (p < len)
		{
			if (q == len)	//�������һλ
				val += ROM.get(roman.charAt(p++));
			else if (ROM.get(roman.charAt(p)) < ROM.get(roman.charAt(q)))
			{//С�����ڴ����ߵ����
				val += (ROM.get(roman.charAt(q)) - ROM.get(roman.charAt(p)));
				p += 2;
				q += 2;
			}
			else if (ROM.get(roman.charAt(p)) >= ROM.get(roman.charAt(q)))
			{//С�����ڴ���ұ�
				val += ROM.get(roman.charAt(p));
				p++;
				q++;
			}
				
		}
		return val;
	}
	public static void main(String[] args) 
	{
		String str = "III";
		int num = RomanToInteger.Conversion(str);
		System.out.println(num);
	}

}
