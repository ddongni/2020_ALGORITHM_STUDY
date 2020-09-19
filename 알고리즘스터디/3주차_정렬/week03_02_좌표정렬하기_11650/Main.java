package week03_02_좌표정렬하기_11650;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(
				(int[] a, int[] b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0]));
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			q.add(new int[] { x, y });
		}
		while (!q.isEmpty()) {
			int[] ans = q.poll();
			System.out.println(ans[0]+" "+ans[1]);
		}
	}
}
