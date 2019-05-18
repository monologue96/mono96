/*
 * WordExercise.java
 * monologue96
 */


import java.util.*;

class WordExercise {
	Scanner input = new Scanner(System.in);
	private String[] word_array = {"abbreviated","abide", "able"};
	private String[] meaning_array = {"단축된, 약자의, 간결하게 한", "머무르다, 살다", "할 수 있는, 유능한, 자격 있는"};
	
	// Q) WordExercise 클래스의 두 객체 toeic_word 와 toefl_word 를 생성할 때 word_array 내용이 각각 다르게 하고 싶은데...
	/*
	public WordExercise(int i) {
		switch (i) {
		case 1: 
			word_array = {"abbreviated","abide", "able"};
			meaning_array = {"단축된, 약자의, 간결하게 한", "머무르다, 살다", "할 수 있는, 유능한, 자격 있는"};
		}
	}
	*/
	
	// 초기화면 메소드
	public int showMainPage() {
		System.out.println("\n=========================================================================");
		System.out.println("| 1. 전체 단어 리스트  | 2. 단어 추가  | 3. 단어 삭제  | 4. 단어 수정  | 5. 검색  | 6. 초기화면  |");
		System.out.println("=========================================================================");
		System.out.print("\n 메뉴 번호 입력>> ");
		
		return input.nextInt();
	}
	
	// 모든 단어 리스트 표시 메소드
	public void getWordList() {
		System.out.println("\n=============현재 영단어 리스트=============\n");
		for(int i=0; i<word_array.length; i++) {
			System.out.println((i+1) + "   " + word_array[i] + "\n         " + meaning_array[i] + "\n");
		}
		System.out.println("=======================================");

	}
	
	// 단어 추가 메소드
	public boolean addWord() {
		
		System.out.println("\n현재 영단어 개수 : " + word_array.length);
		System.out.println("추가할 영단어 입력>> ");
		String eng = input.next();	// Q) nextLine 쓰면 아래 "뜻 입력>>" print문이 같이 실행되어 있음...
		
		System.out.println("뜻 입력>> ");
		String kor = input.next();
		
		System.out.println("\n[1. 리스트에 추가] | [2. 입력 취소]");	// Q) 1,2 외 다른 수 입력시 다시 입력하게 하는 예외처리 필요
		System.out.println("선택>> ");
		
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
	
	// 단어 삭제 메소드
	public boolean removeWord() {
		this.getWordList();		// 단어리스트 표시
		
		System.out.println("\n 삭제할 영단어 번호 입력 (취소하려면 0을 누르십시오) >> ");
		int index = input.nextInt();

		if(0 < index-1 && index-1 <= word_array.length) {
			// 영어 삭제
			List<String> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.remove(w_list.get(index-1));
			word_array = w_list.toArray(new String[w_list.size()]);
			
			// 뜻 삭제
			List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
			m_list.remove(m_list.get(index-1));
			meaning_array = m_list.toArray(new String[m_list.size()]);
			
			return true;
			
		}else if(index==0){
			return false;
		}else{
			System.out.println("입력한 번호에 해당하는 단어가 없습니다. 다시 입력하세요");	
			// Q) 만약에 다 삭제하고 없을 땐? -> 단어가 1개 이상 있을때만 삭제 함수가 실행되도록 처리해야할듯
			removeWord();
			return true;
		}
			
	}
		
	// 단어 수정 메소드	
	public boolean editWord() {
		
		System.out.println("-------------------------------------------------");
		System.out.println("| 1. 영어만 수정  | 2. 뜻만 수정   | 3. 둘 다 수정  |  4. 취소   |");
		System.out.println("-------------------------------------------------");

		System.out.println("옵션 선택>> ");
		int option = input.nextInt();
		if(1 <= option && option <=3) {
			this.getWordList();
			System.out.println("\n[수정할 단어 번호] >> ");
			int index = input.nextInt();
			
			if(0 < index-1 && index-1 <= word_array.length) {
				switch (option) {
				case 1:
					System.out.println("[수정내용 입력] >> ");
					String op1_eng = input.next();
					word_array[index-1] = op1_eng;
					break;
					
				case 2:
					System.out.println("수정내용 입력 >> ");
					String op2_kor = input.next();
					meaning_array[index-1] = op2_kor;
					break;
				case 3:
					System.out.println("영단어 수정내용 입력 >> ");
					String edit_eng = input.next();		// Q) 공백 포함하려고 nextLine 쓰고 실행시키면 이상하게 작동함..
					word_array[index-1] = edit_eng;
					
					System.out.println("뜻 수정내용 입력 >> ");
					String edit_kor = input.next();
					meaning_array[index-1] = edit_kor;
					break;
				}
			}
			return true;
		}else if(option == 4) {
			return false;
		}else {
			System.out.println("\n다시 입력하세요");
			editWord();
			return true;
		}
	}
	
	
	// 단어 조회 메소드
	public void findWord() {
		int found_word = 0;
		System.out.println("\n검색할 영단어 입력>> ");		// 정확하게 입력하지 않아도 유사한 것을 보여줄 수 없을까
		String target = input.next();
		
		System.out.println("\n===============<검색 결과>===============\n");
		for(int i=0 ; i<word_array.length ; i++) {
			if(target.equals(word_array[i])) {
				System.out.println((i+1) + "   " + word_array[i] + "\n         " + meaning_array[i]);
				found_word++;
			}else continue;
		}
		
		if (found_word == 0)
			System.out.println("해당하는 단어 없음");
		System.out.println("\n======================================\n");
	}
}
