import java.util.Scanner;

public class _1979_어디에_단어가_들어갈_수_있을까 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1) 가로벽면에서시작
		 * 2) 세로벽면에서시작
		 * #) 만약 벽면에서 시작했는데 벽이라면 글자칸이나올때까지 전진
		 * #) 글자칸에서 시작했을때부터 벽/아웃라인을 만날때까지 카운트
		 * #) 입력값과 같다면 증가 
		 */
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N=sc.nextInt();
			int len=sc.nextInt();
			
			int puzzle[][] = new int [N][N];
			int Size[] = new int[N+1];
			
			for(int y=0;y<N;y++)
				for(int x=0;x<N;x++)
					puzzle[y][x] = sc.nextInt();
			
			for(int y=0;y<N;y++) {
				int cnt=0;
				for(int x=0;x<N;x++) {
					if (puzzle[y][x] == 0) {
						Size[cnt]++;
						cnt=0;
					}
					else
						cnt++;
				}
				Size[cnt]++;
			}
			for(int x=0;x<N;x++) {
				int cnt=0;
				for(int y=0;y<N;y++) {
					if (puzzle[y][x] == 0) {
						Size[cnt]++;
						cnt=0;
					}
					else
						cnt++;
				}
				Size[cnt]++;
			}
			System.out.println("#"+t+" "+Size[len]);
		}
	}
}
