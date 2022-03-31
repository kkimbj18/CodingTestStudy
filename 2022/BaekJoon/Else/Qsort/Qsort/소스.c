#define _CRT_SECURE_NO_WARNINGS
#define MAX 1000000
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int n[MAX];

void Qsort(int* n, int start, int end)
{
	if (start >= end) return;

	int pivot = start;

	int i = start + 1;
	int j = end;
	int temp;

	while (j > i)
	{
		while (n[j] > n[pivot])
			j--;
		while (n[i] < n[pivot] && j > i)
			i++;
		if (j > i) 
		{
			temp = n[i];
			n[i] = n[j];
			n[j] = temp;
		}
	}
	if (n[pivot] > n[i]) {
		temp = n[i];
		n[i] = n[pivot];
		n[pivot] = temp;
	}

	pivot = i;

	Qsort(n, start, pivot - 1);

	Qsort(n, pivot, end);
}
int main()
{
	int input;

	scanf("%d", &input);

	int* n = (int*)malloc(sizeof(int) * input);

	for(int i = 0; i < input; i++)
		scanf("%d", &n[i]);

	Qsort(n, 0, input - 1);

	for (int i = 0;i < input;i++)
		printf("%d\n", n[i]);

	return 0;
}