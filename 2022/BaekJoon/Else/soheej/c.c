/*
# 행사 일정

 

## 문제 설명

국내 최대의 결혼 정보 회사인 아주웨딩에서는 VIP 고객들을 대상으로 한 다대다 미팅 행사를 개최하려고 한다. 
행사는 내년에 개최 될 예정이며 최대한 많은 고객들이 참가할 수 있는 일정을 정하려고 한다. 아주웨딩은 초정 대상이 될 고객들에게 설문조사를 통해 참가 가능한 일정을 수집했다. 
아래의 조건에 맞추어서 정할 수 있는 최적의 일정을 생각해보자.

 

- 각 고객은 남자 혹은 여자의 한 성별을 가진다.

- 각 고객은 내년 중 행사에 무조건 참가할 수 있는 하나의 기간이 존재한다.

- 행사에는 같은 수의 남자와 여자가 참가해야 한다.

- 최대한 많은 수의 고객이 참가할 수 있는 날짜를 행사일로 결정해야 한다.

 

각 고객의 성별과 참가 가능 기간에 대한 응답 정보들이 주어질 때 행사 참가인원의 최대값을 계산하는 프로그램을 작성하시오.

 

## 입력 형식

첫 줄에는 설문조사에 응답한 회원의 수를 나타내는 5,000이하의 자연수 N이 주어진다. 이후 총 N명의 고객에 대한 설문조사 결과가 한 줄에 하나씩 차례로 주어진다.

 

한 고객의 설문조사 응답은 한 줄로 이루어 져 있으며 S A B형식으로 주어진다.

 

- S는 고객의 성별을 나타내는 한 글자의 문자다. F는 여성을 의미하며 M은 남성을 의미한다.

- A와 B는 고객이 참가할 수 있는 기간을 의미한다.

- A와 B는 1이상 366이하의 자연수이며 항상 A는 B이하의 값이다.

- 내년 1년 기간 중 A번 째 날부터 B번째 날 까지 항상 행사가 참여가 가능하다는 의미이다.

- 1월 1일이 첫 번째 날이며, 12월 31일이 366번째 날이다.

 

## 출력 형식

가장 많은 고객이 참가할 수 있는 행사 날의 참가 고객 수를 출력하시오.
*/
#pragma warning(disable: 4996)

#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<memory.h>
#include<string.h>

#define MAX2(a, b) 	((a) > (b) ? (a) : (b))
#define MIN2(a, b) 	((a) < (b) ? (a) : (b))
#define ABS(x) 		((x) < 0 ? -(x) : (x))

#define MAX_N 5000 

int main(){
	int N;
	char gender[MAX_N];
	int A[MAX_N];
	int B[MAX_N];
	int i, j;
	int number_of_people = 0;
	int women[367] = { 0 };
	int man[367] = { 0 };
	
	scanf("%d", &N);

	
	for(i = 0 ; i < N; i += 1){
		scanf("\n%c %d %d", &gender[i], &A[i], &B[i]);
	}

	/****** Your Code ********/
	
    for(i = 0 ; i < 366; i++) {
        for(j = 0 ; j < N; j++) {
            if(A[j] <= i && B[j] >= i) {
                gender[j] == 'F' ? women[i]++ : man[i]++;
            }
        }
    }

    for(i = 0; i < 366; i++) {
        int tmp = 2 * MIN2(women[i], man[i]);

        if(tmp > number_of_people) number_of_people = tmp;
    }

	/*************************/

	printf("%d\n", number_of_people);
	return 0;
}