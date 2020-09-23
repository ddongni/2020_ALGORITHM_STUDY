package week03_04_나이순정렬_10814;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		info[] li = new info[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			String y = sc.next();
			li[i] =new info(x, y, i);
		}
		Arrays.sort(li);
		for(info ans : li) {
			System.out.println(ans.age + " " + ans.name);
		}
	}
}

class info implements Comparable<info> {
	int age;
	String name;
	int date;

	info(int age, String name, int date) {
		this.age = age;
		this.name = name;
		this.date = date;
	}

	public int compareTo(info o) {
		if (age - o.age == 0) {
			return date - o.date;
		} else {
			return age - o.age;
		}
	}
}
