.data
str0: .asciiz "        PUSHING fp[4"


.text
.globl main

# INIT class Main

main:

    la $a0, str0

    li $v0, 4
    syscall

    li $v0, 10
    syscall

    li $v0, 10
    syscall
