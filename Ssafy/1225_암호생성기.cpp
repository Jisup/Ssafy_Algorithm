#include <iostream>
#include <queue>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 5

int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	while (cin >> tc) {
		queue <int> q;
		for (int i = 0; i < 8; i++) {
			int temp;
			cin >> temp;
			q.push(temp);
		}
		int index = 0;
		while (!q.empty()) {
			index == 5 ? index = 1 : index++;
			int out = q.front(); q.pop();
			int in = out - index;
			if (in <= 0) {
				q.push(0);
				break;
			}
			q.push(in);
		}
		int Size = q.size();
		cout << "#" << tc << " ";
		while (Size-- > 0) {
			cout << q.front() << " ";
			q.pop();
		}
		cout << endl;
	}
}