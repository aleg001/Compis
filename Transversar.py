""" def traverse(node, symbol_table, type_system):
    # Check the type of the node
    if isinstance(node, antlr4.tree.Tree.RuleNode):
        rule_index = node.getRuleContext().ruleIndex
        rule_name = parser.ruleNames[rule_index]

        # If the node is a variable declaration, insert the variable into the symbol table
        if rule_name == 'letStatement':
            # Extract the variable name and type from the node
            var_name = ...  # You'll need to fill in this part based on your syntax tree structure
            var_type = ...

            # Insert the variable into the symbol table
            symbol_table.insert_symbol(var_name, var_type)

        # If the node is a variable usage, look up the variable in the symbol table
        elif rule_name == 'variableUsage':
            # Extract the variable name from the node
            var_name = ...  # You'll need to fill in this part based on your syntax tree structure

            # Look up the variable in the symbol table
            var_type = symbol_table.lookup_symbol(var_name)
            if var_type is None:
                raise ValueError(f"Variable {var_name} is not defined.")

        # If the node is an arithmetic operation, perform type checking and the operation
        elif rule_name in ['addition', 'subtraction', 'multiplication', 'division']:
            # Extract the operands from the node
            operand1 = ...  # You'll need to fill in this part based on your syntax tree structure
            operand2 = ...  # You'll need to fill in this part based on your syntax tree structure

            # Look up the types of the operands in the symbol table
            type1 = symbol_table.lookup_symbol(operand1)
            type2 = symbol_table.lookup_symbol(operand2)

            # Perform the operation using the type system
            if rule_name == 'addition':
                result = type_system.add(operand1, operand2)
            elif rule_name == 'subtraction':
                result = type_system.subtract(operand1, operand2)


    # Recursively traverse all child nodes
    for i in range(node.getChildCount()):
        traverse(node.getChild(i), symbol_table, type_system)
"""
