def are_lists_of_tuples_equal(list1, list2):
    if len(list1) != len(list2):
        return False
    
    for tuple1, tuple2 in zip(list1, list2):
        if tuple1 != tuple2:
            return False
    
    return True