import java.util.Scanner;

public class _1974_스도쿠_검증 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int ary[][] = new int[9][9];
		
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					ary[i][j] = sc.nextInt();
		}
	}

}
