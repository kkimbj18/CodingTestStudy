/*
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이

N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
=================================================================================================================
입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
=================================================================================================================
출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
*/
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

void scope(vector<int> v, int N)
{
    int range = v[N-1] - v[0];

    cout << range << endl;
}
void density(vector<int> v, int N)
{
    int cnt = 0;
    int m_cnt = 0;
    vector<int> tmp;

    for(int i = 0; i < N; i++)
    {
        if(v[i+1] == v[i])
        {
            cnt++;
        }
        else cnt = 0;

        if(cnt > m_cnt) 
        {
            m_cnt = cnt;
            tmp.clear();
            tmp.push_back(v[i]);
        }
        else if(cnt == m_cnt)
            tmp.push_back(v[i]);
    }
    if(tmp.size() > 1)  cout << tmp[1] << endl;
    else cout << tmp[0] << endl;
}
void medium(vector<int> v, int N)
{
    cout << v[(N-1)/2] << endl;
}
void cal_avg(vector<int> v, int N)
{
    double avg, sum = 0;
    
    for(int i = 0; i < N; i++)
        sum += v[i];
    
    avg = sum / N;

    cout << round(avg) << endl;
}
int main(){
    int N;
    
    cin >> N;

    vector<int> v(N);

    for(int i = 0; i < N; i++)
        cin >> v[i];

    sort(v.begin(), v.end());

    cal_avg(v, N);
    medium(v, N);
    density(v, N);
    scope(v, N);

    return 0;
}