#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int C;
	// 테스트 케이스 수
	
	int N;
	// 손님 수

	int x, y;
	// 손님의 방 위치
	int w, h;
	//호텔 방 수, 층 수

	scanf("%d", &C);

	for (int i = 0;i < C;i++)
	{
		scanf("%d %d %d", &h, &w, &N);

		x = (N - 1) / h + 1;

		if (N % h == 0)
			y = h * 100;
		else
			y = (N % h) * 100;

		printf("%d\n", y + x);
	}

	return 0;
}