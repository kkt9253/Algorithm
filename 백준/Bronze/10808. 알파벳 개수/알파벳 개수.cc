#include <bits/stdc++.h>
using namespace std;

int alpha[26];

int main() {
	string s;
	cin >> s;
	int ws = s.size();
	char arr[ws+1];
	strcpy(arr, s.c_str());
	
	for (int i = 0; i < ws; i++) {
		int n = arr[i] - 'a';
		alpha[n]++;
	}
	for (int i : alpha) cout << i << " ";
	return 0;
}