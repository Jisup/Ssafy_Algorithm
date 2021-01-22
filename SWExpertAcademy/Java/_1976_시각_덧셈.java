import java.util.Scanner;

public class _1976_시각_덧셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int hour = sc.nextInt();
			int minute = sc.nextInt();
			hour+=sc.nextInt();
			minute+=sc.nextInt();
			
			hour+=minute/60;
			minute%=60;
			hour=hour%12;
			if (hour==0) hour=12;
			
			System.out.println("#"+t+" "+hour+" "+minute);
		}
	}

}
