# def solution(triangle):
#     answer = 0
#     height = len(triangle)
#     dp = []
#     index = []
    
#     dp.append([triangle[0][0]])
#     index.append([0])
    
#     for i in range(1, height):
#         dp.append([])
#         index.append([])
#         # print(dp)
#         for idx, val in enumerate(dp[i-1]): 
#             baseIdx = index[i-1][idx]
#             # print(i, idx)
#             dp[i].append(val + triangle[i][baseIdx])
#             index[i].append(baseIdx)
#             dp[i].append(val + triangle[i][baseIdx+1])
#             index[i].append(baseIdx+1)
    
#     answer = max(dp[-1])
    
#     return answer

def solution(triangle):
    answer = 0
    height = len(triangle)
    dp = []
    
    dp.append([triangle[0][0]])
    
    for i in range(1, height):
        dp.append([])
        for idx, val in enumerate(triangle[i]): 
            if(idx == 0):
                dp[i].append(val + dp[i-1][idx])
            elif(idx == len(triangle[i])-1):
                dp[i].append(val + dp[i-1][idx-1])
            else:
                dp[i].append(val + max(dp[i-1][idx-1], dp[i-1][idx]))
    
    answer = max(dp[-1])
    
    return answer