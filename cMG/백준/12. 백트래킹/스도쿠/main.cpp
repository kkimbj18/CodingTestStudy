/*
문제
스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 
정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.



나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.



또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.



이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.



게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
=================================================================================================================
입력
아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 
스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
=================================================================================================================
출력
모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
*/
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int arr[9][9];
int cnt = 0;

void print_board()
{
    //cout << "after 스도쿠" << endl;
    for(int j = 0; j < 9; j++)
    {
        for(int i = 0; i < 9; i++)
        {
            cout << arr[j][i] << " ";
        }
        cout << endl;
    }
}
void possible(vector<int> &ps, vector<pair<int, int>> &loc)
{
    //cout << loc[cnt].first << loc[cnt].second << endl;

    int j = loc[cnt].first;
    int i = loc[cnt].second;

    int tmp_col[10] = {0};
    int tmp_row[10] = {0};
    int tmp_cell[10] = {0};

    int rs = (j/3)*3;
    int cs = (i/3)*3;

    for(int a = 0; a < 9; a++)
    {
        if(arr[j][a] != 0)
            tmp_col[arr[j][a]]++;
        if(arr[a][i] != 0)
            tmp_row[arr[a][i]]++;
        if(arr[rs+a/3][cs+a%3] != 0)
            tmp_cell[arr[rs+a/3][cs+a%3]]++;
    }
    for(int a = 1; a < 10; a++)
    {
        if(tmp_col[a] > 1 || tmp_row[a] > 1 || tmp_cell[a] > 1)
            return;

        else if(tmp_col[a] > 0)
            continue;
        else if(tmp_row[a] > 0)
            continue;
        else if(tmp_cell[a] > 0)
            continue;

        ps.push_back(a);
        //cout << ps.back();
    }
}
void fill_board(vector<pair<int, int>> &loc)
{
    if(cnt >= loc.size())
        return;

    vector<int> ps;

    possible(ps, loc);

    while(ps.size() > 0)
    {
        arr[loc[cnt].first][loc[cnt].second] = ps.back();
        ps.pop_back();
        cnt++;
        fill_board(loc);
    }
    if(ps.size() == 0)
    {
        cnt--;
        return;
    }
    
}
int main()
{
    int arr[9][9];

    vector<pair<int, int>> loc;

    for(int j = 0; j < 9; j++)
    {
        for(int i = 0; i < 9; i++)
            cin >> arr[j][i];
    }

    for(int j = 0; j < 9; j++)
    {
        for(int i = 0; i < 9; i++)
        {
            if(arr[j][i] == 0)
            {
                loc.push_back(make_pair(j, i));
                //cout << loc.back().first << " ";
                //cout << loc.back().second << endl;
            }
        }
    }
    fill_board(loc);
    print_board();

    return 0;
}