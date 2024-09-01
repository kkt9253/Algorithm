#include <bits/stdc++.h>
using namespace std;
#define INF 1e9
typedef long long ll;

ll n, a, ret;
stack<pair<ll, ll>> stk; // first : 사람 키, second : 사람 수 

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> a;
		
		int cnt = 1;
		
		while (stk.size() && stk.top().first <= a) {
			ret += stk.top().second;
			
			if (stk.top().first < a) cnt = 1;
			else cnt = stk.top().second + 1;
			
			stk.pop();
		}
		if (stk.size()) ret++;
		
		stk.push({a, cnt});
	}
	
	cout << ret;
	
	return 0;
}