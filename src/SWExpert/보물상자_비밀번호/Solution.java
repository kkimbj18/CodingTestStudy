package SWExpert.��������_��й�ȣ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution
{
public static void main(String args[]) throws Exception
{
/*
�Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
�������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
�� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
*/
//System.setIn(new FileInputStream("res/input.txt"));

/*
ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
*/
	
Scanner sc = new Scanner(System.in);
int T;
T=sc.nextInt();
/*
���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
*/

for(int test_case = 1; test_case <= T; test_case++)
{
	HashSet<Integer> set = new HashSet<>();

	int N = sc.nextInt();
	int K = sc.nextInt();
	
	sc.nextLine();
	
	String num = "";
	
	num = sc.nextLine();
	
	for (int i = 0; i < N/4; i++) {
		for (int j = 0; j < 4; j++) {
			int temp = Integer.parseInt(num.substring((N/4)*j, (N/4)*(j+1)), 16);
			set.add(temp);
		}
		num = num.charAt(N-1) + num.substring(0, N-1);
	}
	
	ArrayList<Integer> list = new ArrayList<Integer>(set);
	Collections.sort(list, Collections.reverseOrder());
	
	System.out.println("#" + test_case + " " + list.get(K-1));
}

sc.close();
}
}