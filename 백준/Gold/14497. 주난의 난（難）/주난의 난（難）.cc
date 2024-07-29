#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

char a[304][304];
int n, m, visited[304][304], cnt;
pair<int, int> junan, crim;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> junan.first >> junan.second >> crim.first >> crim.second;
    junan.first--; junan.second--; crim.first--; crim.second--;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		cin >> a[i][j];
		}
	}
	
    queue<pair<int, int>> q;
    visited[junan.first][junan.second] = 1;
    q.push({junan.first, junan.second});
    
	while (a[crim.first][crim.second] != '0') {
		queue<pair<int, int>> temp;
		cnt++;
		
		while (q.size()) {
			int y, x;
			tie(y, x) = q.front(); q.pop();
			
			for (int i = 0; i < 4; i++) {
	            int ny = y + dy[i];
	            int nx = x + dx[i];
	            if (0 > ny || 0 > nx || nx >= m || ny >= n || visited[ny][nx]) continue;
	            visited[ny][nx] = cnt;
	            
	            if (a[ny][nx] == '0') {
	                q.push({ny, nx});
	            }
	            else if (a[ny][nx] == '1' || a[ny][nx] == '#') {
	            	a[ny][nx] = '0';
	            	temp.push({ny, nx});
	            }
        	}
		}
		q = temp;
	}
    
    cout << visited[crim.first][crim.second];
    
    return 0;
}