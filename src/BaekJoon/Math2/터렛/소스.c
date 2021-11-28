#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

int main() 
{
	int T;
	//테스트 케이스 수

	int x1, x2, y1, y2, r1, r2;

	scanf("%d", &T);

	for (int i = 0;i < T;i++)
	{
		int c;

		scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);

		int x = x2 - x1;
		int y = y2 - y1;
		int r = r1 + r2;
		int nr = r2 - r1;

		int d = x*x + y*y;

		if (r*r == d) c = 1;
		else if (r * r < d) c = 0;
		else if (r * r > d) {
			if (nr * nr == d) c = 1;
			else if (nr * nr < d) c = 2;
			else if (nr * nr > d) c = 0;
		}

		if (x1 == x2 && y1 == y2 && r1 == r2) c = -1;

		printf("%d\n", c);
	}
}