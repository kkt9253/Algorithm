#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int ar[104], n, t;
int a, b;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> t;
	
	for (int i = 0; i <= n; i++) ar[i] = i;
	
	while (t--) {
		cin >> a >> b;
		swap(ar[a], ar[b]);
	}
	
	for (int i = 1; i <= n; i++) cout << ar[i] << " ";
	
	return 0;
}