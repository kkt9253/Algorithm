#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int ret;
string s1;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> s1;
	for (char c : s1) {
		if (c == 'A' || c == 'B' || c == 'C') ret += 3;
		else if (c == 'D' || c == 'E' || c == 'F') ret += 4;
		else if (c == 'G' || c == 'H' || c == 'I') ret += 5;
		else if (c == 'J' || c == 'K' || c == 'L') ret += 6;
		else if (c == 'M' || c == 'N' || c == 'O') ret += 7;
		else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') ret += 8;
		else if (c == 'T' || c == 'U' || c == 'V') ret += 9;
		else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') ret += 10;
	}
	
	cout << ret;
	
	return 0;
}