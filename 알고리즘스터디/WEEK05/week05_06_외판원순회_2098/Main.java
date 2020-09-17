package week05_06_외판원순회_2098;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[n][n];
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = arr[i][j] = sc.nextInt();
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (d[i][j] > d[i][k] + d[k][j]) {
						System.out.println(i + " " + k + " " + j);
						d[i][j] = d[i][k] + d[k][j];
						System.out.println(d[i][j]);
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[j][i] == 0)
					continue;
				answer = Math.min(answer, d[i][j] + arr[j][i]);
			}
		}
		System.out.println(answer);
	}
}
