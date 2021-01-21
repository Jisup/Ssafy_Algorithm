import java.util.Scanner;

public class _2005_ÆÄ½ºÄ®ÀÇ_»ï°¢Çü {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int triangle = sc.nextInt();

			System.out.println("#"+t);
			
			int ary[][] = new int[triangle][triangle];
			ary[0][0]=1;
			System.out.println(ary[0][0]);
			for(int i=1;i<triangle;i++) {
				ary[i][0]=ary[i-1][0];
				System.out.print(ary[i][0]+" ");
				for(int j=1;j<=i;j++) {
					ary[i][j]=ary[i-1][j-1]+ary[i-1][j];
					System.out.print(ary[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
