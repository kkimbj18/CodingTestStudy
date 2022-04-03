# def solution(prices):
#     answer = [-1 for i in prices]
#     count = []

#     for index in range(0, len(prices)-1):
#         count.append(0)
#         if (prices[index] > prices[index+1]):
#             for re_idx in range(index, -1, -1):
#                 if(prices[re_idx] > prices[index+1] and answer[re_idx] == -1):
#                     count[-1]+=1
#                     answer[re_idx] = count.pop()
#         for i in range(len(count)):
#             count[i]+=1

#     count.append(0)
#     i = 0

#     for c in range(len(count)):
#         i += 1
#         while answer[len(prices)-i] != -1:
#             i += 1
#         answer[len(prices)-i] = count.pop()


#     return answer

def solution(prices):
    answer = [-1 for i in prices]
    count = []
    del_list = []

    for index in range(0, len(prices)-1):
        count.append(0)

        if (index == 0):
            obj = dict(zip(list(range(0, 1)), list([-1])))

        if (prices[index] > prices[index+1]):
            for k in sorted(obj.keys(), reverse=True):
                # print(index, k)
                if(prices[k] > prices[index+1]):
                    count[-1] += 1
                    answer[k] = count.pop()
                    del_list.append(k)
                    # print(del_list)
            for i in range(len(del_list)):
                del_unit = del_list.pop()
                del(obj[del_unit])
        for i in range(len(count)):
            count[i] += 1

        obj[index+1] = -1

    count.append(0)
    i = 0

    # print(count)
    # print(obj)

    for k in obj.keys():
        if(len(count) >0):
            answer[k] = count[i]
            i += 1

    return answer
