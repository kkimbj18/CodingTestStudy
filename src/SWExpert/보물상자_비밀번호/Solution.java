package SWExpert.보물상자_비밀번호;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;

class Solution
{
public static void main(String args[]) throws Exception
{
	
Scanner sc = new Scanner(System.in);
int T;
T=sc.nextInt();

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