#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>

int main(void)
{
	int N;
	// ���� �� ���� ��
	int M;
	// ���� �� ���� �� �ִ밪
	double A;
	//���۵� ���� ���
	double T = 0;
	//���۵� ���� ��

	scanf("%d", &N);

	int* Score = (int*)malloc(sizeof(int) * N);
	// �������� ����

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