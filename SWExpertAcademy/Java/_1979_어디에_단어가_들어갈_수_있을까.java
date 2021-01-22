import java.util.Scanner;

public class _1979_어디에_단어가_들어갈_수_있을까{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
