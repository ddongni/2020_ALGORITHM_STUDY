package week01_01_카드1_2161;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		int index = 1;
		while (!q.isEmpty()) {
			int x = q.poll();
			if (index != 1) {
				q.add(x);
				index = 1;
			} else {
				System.out.print(x + " ");
				index = -1;
			}
		}
	}
}
