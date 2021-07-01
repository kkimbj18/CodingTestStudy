#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
    int a, b, c;

    int x;

    scanf("%d %d %d", &a, &b, &c);

    if (b >= c) x = -1;
    else x = (a / (c - b)) + 1;

    printf("%d", x);

    return 0;
}