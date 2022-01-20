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

void count_number(int* arr, int* cnt, int N);
//void counting_sort(int* arr, int* cnt, int N);
void print(int* arr, int* cnt);

void count_number(int* arr, int* cnt, int N)
{
    for(int i = 0; i < N; i++)
        cnt[arr[i]-1]++;
}
/*
void counting_sort(int* arr, int* cnt, int N)
{
    count_number(arr, cnt, N);
*/
    /*
    for(int i = 0; i < 10; i++)
        cout << cnt[i] << " ";
    cout << endl;
    */
/*
    int count = 0;
    
    for(int i = 0; i < N; i++)
    {
        if(cnt[count]>0)
        {
            arr[i] = count+1;
            cnt[count]--;
        }
        else
        {
            count++;
            i--;
        }
        
    }
}
*/
void print(int* arr, int* cnt)
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
    int cnt[max_num] = {0};

    cin >> N;

    int* arr = new int[N];

    for(int i = 0; i < N; i++)
        cin >> arr[i]; 

    count_number(arr, cnt, N);
    print(arr, cnt);

    return 0;
}