def solution(phone_book):
    answer = True
    length = [];

    for v in phone_book:
        length.append(len(v));

    hash_sum = dict(zip(phone_book, length))
    
    for k, v in hash_sum.items():
        for key, val in hash_sum.items():
            if(key != k):
                if(v <= val):
                    if(key.startswith(k)):
                        return False

    return answer