package day14;

import java.util.Scanner;

class Movegame {
	int[] game = { 0, 0, 1, 0, 2, 0, 0, 1, 0 };
	int now = 4;
}

public class moveNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Movegame mg = new Movegame();

		while (true) {
			for (int i = 0; i < 9; i++) {
				if (mg.game[i] == 0) {
					System.out.print("0 ");
				} else if (mg.game[i] == 1) {
					System.out.print("벽 ");
				} else if (mg.game[i] == 2) {
					System.out.print("나 ");
				}
			}
			System.out.println("");
			System.out.println("왼쪽(1) 오른쪽(2) 종료(0)");
			int num = sc.nextInt();

			if (num == 0) {
				System.out.println("게임 종료");
				break;
			}

			if (num == 1) {
				try {
					if (mg.game[mg.now - 1] == 1) {
						System.out.println("벽을 만나 움직일 수 없습니다.");
						System.out.println("벽 부수기 -> 3");
					} else {
						mg.game[mg.now] = 0;
						mg.game[mg.now - 1] = 2;
						mg.now -= 1;
					}
				} catch (Exception e) {
					mg.game[mg.now] = 0;
					mg.game[8] = 2;
					mg.now = 8;
				}
			}
			if (num == 2) {
				try {
					if (mg.game[mg.now + 1] == 1) {
						System.out.println("벽을 만나 움직일 수 없습니다.");
						System.out.println("벽 부수기 -> 3");
					} else {
						mg.game[mg.now] = 0;
						mg.game[mg.now + 1] = 2;
						mg.now += 1;
					}
				} catch (Exception e) {
					mg.game[mg.now] = 0;
					mg.game[0] = 2;
					mg.now = 0;
				}
			}
			if (num == 3) {
				if (mg.game[mg.now - 1] == 1) {
					mg.game[mg.now - 1] = 0;
				} else if (mg.game[mg.now + 1] == 1) {
					mg.game[mg.now + 1] = 0;
				}
			}
		}
	}
}
