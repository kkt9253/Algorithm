#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

bool flag = true;
string s;
int n, vn;
ll c;
vector<pair<int, int>> v;

bool cmp(pair<int, int> a, pair<int, int> b) {
	return a.second > b.second;
}

int main() {
	cin >> n >> c;
	
	for (int i = 0; i < n; i++) {
		cin >> vn;
		for (auto& a : v) {
			if (a.first == vn) {
				a.second++;
				flag = false;
				break;
			}
		}
		if (flag) {
			v.push_back({vn, 1});
		}
		flag = true;
	}
	
	stable_sort(v.begin(), v.end(), cmp);
	
	for (auto a : v) {
		for (int i = 0; i < a.second; i++) cout << a.first << " ";
	}
}