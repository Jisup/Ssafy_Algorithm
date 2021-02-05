import java.util.Arrays;
import java.util.Scanner;

public class _1204_최빈수_구하기 {

	static void init() {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int tc = sc.nextInt();

			int high = -1;
			int ary[] = new int[101];
			Arrays.fill(ary, 0);
			for (int i = 0; i < 1000; i++) {
				int temp = sc.nextInt();
				ary[temp]++;
				high = high > ary[temp] ? high : ary[temp];
			}
			System.out.print("#" + tc + " ");
			for (int i = 100; i >= 0; i--)
				if (high == ary[i]) {
					System.out.println(i);
					break;
				}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
}
