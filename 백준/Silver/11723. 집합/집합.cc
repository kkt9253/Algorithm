#include <bits/stdc++.h>
using namespace std;

vector<int> v;
int n, s;
string f;

bool _find(int c) {
	if (find(v.begin(), v.end(), c) != v.end()) return true;
	return false;
}

void _add(int c) {
	if (!_find(c)) v.push_back(c);
}

void _remove(int c) {
	if (_find(c)) v.erase(find(v.begin(), v.end(), c));
}

void _check(int c) {
	if (_find(c)) cout << 1 << "\n";
	else cout << 0 << "\n";
}

void _toggle(int c) {
	if (_find(c)) _remove(c);
	else _add(c);
}

void _all() {
	v.clear();
	for (int i = 1; i <= 20; i++) v.push_back(i);
}

void _empty() {
	v.clear();
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> f;
		if (f == "add" || f == "remove" || f == "check" || f == "toggle") {
			cin >> s;
			if (f == "add") _add(s);
			else if (f == "remove") _remove(s);
			else if (f == "check") _check(s);
			else if (f == "toggle") _toggle(s);
		}
		else {
			if (f == "all") _all();
			else if (f == "empty") _empty();
		}
	}
	
	return 0;
}