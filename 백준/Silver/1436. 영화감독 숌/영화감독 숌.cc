#include <bits/stdc++.h>
using namespace std;

int n;

int main() {
	cin >> n;
	int i = 666;
	while (n) {
		if (to_string(i).find("666") != string::npos) n--;
		if (n == 0) cout << i << "\n";
		i++;
	}
}