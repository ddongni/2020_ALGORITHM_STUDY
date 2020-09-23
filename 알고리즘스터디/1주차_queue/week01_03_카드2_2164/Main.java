package week01_03_카드2_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1;i<=n;i++) {
			q.add(i);
		}
		int index = 1;
		int count = 0;
		while(!q.isEmpty()) {
			int x= q.poll();
			if(count==n-1) {
				System.out.println(x);
				return;
			}
			if(index!=1) {
				q.add(x);
				index = 1;
			}else {
				count++;
				index = -1;
			}
		}
	}
}
