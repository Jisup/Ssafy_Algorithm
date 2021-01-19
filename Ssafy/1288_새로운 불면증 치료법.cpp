#include <iostream>
#include <string>
#include <string.h>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 10

bool sheep[MAX];
int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		memset(sheep, 0, sizeof sheep);
		int temp, cnt = 1, view=0;
		cin >> temp;
		while (true) {
			if (view == 10) break;
			string sleep = to_string(temp * cnt++);
			for (int i = 0; i < sleep.length(); i++) {
				if (!sheep[sleep[i] - '0']) {
					view++;
					sheep[sleep[i] - '0'] = true;
				}
			}
		}
		cout << "#" << t << " " << temp*(cnt-1) << endl;
	}
}