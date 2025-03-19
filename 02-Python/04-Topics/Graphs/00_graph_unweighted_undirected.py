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

def edgeExists(graph, u, v):
    if u in graph and v in graph[u]:
        return v in graph and u in graph[v]
    return False

def addEdge(graph, u, v):
    if not edgeExists(graph, u, v):
        # add new node
        if u not in graph:
            graph[u] = []
        graph[u].append(v)
        
        if v not in graph:
            graph[v] = []
        graph[v].append(u)

def traverse(graph):
    for node, neighbours in graph.items():
        print(f"{node} --> {neighbours}")
        # for neighbour in neighbours:
        #     print(f"node {node} --> : {neighbour}")

if __name__ == "__main__":
    graph = {
        '0' : ['1','2'],
        '1' : ['0','2'],
        '2' : ['0','1']
    }

    traverse(graph)
    addEdge(graph, '1', '3')
    addEdge(graph, '3', '4')
    print("--------")
    traverse(graph) 
    source = "0"
    target = "2"
    shortest_len = BFS(graph, source, target)
    print(f"shortest length from {source} to {target} = "+ str(shortest_len))