/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
=================================================================================================================
입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
=================================================================================================================
출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/
#include <iostream>
#include <algorithm>

using namespace std;
void bubble_sort(int* tmp, int N)
{
    int temp;
    for(int i = 0; i < N-1; i++)
    {
        for(int j = i; j < N; j++)
        {
            if(tmp[i] > tmp[j])
            {
                temp = tmp[i];
                tmp[i] = tmp[j];
                tmp[j] = temp;
            }
        }
    }
}
int main(){
    int N;

    cin >> N;
    
    int* tmp = new int[N];

    for(int i = 0; i < N; i++) cin >> tmp[i];

    bubble_sort(tmp, N);

    for(int i = 0; i < N; i++)
        cout << tmp[i] << endl;

    delete[] tmp;

    return 0;
}