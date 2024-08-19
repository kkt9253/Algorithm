#include <bits/stdc++.h>
using namespace std;

bool flag, err;
int t, n;
string p, x;
deque<int> dq;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> t;
	
	while (t--) {
		cin >> p >> n >> x;
		
		flag = false;
		err = false;
		dq.clear();
		
		string val = "";
		for (char c : x) { // 배열에 숫자 저장 
			if ('0' <= c && c <= '9') { // 숫자라면 
				val += c; 
			}
			else { // 숫자가 아니라면 
				if (val.size()) {
					dq.push_back(atoi(val.c_str()));
					val = "";
				}
			}
		}
		
		for (char c : p) { // 함수배열 호출 
			if (c == 'R') flag = !flag;
			else {
				if (dq.size()) {
					if (flag) dq.pop_back();
					else dq.pop_front();
				}
				else {
					err = true;
					break;
				}
			}
		}
		
		if (err) cout << "error\n";
		else {
			if (flag) reverse(dq.begin(), dq.end());
			cout << "[";
			for (int i = 0; i < dq.size(); i++) {
				cout << dq[i];
				if (i < dq.size() - 1) cout << ",";
			}
			cout << "]\n";
		}
	}
	
	return 0;
}