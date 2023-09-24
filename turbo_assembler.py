def generate_turbo_assembler_code(
    cool_source_code, input_stream, lexer, tokens, parser, tree, visitor, yaplParser
):
    turbo_assembler_code = []
    register_counter = 0

    def append_turbo_assembler_code(code):
        turbo_assembler_code.append(code)

    def generate_unique_label():
        return f"label_{len(turbo_assembler_code)}"

    def allocate_temporary_register():
        nonlocal register_counter
        register = f"$t{register_counter}"
        register_counter += 1
        return register

    for expr in tree.expr():
        if isinstance(expr, yaplParser.DispatchExplicitAContext):
            object_address = visitor.visit(expr.expr(0))
            method_name = expr.ID().getText()
            append_turbo_assembler_code(f"la $a0, {object_address}")
            append_turbo_assembler_code(f"li $v0, method_label_{method_name}")
            append_turbo_assembler_code("jalr $v0")
        elif isinstance(expr, yaplParser.DispatchImplicitBContext):
            method_name = expr.ID().getText()
            append_turbo_assembler_code(f"li $v0, method_label_{method_name}")
            append_turbo_assembler_code("jalr $v0")
        elif isinstance(expr, yaplParser.IfContext):
            condition = visitor.visit(expr.expr(0))
            then_expr = expr.expr(1)
            else_expr = expr.expr(2)

            label_true = generate_unique_label()
            label_false = generate_unique_label()
            label_end = generate_unique_label()

            append_turbo_assembler_code(f"beqz {condition}, {label_false}")
            append_turbo_assembler_code(f"j {label_true}")
            append_turbo_assembler_code(f"{label_false}:")

            if else_expr:
                # Handle else branch
                append_turbo_assembler_code("  # Turbo Assembler code for else_expr")
            append_turbo_assembler_code(f"j {label_end}")
            append_turbo_assembler_code(f"{label_true}:")

            # Handle then branch
            append_turbo_assembler_code("  # Turbo Assembler code for then_expr")
            append_turbo_assembler_code(f"{label_end}:")

        elif isinstance(expr, yaplParser.Arithmetic1Context):

            left_operand = visitor.visit(expr.expr(0))
            right_operand = visitor.visit(expr.expr(1))
            result_register = allocate_temporary_register()
            operator = expr.op.text

            append_turbo_assembler_code(f"lw {result_register}, {left_operand}")
            if operator == "*":
                append_turbo_assembler_code(
                    f"mul {result_register}, {result_register}, {right_operand}"
                )
            elif operator == "/":
                append_turbo_assembler_code(
                    f"div {result_register}, {result_register}, {right_operand}"
                )
            elif operator == "+":
                append_turbo_assembler_code(
                    f"add {result_register}, {result_register}, {right_operand}"
                )
            elif operator == "-":
                append_turbo_assembler_code(
                    f"sub {result_register}, {result_register}, {right_operand}"
                )

        elif isinstance(expr, yaplParser.LetInContext):
            let_variables = expr.formal()
            body_expr = expr.expr()

            for var in let_variables:
                var_name = var.ID().getText()
                var_type = var.TYPE().getText()
                init_expr = var.expr()
                if init_expr:
                    init_value = visitor.visit(init_expr)
                    append_turbo_assembler_code(f"li $a0, {init_value}")
                    append_turbo_assembler_code(f"sw $a0, {var_name}")
                else:
                    append_turbo_assembler_code(f"li $a0, 0")
                    append_turbo_assembler_code(f"sw $a0, {var_name}")

            body_result = visitor.visit(body_expr)
            append_turbo_assembler_code(f"move $v0, {body_result}")

        elif isinstance(expr, yaplParser.BlockContext):
            block_exprs = expr.expr()

            for block_expr in block_exprs:
                block_result = visitor.visit(block_expr)

        elif isinstance(expr, yaplParser.WhileContext):
            condition = visitor.visit(expr.expr(0))
            loop_body = expr.expr(1)

            label_start = generate_unique_label()
            label_end = generate_unique_label()

            append_turbo_assembler_code(f"{label_start}:")
            append_turbo_assembler_code(f"beqz {condition}, {label_end}")

            loop_body_result = visitor.visit(loop_body)

            append_turbo_assembler_code(f"j {label_start}")
            append_turbo_assembler_code(f"{label_end}:")

    turbo_assembler_code_str = "\n".join(turbo_assembler_code)

    return turbo_assembler_code_str
