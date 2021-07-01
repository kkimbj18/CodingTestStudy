#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) 
{
	int H, M;
	int h, m;

	scanf("%d %d", &H, &M);

	if (M >= 45)
	{
		m = M - 45;
		h = H;
	}
	else
	{
		m = 15 + M;
		// M - 45 + 60
		if (H == 0)
			h = 23;
		else h = H - 1;
	}
	printf("%d %d", h, m);
}