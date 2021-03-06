/*
# 버블 정렬 구현하기

 

## 문제 설명

버블 정렬은 아래와 같은 알고리즘으로 동작한다. 알고리즘을 이해해보고 직접 구현해보자.

 

데이터의 수가 N개 이고 데이터가 A[0] ~ A[N-1]에 저장되어 있다고 하자. 아래의 과정을 수행한다.

 

1. A[0] ~ A[N-1] 범위에 대해 아래의 과정을 수행한다.

- 배열의 0번 칸의 숫자가 1번 칸의 숫자 보다 크다면 두 값의 위치를 교환한다

- 배열의 1번 칸의 숫자가 2번 칸의 숫자 보다 크다면 두 값의 위치를 교환한다

- ...

- 배열의 N-2번 칸의 숫자가 N-1번 칸의 숫자 보다 크다면 두 값의 위치를 교환한다.

2. A[0] ~ A[N-2] 범위에 대해 위의 과정을 다시 수행한다.

3. …

4. A[0] ~ A[1] 범위에 대해 위의 과정을 다시 수행한다.

 

위의 알고리즘을 참고하여 버블 정렬을 구현해보자.

 

## 입력 형식

첫 줄에는 데이터의 수를 나타내는 자연수 N이 주어진다. N은 1이상 1,000이하의 자연수이다.

 

두 번째 줄에는 공백으로 구분된 N개의 정수가 주어진다. 모든 정수는 32비트 정수형 데이터이다.


 

## 출력 형식

한 줄에 N개의 오름차순으로 정렬 된 숫자들을 공백으로 구분하여 출력한다.

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