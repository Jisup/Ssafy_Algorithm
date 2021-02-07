

import java.util.Scanner;

public class _3499_퍼펙트_셔플 {

	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int suffle = sc.nextInt();
			int half = suffle/2;
			String card[] = new String[suffle];
			for(int i=0;i<suffle;i++)
				card[i] = sc.next();
			String first[] = new String[half];
			for(int i=0;i<half;i++) first[i] = card[i];
			String second[] = new String[half];
			if (suffle %2 == 0)
				for(int i=half;i<suffle;i++) second[i-half] = card[i];
			else
				for(int i=half+1;i<suffle;i++) second[i-half-1] = card[i];
			
			System.out.print("#"+t+" ");
			for(int i=0;i<half;i++) {
				System.out.print(first[i]+" "+second[i]+" ");
			}
			if (suffle %2 != 0)
				System.out.print(card[half]);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		init();
	}
}
