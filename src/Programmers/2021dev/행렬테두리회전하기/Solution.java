class Solution {
    
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            
            int y = query[0] - 1;
            int x = query[1] - 1;
            int minY = y;
            int minX = x;
            int maxY = query[2];
            int maxX = query[3];
            
            int temp = map[y][x];
            int next;
            int d = 0;
            int min = Integer.MAX_VALUE;
            
            while(true) {
                if (min > map[y][x]) min = map[y][x];
                
                int ty = y + dy[d];
                int tx = x + dx[d];
                
                if (ty < minY || tx < minX || ty >= maxY || tx >= maxX) {
                    d++;
                    if (d > 3) break;
                    ty = y + dy[d];
                    tx = x + dx[d];
                }
                
                next = map[ty][tx];
                map[ty][tx] = temp;
                temp = next;
                
                x = tx;
                y = ty;
            }
            
            answer[i] = min;
            // print(map);
        }
        
        return answer;
    }
    
    public void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}