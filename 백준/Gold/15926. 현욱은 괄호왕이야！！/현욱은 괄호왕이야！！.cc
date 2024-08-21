#include <bits/stdc++.h>
using namespace std;

int n, ret;
string s;
int check[200004];
stack<int> stk;

int main() {
	
	cin >> n >> s;
	
	for (int i = 0; i < n; i++) {
		if (s[i] == '(') {
			stk.push(i);
		}
		else {
			if (stk.size()) {
				check[i] = check[stk.top()] = 1;
				stk.pop();
			}
		}
	}
	
	int cnt = 0;
	for (int i : check) {
		if (i == 1) cnt++;
		else {
			ret = max(ret, cnt);
			cnt = 0;
		}
	}
	
	cout << ret;
	
	return 0;
}