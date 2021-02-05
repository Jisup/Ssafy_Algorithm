import java.util.Scanner;

public class _5431_민석이의_과제_체크하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean visit[] = new boolean[N+1];
			for(int i=0;i<M;i++) {
				visit[sc.nextInt()]=true;
			}
			System.out.print("#"+t+" ");
			for(int i=1;i<=N;i++)
				if (!visit[i]) System.out.print(i+" ");
			System.out.println();
		}
	}
}
