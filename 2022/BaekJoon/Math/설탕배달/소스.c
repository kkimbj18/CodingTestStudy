#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int N;

	int a = 0;
	int b = 0;

	int count = 0;

	scanf("%d", &N);

	for (int a = 0;a <= N / 3;a++)
	{
		if ((N - 3 * a) % 5 == 0)
		{
			b = (N - 3 * a) / 5;
			count = a + b;
			break;
		}
	}

	if (count == 0) count = -1;

	printf("%d", count);

	return 0;
}