package week05_02_¿µÈ­°¨µ¶¼ò_1436;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String num ="";
		for(int i=666;i<Integer.MAX_VALUE;i++) {
			num = i+"";
			if(num.contains("666"))
				n--;
			if(n==0)
				break;
		}
		System.out.println(num);
	}
}
