#include <bits/stdc++.h>
using namespace std;

int n, m, f, cnt;
vector<int> v;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> f;
        v.push_back(f);
    }

    for (int i = 0; i < n; i++) {
    	for (int j = i + 1; j < n; j++) {
    		if ( (v[i] + v[j]) == m) cnt++;
		}
    }

    cout << cnt;

    return 0;
}
