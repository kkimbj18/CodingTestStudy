#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <malloc.h>


int main() {
    int max, min, x;

    scanf("%d", &x);

    int* a = (int*)malloc(sizeof(int) * x);

    for (int i = 0;i < x; i++)
        scanf("%d", &a[i]);

    max = min = a[0];

    for (int i = 0; i < x; i++)
    {
        if (max < a[i]) max = a[i];
        else if (min > a[i]) min = a[i];
    }
    printf("%d %d", max, min);

    return 0;
}