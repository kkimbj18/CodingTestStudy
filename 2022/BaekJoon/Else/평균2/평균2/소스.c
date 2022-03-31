#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>

int main(void)
{
	int N;
	// 시험 본 과목 수
	int M;
	// 시험 본 과목 중 최대값
	double A;
	//조작된 점수 평균
	double T = 0;
	//조작된 점수 합

	scanf("%d", &N);

	int* Score = (int*)malloc(sizeof(int) * N);
	// 시험점수 집합

	scanf("%d", &Score[0]);
	M = Score[0];

	for (int i = 1; i < N;i++)
	{
		scanf("%d", &Score[i]);
		if (Score[i] > M) M = Score[i];
	}
	for (int i = 0; i < N; i++)
	{
		T += (double)Score[i] / M * 100;
	}
	A = T / N;

	printf("%lf", A);
}