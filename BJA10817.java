package Baekjoon_Algorithm;
import java.util.Scanner;

public class BJA10817 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
	
		String str = input.nextLine();
		String[] splits = str.split("\\s");		// ���ڿ��� ������ �������� �и��Ͽ� splits �迭�� ����

		int errorcount = 0;		// 1�̻� 100 ������ ���� ������ �������� �ʴ� ���� ����
	
        for (int i = 0 ; i < 3 ; i++) {
        	if((Integer.parseInt(splits[i])<1 || Integer.parseInt(splits[i])>100) == true)
        		errorcount++;
        }
        	
        if (errorcount<1){				// �� �� ��� ������ ������ ��� �� ����
    		
        	int a = Integer.parseInt(splits[0]);
        	int b = Integer.parseInt(splits[1]);
        	int c = Integer.parseInt(splits[2]);
        	
        	if (a>b) {
        		if (b>c)
        			System.out.println(b);
        		else {
        			if (a<c)
        				System.out.println(a);
        			else System.out.println(c);
        		}
        	}else if(a==b)
        		System.out.println(a);
        	else {
        		if (b<c)
        			System.out.println(b);
        		else if(b>c) {
        			if (a<c) 
        				System.out.println(c);
        			else if (a>=c)
        				System.out.println(a);
        		}
        		else System.out.println(b);
        	}
        }
	}
}
