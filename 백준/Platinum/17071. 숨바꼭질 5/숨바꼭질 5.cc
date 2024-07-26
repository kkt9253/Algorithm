#include <bits/stdc++.h>
using namespace std;
const int mx = 500000;

int a, b, visited[2][mx + 4], turn = 1, ok;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> a >> b;
    if(a == b) {
		cout << 0 << "\n";
		return 0;
	}
    
    queue<int> q;
    visited[0][a] = 1;
    q.push(a);
    while (q.size()) {
    	b += turn;
    	if (b > mx) break;
    	if (visited[turn % 2][b]) {
    		ok = 1;
    		break;
		}
		
		int qSize = q.size();
		for (int i = 0; i < qSize; i++) {
			int here = q.front();
			q.pop();
			for (int next : {here + 1, here - 1, here * 2}) {
				if (0 <= next && next <= mx && !visited[turn % 2][next]) {
					visited[turn % 2][next] = visited[(turn + 1) % 2][here] + 1;
					q.push(next);
					if (next == b) {
						ok = 1;
						break;
					}
				}
			}
			if (ok) break;
		}
		if (ok) break;
		turn++;
	}
    
    if (ok) cout << turn << "\n";
    else cout << "-1\n";
    return 0;
}
