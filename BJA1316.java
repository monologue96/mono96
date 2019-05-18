package Baekjoon_Algorithm;
import java.util.*;

public class BJA1316 {
	static int groupcheck(String s) {	// 그룹 단어인지 체크하는 함수
		int is_dup = 0;		// 그룹 단어 조건에 반하는 인덱스 개수
		int is_group = 0;
		
		// 아래 for문은 그룹 단어인지 체크하는 알고리즘을 코드로 작성한 것
		for(int j=0 ; j<s.length()-2 ; j++) {
			for(int k=j+2 ; k<s.length() ; k++) {
				if((s.charAt(j) == s.charAt(k)) && (s.charAt(j) != s.charAt(j+1)))
					is_dup++;	
					continue;	
					// 예컨대, abaaa 라는 단어에서, 
					// 첫 번째 문자 a와 3번째 문자 a를 비교하여 첫 번째 문자가 그룹 단어 조건에 반한다는 것이 확인되면
					// 첫 번째 문자 a와 4~5번째 문자들은 비교할 필요가 없으니 곧바로 다음 인덱스에 대해 for문을 실행해도 된다.
			}
		}
		if(is_dup == 0)		// 모든 인덱스에 대해 그룹 단어 조건을 만족하는 경우
			is_group = 1;
		
		return is_group;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int group_word_num = 0;		//그룹 단어 개수
		int word_num = input.nextInt();		//단어 개수 입력
		
		for (int i=0; i<word_num ; i++) {
			String word = input.next();
			word = word.toUpperCase();
			
			// 단어를 이루는 문자 개수가 1개 혹은 2개이면 무조건 그룹 단어이다.
			// aa 는 연속하는 a로 이루어져 있으므로 그룹 단어이다.
			if(0 < word.length() && word.length() <= 2) {
				group_word_num++;
			}else {
				// n개의 단어들에 대해 groupcheck 의 반환값을 모두 더하면 그 값이 바로 n개의 단어들 중 그룹 단어의 개수를 나타낸다.
				group_word_num += groupcheck(word);
			}
		}
		
		System.out.println(group_word_num);		// 그룹 단어 개수 출력 
	}
}
