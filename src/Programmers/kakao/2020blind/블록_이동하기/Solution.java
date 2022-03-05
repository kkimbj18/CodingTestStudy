import java.util.*;

class Solution {
    
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    
    // 90  : 0
    // -90 : 1
    // 왼아, 왼위, 오위, 오아
    static int[] ry = { 1, -1, -1, 1 };
    static int[] rx = { -1, -1, 1, 1 };
    
    public int solution(int[][] map) {
        int answer = bfs(map);
        
        return answer;
    }
    
    public boolean check(int y, int x, int N) {
        if (y < 0 || x < 0 || y >= N || x >= N) return true;
        
        return false;
    }
    
    public int bfs(int[][] map) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 0, 0, 1));
        int N = map.length;
        int count = 0;
        
        boolean[][][][] v = new boolean[N][N][N][N];
        v[0][0][0][1] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            count++;
            
            for (int qq = 0; qq < size; qq++) {
                P p = q.poll();
                
                // 칸 이동
                for (int d = 0; d < 4; d++) {
                    int lty = p.ly + dy[d];
                    int ltx = p.lx + dx[d];
                    int rty = p.ry + dy[d];
                    int rtx = p.rx + dx[d];
                    
                    if (check(lty, ltx, N) || check(rty, rtx, N)) continue;
                    if (map[lty][ltx] == 1 || map[rty][rtx] == 1 || v[lty][ltx][rty][rtx]) continue;
                    
                    if ((lty == N-1 && ltx == N-1) || (rty == N-1 && rtx == N-1)) return count;
                    
                    v[lty][ltx][rty][rtx] = true;
                    q.add(new P(lty, ltx, rty, rtx));
                }
                
                // 회전
                // 축
                for (int i = 0; i < 2; i++) {
                    int targety;
                    int targetx;
                    int axisy;
                    int axisx;
                    if (i == 1) {
                        targety = p.ry;
                        targetx = p.rx;
                        axisy = p.ly;
                        axisx = p.lx;
                    } else {
                        targety = p.ly;
                        targetx = p.lx;
                        axisy = p.ry;
                        axisx = p.rx;
                    }
                    
                    // 회전 방향
                    for (int j = 0; j < 2; j++) {
                        int ty = targety;
                        int tx = targetx;
                        int ay = axisy;
                        int ax = axisx;
                        
                        int add;
                        int start;
                        
                        if (j == 0) {
                            start = 3;
                        } else {
                            start = 2;
                        }
                        
                        // 왼아, 왼위, 오위, 오아
                        int d = 0;
                        if (targetx > axisx) d = 0;
                        else if (targety > axisy) d = 1;
                        else if (targetx < axisx) d = 2;
                        else if (targety < axisy) d = 3;
                        
                        ty += ry[(d+j) % 4];
                        tx += rx[(d+j) % 4];
                        if (check(ty, tx, N) || map[ty][tx] == 1) continue;
                        if (i == 0) {
                            if (v[ty][tx][ay][ax]) continue;
                        } else {
                            if (v[ay][ax][ty][tx]) continue;
                        }
                        
                        int index = start + d;
                        if (index > 3) index %= 4;
                        int tty = ay + ry[index];
                        int ttx = ax + rx[index];
                        if (check(tty, ttx, N) || map[tty][ttx] == 1) continue;
                        
                        if (ty == N-1 && tx == N-1) return count;
                        
                        if (i == 0) {
                            v[ty][tx][ay][ax] = true;
                            q.add(new P(ty, tx, ay, ax));
                        } else {
                            v[ay][ax][ty][tx] = true;
                            q.add(new P(ay, ax, ty, tx));
                        }
                    }
                }
            }
        }
        
        return count;
    }
}

class P {
    int ly;
    int lx;
    int ry;
    int rx;
    
    P (int ly, int lx, int ry, int rx) {
        this.ly = ly;
        this.lx = lx;
        this.ry = ry;
        this.rx = rx;
    }
}