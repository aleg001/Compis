
import tkinter as tk
from antlr4 import *
from CustomErrorListener import CustomErrorListener
import subprocess

class TerminalApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Mini Sublime Text")
        self.root.configure(bg="#0D2844")
        self.root.geometry('800x600')  # default window size
        self.root.minsize(600, 400)    # minimum window size
        
        self.create_widgets()

    def create_widgets(self):
        # Styling
        bg_color = "#2A2E37"
        fg_color = "#C0C5CE"
        error_color = "#E95678"
        font_style = ("Arial", 12)

        # Text widgets for input and output
        self.input_text = tk.Text(
            self.root,
            bg=bg_color,
            fg=fg_color,
            insertbackground=fg_color,
            font=font_style,
            wrap=tk.WORD,
        )
        self.output_text = tk.Text(
            self.root,
            bg=bg_color,
            fg=error_color,
            insertbackground=fg_color,
            font=font_style,
            state=tk.DISABLED,
        )
        self.input_text.grid(row=0, column=0, padx=10, pady=10, sticky="nsew")
        self.output_text.grid(row=0, column=1, padx=10, pady=10, sticky="nsew")

        # Buttons
        button_frame = tk.Frame(self.root, bg="#0D2844")
        self.execute_button = tk.Button(
            button_frame,
            text="Run",
            command=self.execute_command,
            bg="#4B8B3B",
            fg=fg_color,
            font=font_style,
        )
        self.clear_button = tk.Button(
            button_frame,
            text="Clear",
            command=self.clear_output,
            bg="#A93B3B",
            fg=fg_color,
            font=font_style,
        )
        self.show_table_button = tk.Button(
            button_frame,
            text="Show Table",
            command=self.show_table,
            bg="#3B65A9",
            fg=fg_color,
            font=font_style,
        )
        self.execute_button.pack(fill=tk.BOTH, padx=10, pady=5)
        self.clear_button.pack(fill=tk.BOTH, padx=10, pady=5)
        self.show_table_button.pack(fill=tk.BOTH, padx=10, pady=5)
        button_frame.grid(row=0, column=2, padx=10, pady=10, sticky="nsew")

        # Configure weights for resizing
        self.root.grid_rowconfigure(0, weight=1)
        self.root.grid_columnconfigure(0, weight=2)
        self.root.grid_columnconfigure(1, weight=1)
        self.root.grid_columnconfigure(2, weight=0)

    # ... [Rest of the methods remain unchanged]

