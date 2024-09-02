#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int ret, n, ar[200004];
string s;
stack<int> stk;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> s;
	
	for (int i = 0; i < n; i++) {
		if (s[i] == '(') {
			stk.push(i);
		} else if (stk.size() && s[i] == ')'){
			ar[i] = 1;
			ar[stk.top()] = 1;
			stk.pop();
		}
	}
	
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		if (ar[i]) {
			cnt += 1;
		} else {
			cnt = 0;
		}
		ret = max(ret, cnt);
	}
	
	cout << ret;
	
	return 0;
}