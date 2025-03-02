def main():
    import sys
    sys.setrecursionlimit(10**6)
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0

    N, M = map(int, data[idx].split())
    idx += 1

    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        while idx < len(data) and len(data[idx].split()) < 2:
            idx += 1
        if idx >= len(data):
            break
        u, v = map(int, data[idx].split())
        graph[u].append(v)
        graph[v].append(u)
        idx += 1

    visited = [False] * (N + 1)
    parent = [0] * (N + 1)
    cycle = None

    def dfs(node, _parent):
        nonlocal cycle
        visited[node] = True
        parent[node] = _parent

        for neighbor in graph[node]:
            if not visited[neighbor]:
                if dfs(neighbor, node):
                    return True
            elif neighbor != _parent:
                cycle = []
                cycle.append(neighbor)
                current = node
                while current != neighbor:
                    cycle.append(current)
                    current = parent[current]
                cycle.append(neighbor)
                return True
        return False

    for i in range(1, N + 1):
        if not visited[i]:
            if dfs(i, -1):
                break

    if cycle is None:
        print("NO")
    else:
        print("YES")
        cycle.reverse()
        print(" ".join(map(str, cycle)))

if __name__ == "__main__":
    main()
