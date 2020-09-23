package week04_06_방배정하기_14697;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		int[] dp = new int[301];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
			dp[arr[i]] = 1;
		}
		int n = sc.nextInt();
		for (int i = 1; i < n + 1; i++) {
			if (dp[i] == 1) {
				for (int j = 0; j < 3; j++) {
					if (i + arr[j] < 301) {
						dp[i + arr[j]] = 1;
					}
				}
			}
		}
		System.out.println(dp[n]);
	}
}
