#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	double A, B, V;

	int n;

	double H;

	scanf("%lf %lf %lf", &A, &B, &V);

	H = V / (A - B) - (B / (A - B));

	if (H - (int)H == 0) n = (int)H;
	else n = (int)H + 1;

	printf("%d\n", n);

	return 0;
}