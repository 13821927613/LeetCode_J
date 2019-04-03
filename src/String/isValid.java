/*����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
��Ч�ַ��������㣺
1.�����ű�������ͬ���͵������űպϡ�
2.�����ű�������ȷ��˳��պϡ�
ע����ַ����ɱ���Ϊ����Ч�ַ�����
	ʾ�� 1:
	����: "()"
	��� : true
	ʾ�� 2 :
	���� : "()[]{}"
	��� : true
	ʾ�� 3 :
	���� : "(]"
	��� : false
	ʾ�� 4 :
	���� : "([)]"
	��� : false
	ʾ�� 5 :
	���� : "{[]}"
	��� : true*/
package String;

import java.util.*;

public class isValid 
{
	public static boolean judge(String str)
	{
		boolean isValid = true;
		Stack<Character> st = new Stack<Character>();
		int len = str.length();
		if (len == 0)
			return true;
		for (int i = 0; i < len && isValid; i++)
		{
			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
				st.push(str.charAt(i));
			if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']')
			{
				if (st.isEmpty())
				{
					isValid = false;
					break;
				}
				char temp = st.pop();
				switch (str.charAt(i))
				{
				case ')': isValid = (temp=='(') ? true : false;
				break;
				case '}': isValid = (temp=='{') ? true : false;
				break;
				case ']': isValid = (temp=='[') ? true : false;
				break;
				}
			}
		}
		if (!st.isEmpty())
			isValid = false;
		return isValid;
	}

	public static void main(String[] args) 
	{
		String str = "()";
		boolean isValid = judge(str);
		System.out.println(isValid);
	}

}
