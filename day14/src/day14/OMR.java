package day14;

import java.util.Scanner;

class Test {
	int[] answer = { 1, 3, 4, 2, 5 };
	int[] hgd = new int[5];
	int score = 0;
	String ox = "";
}

public class OMR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test ts = new Test();
		System.out.println("답안 입력(5개): ");
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			ts.hgd[i] = num;
			if (ts.answer[i] == ts.hgd[i]) {
				ts.ox += "O ";
				ts.score += 20;
			} else {
				ts.ox += "X ";
			}
		}
		System.out.print("answer = [ ");
		for (int j = 0; j < 5; j++) {
			System.out.print(ts.answer[j] + " ");
		}
		System.out.println("]");

		System.out.print("hgd = [ ");
		for (int k = 0; k < 5; k++) {
			System.out.print(ts.hgd[k] + " ");
		}
		System.out.println("]");

		System.out.println("정오표 = [ " + ts.ox + "]");
		System.out.println("성적 = " + ts.score + "점");

	}
}
