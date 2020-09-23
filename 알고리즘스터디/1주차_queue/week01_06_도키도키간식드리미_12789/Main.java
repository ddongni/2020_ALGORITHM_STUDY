package week01_06_도키도키간식드리미_12789;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			q.add(sc.nextInt());
		}
		int index = 1;
		boolean[] ch = new boolean[n + 1];
		while (true) {
			if (q.isEmpty() && s.isEmpty()) {
				System.out.println("Nice");
				break;
			}
			if (index == n + 1) {
				System.out.println("Sad");
				break;
			}
			if (ch[index]) {
				if (s.peek() == index) {
					s.pop();
					index++;
				} else {
					System.out.println("Sad");
					break;
				}
			} else {
				if (!q.isEmpty()) {
					int x = q.poll();
					if (x == index) {
						index++;
					} else {
						ch[x] = true;
						s.push(x);
					}
				}
			}
		}
	}
}
