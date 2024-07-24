#include <bits/stdc++.h>
using namespace std;
const int MAX = 200000;
int visited[MAX + 4];
long long cnt[MAX + 4];

int main() {
    int n, k;
    cin >> n >> k;
    
    if (n == k) {
        puts("0"); 
        puts("1");
        return 0; 
    }

    visited[n] = 1;
    cnt[n] = 1;
    queue<int> q;
    q.push(n);
    
    while (!q.empty()) {
        int now = q.front();
        q.pop();
        
        for (int next : {now - 1, now + 1, now * 2}) {
            if (0 <= next && next <= MAX) {
                if (!visited[next]) {
                    q.push(next);
                    visited[next] = visited[now] + 1;
                    cnt[next] = cnt[now];  // 새로 방문한 경우
                } else if (visited[next] == visited[now] + 1) {
                    cnt[next] += cnt[now];  // 최단 시간으로 방문한 경우
                }
            }
        }
    }
    
    cout << visited[k] - 1 << '\n';
    cout << cnt[k] << '\n';
    return 0;
}
