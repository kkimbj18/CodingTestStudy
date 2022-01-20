#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	unsigned long long int n, m;

	unsigned long long int mp;
	unsigned long long int ml;

	scanf("%lld %lld", &n, &m);

	mp = n / m;
	ml = n % m;

	printf("%lld\n%lld", mp, ml);

	return 0;
}