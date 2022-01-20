/*
양의 정수에 대한 새로운 연산자 #을 365 # 127 = (3 + 6 + 5) + (1 + 2 + 7) = 24와 같이 각 정수의 자릿수를 모두 더하는 것으로 정의할 때, 
임의로 주어진 개의 양의 정수 s1, a1, a2, a3, … , aN-1으로부터 sN은 다음과 같이  N - 1번의  #연산을 순차적으로 계산한 결과 값이다.

 

1부터 999까지 양의 정수 중에서 임의로 선택한 N개의 정수가 주어져 있을 때, 위에서 정의한대로 계산한 결과 sN을 출력하는 프로그램을 작성하시오.

[제약사항]
주어진 정수의 개수는 최대 100개 이내로 제한한다. 시간제한: 0.1초

[입력]
입력은 한 줄에 N의 값과 N개의 정수가 빈 칸을 사이에 두고 차례대로 주어진다.

[출력]
계산 결과 얻어진 sN의 값을 출력한다.
*/

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

#define INPUT_NUM_MAX 100

int main()
{
    int input_num;
    int input_data[INPUT_NUM_MAX];
    int out;
    int i;

    scanf("%d", &input_num);
    for (i = 0; i < input_num; i++)
        scanf("%d", &input_data[i]);

    ////////////////////////////////////////

    out = 0;

    for (int i = 0; i < input_num; i++)
    {
        int temp = 0;

        if (input_data[i] / 100 >= 1)
        {
            int a = input_data[i] / 100;
            int b = input_data[i] / 10 - a * 10;
            int c = input_data[i] - a * 100 - b * 10;
            temp = a + b + c;

            //printf("A");
        }
        else if (input_data[i] / 10 >= 1)
        {
            int b = input_data[i] / 10;
            int c = input_data[i] % 10;
            temp = b + c;

            //printf("B");
        }
        else{
            temp = input_data[i];

            //printf("C");
        }

        if(out / 10 >= 1) out = out / 10 + out % 10;

        out += temp;
    }

    ////////////////////////////////////////

    printf("%d", out);
    return 0;
}