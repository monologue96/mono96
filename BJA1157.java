package Baekjoon_Algorithm;
import java.util.*;

public class BJA1157 {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		str = str.toUpperCase();	// ��ҹ��� �������� �����Ƿ� ��� ���ڸ� �빮�ڷ� ��ȯ
		int char_num;
		
		// a~z �� ���� �󵵸� ���� �迭 ����. ����ִ� �ε����� ���� ����ϸ� 0�̴�.
		int[] count = new int[26];	// �ܾ� ���̰� 1,000,000 �̶� �ܾ �̷�� ���ĺ��� �ִ� 26�����̴�.
		
		//�Ʒ� for���� A~Z (count�迭 �ε��� 0~25) �� �󵵼��� �����ϴ� �˰����̴�.
		for (int i = 0; i < str.length(); i++) {
			char_num = str.charAt(i);	// �� ������ �ƽ�Ű�ڵ� �������� char_num�� ����
			count[char_num - 65]++;	
			// count[0~25] �� ���� A~Z�� ���Ƚ������ ��Ÿ���� ���� 'A'�� �ƽ�Ű�ڵ� ������ 65�� ����.
		}
		
		// �Ʒ� �ּ�ó���� �ڵ�� ���ĺ����� Ƚ���� ����մϴ�. ������̹Ƿ� �ּ��� �����ϰ� ������� ������
		/*
			System.out.println("========================");
			System.out.println("���ĺ� ��ȣ" + "	" + "Ƚ��");
			System.out.println("========================");
	
			for (int i = 0; i < count.length; i++) {
				System.out.println(i + "      " + count[i] + "��");
			}
		*/
		
		
		int max=0;
		int max_char_num=0;		// �󵵼�(max)�� �ִ��� �ε��� ���� ������ ����
		for (int i=0; i<count.length ; i++) {
			if(max <= count[i]) {
				max = count[i];
				max_char_num = i;
			}
		}
		//System.out.println("���� ���� ���� ���ĺ� : " + (char)(max_char_num+65));
		
		
		int max_another = 0;
		
		// max_char_num �ε����� �����ϰ� ������ �ε����� ���� �ִ� �󵵼��� ���Ѵ�.
		for (int i=0; i<count.length ; i++) {
			if(i != max_char_num) {
				if(max_another <= count[i]) {
					max_another = count[i];
				}
			}
		}
		
		if(max == max_another)	
			// �󵵼��� ���� ���� ������ '?'���
			System.out.println("?");
		else System.out.println((char)(max_char_num + 65));
		// �󵵼��� �ִ��� ���ڰ� �ϳ����̸� �ش� ���ڸ� ���. 
		// �̶� max_char_num�� �ε������̹Ƿ� 'A'�� �ƽ�Ű�ڵ� ��������ŭ ������� �ش��ϴ� ���ĺ��� ��µȴ�.
	}
}
