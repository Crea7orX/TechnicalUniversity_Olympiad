import sys

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        X, n = map(int, data[idx].split())
        idx += 1
        mask = 1 << n
        result.append(str(X | mask))

    print("\n".join(result))

if __name__ == "__main__":
    main()
