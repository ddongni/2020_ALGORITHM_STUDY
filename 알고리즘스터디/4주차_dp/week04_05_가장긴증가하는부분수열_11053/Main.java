package week04_05_가장긴증가하는부분수열_11053;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = 1;
		if (n != 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					} else {
						dp[i] = Math.max(dp[i], 1);
					}
				}
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
