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
#define mid ((left+right)/2)

#include <iostream>
#include <algorithm>

using namespace std;

int* temp;

void merge(int* tmp, int left, int right);
void partition(int* tmp, int left, int right);
void merge_sort(int* tmp, int N);
void print(int* tmp, int N);

void merge(int* tmp, int left, int right)
{
    int i, j, k, opt;

    //int* temp = new int[right-left + 1];

    i = left;
    j = mid + 1;
    k = left;
    
    while(i <= mid && j <= right)
    {
        if(tmp[i] <= tmp[j])
            temp[k++] = tmp[i++];
        else
            temp[k++] = tmp[j++];
    }

    opt = i > mid ? j : i;

    while(k<=right) temp[k++] = tmp[opt++];

    for(int x = left; x <= right; x++) tmp[x] = temp[x];

    //delete[] temp;
}
void partition(int* tmp, int left, int right)
{
    if(left < right)
    {
        partition(tmp, left, mid);
        partition(tmp, mid+1, right);
        merge(tmp, left, right);
    }
}
void merge_sort(int* tmp, int N)
{
    partition(tmp, 0, N-1);
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
    temp = new int[N];

    for(int i = 0; i < N; i++)
        cin >> tmp[i];

    merge_sort(tmp, N);
    print(tmp, N);

    delete[] tmp;
    delete[] temp;

    return 0;
}