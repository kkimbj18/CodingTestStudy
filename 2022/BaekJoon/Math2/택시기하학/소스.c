#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <stdio.h>
#include <math.h>

int main()
{
	double R;
	const double pi = acos(-1.0);

	scanf("%lf", &R);

	double uc, tc;

	uc = R * R * pi;
	tc = 2 * R * R;

	printf("%.6lf\n%.6lf", uc, tc);

	return 0;
}