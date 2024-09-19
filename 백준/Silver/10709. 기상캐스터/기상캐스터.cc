#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int h, w, flag, ret[104][104];
string s;

int main() {
	cin >> h >> w;
	
	fill(&ret[0][0], &ret[0][0] + 104 * 104, -1);
	
	for (int i = 0; i < h; i++) {
		flag = 0;
		cin >> s;
		
		for (int j = 0; j < w; j++) {
			if (s[j] == 'c') {
				flag = 1;
				ret[i][j] = 0; 
			}
			else if (flag > 0) {
				ret[i][j] = flag;
				flag += 1;
			}
		}
	}
	
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			cout << ret[i][j] << " ";
		}
		cout << "\n";
	}
	
	return 0;
}