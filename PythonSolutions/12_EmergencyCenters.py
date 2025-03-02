def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    idx = 0
    N = int(data[idx])
    idx += 1

    A = []
    for _ in range(N):
        row = list(map(int, data[idx:idx + N]))
        A.append(row)
        idx += N

    min_distance = float('inf')
    for i in range(N - 3):
        for j in range(i + 1, N - 2):
            for k in range(j + 1, N - 1):
                for l in range(k + 1, N):
                    current_distance = (
                        A[i][j] + A[i][k] + A[i][l] +
                        A[j][k] + A[j][l] + A[k][l]
                    )
                    min_distance = min(min_distance, current_distance)

    print(min_distance)

if __name__ == "__main__":
    main()
