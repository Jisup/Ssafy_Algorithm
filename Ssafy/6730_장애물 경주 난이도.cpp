#include <iostream>
#include <algorithm>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define INF 2147483647
#define MAX 100

int block;
int obstacle[MAX];
int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		int high = 0, low = 0;
		cin >> block;
		for (int i = 0; i < block; i++) {
			cin >> obstacle[i];
		}
		for (int i = 0; i < block - 1; i++) {
			int stay = obstacle[i] - obstacle[i + 1];
			if (stay < 0) {
				high = high > abs(stay) ? high : abs(stay);
			}
			else {
				low = low > stay ? low : stay;
			}
		}
		cout << "#" << t << " " << high << " " << low << endl;
	}
}