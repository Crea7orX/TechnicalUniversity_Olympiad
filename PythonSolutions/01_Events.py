import sys
import math

def combination(N, P):
    if P > N:
        return 0
    return math.comb(N, P)

def main():
    T = int(input().strip())
    result = []

    for _ in range(T):
        input_line = input().strip().split()
        P = int(input_line[0])  # participants
        R = int(input_line[1])  # prizes
        N = int(input_line[2])  # total participants
        M = int(input_line[3])  # total prizes

        participants_combinations = combination(N, P)
        prizes_combinations = combination(M, R)

        total = participants_combinations * prizes_combinations
        result.append(str(total))

    print("\n".join(result))

if __name__ == "__main__":
    main()
