package week01_05_요세푸스문제0_11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i =1;i<=n;i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int index =1;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(index==k) {
				sb.append(x);
				if(q.isEmpty()) {
					sb.append(">");
				}else {
					sb.append(", ");
				}
				index = 1;
			}else {
				q.add(x);
				index++;
			}
		}
		System.out.println(sb.toString());
	}
}
