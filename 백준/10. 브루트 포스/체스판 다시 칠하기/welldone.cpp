#include <stdio.h>

int main() {
	
	char arr[50][50];
	int n, m;
	int cnt = 0;
	int min = 64;
	scanf("%d%d", &n, &m);
	int i, j;

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			scanf(" %c", &arr[i][j]);
			if (i >= 7 && j >= 7) {
				for (int k = i; k >= i - 7; k--) {
					for (int l = j; l >= j - 7; l--) {
						if ((i + j) % 2 == (k + l) % 2) {
							if (arr[i][j] != arr[k][l]) {
								cnt++;
							}
						}
						else if ((i + j) % 2 != (k + l) % 2) {
							if (arr[i][j] == arr[k][l]) {
								cnt++;
							}
						}
					}
				}
				if (min >= cnt) {
					min = cnt;
				}
				cnt = 0;
			}
		}
	}
	printf("%d\n", min);
}