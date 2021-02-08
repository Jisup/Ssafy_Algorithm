
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1228_암호문1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();

			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < N; i++)
				q.add(sc.nextInt());

			int modify = sc.nextInt();
			for (int m = 0; m < modify; m++) {
				String temp = sc.next();
				int index = sc.nextInt();
				int new_value = sc.nextInt();

//			System.out.println(temp+" "+index+" "+new_value);
				Queue<Integer> nq = new LinkedList<Integer>();
				for (int i = 0; i < index; i++)
					nq.add(q.poll());
				for (int i = 0; i < new_value; i++)
					nq.add(sc.nextInt());
				nq.addAll(q);
				q.clear();
//			view(nq);
				q.addAll(nq);
				nq.clear();
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++)
				System.out.print(q.poll() + " ");
			System.out.println();
		}
	}

	static void view(Queue<Integer> q) {
		Iterator<Integer> iter = q.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println();
	}
}
