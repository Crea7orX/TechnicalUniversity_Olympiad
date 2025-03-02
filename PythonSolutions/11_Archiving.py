def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        N = int(data[idx])
        K = int(data[idx + 1])
        idx += 2

        sizes = list(map(int, data[idx:idx + N]))
        idx += N

        sizes.sort()
        result.append(" ".join(map(str, sizes[:K])))

    print("\n".join(result))

if __name__ == "__main__":
    main()
