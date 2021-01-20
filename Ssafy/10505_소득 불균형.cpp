#include <iostream>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define MAX 10001

int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		int temp, avg = 0;
		int gdp[MAX] = { 0, };
		cin >> temp;
		for (int i = 0; i < temp; i++) {
			cin >> gdp[i];
			avg += gdp[i];
		}
		avg /= temp;
		int cnt = 0;
		for (int i = 0; i < temp; i++) {
			if (gdp[i] <= avg)
				cnt++;
		}
		cout << "#" << t << " " << cnt << endl;
	}
}
