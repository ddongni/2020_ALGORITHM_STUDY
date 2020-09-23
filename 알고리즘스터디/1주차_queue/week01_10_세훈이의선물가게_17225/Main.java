package week01_10_세훈이의선물가게_17225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a  =sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		Queue<Integer> B = new LinkedList<>();
		Queue<Integer> R = new LinkedList<>();
		int LastB =-1;
		int LastR =-1;
		for(int i=0;i<n;i++) {
			int t =sc.nextInt();
			String c= sc.next();
			int m = sc.nextInt();
			switch(c) {
			case "B" :
				if(LastB>=t) {
					t=LastB;
				}
				for(int j=0;j<m;j++) {
					B.add(t+j*a);
					LastB = t+j*a;
				}
				LastB+=a;
				break;
			case "R" :
				if(LastR>=t) {
					t=LastR;
				}
				for(int j=0;j<m;j++) {
					R.add(t+j*b);
					LastR=t+j*b;
				}
				LastR+=b;
				break;
			}
		}
		int index = 1;
		StringBuilder sb = new StringBuilder();
		StringBuilder sr = new StringBuilder();
		sb.append(B.size()+"\n");
		sr.append(R.size()+"\n");
		while(true) {
			if(B.isEmpty()) {
				while(!R.isEmpty()) {
					R.poll();
					sr.append(index+" ");
					index++;
				}
				break;
			}
			if(R.isEmpty()) {
				while(!B.isEmpty()) {
					B.poll();
					sb.append(index+" ");
					index++;
				}
				break;
			}
			if(B.peek() <= R.peek()) {
				B.poll();
				sb.append(index+" ");
			}else {
				R.poll();
				sr.append(index+" ");
			}
			index++;
		}
		System.out.println(sb.toString());
		System.out.println(sr.toString());
		
	}
}
