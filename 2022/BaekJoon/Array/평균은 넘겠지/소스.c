#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>

int main(void)
{
	int C;
	//�׽�Ʈ ���̽� ����

	scanf("%d", &C);

	for (int i = 0; i < C; i++)
	{
		int Count = 0;
		//�׽�Ʈ ���̽� �� ����� �Ѵ� �л� �� ī��Ʈ
		int S;
		//�׽�Ʈ ���̽� �� �л� ��
		int T = 0;
		//�׽�Ʈ ���̽� �� �� ��
		double A;
		//�׽�Ʈ ���̽� �� ���

		scanf("%d", &S);

		int* n = (int*)malloc(sizeof(int) * S);
		//�׽�Ʈ ���̽� �� �л����� ���� ����
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