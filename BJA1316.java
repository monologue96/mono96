package Baekjoon_Algorithm;
import java.util.*;

public class BJA1316 {
	static int groupcheck(String s) {	// �׷� �ܾ����� üũ�ϴ� �Լ�
		int is_dup = 0;		// �׷� �ܾ� ���ǿ� ���ϴ� �ε��� ����
		int is_group = 0;
		
		// �Ʒ� for���� �׷� �ܾ����� üũ�ϴ� �˰����� �ڵ�� �ۼ��� ��
		for(int j=0 ; j<s.length()-2 ; j++) {
			for(int k=j+2 ; k<s.length() ; k++) {
				if((s.charAt(j) == s.charAt(k)) && (s.charAt(j) != s.charAt(j+1)))
					is_dup++;	
					continue;	
					// ������, abaaa ��� �ܾ��, 
					// ù ��° ���� a�� 3��° ���� a�� ���Ͽ� ù ��° ���ڰ� �׷� �ܾ� ���ǿ� ���Ѵٴ� ���� Ȯ�εǸ�
					// ù ��° ���� a�� 4~5��° ���ڵ��� ���� �ʿ䰡 ������ ��ٷ� ���� �ε����� ���� for���� �����ص� �ȴ�.
			}
		}
		if(is_dup == 0)		// ��� �ε����� ���� �׷� �ܾ� ������ �����ϴ� ���
			is_group = 1;
		
		return is_group;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int group_word_num = 0;		//�׷� �ܾ� ����
		int word_num = input.nextInt();		//�ܾ� ���� �Է�
		
		for (int i=0; i<word_num ; i++) {
			String word = input.next();
			word = word.toUpperCase();
			
			// �ܾ �̷�� ���� ������ 1�� Ȥ�� 2���̸� ������ �׷� �ܾ��̴�.
			// aa �� �����ϴ� a�� �̷���� �����Ƿ� �׷� �ܾ��̴�.
			if(0 < word.length() && word.length() <= 2) {
				group_word_num++;
			}else {
				// n���� �ܾ�鿡 ���� groupcheck �� ��ȯ���� ��� ���ϸ� �� ���� �ٷ� n���� �ܾ�� �� �׷� �ܾ��� ������ ��Ÿ����.
				group_word_num += groupcheck(word);
			}
		}
		
		System.out.println(group_word_num);		// �׷� �ܾ� ���� ��� 
	}
}
