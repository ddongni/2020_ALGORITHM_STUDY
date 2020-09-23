package week04_02_포도주시식_2156;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		if (n >= 2) {
			dp[2] = dp[1] + arr[2];
		}
		for (int i = 3; i <= n; i++) {
			// x o o
			dp[i] = Math.max(dp[i], dp[i - 3] + arr[i - 1] + arr[i]);
			// o x o
			dp[i] = Math.max(dp[i], dp[i - 2] + arr[i]);
			// o o x
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		System.out.println(dp[n]);
	}
}