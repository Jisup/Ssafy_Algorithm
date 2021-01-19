#include <iostream>
#include <string>
using namespace std;

#define endl "\n"
#define tap "\t"
#define MAX 27

bool alpha[MAX];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int tc;
	cin >> tc;

	alpha['a' - 'a'] = true;
	alpha['e' - 'a'] = true;
	alpha['i' - 'a'] = true;
	alpha['o' - 'a'] = true;
	alpha['u' - 'a'] = true;
	for (int t = 1; t <= tc; t++) {
		string temp;
		cin >> temp;
		cout << "#" << t << " ";
		for (int i = 0; i < temp.length(); i++) {
			if (!alpha[temp[i] - 'a']) cout << temp[i];
		}
		cout << endl;
	}
}
