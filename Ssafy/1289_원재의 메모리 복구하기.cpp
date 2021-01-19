#include <iostream>
#include <string>
#include <queue>
#include <set>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"

int main() {
#ifdef _CONSOLE
	freopen("input.txt", "r", stdin);
#endif
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		int cnt = 0;
		string temp;
		cin >> temp;
		if (temp[0] == '1')
			cnt++;
		for (int i = 0; i < temp.length()-1; i++) {
			if (temp[i] != temp[i + 1]) cnt++;
		}
		cout << "#" << t << " " << cnt << endl;
	}
}