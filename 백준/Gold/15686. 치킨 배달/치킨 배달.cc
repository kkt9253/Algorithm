#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1e7;

int n, m, a[54][54], mi = INF;
vector<pair<int, int>> h, c;
vector<int> md;

int cal() {
    int totalDistance = 0;
    for (auto i : h) {
        int minDistance = INF;
        for (int j : md) {
            int chickenDistance = abs(c[j].first - i.first) + abs(c[j].second - i.second);
            minDistance = min(minDistance, chickenDistance);
        }
        totalDistance += minDistance;
    }
    return totalDistance;
}

void combi(int start) {
    if (md.size() == m) {
        mi = min(mi, cal());
        return;
    }
    for (int i = start + 1; i < c.size(); i++) {
        md.push_back(i);
        combi(i);
        md.pop_back();
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n >> m;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
            if (a[i][j] == 1) h.push_back({i, j});
            if (a[i][j] == 2) c.push_back({i, j});
        }
    }
    
    combi(-1);
    cout << mi << '\n';
    
    return 0;
}
