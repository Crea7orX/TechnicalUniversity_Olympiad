import sys

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        x1, y1, x2, y2, x3, y3 = map(int, data[idx].split())
        idx += 1

        area = abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2
        result.append(f"{area:.2f}")

    print("\n".join(result))

if __name__ == "__main__":
    main()
