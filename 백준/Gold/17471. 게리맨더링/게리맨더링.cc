#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

int n, a[14], b, c, d, ret = INF;
vector<int> av[14];

// 선거구의 인구 합 
int cal(vector<int> &v) {
    int sum = 0;
    for (int i : v) sum += a[i];
    return sum;
}

// 모든 구역이 연결되어 있는지 확인하는 함수 (BFS)
bool check(vector<int> &v) {
    if (v.empty()) return false;
    vector<bool> visited(n + 1, false);
    queue<int> q;
    q.push(v[0]);
    visited[v[0]] = true;
    int count = 1;
    
    while (!q.empty()) {
        int cur = q.front(); q.pop();
        for (int next : av[cur]) {
            if (!visited[next] && find(v.begin(), v.end(), next) != v.end()) {
                visited[next] = true;
                q.push(next);
                count++;
            }
        }
    }
    
    return count == v.size();
}

// 1선거구, 2선거구를 나누어 모두 연결되어 있는지 확인하고 true라면 두 선거구의 인구차이를 ret에 저장. 
void go(int num) {
    vector<int> f;
    vector<int> s;
    for (int i = 0; i < n; i++) {
        if (num & (1 << i)) f.push_back(i + 1);
        else s.push_back(i + 1);
    }
    
    if (check(f) && check(s)) {
        int val = abs(cal(f) - cal(s));
        ret = min(ret, val);
    }
    
    return;
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++) {
        cin >> b;
        for (int j = 0; j < b; j++) {
            cin >> c;
            av[i].push_back(c);
        }
    }
    
    // 아무것도 포함하지 않는 경우를 제외한 모든 경우를 비트로 만들어 보냄. 
    for (int i = 1; i < (1 << n); i++) {
        go(i);
    }
    
    if (ret == INF) cout << -1;
    else cout << ret;
    
    return 0;
}
