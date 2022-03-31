#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

/* 연속된 공백이 없는 경우, 단어의 갯수를 계산하는 알고리즘*/

int main()
{
	char w[1000001];
	//문자열
	int c = 0;
	//단어 수

	scanf("%[^\n]s",w);

	int s = strlen(w);
	
	if (w[0] != ' ') c++;
	for (int i = 0;i < s;i++)
	{
		if (w[i + 1] != '\0') {
			if (w[i] == ' ') c++;
		}
	}
	printf("%d", c);

	return 0;
}