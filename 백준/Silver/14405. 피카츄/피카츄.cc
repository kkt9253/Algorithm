#include <bits/stdc++.h>
using namespace std;

bool flag;
int n;
string a[3] = {"pi", "ka", "chu"};
string s;
queue<char> q;

bool solve(string ss) {
	for (char c : ss) {
		if (q.front() == c) q.pop();
		else return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> s;
	for (char c : s) q.push(c);
	
	while (q.size()) {
		if (q.size() >= 2 && q.front() == 'p') {
		    flag = solve(a[0]);
		}
		else if (q.size() >= 2 && q.front() == 'k') {
		    flag = solve(a[1]);
		}
		else if (q.size() >= 3 && q.front() == 'c') {
		    flag = solve(a[2]);
		}
		else {
			flag = false;
			break;
		}
		if (!flag) break;
	}
	
	if (flag) cout << "YES";
	else cout << "NO";
	
	return 0;
}