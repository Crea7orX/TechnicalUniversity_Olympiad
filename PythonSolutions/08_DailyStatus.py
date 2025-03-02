def is_working(N, D):
    should_shift = N % 2 != 0
    return (N & (1 << (D - 1 if should_shift else D))) != 0

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    idx = 1
    result = []

    for _ in range(T):
        N = int(data[idx])
        D = int(data[idx + 1])
        idx += 2

        if is_working(N, D):
            result.append("Operational")
        else:
            result.append("Off")

    print("\n".join(result))

if __name__ == "__main__":
    main()
