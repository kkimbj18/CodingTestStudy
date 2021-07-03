#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	char word[1000001];
	int count[26] = { 0, };
	// 아스키 코드 대문자 알파벳 26개 순서대로 카운트 갯수 0으로 초기화
	char ans;
	// 최빈 알파벳
	int max = 0;
	// 최대 카운트 수
	int x;
	// word[i]의 아스키 코드 값

	scanf("%s", &word);

	int N = strlen(word);
	// 반복문에서 시간초과를 배제하기위해 따로 글자 수 변수로 지정

	for (int i = 0;i < N;i++)
	{
		x = word[i];
		if (x <= 90)
			count[x - 65]++;
		else count[x - 97]++;
	}

	for (int i = 0;i < 26; i++)
	{
		if (count[i] == max) ans = '?';
		else if (count[i] > max)
		{
			max = count[i];
			ans = i + 65;
		}

	}
	printf("%c\n", ans);

	return 0;
}