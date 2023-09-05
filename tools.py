def are_lists_of_tuples_equal(list1, list2):
    if len(list1) != len(list2):
        return False

    for tuple1, tuple2 in zip(list1, list2):
        if tuple1 != tuple2:
            return False

    return True

def banner(header, row_jumps = False):
    print()
    value   = 120
    banner = "{:─^120}".format(header)

    print(f'{"─"*value}')

    if row_jumps:
        print(f'\n{banner}\n')
    else:
        print(f'{banner}')
    print(f'{"─"*value}\n')