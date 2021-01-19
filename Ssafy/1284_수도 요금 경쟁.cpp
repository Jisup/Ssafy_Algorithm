#include <iostream>
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
	/*
	* Q 기본요금	<B사>
	* R 월간사용량 <B사>
	* P 리터당 P원 <A사>
	* S 초과 리터당 S원 <B사>
	* W 한달물사용량
	* P Q R S W
	*/
	int tc;
	cin >> tc;
	for (int t = 1; t <= tc; t++) {
		int P, Q, R, S, W;
		cin >> P >> Q >> R >> S >> W;
		int A = W * P;
		int B = Q;
		if (R < W) B += (W - R) * S;
		cout << "#" << t << " ";
		if (A <= B)
			cout << A << endl;
		else
			cout << B << endl;
	}
}
