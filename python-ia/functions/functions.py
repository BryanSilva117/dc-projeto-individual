def remove_same_names(nomes):
    seen = set()
    result = []
    for nome in nomes:
        if nome not in seen:
            result.append(nome)
            seen.add(nome)
    return result
    
