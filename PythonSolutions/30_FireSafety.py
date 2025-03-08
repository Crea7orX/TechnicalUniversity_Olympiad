import sys
from collections import deque

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        n, m = map(int, data[idx].split())
        idx += 1

        building = []
        for _ in range(n):
            row = list(map(int, data[idx].split()))
            building.append(row)
            idx += 1

        startX, startY = map(int, data[idx].split())
        idx += 1

        if startX < 0 or startX >= n or startY < 0 or startY >= m or building[startX][startY] == 1:
            result.append("Invalid starting point\n")
            continue

        visited = [[False for _ in range(m)] for _ in range(n)]
        bfs(building, visited, startX, startY, n, m)

        for i in range(n):
            result.append(" ".join(map(lambda x: "1" if x else "0", visited[i])))
            result.append("\n")

    print("".join(result))

def bfs(building, visited, startX, startY, n, m):
    dx = [-1, 1, 0, 0, -1, -1, 1, 1]
    dy = [0, 0, -1, 1, -1, 1, -1, 1]
    queue = deque()
    queue.append((startX, startY))
    visited[startX][startY] = True

    while queue:
        x, y = queue.popleft()

        for i in range(8):
            newX = x + dx[i]
            newY = y + dy[i]

            if 0 <= newX < n and 0 <= newY < m and not visited[newX][newY] and building[newX][newY] == 0:
                queue.append((newX, newY))
                visited[newX][newY] = True

if __name__ == "__main__":
    main()
