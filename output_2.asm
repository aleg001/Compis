.data

	palabra: .asciiz "asdfasfd"


	palabra2: .asciiz "asdfasfd"


	palabra3: .word 1234


.text

# INIT class Main

Main:

        jal Main_main
        
# INIT METHOD main

Main_main:


        lw $t9, palabra3

        move $a0, $t9
        jal out_int
        

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
