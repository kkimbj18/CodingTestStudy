#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>

int main(void)
{
	int C;
	//테스트 케이스 개수

	scanf("%d", &C);

	for (int i = 0; i < C; i++)
	{
		int Count = 0;
		//테스트 케이스 내 평균을 넘는 학생 수 카운트
		int S;
		//테스트 케이스 내 학생 수
		int T = 0;
		//테스트 케이스 내 총 합
		double A;
		//테스트 케이스 내 평균

		scanf("%d", &S);

		int* n = (int*)malloc(sizeof(int) * S);
		//테스트 케이스 내 학생들의 점수 집합
		for (int j = 0; j < S; j++) 
		{
			scanf("%d", &n[j]);
			T += n[j];
		}
		A = (double)T / S;
		for (int j = 0; j < S; j++) 
			if (n[j] > A) Count++;
		printf("%.3lf%%\n", (double)Count / S * 100);
	}
}