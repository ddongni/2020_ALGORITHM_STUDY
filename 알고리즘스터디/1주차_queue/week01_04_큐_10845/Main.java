package week01_04_큐_10845;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		while (n-- > 0) {
			String str = sc.next();
			if (str.equals("push")) {
				q.add(sc.nextInt());
			} else if (str.equals("pop")) {
				System.out.println(q.isEmpty() ? -1 : q.poll());
			} else if (str.equals("size")) {
				System.out.println(q.size());
			} else if (str.equals("empty")) {
				System.out.println(q.isEmpty() ? 1 : 0);
			} else if (str.equals("front")) {
				System.out.println(q.isEmpty() ? -1 : q.peek());
			} else if (str.equals("back")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					int index = 0;
					for (int x : q) {
						if (index == q.size() - 1) {
							System.out.println(x);
						}
						index++;
					}
				}
			}
		}
	}
}
