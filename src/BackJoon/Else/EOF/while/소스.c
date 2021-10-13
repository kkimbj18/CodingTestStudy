#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int A, B;

	while (1)
	{
		if (scanf("%d %d", &A, &B) == EOF)
			break;

		printf("%d", A + B);
	}
}