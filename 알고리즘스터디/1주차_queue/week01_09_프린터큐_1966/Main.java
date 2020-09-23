package week01_09_프린터큐_1966;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			int max =Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				int x = sc.nextInt();
				q.add(x);
				pq.add(x);
			}
			int count = 0;
			while(!q.isEmpty()) {
				int x = q.poll();
				if(x != pq.peek()) {
					if(m==0) {
						m = q.size();
					}else {
						m--;
					}
					q.add(x);
				}else{
					count++;
					pq.poll();
					if(m==0) {
						break;
					}else {
						m--;
					}
				}
			}
			System.out.println(count);
		}
	}
}
