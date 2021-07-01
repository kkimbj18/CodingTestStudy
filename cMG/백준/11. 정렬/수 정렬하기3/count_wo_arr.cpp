/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
=================================================================================================================
입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
=================================================================================================================
출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/
#define max_num 10000

#include <iostream>

using namespace std;

void print(int* cnt);

void print(int* cnt)
{
    for(int i = 0; i < max_num; i++)
        if(cnt[i] != 0)
        {
            for(int j = 0; j < cnt[i]; j++)
                cout << i+1 << '\n';
        }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int N;
    int x;
    int cnt[max_num] = {0};

    cin >> N;

    for(int i = 0; i < N; i++)
    {
        cin >> x; 
        cnt[x-1]++;
    }

    print(cnt);

    return 0;
}