package prob02_HIndex_42747;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}

	static public int solution(int[] citations) {
		int answer = 0;
		int[] count = new int[10001];
		for(int i=0;i<citations.length;i++) {
			for(int j=0;j<=citations[i];j++) {
				count[j]++;
			}
		}
		Arrays.sort(citations);
		for (int i = citations[citations.length-1]; i>=0; i--) {
			int h = i;
			if(count[h]>=h) {
				answer = h;
				break;
			}
		}
		return answer;
	}
}
