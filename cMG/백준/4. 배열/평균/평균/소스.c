#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>

// ��Ÿ�� ���� ( �ʹ� ���� �ð��� �ҿ�� )

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
	double* s = (double*)malloc(sizeof(int) * N);
	// ���۵� �������� ����

	scanf("%d", &Score[0]);
	M = Score[0];

	for (int i = 1; i < N;i++)
	{
		scanf("%d", &Score[i]);
		if (Score[i] > M) M = Score[i];
	}
	for (int i = 0; i < N; i++)
	{
		s[i] = (double)Score[i] / M * 100;
		T += s[i];
	}
	A = T / N;

	printf("%lf", A);
}