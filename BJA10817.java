package Baekjoon_Algorithm;
import java.util.Scanner;

public class BJA10817 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
	
		String str = input.nextLine();
		String[] splits = str.split("\\s");		// 문자열을 공백을 기준으로 분리하여 splits 배열에 저장

		int errorcount = 0;		// 1이상 100 이하의 정수 조건을 만족하지 않는 정수 개수
	
        for (int i = 0 ; i < 3 ; i++) {
        	if((Integer.parseInt(splits[i])<1 || Integer.parseInt(splits[i])>100) == true)
        		errorcount++;
        }
        	
        if (errorcount<1){				// 세 수 모두 조건을 만족할 경우 비교 진행
    		
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
