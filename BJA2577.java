package Baekjoon_Algorithm;
import java.util.*;

public class BJA2577 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num = 1;	// A*B*C �� ������ ����
		boolean iserror = false;
		
		// A*B*C �� �ش��ϴ� for��
		for (int i=0; i<3 ; i++) {
			int input_num = input.nextInt();
			// ���� �˻�
			if(100 <= input_num && input_num < 1000)
				num *= input_num;
			else {
				iserror = true;
				break;
			}
		}
		
		if(iserror == false) {
			// num �� ���ڿ��� ��ȯ
			String str = Integer.toString(num);
			
			// num���� ���� i�� ���� �� ���� �������� ���
			for (int i=0 ; i<10 ; i++) {
				int val = 0;
				
				for (int j=0 ; j<str.length() ; j++) {
					if(str.charAt(j) == (i+48))
						// ��ȯ���� char���̹Ƿ� Ȯ���ϰ��� �ϴ� ���� i ���� �ƽ�Ű�ڵ� ���������� ��ȯ�ؾ� �Ѵ�.
						// ���� 0 �� �ƽ�Ű�ڵ� �������� 48
						val++;
				}
				System.out.println(val);
			}
		}
		
		
	}
}
