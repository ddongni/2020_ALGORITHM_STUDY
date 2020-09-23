package prob01_파스칼삼각형_15489;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] p = new int[30][30];
		p[0][0] = p[1][0] = p[1][1] = 1; // 1행, 2행 초기화
		for (int i = 2; i < 30; i++) {
			p[i][0] = 1; // 맨 왼쪽 값 1
			int j;
			for (j = 1; j < i; j++) {
				p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
			}
			p[i][j] = 1; // 맨 오른쪽에 있는 값 1
		}
//		for(int i=0;i<30;i++) {
//			for(int j=0;j<30;j++) {
//				System.out.print(p[i][j]+" ");
//			}
//			System.out.println();
//		}
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		int w = sc.nextInt();
		int sum = 0;
		int idx = 1;
		for (int i = 0; i < w; i++) {
			for(int j=0;j<idx;j++) {
				sum += p[r+i][c+j];
			}
			idx++;
		}
		System.out.println(sum);

	}
}
