import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1225_암호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//이거 꼭 기억하기
		while(sc.hasNext()) {
			String tc = sc.next();
			Queue<Integer>q = new LinkedList<Integer>();
			for(int i=0;i<8;i++)
				q.add(sc.nextInt());
			
			int index=0;
			while(!q.isEmpty()) {
				index = index == 5 ? 1: index+1;
				int out = q.poll();
				int in = out - index;
				if (in <= 0) {
					q.add(0);
				break;
				}
				q.add(in);
			}
			int Size = q.size();
			System.out.print("#"+ tc+" ");
			while(Size-->0) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}

}
