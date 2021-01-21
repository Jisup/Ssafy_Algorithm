import java.util.Scanner;

public class _1984_중간_평균값_구하기 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int high = 0;
			int low = 2147483647;
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int temp = sc.nextInt();
				sum += temp;
				high = high > temp ? high : temp;
				low = low < temp ? low : temp;
			}
//			System.out.println((double)((sum-high-low)/8));
			System.out.println("#"+t+" "+Math.round((double)(sum-high-low)/8));
		}
		sc.close();
	}
}
