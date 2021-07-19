def longestCommonSubsequence(a: str, b: str) -> str:

    dp = [[0 for _ in range(len(b)+1)] for __ in range(len(a)+1)]

    for i in range(1, len(a)+1):
        for j in range(1, len(b)+1):
            if a[i-1] == b[j-1]:
                dp[i][j] = 1 + dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    length = dp[len(a)][len(b)]
    ret = ['' for _ in range(length + 1)]

    i = len(a)
    j = len(b)

    while i > 0 and j > 0:
        if a[i-1] == b[j-1]:
            ret[length-1] = a[i-1]
            i -= 1
            j -= 1
            length -= 1
        elif dp[i-1][j] > dp[i][j-1]:
            i -= 1
        else:
            j -= 1

        print(ret)
    return "".join(ret)


print(longestCommonSubsequence("hodor", "modohodo"))
