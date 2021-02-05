import java.util.Scanner;

public class _2063_중간값찾기 {

	public static void main(String[] args) {
		// CountingSorting
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count[] = new int[101];
		for (int i = 0; i < N; i++)
			count[sc.nextInt()]++;
		int sum = 0, middle = N / 2;
		for (int i = 0; i < N; i++) {
			sum += count[i];
			if (middle < sum) {
				System.out.println(i);
				break;
			}
		}
	}

}
