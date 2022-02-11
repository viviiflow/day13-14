package day14;

import java.util.Scanner;

class TTT {
	String[][] game = new String[3][3];
	int turn = 0;
	int win = 0;
}

public class TicTacToe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TTT t = new TTT();
		System.out.println("======틱택토 게임======");
		while (true) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (t.game[i][j] == null) {
						System.out.print("[ ] ");
					} else {
						System.out.print("[" + t.game[i][j] + "] ");
					}
				}
				System.out.println();
			}
			if (t.turn % 2 == 0) {
				System.out.print("[player1] y좌표: ");
				int y = sc.nextInt();
				System.out.print("[player1] x좌표: ");
				int x = sc.nextInt();
				if (t.game[y][x] == null) {
					t.game[y][x] = "O";
					t.turn++;
				} else {
					System.out.println("다시 입력하기");
				}
				System.out.println();
			} else {
				System.out.print("[player2] y좌표: ");
				int y = sc.nextInt();
				System.out.print("[player2] x좌표: ");
				int x = sc.nextInt();
				if (t.game[y][x] == null) {
					t.game[y][x] = "X";
					t.turn++;
				} else {
					System.out.println("다시 입력하기");
				}
				System.out.println();
			}

			for (int i = 0; i < 3; i++) {// 가로줄
				try {
					if ((t.game[i][0].equals(t.game[i][1])) && (t.game[i][1].equals(t.game[i][2]))
							&& (t.game[i][0].equals("O"))) {
						t.win = 1;
					} else if ((t.game[i][0].equals(t.game[i][1])) && (t.game[i][1].equals(t.game[i][2]))
							&& (t.game[i][0].equals("X"))) {
						t.win = 2;
					}
				} catch (Exception e) {
					continue;
				}
			}

			for (int i = 0; i < 3; i++) {// 세로줄
				try {
					if ((t.game[0][i].equals(t.game[1][i])) && (t.game[1][i].equals(t.game[2][i]))
							&& (t.game[0][i].equals("O"))) {
						t.win = 1;
					} else if ((t.game[0][i].equals(t.game[1][i])) && (t.game[1][i].equals(t.game[2][i]))
							&& (t.game[0][i].equals("X"))) {
						t.win = 2;
					}
				} catch (Exception e) {
					continue;
				}
			}

			// 대각선1
			try {
				if ((t.game[0][0].equals("O")) && (t.game[1][1].equals("O")) && (t.game[2][2].equals("O"))) {
					t.win = 1;
				} else if ((t.game[0][0].equals("X")) && (t.game[1][1].equals("X")) && (t.game[2][2].equals("X"))) {
					t.win = 2;
				}
			} catch (Exception e) {
			}

			// 대각선2
			try {
				if ((t.game[0][2].equals("O")) && (t.game[1][1].equals("O")) && (t.game[2][0].equals("O"))) {
					t.win = 1;
				} else if ((t.game[0][2].equals("X")) && (t.game[1][1].equals("X")) && (t.game[2][0].equals("X"))) {
					t.win = 2;
				}
			} catch (Exception e) {
			}

			if (t.win == 1) {
				System.out.println("[player1] 승리");
				break;
			} else if (t.win == 2) {
				System.out.println("[player2] 승리");
				break;
			}
		}
	}
}
