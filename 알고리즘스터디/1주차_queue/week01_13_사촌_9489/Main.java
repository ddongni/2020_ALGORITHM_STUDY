package week01_13_사촌_9489;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (n == 0 && k == 0) {
				break;
			}
			int[] p = new int[n];
			int temp = -1;
			int count = -1; //그룹 번호 저장
			int k_index = -1; //k 위치 저장
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				if (x - temp > 1) {
					count++;
				}
				p[i] = count;
				temp = x;
				if(x==k) {
					k_index = i;
				}
				
			}
			int k_parent = p[k_index];
			int ans = 0;

			System.out.println(ans);
		}
	}
}