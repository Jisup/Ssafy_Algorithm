import java.util.Arrays;
import java.util.Scanner;

public class _1974_스도쿠_검증 {

	static boolean check[] = new boolean[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int ary[][] = new int[9][9];
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					ary[i][j] = sc.nextInt();

			System.out.print("#" + t + " ");
			// 가로검증
			if (!Row(ary)) {
				System.out.println(0);
				continue;
			}
//			System.out.println();
			// 세로검증
			if (!Column(ary)) {
				System.out.println(0);
				continue;
			}
//			System.out.println();
			// 3x3검증
			if (!Split(ary)) {
				System.out.println(0);
				continue;
			}
			System.out.println(1);
		}
	}

	static boolean Row(int ary[][]) {
		for (int y = 0; y < 9; y++) {
			Arrays.fill(check, false);
			for (int x = 0; x < 9; x++) {
//				System.out.print(ary[y][x] + " ");
				if (!check[ary[y][x]])
					check[ary[y][x]] = true;
				else {
					return false;
				}
			}
//			System.out.println();
		}
		return true;
	}

	static boolean Column(int ary[][]) {
		for (int x = 0; x < 9; x++) {
			Arrays.fill(check, false);
			for (int y = 0; y < 9; y++) {
//				System.out.print(ary[y][x] + " ");
				if (!check[ary[y][x]])
					check[ary[y][x]] = true;
				else {
					return false;
				}
			}
//			System.out.println();
		}
		return true;
	}

	static boolean Split(int ary[][]) {
		for (int i = 0; i < 9; i += 3)
			for (int j = 0; j < 9; j += 3) {
				Arrays.fill(check, false);
				for (int y = i; y < i + 3; y++)
					for (int x = j; x < j + 3; x++) {
//						System.out.print(ary[y][x] + " ");
						if (!check[ary[y][x]])
							check[ary[y][x]] = true;
						else {
							return false;
						}
					}
//				System.out.println();
			}
		return true;
	}
}
