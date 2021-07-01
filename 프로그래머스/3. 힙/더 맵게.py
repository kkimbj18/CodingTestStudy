import heapq

def solution(scoville, K):
    answer = 0
    first = 0
    second = 0
    heap = []
    
    for food in scoville:
        heapq.heappush(heap, food)
    
    while(1):
        if(heap[0] < K):
            if(len(heap)==1):
                return -1
            first = heapq.heappop(heap)
            second = heapq.heappop(heap)
            heapq.heappush(heap, first+2*second)
            answer+=1
        else:
            break
        
    return answer