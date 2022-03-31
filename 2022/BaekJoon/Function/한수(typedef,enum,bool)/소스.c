#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

typedef enum
{
	false,
	true
}bool;
bool han(int a)
{
	if (a < 100)
		return true;
	else if (a >= 100)
	{
		if (a / 100 - a / 10 % 10 == a / 10 % 10 - a % 10)
			return true;
		else return false;
	}
	else return false;
}
int main()
{

	int N;
	int C = 0;

	scanf("%d", &N);

	for (int i = 0;i < N;i++) if(han(i+1)) C++;

	printf("%d", C);

	return 0;
}