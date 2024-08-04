#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

int n, mp, mf, ms, mv, p, f, s, v, c, retc = INF;
vector<array<int, 5>> elementV;
vector<int> retV;

int main() {
	cin >> n >> mp >> mf >> ms >> mv;
	for (int i = 0; i < n; i++) {
		cin >> p >> f >> s >> v >> c;
		elementV.push_back({p, f, s, v, c});
	}
	
	for (int i = 0; i < (1 << n); i++) {
		int sp = 0, sf = 0, ss = 0, sv = 0, sc = 0;
		vector<int> vv;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				vv.push_back(j + 1);
				sp += elementV[j][0];
				sf += elementV[j][1];
				ss += elementV[j][2];
				sv += elementV[j][3];
				sc += elementV[j][4];
			}
		}
		if (sp >= mp && sf >= mf && ss >= ms && sv >= mv) {
			if (retc > sc) {
				retc = sc;
				retV = vv;
			} else if (retc == sc && retV > vv) {
				retV = vv;
			}
		}
	}
	if (retc == INF) cout << -1;
	else {
		cout << retc << "\n";
		for (int i : retV) cout << i <<" ";
	}
	
	return 0;
}