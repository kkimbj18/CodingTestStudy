#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

void hanoi(int num,int start, int to, int via) {
	if (num == 1) 
		printf("%d %d\n", start, to);
	else {
		hanoi(num - 1, start, via, to);
		printf("%d %d\n", start, to);
		hanoi(num - 1, via, to, start);
	}
}
int main()
{
	int K;
	int S;

	scanf("%d", &K);

	S = pow(2, K) - 1;

	printf("%d\n", S);

	hanoi(K,1,3,2);

	return 0;
}