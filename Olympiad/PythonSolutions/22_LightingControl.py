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
        Q = int(data[idx])
        idx += 1

        for _ in range(Q):
            P = int(data[idx])
            idx += 1
            mask = 1 << (P - 1)
            N ^= mask

        result.append(str(N))

    print("\n".join(result))

if __name__ == "__main__":
    main()
