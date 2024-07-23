#include <bits/stdc++.h>
using namespace std;
#define prev tak
const int INF = 987654321;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

char a[1004][1004];
int n, m;
int ft[1004][1004], jh[1004][1004];
queue<pair<int, int>> f;
queue<pair<int, int>> jq;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n >> m;
    for(int i = 0; i < n; i++){ 
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if (a[i][j] == 'F') {
                ft[i][j] = 0;
                f.push({i, j});
            } else {
                ft[i][j] = INF;
            }
            if (a[i][j] == 'J') {
                jh[i][j] = 0;
                jq.push({i, j});
            } else {
                jh[i][j] = INF;
            }
        }
    }
    
    while(!f.empty()) {
        int y = f.front().first;
        int x = f.front().second;
        f.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (ft[ny][nx] != INF || a[ny][nx] == '#') continue;
            f.push({ny, nx});
            ft[ny][nx] = ft[y][x] + 1;
        }
    }
    
    while(!jq.empty()) {
        int y = jq.front().first;
        int x = jq.front().second;
        jq.pop();
        if (x == m - 1 || y == n - 1 || x == 0 || y == 0) {
            cout << jh[y][x] + 1;
            return 0;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (a[ny][nx] == '#' || jh[ny][nx] != INF || jh[y][x] + 1 >= ft[ny][nx]) continue;
            jq.push({ny, nx});
            jh[ny][nx] = jh[y][x] + 1;
        }
    }
    
    cout << "IMPOSSIBLE";
    return 0;  
}
