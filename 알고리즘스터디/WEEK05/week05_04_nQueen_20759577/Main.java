package week05_04_nQueen_20759577;

import java.util.Scanner;

public class Main {
	static int n, answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {//ù ��° ���� �� ����
			int[] row = new int[n];
			row[0] = i;
			put(row, 0);
		}
		System.out.println(answer);
	}
	static void put(int[] row, int col) {
		if(col==n-1) { // n-1 ������ ä������ n���� �� �� ���� ����
			answer++;
			return;
		}
		for(int i=0;i<n;i++) {
			row[col+1] = i;
			if(isPossible(row, col+1)) {
				// ���� i�� count+1���� ���� �� �ִٸ� ���� �� ����
				put(row, col+1);
			}
		}
	}
	static boolean isPossible(int[] row, int col) {
		for(int i =0;i<col;i++) {
			// ������ ���� ����� ���� ��ġ�ϸ� ���� �� ����
			if(row[i] == row[col]) return false;
			// ������ ���� ������ �밢���� ��ġ�ϸ� ���� �� ����
			if(Math.abs(i-col)==Math.abs(row[i]-row[col])) return false;
		}
		return true;
	}
}
