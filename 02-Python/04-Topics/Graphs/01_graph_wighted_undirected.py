# Creating a weighted graph using a dictionary
weighted_graph = {
    'A': {'B': 3, 'C': 4},
    'B': {'A': 3, 'D': 1},
    'C': {'A': 4, 'D': 2},
    'D': {'B': 1, 'C': 2}
}

# Example: Access neighbors of a node
print("Neighbors of A:", weighted_graph['A'])  # Output: {'B': 3, 'C': 4}

# Example: Access weight of edge between A and B
print("Weight of edge A-B:", weighted_graph['A']['B'])  # Output: 3

# Adding a new node E
weighted_graph['E'] = {}

# Adding an edge between E and A with weight 5
weighted_graph['E']['A'] = 5
weighted_graph['A']['E'] = 5  # Since it's an undirected graph

### print(weighted_graph)

# Traversing the graph
#for K, V in dictionary_var.items():
for node, edges in weighted_graph.items(): 
    #print(f"Node {node} has edges:")
    print("")
    for neighbor, weight in edges.items():
        print(f"{node}->{neighbor} : {weight}")

def add_node(graph, node):
    if node not in graph:
        graph[node] = {}

add_node(weighted_graph, 'F')

def add_edge(graph, node1, node2, weight):
    if node1 in graph and node2 in graph:
        graph[node1][node2] = weight
        graph[node2][node1] = weight  # Omit for directed graphs

add_edge(weighted_graph, 'A', 'F', 6)

def remove_edge(graph, node1, node2):
    if node1 in graph and node2 in graph[node1]:
        del graph[node1][node2]
        del graph[node2][node1]  # Omit for directed graphs

remove_edge(weighted_graph, 'A', 'B')

def edge_exists(graph, node1, node2):
    return node1 in graph and node2 in graph[node1]

print(edge_exists(weighted_graph, 'A', 'B'))  # True


if __name__ == "__main__":
    h


"""
#def first_graph():
graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "jonny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["jonny"] = []

from collections import deque
search_queue = deque()
search_queue += graph["you"]

while search_queue : 
    node = search_queue.pop()

#if __name__ == "__main__":


graph = {
    "you"   : ["alice", "bob", "claire"],
    "bob"   : ["anuj", "peggy"],
    "alice" : ["peggy"],
    "claire": ["thom", "jonny"],
    "anuj"  : [],
    "peggy" : [],
    "thom"  : [],
    "jonny" : []        
}
"""