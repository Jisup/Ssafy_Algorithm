/*
#include <iostream>
#include <string.h>
#pragma warning(disable:4996)

using namespace std;

#define endl "\n"
#define MAX 21

int total, max_cal;
int high_cal = 0;
int high_score = 0;

typedef struct data {
	int score;
	int cal;
}Data;

Data food[MAX];
bool visit[MAX];

void solve(int index, int score, int sum_cal) {
	if (sum_cal > max_cal) return;

	high_score = high_score > score ? high_score : score;

	for (int i = index + 1; i < total; i++) {
		if (!visit[i]) {
			visit[i] = true;
			solve(i, score + food[i].score, sum_cal+food[i].cal);
			visit[i] = false;
		}
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
	for (int t = 1; t <= tc; t++) {
		memset(visit, 0, sizeof visit);
		cin >> total >> max_cal;
		for (int i = 0; i < total; i++) {
			int temp1, temp2;
			cin >> temp1 >> temp2;
			food[i] = { temp1, temp2 };
		}
		for (int i = 0; i < total; i++) {
			visit[i] = true;
			solve(i, food[i].score, food[i].cal);
			visit[i] = false;
		}
		cout << "#"<<t<<" "<<high_score<<endl;
		high_score = 0; high_cal = 0;
	}
}
*/

/*
0/1 ���� �˰��� �� ���繮�� ����� �賶::https://www.acmicpc.net/problem/12865

�� ����ü�� �ε����� ���⶧���� ���� ū 0/1 �����ǰ�� ��� �Ұ����ϴ�

i ��° ���� �־��� �� = dp [ i-1 ] [ j- (i ��° ���� ����) ] + (i ��° ���� ��ġ) �� ���� ���� �� �ֽ��ϴ�.
(�賶���� i ��° ���� ���� �� ���� ������ ��ġ�� �ִ��� ������ ���� dp [ i-1 ] [ j- (i ��° ���� ����) ] �� �Ǳ� �����Դϴ�.)
*/
#include<cstdio>
#include<iostream>
#include<vector>
#include<cstring>
using namespace std;

int n, l;
pair<int, int> p[30];
int dp[10004];

int main() {
	int t;
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &l);

		memset(dp, 0, sizeof dp);
		for (int i = 0; i < n; i++) {
			scanf("%d %d", &p[i].first, &p[i].second);

			for (int j = l; j >= p[i].second; j--) {
				if (dp[j] < p[i].first + dp[j - p[i].second])
					dp[j] = p[i].first + dp[j - p[i].second];
			}
		}
		printf("#%d %d\n", tc, dp[l]);
	}
}