#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1e7;

int n, m, a[54][54], mi = INF;
vector<pair<int, int>> h, c;
vector<int> chickenList;

int cal() {
	int ret = 0; // 남은 치킨집 조합에 대한 최단거리 
	for (auto i : h) {
		int minDistance = INF; // 집에서 치킨집까지의 최단거리
		for (int j : chickenList) {
			minDistance = min(minDistance, abs(c[j].first - i.first) + abs(c[j].second - i.second));
		}
		ret += minDistance;
	}
	return ret;
}

void combi(int start) {
	if (chickenList.size() == m) { // 남은 치킨집 조합 구해지면 해당 치킨집들에 대한 최단거리 구하기(도시의 치킨 거리의 최솟값) 
		mi = min(mi, cal());
		return;
	}
	for (int i = start + 1; i < c.size(); i++) { // 존재하는 치킨집 중 m개의 폐업하고 남은 치킨집 조합 구하기 
		chickenList.push_back(i);
		combi(i);
		chickenList.pop_back();
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
			if (a[i][j] == 1) h.push_back({i, j});
			if (a[i][j] == 2) c.push_back({i, j});
		}
	}
	
	combi(-1);
	cout << mi;
	
	return 0;
}