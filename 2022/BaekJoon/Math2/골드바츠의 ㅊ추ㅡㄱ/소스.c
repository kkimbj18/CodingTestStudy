#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

typedef enum {
	false, true
}bool;

int main() 
{
	int n;
	//테스트 케이스 수

	bool P[10000];

	for (int i = 2; i < 10000;i++)
	{
		int count = 0;

		for (int j = 1; j <= i; j++)
			if (i % j == 0) count++;

		if (count == 2) P[i] = true;
		else P[i] = false;
	}

	scanf("%d", &n);

	int* N = (int*)malloc(sizeof(int) * n);

	for (int i = 0;i < n;i++)
	{
		int a, b;
		int A, B;

		scanf("%d", &N[i]);

		for (int j = 0; j < N[i]/2 - 1;j++)
		{
			a = j + 2;
			b = N[i] - a;

			if (P[a] == 1&&P[b] == 1)
			{
				A = a;
				B = b;
			}
		}
		printf("%d %d\n", A, B);
	}

	return 0;
}