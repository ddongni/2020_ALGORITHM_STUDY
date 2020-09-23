package week01_07_Router_15828;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		while (true) {
			int x = sc.nextInt();
			if (x == -1) {
				break;
			} else if (x == 0) {
				q.poll();
			} else {
				if (q.size() < n) {
					q.add(x);
				}
			}
		}
		if (q.isEmpty()) {
			System.out.println("empty");
			return;
		} else {
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
		}
	}
}
