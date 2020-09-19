package week03_05_국영수_10825;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		info[] arr = new info[n];
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int language = sc.nextInt();
			int english = sc.nextInt();
			int math = sc.nextInt();
			arr[i] = new info(name, language, english, math);
		}
		Arrays.sort(arr);
		for (info x : arr) {
			System.out.println(x.name);
		}
	}
}

class info implements Comparable<info> {
	String name;
	int language;
	int english;
	int math;

	info(String name, int language, int english, int math) {
		this.name = name;
		this.language = language;
		this.english = english;
		this.math = math;
	}

	public int compareTo(info o) {
		if (o.language - language == 0) {
			if (english - o.english == 0) {
				if (o.math - math == 0) {
					return name.compareTo(o.name);
				} else {
					return o.math - math;
				}
			} else {
				return english - o.english;
			}
		} else {
			return o.language - language;
		}
	}
}
