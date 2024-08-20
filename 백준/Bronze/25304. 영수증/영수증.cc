#include <bits/stdc++.h>
using namespace std;

int x, n, a, b, sum;

int main() {
	
	cin >> x >> n;
	while (n--) {
		cin >> a >> b;
		sum += (a * b);
	}
	
	cout << (x == sum ? "Yes" : "No");
	
    return 0;
}