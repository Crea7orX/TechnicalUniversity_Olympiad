from collections import deque

def find_path(maze, rows, cols, start_x, start_y, end_x, end_y):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    visited = [[False for _ in range(cols)] for _ in range(rows)]
    queue = deque()

    queue.append((start_x, start_y))
    visited[start_x][start_y] = True

    while queue:
        x, y = queue.popleft()

        if x == end_x and y == end_y:
            return True

        for dx, dy in directions:
            current_x = x + dx
            current_y = y + dy

            if (
                0 <= current_x < rows and
                0 <= current_y < cols and
                not visited[current_x][current_y] and
                maze[current_x][current_y] != '#'
            ):
                visited[current_x][current_y] = True
                queue.append((current_x, current_y))

    return False

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
        M = int(data[idx + 1])
        idx += 2

        maze = []
        for _ in range(N):
            row = data[idx]
            maze.append(list(row))
            idx += 1

        start_row, start_col = -1, -1
        end_row, end_col = -1, -1

        for row in range(N):
            for col in range(M):
                if maze[row][col] == 'S':
                    start_row, start_col = row, col
                elif maze[row][col] == 'E':
                    end_row, end_col = row, col

                if start_row != -1 and end_row != -1:
                    break

        found = find_path(maze, N, M, start_row, start_col, end_row, end_col)
        result.append("Yes" if found else "No")

    print("\n".join(result))

if __name__ == "__main__":
    main()
