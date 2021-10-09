#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() 
{
	int N;
	int M;

	scanf("%d %d", &N, &M);

	

	int* n = (int*)malloc(sizeof(int) * N);

	for (int i = 0; i < N; i++)
		scanf("%d", &n[i]);

	int max = 0;
	int ta;

	for (int i = 0; i < N - 2;i++)
	{
		for (int j = i + 1;j < N - 1;j++)
		{
			for (int z = j + 1;z < N;z++)
			{
				ta = n[i] + n[j] + n[z];

				if (max < ta&&ta<=M)
					max = ta;

				if (ta == M)
					break;
			}
		}
	}
	printf("%d\n", max);

	return 0;
}