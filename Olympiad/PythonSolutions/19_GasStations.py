import sys

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        N = int(data[idx])
        idx += 1

        dist = [[0] * (N + 1) for _ in range(N + 1)]
        s0j_input = list(map(int, data[idx].split()))
        idx += 1
        for i in range(1, N + 1):
            dist[0][i] = s0j_input[i - 1]
            dist[i][0] = dist[0][i]

        for k in range(1, N):
            skj_input = list(map(int, data[idx].split()))
            idx += 1
            for j in range(k + 1, N + 1):
                dist[k][j] = skj_input[j - k - 1]
                dist[j][k] = dist[k][j]

        dp = [[-1] * (1 << (N + 1)) for _ in range(N + 1)]
        result.append(str(tsp(N, dist, dp, 0, 1)))

    print("\n".join(result))

def tsp(N, dist, dp, pos, mask):
    if mask == (1 << (N + 1)) - 1:
        return dist[pos][0]

    if dp[pos][mask] != -1:
        return dp[pos][mask]

    min_cost = float('inf')
    for next in range(N + 1):
        if next != pos and not (mask & (1 << next)):
            new_mask = mask | (1 << next)
            cost = dist[pos][next] + tsp(N, dist, dp, next, new_mask)
            if cost < min_cost:
                min_cost = cost

    dp[pos][mask] = min_cost
    return min_cost

if __name__ == "__main__":
    main()
