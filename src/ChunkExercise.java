/*
 * ChunkExercise.java
 * monologue96
 */

import java.util.*;

class ChunkExercise {
	Scanner input = new Scanner(System.in);
	
	private String[] chunk_array = {"a few","as well", "because of..."};
	private String[] meaning_array = {"어느 정도, 조금, 약간", "게다가, 더욱이", "~때문에"};
	
	// 초기화면 메소드
	public int showMainPage() {
		System.out.println("\n==========================================================");
		System.out.println("| 1. 전체 숙어 리스트  | 2. 숙어 추가  | 3. 숙어 삭제  | 4. 검색  | 5. 종료  | ");
		System.out.println("==========================================================");
		System.out.print("\n 메뉴 번호 입력>> ");
		
		return input.nextInt();
	}
	// 모든 단어 리스트를 표시
	public void getChunkList() {
		for(int i=0; i<chunk_array.length; i++) 
			System.out.println((i+1) + "   " + chunk_array[i] + "\n         " + meaning_array[i] + "\n");
	}
	
	// 단어 추가
	public void addChunk() {
		System.out.println("현재 영숙어 개수 : " + chunk_array.length);
		System.out.println("추가할 영숙어 입력>> ");
		String eng = input.nextLine();	// 공백까지
		List<String> c_list = new ArrayList<>(Arrays.asList(chunk_array));
		c_list.add(eng);
		chunk_array = c_list.toArray(new String[c_list.size()]);
		
		System.out.println("뜻 입력>> ");
		String kor = input.nextLine();
		List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
		m_list.add(kor);
		meaning_array = m_list.toArray(new String[m_list.size()]);
	}
	
	// 단어 삭제
	public void removeChunk(String eng, String kor) {
			List<String> w_list = new ArrayList<>(Arrays.asList(chunk_array));
			w_list.remove(eng);
			chunk_array = w_list.toArray(new String[w_list.size()]);
			
			List<String> m_list = new ArrayList<>(Arrays.asList(meaning_array));
			m_list.remove(kor);
			meaning_array = m_list.toArray(new String[m_list.size()]);
		}
		
	// 단어 수정
	public void editChunkEng(int index, String eng) {
		chunk_array[index-1] = eng;
	}
	public void editChunkKor(int index, String kor) {
		meaning_array[index-1] = kor;
	}
	
	// 단어 조회
	public void findChunk(String target) {
		for(int i=0 ; i<chunk_array.length ; i++) {
			if(target.equals(chunk_array[i])) {
				System.out.println("\n<결과>\n");
				System.out.println((i+1) + "   " + chunk_array[i] + "\n         " + meaning_array[i] + "\n");
			}else continue;
		}
	}
}
