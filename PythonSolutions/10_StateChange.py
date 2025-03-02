import sys

def main():
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    idx = 1
    result = []

    for _ in range(T):
        X = int(data[idx])
        N = int(data[idx + 1])
        idx += 2

        mask = 1 << N
        state = X ^ mask
        result.append(str(state))

    print("\n".join(result))

if __name__ == "__main__":
    main()
