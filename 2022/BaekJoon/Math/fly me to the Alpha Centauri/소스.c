#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int T;
	// 테스트 케이스 수

	scanf("%d", &T);

	long long int x, y;
	//현 위치, 목표 위치

	for (int i = 0;i < T;i++)
	{
		long long int d;
		// 이동해야할 거리

		scanf("%d %d", &x, &y);

		d = y - x;

		long long int j = 1;
		
		long long int n;
		while (1)
		{
			if (d > j * j - j && d <= j * j + j)
			{
				if (d <= j * j) n = 2 * j - 1;
				else n = 2 * j;
				break;
			}
			j++;
		}

		printf("%d\n", n);
	}

	return 0;
}