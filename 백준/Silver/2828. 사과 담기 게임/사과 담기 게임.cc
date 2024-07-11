#include <bits/stdc++.h>
using namespace std;

int n, m, j, f, ret, w;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m >> j;
	
	for (int i = 0; i < j; i++) {
		cin >> f;
		if (w >= f) {
			ret += abs(f - w - 1);
			w += f - w - 1;
		}
		else if (w + m < f) {
			ret += f - (w + m);
			w += f - (w + m);
		}
	}
	
	cout << ret;
    
    return 0;
}
