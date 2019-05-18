/*
 * WordExercise.java
 * monologue96
 */


import java.util.*;

class WordExercise {
	Scanner input = new Scanner(System.in);
	private String[] word_array = {"abbreviated","abide", "able"};
	private String[] meaning_array = {"�����, ������, �����ϰ� ��", "�ӹ�����, ���", "�� �� �ִ�, ������, �ڰ� �ִ�"};
	
	// Q) WordExercise Ŭ������ �� ��ü toeic_word �� toefl_word �� ������ �� word_array ������ ���� �ٸ��� �ϰ� ������...
	/*
	public WordExercise(int i) {
		switch (i) {
		case 1: 
			word_array = {"abbreviated","abide", "able"};
			meaning_array = {"�����, ������, �����ϰ� ��", "�ӹ�����, ���", "�� �� �ִ�, ������, �ڰ� �ִ�"};
		}
	}
	*/
	
	// �ʱ�ȭ�� �޼ҵ�
	public int showMainPage() {
		System.out.println("\n=========================================================================");
		System.out.println("| 1. ��ü �ܾ� ����Ʈ  | 2. �ܾ� �߰�  | 3. �ܾ� ����  | 4. �ܾ� ����  | 5. �˻�  | 6. �ʱ�ȭ��  |");
		System.out.println("=========================================================================");
		System.out.print("\n �޴� ��ȣ �Է�>> ");
		
		return input.nextInt();
	}
	
	// ��� �ܾ� ����Ʈ ǥ�� �޼ҵ�
	public void getWordList() {
		System.out.println("\n=============���� ���ܾ� ����Ʈ=============\n");
		for(int i=0; i<word_array.length; i++) {
			System.out.println((i+1) + "   " + word_array[i] + "\n         " + meaning_array[i] + "\n");
		}
		System.out.println("=======================================");

	}
	
	// �ܾ� �߰� �޼ҵ�
	public boolean addWord() {
		
		System.out.println("\n���� ���ܾ� ���� : " + word_array.length);
		System.out.println("�߰��� ���ܾ� �Է�>> ");
		String eng = input.next();	// Q) nextLine ���� �Ʒ� "�� �Է�>>" print���� ���� ����Ǿ� ����...
		
		System.out.println("�� �Է�>> ");
		String kor = input.next();
		
		System.out.println("\n[1. ����Ʈ�� �߰�] | [2. �Է� ���]");	// Q) 1,2 �� �ٸ� �� �Է½� �ٽ� �Է��ϰ� �ϴ� ����ó�� �ʿ�
		System.out.println("����>> ");
		
		if(input.nextInt()==1) {
			List<String> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.add(eng);
			word_array = w_list.toArray(new String[w_list.size()]);	
			
			List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
			m_list.add(kor);
			meaning_array = m_list.toArray(new String[m_list.size()]);
			
			return true;
		}else return false;
		
	}
	
	// �ܾ� ���� �޼ҵ�
	public boolean removeWord() {
		this.getWordList();		// �ܾ��Ʈ ǥ��
		
		System.out.println("\n ������ ���ܾ� ��ȣ �Է� (����Ϸ��� 0�� �����ʽÿ�) >> ");
		int index = input.nextInt();

		if(0 < index-1 && index-1 <= word_array.length) {
			// ���� ����
			List<String> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.remove(w_list.get(index-1));
			word_array = w_list.toArray(new String[w_list.size()]);
			
			// �� ����
			List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
			m_list.remove(m_list.get(index-1));
			meaning_array = m_list.toArray(new String[m_list.size()]);
			
			return true;
			
		}else if(index==0){
			return false;
		}else{
			System.out.println("�Է��� ��ȣ�� �ش��ϴ� �ܾ �����ϴ�. �ٽ� �Է��ϼ���");	
			// Q) ���࿡ �� �����ϰ� ���� ��? -> �ܾ 1�� �̻� �������� ���� �Լ��� ����ǵ��� ó���ؾ��ҵ�
			removeWord();
			return true;
		}
			
	}
		
	// �ܾ� ���� �޼ҵ�	
	public boolean editWord() {
		
		System.out.println("-------------------------------------------------");
		System.out.println("| 1. ��� ����  | 2. �游 ����   | 3. �� �� ����  |  4. ���   |");
		System.out.println("-------------------------------------------------");

		System.out.println("�ɼ� ����>> ");
		int option = input.nextInt();
		if(1 <= option && option <=3) {
			this.getWordList();
			System.out.println("\n[������ �ܾ� ��ȣ] >> ");
			int index = input.nextInt();
			
			if(0 < index-1 && index-1 <= word_array.length) {
				switch (option) {
				case 1:
					System.out.println("[�������� �Է�] >> ");
					String op1_eng = input.next();
					word_array[index-1] = op1_eng;
					break;
					
				case 2:
					System.out.println("�������� �Է� >> ");
					String op2_kor = input.next();
					meaning_array[index-1] = op2_kor;
					break;
				case 3:
					System.out.println("���ܾ� �������� �Է� >> ");
					String edit_eng = input.next();		// Q) ���� �����Ϸ��� nextLine ���� �����Ű�� �̻��ϰ� �۵���..
					word_array[index-1] = edit_eng;
					
					System.out.println("�� �������� �Է� >> ");
					String edit_kor = input.next();
					meaning_array[index-1] = edit_kor;
					break;
				}
			}
			return true;
		}else if(option == 4) {
			return false;
		}else {
			System.out.println("\n�ٽ� �Է��ϼ���");
			editWord();
			return true;
		}
	}
	
	
	// �ܾ� ��ȸ �޼ҵ�
	public void findWord() {
		int found_word = 0;
		System.out.println("\n�˻��� ���ܾ� �Է�>> ");		// ��Ȯ�ϰ� �Է����� �ʾƵ� ������ ���� ������ �� ������
		String target = input.next();
		
		System.out.println("\n===============<�˻� ���>===============\n");
		for(int i=0 ; i<word_array.length ; i++) {
			if(target.equals(word_array[i])) {
				System.out.println((i+1) + "   " + word_array[i] + "\n         " + meaning_array[i]);
				found_word++;
			}else continue;
		}
		
		if (found_word == 0)
			System.out.println("�ش��ϴ� �ܾ� ����");
		System.out.println("\n======================================\n");
	}
}
