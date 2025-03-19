graph = {}
graph["start"] = [{"A",},"B"]
graph["A"]     = ["C","D"]
graph["B"]     = ["A","D"]
graph["C"]     = ["D","E"]
graph["D"]     = ["E"]
graph["E"]     = []