directed_graph = {
    'A': {'B': 3, 'C': 4},
    'B': {'D': 1},
    'C': {'D': 2},
    'D': {}
}

# Weight of edge A -> B
print("Weight of edge A->B:", directed_graph['A']['B'])  # Output: 3
