package Baekjoon_Algorithm;
import java.util.*;

public class BJA1157 {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		str = str.toUpperCase();	// 대소문자 구별하지 않으므로 모든 문자를 대문자로 변환
		int char_num;
		
		// a~z 의 출현 빈도를 담을 배열 생성. 비어있는 인덱스의 값을 출력하면 0이다.
		int[] count = new int[26];	// 단어 길이가 1,000,000 이라도 단어를 이루는 알파벳은 최대 26가지이다.
		
		//아래 for문은 A~Z (count배열 인덱스 0~25) 의 빈도수를 저장하는 알고리즘이다.
		for (int i = 0; i < str.length(); i++) {
			char_num = str.charAt(i);	// 각 문자의 아스키코드 정수값을 char_num에 저장
			count[char_num - 65]++;	
			// count[0~25] 이 각각 A~Z의 사용횟수임을 나타내기 위해 'A'의 아스키코드 정수값 65을 뺀다.
		}
		
		// 아래 주석처리된 코드는 알파벳별로 횟수를 출력합니다. 참고용이므로 주석을 제거하고 실행시켜 보세요
		/*
			System.out.println("========================");
			System.out.println("알파벳 번호" + "	" + "횟수");
			System.out.println("========================");
	
			for (int i = 0; i < count.length; i++) {
				System.out.println(i + "      " + count[i] + "번");
			}
		*/
		
		
		int max=0;
		int max_char_num=0;		// 빈도수(max)가 최대인 인덱스 값을 저장할 변수
		for (int i=0; i<count.length ; i++) {
			if(max <= count[i]) {
				max = count[i];
				max_char_num = i;
			}
		}
		//System.out.println("가장 많이 사용된 알파벳 : " + (char)(max_char_num+65));
		
		
		int max_another = 0;
		
		// max_char_num 인덱스를 제외하고 나머지 인덱스에 대해 최대 빈도수를 구한다.
		for (int i=0; i<count.length ; i++) {
			if(i != max_char_num) {
				if(max_another <= count[i]) {
					max_another = count[i];
				}
			}
		}
		
		if(max == max_another)	
			// 빈도수가 같은 것이 있으면 '?'출력
			System.out.println("?");
		else System.out.println((char)(max_char_num + 65));
		// 빈도수가 최대인 문자가 하나뿐이면 해당 문자를 출력. 
		// 이때 max_char_num는 인덱스값이므로 'A'의 아스키코드 정수값만큼 더해줘야 해당하는 알파벳이 출력된다.
	}
}
