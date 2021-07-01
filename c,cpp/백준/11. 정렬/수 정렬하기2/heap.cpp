/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
=================================================================================================================
입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
=================================================================================================================
출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/
#include <iostream>
#include <algorithm>

using namespace std;

void heapify(int* tmp, int i, int N);
void heap_sort(int* tmp, int N);
void print(int* tmp, int N);

void heapify(int* tmp, int i, int N)
{
    int l = i * 2 + 1;
    int r = i * 2 + 2;
    int max = i;

    if(l < N && tmp[max] < tmp[l]) max = l;
    if(r < N && tmp[max] < tmp[r]) max = r; 
    if(max!=i)
    {
        swap(tmp[i], tmp[max]);
        heapify(tmp, max, N);
    }
}
void heap_sort(int* tmp, int N)
{
    //초기 MAX힙 구현
    for(int i = N/2 - 1; i >= 0; i--)
        heapify(tmp, i, N);
    //MAX힙의 최상위 부분을 최하단 노드로 빼서 힙 구현에서 제외시키면서 힙 구현
    for(int i = N - 1; i >= 0; i--)
    {
        swap(tmp[0], tmp[i]);
        heapify(tmp, 0, i);
    }
}
void print(int* tmp, int N)
{
    for(int i = 0; i < N; i++)
        cout << tmp[i] << '\n';
}
int main()
{
    int N;

    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> N;

    int* tmp = new int[N];

    for(int i = 0; i < N; i++)
        cin >> tmp[i];

    heap_sort(tmp, N);
    print(tmp, N);

    delete[] tmp;

    return 0;
}