#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

/* ���ӵ� ������ ���� ���, �ܾ��� ������ ����ϴ� �˰���*/

int main()
{
	char w[1000001];
	//���ڿ�
	int c = 0;
	//�ܾ� ��

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