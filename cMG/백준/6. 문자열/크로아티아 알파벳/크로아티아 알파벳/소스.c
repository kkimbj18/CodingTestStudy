#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	char input[101]; // �Է¹��� ���ĺ�

	scanf("%s", &input);

	int len = strlen(input);

	int i = 0; // üũ�� �ܾ��� index
	int c = 0; // ũ�ξ�Ƽ�� ���ĺ� ��

	while (len > i)
	{
		switch(input[i])
		{
		case 'c':
			if (input[i + 1] == '=' ||input[i + 1] == '-')
				i++;
			break;
		case 'd':
			if (input[i + 1] == 'z' && input[i + 2] == '=')
				i += 2;
			else if (input[i + 1] == '-')
				i++;
			break;
		case 'l':
			if (input[i + 1] == 'j')
				i++;
			break;
		case 'n':
			if (input[i + 1] == 'j')
				i++;
			break;
		case 's':
			if (input[i + 1] == '=')
				i++;
			break;
		case 'z':
			if (input[i + 1] == '=')
				i++;
			break;
		}
		i++;
		c++;
	}
	printf("%d", c);

	return 0;
}