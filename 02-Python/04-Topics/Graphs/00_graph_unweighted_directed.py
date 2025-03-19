from collections import deque


def BFS(graph, start_node, target_node):
    search_queue = deque([(start_node, 0)]) # Q stores tuple (node, dist)
    visited = set() # to avoid cycles 

    while search_queue: 
        node, dist = search_queue.popleft()

        if node==target_node :
            return dist
        if node not in visited:
            visited.add(node)
            neighbours = graph.get(node,[]) #dictionary.get(key, default_value) safer alternative to dict[key]
            for neighbour in neighbours : 
                search_queue.append((neighbour, dist+1))
    return -1

if __name__ == "__main__":
    graph = {
        'S' : ['A','B'],
        'A' : ['C','F'],
        'B' : ['C','D'],
        'D' : ['F']
    }
    
    source = "S"
    target = "F"
    shortest_len = BFS(graph, source, target)
    print(f"shortest length from {source} to {target} = "+ str(shortest_len))

