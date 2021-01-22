import java.util.Scanner;

public class _1284_수도요금_경쟁 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			int A = W * P;
			int B = Q;
			if (R < W)
				B += (W - R) * S;
			System.out.print("#" + t + " ");
			if (A <= B)
				System.out.println(A);
			else
				System.out.println(B);
		}
	}

}
