#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	char word[1000001];
	int count[26] = { 0, };
	// �ƽ�Ű �ڵ� �빮�� ���ĺ� 26�� ������� ī��Ʈ ���� 0���� �ʱ�ȭ
	char ans;
	// �ֺ� ���ĺ�
	int max = 0;
	// �ִ� ī��Ʈ ��
	int x;
	// word[i]�� �ƽ�Ű �ڵ� ��

	scanf("%s", &word);

	int N = strlen(word);
	// �ݺ������� �ð��ʰ��� �����ϱ����� ���� ���� �� ������ ����

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