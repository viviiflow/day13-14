package day14;

import java.util.Scanner;

class School {
	String name = "";
	int[] ids = { 1001, 1002, 1003, 1004, 1005 };
	int[] scores = { 92, 38, 87, 100, 11 };
}

public class score2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		School mega = new School();
		mega.name = "학생성적 관리 프로그램";
		while (true) {
			System.out.println("=== " + mega.name + " ===");
			System.out.println("1. 전교생 성적확인");
			System.out.println("2. 1등학생 성적확인");
			System.out.println("3. 꼴등학생 성적확인");
			System.out.println("4. 성적확인하기");
			System.out.println("5. 종료하기");
			int slt = sc.nextInt();

			if (slt == 1) {
				for (int i = 0; i < mega.ids.length; i++) {
					System.out.println(mega.ids[i] + "학번: " + mega.scores[i] + "점");
				}
			}
			if (slt == 2) {
				int max = 0, idx = 0;
				for (int i = 0; i < mega.scores.length; i++) {
					if (max < mega.scores[i]) {
						max = mega.scores[i];
						idx = i;
					}
				}
				System.out.println("1등: " + max + "점(" + mega.ids[idx] + "학번)");
			}
			if (slt == 3) {
				int min = 1000, idx = 0;
				for (int i = 0; i < mega.scores.length; i++) {
					if (min > mega.scores[i]) {
						min = mega.scores[i];
						idx = i;
					}
				}
				System.out.println("꼴등: " + min + "점(" + mega.ids[idx] + "학번)");
			}
			if (slt == 4) {
				System.out.println("학번 입력: ");
				int num = sc.nextInt();
				try {
					System.out.println(mega.scores[num - 1001] + "점");
				} catch (Exception e) {
					System.out.println("존재하지 않습니다.");
				}
			}
			if (slt == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
