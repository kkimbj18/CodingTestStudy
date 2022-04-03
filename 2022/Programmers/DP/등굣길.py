def solution(m, n, puddles):
    answer = 0
    dp = [[1]*n for x in range(0, m)]
    
    for i in puddles:
        dp[i[0]-1][i[1]-1] = -1
    
    for i in range(1, m):
        if(dp[i][0] == -1):
            for x in range(i, m):
                dp[x][0] = 0
            break
    
    for j in range(1, n):
        if(dp[0][j] == -1):
            for x in range(j, n):
                dp[0][x] = 0
            break
    
    for i in range(1, m):
        for j in range(1, n):
            if(dp[i][j] == -1):
                dp[i][j] = 0
                continue
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007 
    
    answer = dp[m-1][n-1]
    
    return answer