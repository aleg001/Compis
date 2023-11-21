.data

.text

# INIT class Main

Main:

        jal Main_main
        
# INIT METHOD main

Main_main:


        li $t9, 1


        li $t8, 1

        jal Fibonacci
        move $t2, $s7

        move $t1, $t2
        move $a0, $t9
        move $a1, $t8
        jal substr
        

        move $t9, $t0

        move $a0, $t9
        jal out_string
        

	# Terminando programa
	li $v0, 10
	syscall


out_string:
	li $v0, 4
	syscall
	j return

out_int:
	li $v0, 1
	syscall
	

return:
	jr $ra

substr:
	move $s1, $a0
	li $a0, 20
	li $v0, 9
	syscall
	move $t0, $v0
	li $s0, 0

transfer:
	blt $s0, $s1, next
	lb $s2, 0($t1)
	sb $s2, 0($v0)
	addi $v0, $v0, 1
	beq $s0, $a1, return

next:
	addi $s0, $s0, 1
	addi $t1, $t1, 1
	j transfer

Fibonacci:
	li $a0, 7
	li $v0, 9
	syscall
	move $t6, $v0
        li $t5, 70
        sb $t5, 0($t6)
        li $t5, 105
        sb $t5, 1($t6)
        li $t5, 98
        sb $t5, 2($t6)
        li $t5, 111
        sb $t5, 3($t6)
        li $t5, 110
        sb $t5, 4($t6)
        li $t5, 97
        sb $t5, 5($t6)
        li $t5, 99
        sb $t5, 6($t6)
        li $t5, 99
        sb $t5, 7($t6)
        li $t5, 105
        sb $t5, 8($t6)
	move $s7, $t6
	jr $ra
Object:
	li $a0, 7
	li $v0, 9
	syscall
	move $t6, $v0
        li $t5, 79
        sb $t5, 0($t6)
        li $t5, 98
        sb $t5, 1($t6)
        li $t5, 106
        sb $t5, 2($t6)
        li $t5, 101
        sb $t5, 3($t6)
        li $t5, 99
        sb $t5, 4($t6)
        li $t5, 116
        sb $t5, 5($t6)
	move $s7, $t6
	jr $ra
IO:
	li $a0, 7
	li $v0, 9
	syscall
	move $t6, $v0
        li $t5, 73
        sb $t5, 0($t6)
        li $t5, 79
        sb $t5, 1($t6)
	move $s7, $t6
	jr $ra
Main_type_name:
	li $a0, 10
	li $v0, 9
	syscall
	move $t6, $v0
        li $t5, 70
        sb $t5, 0($t6)
        li $t5, 97
        sb $t5, 1($t6)
        li $t5, 108
        sb $t5, 2($t6)
        li $t5, 115
        sb $t5, 3($t6)
        li $t5, 101
        sb $t5, 4($t6)
	move $s7, $t6
	jr $ra