#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int n, m, a, ret;
int ar[100001];  // 배열 크기 수정: 최대값 100,000 + 1로 설정
vector<int> v;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n >> m; // 재료 개수와 갑옷 만드는데 드는 값 
    
    if (m >= 200000) { // 재료의 최대 값은 100000까지인데 재료의 최대합은 199999까지이므로 이 수의 초과값이면 종료 
        cout << 0;
        return 0;
    }
    // ar배열은 각 인덱스가 해당 재료의 값과 동일, 즉 ar[8]이 1이면 8의 재료를 갖고 있다는 의미로 ar배열 사용함 
    while (n--) {
        cin >> a;
        if (a <= 100000) {  // 추가: 입력값 a가 배열 크기를 넘지 않도록 체크
            ar[a] = 1; 
            v.push_back(a);
        }
    }
    
    for (int i : v) { // 재료 순회하면서
        if (m - i > 0 && m - i <= 100000 && m - i != i && ar[m - i]) { // i가 m이 되기 위해선 i + (m - i) 이므로  ar[m - i]있는지 확인 
            ret++; // 있으면 개수 올리고 
            ar[m - i] = ar[i] = 0; // 사용한 재료 삭제 
        } 
    }
    cout << ret;
    return 0;
}
