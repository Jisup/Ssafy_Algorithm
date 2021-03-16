import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1238_Contact {
	static int N, start, callcount, Contact;
	static ArrayList<ArrayList<Integer>> contact;
	static int visit[];
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Contact=0;
			callcount=1;
			visit = new int[101];
			contact = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<101;i++) {
				contact.add(new ArrayList<Integer>());
			}
			
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (!contact.get(from).contains(to))
					contact.get(from).add(to);
			}
			solve();
			select();
			System.out.println("#"+t+" "+Contact);
		}
	}
	static void solve() {
		Queue<Integer>call = new LinkedList<>();
		Queue<Integer>calling = new LinkedList<>();
		call.add(start);
		visit[start]=callcount++;
		while(!call.isEmpty()) {
			while(!call.isEmpty()) {
				int now = call.poll();
				for(int i=0;i<contact.get(now).size();i++) {
					int next = contact.get(now).get(i);
					if (visit[next] == 0) {
						visit[next] = callcount;
						calling.add(next);
					}
				}
			}
			if(!calling.isEmpty()) {
				call.addAll(calling);
				calling.clear();
				callcount++;
			}
		}
	}
	static void select() {
		for(int i=1;i<101;i++) {
			if (visit[i] == callcount-1) {
				Contact = Contact > i ? Contact : i;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		init();
	}

}
