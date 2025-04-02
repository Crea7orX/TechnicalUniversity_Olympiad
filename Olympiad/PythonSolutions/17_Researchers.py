import sys
import heapq

def main():
    input = sys.stdin.read
    data = input().splitlines()
    idx = 0
    T = int(data[idx])
    idx += 1
    result = []

    for _ in range(T):
        N, M = map(int, data[idx].split())
        idx += 1

        graph = [[] for _ in range(N + 1)]
        for _ in range(M):
            u, v, weight = map(int, data[idx].split())
            graph[u].append((v, weight))
            graph[v].append((u, weight))
            idx += 1

        dist = dijkstra(N, graph)
        result.append(str(dist))

    print("\n".join(result))

def dijkstra(n, graph):
    dist = [float('inf')] * (n + 1)
    dist[1] = 0

    pq = []
    heapq.heappush(pq, (0, 1))

    while pq:
        d, node = heapq.heappop(pq)

        if d > dist[node]:
            continue

        for neighbor, weight in graph[node]:
            new_dist = d + weight

            if new_dist < dist[neighbor]:
                dist[neighbor] = new_dist
                heapq.heappush(pq, (new_dist, neighbor))

    return dist[n] if dist[n] != float('inf') else -1

if __name__ == "__main__":
    main()
