#include <iostream>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 5


int result[MAX];
int Div[MAX] = { 2,3,5,7,11 };

void solve(int item) {
	for (int i = 0; i < MAX; i++) {
		int cnt = 0;
		while (item % Div[i] == 0) {
			if (item == 0) break;
			item /= Div[i];
			cnt++;
		}
		result[i] = cnt;
	}
}
int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;

	for (int i = 1; i <= tc; i++) {
		int temp;
		cin >> temp;
		solve(temp);
		cout << "#" << i << " ";
		for (int k = 0; k < MAX; k++) {
			cout << result[k] << " ";
		}
		cout << endl;
	}
}
