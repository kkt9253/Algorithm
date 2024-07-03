#include <bits/stdc++.h>
using namespace std;

string str;
int cnt[26];

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	cin >> str;
	for (char i : str) {
		cnt[i - 'a']++;
	}
	for (int i : cnt) cout << i << " ";
}