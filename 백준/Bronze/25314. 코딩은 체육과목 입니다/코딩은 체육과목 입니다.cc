#include <bits/stdc++.h>
using namespace std;

int n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	
	int cnt = n / 4;
	while (cnt--) cout << "long ";
	cout << "int";
	
    return 0;
}