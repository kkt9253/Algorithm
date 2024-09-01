#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

string a, b;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> a >> b;
	
	reverse(a.begin(), a.end()); reverse(b.begin(), b.end());
	int nA = atoi(a.c_str()); int nB =  atoi(b.c_str());
	
	cout << (nA > nB ? nA : nB);
	
	return 0;
}