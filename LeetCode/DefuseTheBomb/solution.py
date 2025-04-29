def decrypt( code: List[int], k: int) -> List[int]:
    r_list = [0]*len(code)

    n = len(code)

    if k == 0:
        return r_list
    elif k > 0:
        for i in range(n):
            result[i] = sum(code[(i+j)%n] for j in range(1, k+1))
    elif k < 0:
        for i in range(n):
            result[i] = sum(code[(i+j)%n] for j in range(k, 0))
    return r_list

