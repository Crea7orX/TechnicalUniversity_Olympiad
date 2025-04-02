import math

def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    T = int(data[0])
    result = []

    for i in range(1, T + 1):
        xA, yA, xB, yB, xX, yX = map(int, data[i].split())
        distance = point_to_line_distance(xA, yA, xB, yB, xX, yX)
        result.append(f"{distance:.2f}")

    print("\n".join(result))

def point_to_line_distance(xA, yA, xB, yB, xX, yX):
    numerator = abs((yB - yA) * xX - (xB - xA) * yX + xB * yA - yB * xA)
    denominator = math.sqrt((yB - yA)**2 + (xB - xA)**2)
    return numerator / denominator

if __name__ == "__main__":
    main()
