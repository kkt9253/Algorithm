#include <bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	while (1) {
		string s;		
		getline(cin, s);
		if (s == ".") break;
		stack<char> stk;
		bool ret = true;
		
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == '(' || s[i] == '[' || s[i] == ')' || s[i] == ']') {
				if (s[i] == '(') stk.push(s[i]);
				else if (s[i] == '[') stk.push(s[i]);
				else if (stk.size() && s[i] == ')' && stk.top() == '(') stk.pop();
				else if (stk.size() && s[i] == ']' && stk.top() == '[') stk.pop();
				else {
					ret = false;
					break;
				}
			}
		}
		
		if (stk.empty() && ret) cout << "yes\n";
		else cout << "no\n";
	}
	
	return 0;
}