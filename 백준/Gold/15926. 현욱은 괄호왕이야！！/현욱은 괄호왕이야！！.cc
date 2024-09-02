#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int n, ret;
string s;
stack<int> stk;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> s;
	stk.push(-1);
	
	for (int i = 0; i < n; i++) {
		if (s[i] == '(') {
			stk.push(i);
		} 
		else {
			stk.pop();
			if (stk.empty()) stk.push(i);
			else ret = max(ret, i - stk.top());
		}
	}
	
	cout << ret;
	
	return 0;
}