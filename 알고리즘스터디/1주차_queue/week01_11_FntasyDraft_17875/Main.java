package week01_11_FntasyDraft_17875;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String[][] ans = new String[n][k];
		Queue<String>[] q = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			q[i] = new LinkedList<>();
			for (int j = 0; j < x; j++) {
				q[i].add(sc.next());
			}
		}
		int p = sc.nextInt();
		Queue<String> ranking = new LinkedList<>();
		for (int i = 0; i < p; i++) {
			ranking.add(sc.next());
		}
		Set<String> s = new HashSet<>();
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < n; i++) {
				boolean didadd = false;
				while (!q[i].isEmpty()) {
					if (s.add(q[i].peek())) {
						ans[i][j] = q[i].poll();
						s.add(ans[i][j]);
						didadd = true;
						break;
					} else {
						q[i].poll();
					}
				}
				if (!didadd) {
					while (!ranking.isEmpty()) {
						if (s.add(ranking.peek())) {
							ans[i][j] = ranking.poll();
							s.add(ans[i][j]);
							break;
						} else {
							ranking.poll();
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
