/*��дһ�������������ַ��������е������ǰ׺��
��������ڹ���ǰ׺�����ؿ��ַ��� ""��
ʾ�� 1:
����: ["flower", "flow", "flight"]
	��� : "fl"
	ʾ�� 2 :
	���� : ["dog", "racecar", "car"]
	��� : ""
	���� : ���벻���ڹ���ǰ׺��
	˵�� :
	��������ֻ����Сд��ĸ a - z ��*/
package String;

public class longestCommonPrefix 
{
	public static String longest(String[] strs)
	{
		String ComPre = "";
		if (strs.length == 1)
			return strs[0];
		if (strs.length > 1 && strs[0].length() > 0)
		{	int len = strs[0].length();
			for (int i = 0; i < len; i++)
			{
				char curr = strs[0].charAt(i);
				for (int j = 1; j < strs.length; j++)
				{
					if (i > (int) strs[j].length() - 1 || strs[j].charAt(i) != curr)
						return ComPre;
					if (j == strs.length - 1)
						ComPre = ComPre + curr;
				}
			}
		}
		return ComPre;
	}
	public static void main(String[] args) 
	{
		String[] strs = {"dog", "racecar", "car"};
		String Common = longest(strs);
		System.out.println(Common);
	}

}
