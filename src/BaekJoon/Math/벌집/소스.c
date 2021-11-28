#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int N;
	int i = -1;
	int c = 1;
	int t = 0;

	scanf("%d", &N);

	while (1)
	{
		i++;
		t += 6 * i;
		if ((N - 1) <= t) break;
		else c++;
	}

	printf("%d", c);

	return 0;
}