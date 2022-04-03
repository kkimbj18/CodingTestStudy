class Solution {
    static int lockHollCnt;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int M = key.length;
        int N = lock.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) lockHollCnt++;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            // System.out.println(i);
            // print(key, M);
            for (int j = -(M-1); j < N + M - 1; j++) {
                for (int k = -(M-1); k < N + M - 1; k++) {
                    if(checkValid(j, k, N, M, key, lock)) return true;
                }
            }
            
            if (i == 3) break;
            key = rotate(key, M);
        }
        
        return false;
    }
    
    public static void print(int[][] key, int M) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(key[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static boolean checkValid(int y, int x, int N, int M, int[][] key, int[][] lock) {
        int cnt = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int ly = i + y;
                int lx = j + x;
                if (ly < 0 || lx < 0 || ly >= N || lx >= N) continue;
                // System.out.println(ly + " " + lx + " " + i + " " + j + " " + lock[ly][lx] + " " + key[i][j]);
                if (lock[ly][lx] == key[i][j]) return false;
                
                if (lock[ly][lx] == 0) cnt++;
            }
        }
        
        return (cnt == lockHollCnt) ? true : false;
    }
    
    public static int[][] rotate(int[][] key, int M) {
        int[][] newKey = new int[M][M];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                newKey[j][M-1-i] = key[i][j];
            }
        }
        // print(newKey, M);
        
        return newKey;
    }
}