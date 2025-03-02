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
            U, V, W = map(int, data[idx].split())
            graph[U].append((V, W))
            graph[V].append((U, W))
            idx += 1

        S = int(data[idx])
        idx += 1

        dist = [float('inf')] * (N + 1)
        dist[S] = 0

        pq = []
        heapq.heappush(pq, (0, S))

        while pq:
            time, u = heapq.heappop(pq)

            if time > dist[u]:
                continue

            for v, w in graph[u]:
                new_time = time + w
                if new_time < dist[v]:
                    dist[v] = new_time
                    heapq.heappush(pq, (new_time, v))

        total_time = 0
        for i in range(1, N + 1):
            if i != S:
                total_time += dist[i]

        result.append(str(total_time))

    print("\n".join(result))

if __name__ == "__main__":
    main()
