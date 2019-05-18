package Baekjoon_Algorithm;
import java.util.*;

public class BJA2577 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num = 1;	// A*B*C 를 저장할 변수
		boolean iserror = false;
		
		// A*B*C 에 해당하는 for문
		for (int i=0; i<3 ; i++) {
			int input_num = input.nextInt();
			// 조건 검사
			if(100 <= input_num && input_num < 1000)
				num *= input_num;
			else {
				iserror = true;
				break;
			}
		}
		
		if(iserror == false) {
			// num 을 문자열로 변환
			String str = Integer.toString(num);
			
			// num에서 숫자 i가 각각 몇 번씩 쓰였는지 출력
			for (int i=0 ; i<10 ; i++) {
				int val = 0;
				
				for (int j=0 ; j<str.length() ; j++) {
					if(str.charAt(j) == (i+48))
						// 반환값이 char형이므로 확인하고자 하는 숫자 i 역시 아스키코드 정수형으로 변환해야 한다.
						// 숫자 0 의 아스키코드 정수값은 48
						val++;
				}
				System.out.println(val);
			}
		}
		
		
	}
}
