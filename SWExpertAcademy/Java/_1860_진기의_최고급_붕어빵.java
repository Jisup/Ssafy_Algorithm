import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1860_진기의_최고급_붕어빵 {
	static void init() {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			ArrayList<Integer> ary = new ArrayList<Integer>();
			for (int i = 0; i < N; i++)
				ary.add(sc.nextInt());
			Collections.sort(ary);

			System.out.print("#" + t + " ");
			if (solve(N, M, K, ary))
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
	}

	static boolean solve(int N, int M, int K, ArrayList<Integer> ary) {
		// 주어진 ary초때 만들수 있는 붕어빵의수
		// 이전에 만들어서 판매한 붕어빵의수
		int now = 0;
		int yet = 0;
		for(int item : ary) {
			now = (item/M)*K;
//			System.out.println(item+": "+now+" "+yet);
			if (now-yet <= 0) return false;
			yet+=1;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// N명의 사람들에게 M초의 시간동안 K개의 붕어빵을 만들수잇다
		// M초동안 K개의 붕어빵이 나온다
		// 그걸 N명의 사람들에게 줄수잇냐?
		init();
	}

}
