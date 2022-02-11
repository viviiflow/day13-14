package day14;

import java.util.Scanner;

class Sr {
	int[] ids = { 1001, 1002, 1003, 1004, 1005 };
	int[] scores = new int[5];
}

public class score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sr std = new Sr();
		int sum = 0, cnt = 0;

		while (true) {
			System.out.println("<성적 관리 프로그램>");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 확인");
			System.out.println("3. 성적 출력(인덱스)");
			System.out.println("4. 성적 출력(학번)");
			System.out.println("5. 인덱스 출력");
			System.out.println("6. 종료");
			int slt = sc.nextInt();

			if (slt == 1) {
				for (int i = 0; i < std.ids.length; i++) {
					System.out.println((i + 1) + "번째 학생 점수 입력: ");
					std.scores[i] = sc.nextInt();
					sum += std.scores[i];
					if (std.scores[i] >= 60) {
						cnt++;
					}
				}
				System.out.println("성적 입력이 완료되었습니다.");
			}
			if (slt == 2) {
				System.out.println("전교생 총점: " + sum + "/평균: " + (sum / std.ids.length));
				int max = 0, idx = 0;
				for (int i = 0; i < std.scores.length; i++) {
					if (max < std.scores[i]) {
						max = std.scores[i];
						idx = i;
					}
				}
				System.out.println("1등: " + max + "점(" + std.ids[idx] + "학번)");
			}
			if (slt == 3) {
				System.out.println("인덱스 입력: ");
				int idx = sc.nextInt();
				if (idx >= std.ids.length) {
					System.out.println("존재하지 않습니다.");
				} else {
					System.out.println(std.scores[idx] + "점");
				}
			}
			if (slt == 4) {
				System.out.println("학번 입력: ");
				int num = sc.nextInt();
				try {
					System.out.println(std.scores[num - 1001] + "점");
				} catch (Exception e) {
					System.out.println("존재하지 않습니다.");
				}
			}
			if (slt == 5) {
				System.out.println("성적 입력: ");
				int scr = sc.nextInt();
				String data ="인덱스: ";
				for (int i = 0; i < std.ids.length; i++) {
					if (scr == std.scores[i]) {
						data+=i+", ";
					}
				}
				data = data.substring(0, data.length() - 2);
				System.out.println(data);
			}
			if (slt == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}

	}
}
