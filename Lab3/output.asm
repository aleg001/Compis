.data
str0: .asciiz "Hello, World.\n"

.text
.globl main
main:
# INIT class Main

main:

    la $a0, str0

    jal out_string
    addiu $sp, $sp, 4

    li $v0, 10
    syscall

    li $v0, 10
    syscall

    li $v0, 10
    syscall