def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    idx = 1
    result = []

    for _ in range(T):
        A = data[idx]
        B = data[idx + 1]
        idx += 2

        is_opposite = False
        if A.startswith("-"):
            is_opposite = not is_opposite
        if B.startswith("-"):
            is_opposite = not is_opposite

        if is_opposite:
            result.append("Opposite")
        else:
            result.append("Same")

    print("\n".join(result))

if __name__ == "__main__":
    main()
