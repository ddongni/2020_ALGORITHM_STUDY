package week05_04_nQueen_20759577;

import java.util.Scanner;

public class Main {
	static int n, answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {//첫 번째 퀸의 행 선택
			int[] row = new int[n];
			row[0] = i;
			put(row, 0);
		}
		System.out.println(answer);
	}
	static void put(int[] row, int col) {
		if(col==n-1) { // n-1 열까지 채웠으면 n개의 퀸 다 놓은 것임
			answer++;
			return;
		}
		for(int i=0;i<n;i++) {
			row[col+1] = i;
			if(isPossible(row, col+1)) {
				// 퀸을 i행 count+1열에 놓을 수 있다면 다음 퀸 진행
				put(row, col+1);
			}
		}
	}
	static boolean isPossible(int[] row, int col) {
		for(int i =0;i<col;i++) {
			// 이전에 놓은 퀸들과 행이 일치하면 놓을 수 없음
			if(row[i] == row[col]) return false;
			// 이전에 놓은 퀸들의 대각선에 위치하면 놓을 수 없음
			if(Math.abs(i-col)==Math.abs(row[i]-row[col])) return false;
		}
		return true;
	}
}
