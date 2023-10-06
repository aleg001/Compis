class ThreeAddressCode:
    def __init__(self):
        self.class_elements = []
        self.labels = []
        self.labels_copy = []
        self.temporaries = []
        self.triples = []

    def clear_class_elements(self):
        self.class_elements.clear()

    def clear_temporaries(self):
        self.temporaries.clear()

    def clear_labels_copy(self):
        self.labels_copy.clear()

    def new_temporary(self):
        num = 0
        existing_temporaries = {f"t{i}" for i in range(len(self.temporaries))}
        while f"t{num}" in existing_temporaries:
            num += 1
        new_temp = f"t{num}"
        self.temporaries.append(new_temp)
        return new_temp

    def get_labels_by_value(self, label_value):
        return [
            triple
            for triple in self.triples
            if triple.l == label_value or (triple.l == f"{label_value}_EndTask")
        ]

    def add_label(self, value, scope):
        existing_labels = {label[1] for label in self.labels}
        num = next(
            i for i in range(len(existing_labels)) if f"L{i}" not in existing_labels
        )
        new_label = f"L{num}"
        self.labels.append([value, new_label, scope])
        self.labels_copy.append([value, new_label, scope])

    def add_class_element(self, value, record):
        existing_records = {element[1] for element in self.class_elements}
        num = next(
            i
            for i in range(len(existing_records))
            if f"{record}{i}" not in existing_records
        )
        self.class_elements.append([value, f"{record}{num}"])

    def remove_label(self, target_label):
        self.labels_copy = [
            label for label in self.labels_copy if label[1] != target_label
        ]

    def find_label_in_copy(self, value, scope):
        return next(
            (
                label[1]
                for label in reversed(self.labels_copy)
                if label[0] == value and label[2] == scope
            ),
            None,
        )

    def find_label(self, value, scope):
        return next(
            (
                label[1]
                for label in reversed(self.labels)
                if label[0] == value and label[2] == scope
            ),
            None,
        )

    def get_label_value(self, target_label):
        return next(
            (label[0] for label in self.labels if label[1] == target_label),
            target_label if "_EndTask" in target_label else None,
        )

    def get_record_by_label(self, target_label):
        return next(
            (record[0] for record in self.labels if record[1] == target_label), None
        )

    def get_record(self, value):
        return next(
            (
                record[1]
                for record in reversed(self.class_elements)
                if record[0] == value
            ),
            None,
        )

    def printTacLabel(self):
        op_to_format_str = {
            "add": "\t{s} <- {x} + {y}\n",
            "sub": "\t{s} <- {x} - {y}\n",
            "div": "\t{s} <- {x} / {y}\n",
            "mul": "\t{s} <- {x} * {y}\n",
            "beq": "\t{x} == {y} GOTO {s}\n",
            "ble": "\t{x} <= {y} GOTO {s}\n",
            "blt": "\t{x} < {y} GOTO {s}\n",
            "and": "\t{x} & {y} GOTO {s}\n",
            "or": "\t{x} | {y} GOTO {s}\n",
            "j": "\tGOTO {s}\n",
            "not": "\t{s} <- NOT {x}\n",
            "isvoid": "\t{s} <- ISVOID {x}\n",
            "invert": "\t{s} <- INVERT {x}\n",
            "create": "\t{s} CREATED AS {x}\n",
            "bnq": "\t{x} != {y} GOTO {s}\n",
            "bg": "\t{x} > {y} GOTO {s}\n",
            "bgt": "\t{x} >= {y} GOTO {s}\n",
        }

        with open("output/tacResultLabel.txt", "w") as file:
            file.write("Three Direction Code\n")
            for tac in self.triples:
                if tac.l:
                    if "_EndTask" in tac.l:
                        parts = tac.l.split("_")
                        file.write(f"{parts[0]}_{parts[1]}:=\n")
                    else:
                        file.write(f"{tac.l}:=\n")
                elif tac.o in op_to_format_str:
                    file.write(
                        op_to_format_str[tac.o].format(s=tac.s, x=tac.x, y=tac.y)
                    )
                elif tac.o == "<-":
                    file.write(f"\t{tac.s} {tac.o} {tac.x}\n")
                elif tac.o == "call":
                    call_str = f"\t{tac.s} <- CALL {tac.x}"
                    if tac.y:
                        params = (
                            tac.y[1:-1].replace("'", "")
                            if "[" in str(tac.y)
                            else str(tac.y)
                        )
                        file.write(f"{call_str}({params})\n")
                    else:
                        file.write(f"{call_str}\n")
                else:
                    file.write(f"\t{tac.o} {tac.s} {tac.x} {tac.y}\n")

    def printTac(self):
        all_labels = [label[1] for label in self.labels]

        op_to_format_str = {
            "add": "\t{s} <- {x} + {y}\n",
            "sub": "\t{s} <- {x} - {y}\n",
            "div": "\t{s} <- {x} / {y}\n",
            "mul": "\t{s} <- {x} * {y}\n",
            "beq": "\t{x} == {y} GOTO {s}\n",
            "ble": "\t{x} <= {y} GOTO {s}\n",
            "blt": "\t{x} < {y} GOTO {s}\n",
            "and": "\t{x} & {y} GOTO {s}\n",
            "or": "\t{x} | {y} GOTO {s}\n",
            "j": "\tGOTO {s}\n",
            "not": "\t{s} <- NOT {x}\n",
            "isvoid": "\t{s} <- ISVOID {x}\n",
            "invert": "\t{s} <- INVERT {x}\n",
            "create": "\t{s} CREATED AS {x}\n",
            "bnq": "\t{x} != {y} GOTO {s}\n",
            "bg": "\t{x} > {y} GOTO {s}\n",
            "bgt": "\t{x} >= {y} GOTO {s}\n",
            "<-": "\t{s} {o} {x}\n",
        }

        with open("output/tacResult.txt", "w") as file:
            file.write("Three Direction Code\n")
            for tac in self.tercetos:
                if tac.l:
                    if "_EndTask" in tac.l:
                        parts = tac.l.split("_")
                        file.write(
                            f"{self.get_record_by_label(parts[0])}_{parts[1]}:=\n"
                        )
                    else:
                        file.write(f"{self.get_record_by_label(tac.l)}:=\n")
                elif tac.o in op_to_format_str:
                    formatted_str = op_to_format_str[tac.o]
                    file.write(formatted_str.format(s=tac.s, x=tac.x, y=tac.y, o=tac.o))
                elif tac.o == "call":
                    call_str = f"\t{tac.s} <- CALL {tac.x}"
                    if tac.y:
                        params = (
                            str(tac.y)[1:-1].replace("'", "")
                            if "[" in str(tac.y)
                            else str(tac.y)
                        )
                        file.write(f"{call_str}({params})\n")
                    else:
                        if tac.x not in all_labels:
                            file.write(f"{call_str}\n")
                        else:
                            file.write(
                                f"{call_str} {self.get_record_by_label(tac.x)}\n"
                            )
                else:
                    file.write(f"\t{tac.o} {tac.s} {tac.x} {tac.y}\n")
