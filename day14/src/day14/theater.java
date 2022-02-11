package day14;

import java.util.Scanner;

class Movie {
	int[] seat = new int[7];
	int money = 0;
}

public class theater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Movie mv = new Movie();
		while (true) {
			System.out.println("=============");
			System.out.println("[MEGA MOVIE]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			System.out.println("=============");
			int slt = sc.nextInt();

			if (slt == 1) {
				System.out.print("seat = ");
				for (int i = 0; i < mv.seat.length; i++) {
					System.out.print(mv.seat[i] + " ");
				}
				System.out.println();
				System.out.println("좌석선택 :");
				int slts = sc.nextInt();
				if (mv.seat[slts] == 1) {
					System.out.println("이미 예매가 완료된 자리입니다.");
				} else {
					mv.seat[slts] = 1;
					mv.money += 12000;
				}
			}
			if (slt == 2) {
				System.out.println("매출액 : " + mv.money + "원");
				break;
			}
		}
	}
}
