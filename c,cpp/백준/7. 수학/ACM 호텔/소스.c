#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int C;
	// �׽�Ʈ ���̽� ��
	
	int N;
	// �մ� ��

	int x, y;
	// �մ��� �� ��ġ
	int w, h;
	//ȣ�� �� ��, �� ��

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