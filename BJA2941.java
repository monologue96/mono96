package Baekjoon_Algorithm;
import java.util.*;

public class BJA2941 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		int len = str.length();
		
		int cro = 0;
		
		if(len<=100) {
			for (int i=0 ; i<len-1 ; i++) {
				if(str.charAt(i)=='c' && (str.charAt(i+1)=='=' || str.charAt(i+1)=='-')){
					cro++;
					i++;
					continue;	
					/* i��° �ε����� ���� for���� �����ϴ� ���� ũ�ξ�Ƽ�� ���ĺ����� Ȯ���ϸ�
					 * i+1��° �ε����� ���ؼ� for���� ������ �ʿ䰡 ����. �̹� i��° �ε����� �Բ� �ϳ��� ���ĺ��̶�� �����ϱ�.
					 * �� ���� ������ i++; continue; ���� �� ���̴�.
					 */
				}
				
				if(str.charAt(i)=='d' && str.charAt(i+1)=='z' && str.charAt(i+2)=='='){
					cro+=2;		
					// 'dz=' �� �ϳ��� ���ĺ��̹Ƿ� ���̰� 2 �����Ѵ�. �̴� ũ�ξ�Ƽ�� ���ĺ��� 2�� �ִ� �Ͱ� ����.
					i++;
					continue;
				}
					
				
				if((str.charAt(i)=='l' || str.charAt(i)=='n') && str.charAt(i+1)=='j'){
					cro++;
					i++;
					continue;
				}
				
				if(str.charAt(i)=='d' && str.charAt(i+1)=='-'){
					cro++;
					i++;
					continue;
				}
				
				if((str.charAt(i)=='s' || str.charAt(i)=='z') && str.charAt(i+1)=='='){
					cro++;
					i++;
					continue;
				}
			}
			System.out.println(len-cro);
		}

	}
}

