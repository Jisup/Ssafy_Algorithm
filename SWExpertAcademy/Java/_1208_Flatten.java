import java.util.Arrays;
import java.util.Scanner;

public class _1208_Flatten {

	static void init() {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int Dump = sc.nextInt();
			int ary[] = new int[100];
			for (int i = 0; i < 100; i++)
				ary[i] = sc.nextInt();
			System.out.print("#"+t+" ");
			solve(ary, Dump);
		}
	}

	static void solve(int ary[], int Dump) {
		while(Dump-->0) {
			ary[99]--;
			ary[0]++;
			Arrays.sort(ary);
		}
		System.out.println(ary[99]-ary[0]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
}
