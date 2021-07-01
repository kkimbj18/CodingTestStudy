def solution(money):
    answer = 0
    
    dp_first = []
    dp_second = []
    
    dp_first.append(money[0])
    dp_first.append(max(money[0], money[1]))
    dp_second.append(0)
    dp_second.append(money[1])
    
    for i in range(2, len(money)-1):
        dp_first.append(max(dp_first[i-1], money[i]+dp_first[i-2]))
        
    for i in range(2, len(money)):
        dp_second.append(max(dp_second[i-1], money[i]+dp_second[i-2]))
        
    answer = max(max(dp_first), max(dp_second))
    
    return answer