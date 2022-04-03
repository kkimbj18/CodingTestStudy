import java.util.*;

class Solution {
    static int N;
    static boolean[][][] map;
    
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        N = n+1;
        map = new boolean[N][N][2];
        
        // 가로, 세로, 종류, 설치/삭제
        for (int[] command: build_frame) {
            build(command);
        }
        
        answer = findResult();
        
        return answer;
    }
    
    public static int[][] findResult() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int t = 0; t < 2; t++) {
                    if (map[j][i][t]) list.add(new int[] { i, j, t });
                }
            }
        }
        int[][] res = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    public static void build(int[] command) {
        int x = command[0];
        int y = command[1];
        int type = command[2];
        int action = command[3];
        
        if (action == 1) {
            if (!checkValid(command)) return;
            
            map[y][x][type] = true;
        } else if (action == 0) { 
            remove(y, x, type);
        }
        
        
    }
    
    public static void remove(int y, int x, int type) {
        map[y][x][type] = false;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k] && !checkValid(new int[] { j, i, k })) {
                        map[y][x][type] = true;
                        return;
                    } 
                }
            }
        }
        
//         for (int d = 0; d < 4; d++) {
//             int ty = y + dy[d];
//             int tx = x + dx[d];
//             if (ty < 0 || tx < 0 || ty >= N || tx >= N) continue;

//             for (int i = 0; i < 2; i++) {
//                 if (map[ty][tx][i]) {
//                     if (!checkValid(new int[]{ tx, ty, i })) {
//                         map[y][x][type] = true;
//                         return;
//                     }
//                 }
//             }
//         }
    }
    
    public static boolean checkValid(int[] command) {
        // 가로, 세로, 종류, 설치/삭제
        int x = command[0];
        int y = command[1];
        int type = command[2];
        
        if (type == 0) {
            if (y == 0) return true;
            if (map[y-1][x][0]) return true;
            if ((x-1 >= 0 && map[y][x-1][1]) || map[y][x][1]) return true;
        } else if (type == 1) {
            if (map[y-1][x][0] || (x+1 < N && map[y-1][x+1][0])) return true;
            if ((x-1 >= 0 && map[y][x-1][1]) && (x+1 < N && map[y][x+1][1])) return true;
        }
        
        return false;
    }
}