.data

.text

# INIT class Main

Main:

        jal Main_main

# INIT METHOD main

Main_main:


        li $t9, 1


        li $t8, 3

        jal Object
        move $t2, $s7

        move $t1, $t2
        move $a0, $t9
        move $a1, $t8
        jal substr


        move $t9, $t0

        move $a0, $t9
       	jal out_string



        # * Terminando programa
        li $v0, 10
        syscall

substr:
	$move $a0, $s0
	# Espacio
	li $a0, 20
	li $v0, 9
	syscall
	move $t0, $v0

transfer:



transfer_skip:

transfer_end:
    	jr $ra

out_string:
	li $v0, 4
	syscall
	jr $ra

out_int:
	li $v0, 1
	syscall
	jr $ra
Object:

	# Espacio Palabra object
	li $a0, 7
	li $v0, 9
	syscall
	move $t7, $v0

	# * Escritura de palabra object
	li $t6, 79
	sb $t6, 0($t7)
	li $t6, 98
	sb $t6, 1($t7)
	li $t6, 106
	sb $t6, 2($t7)
	li $t6, 101
	sb $t6, 3($t7)
	li $t6, 99
	sb $t6, 4($t7)
	li $t6, 116
	sb $t6, 5($t7)
	li $t6, 10
	sb $t6, 13($t7)

	# * Salvar en temporal de metodo s7
	move $s7, $t7
	jr $ra




substr:
	# Threshold
	move $s2, $a0

	# Espacio
	li $a0, 20
	li $v0, 9
	syscall
	move $t0, $v0

	# Contador
	li $s1, 1


transfer:
	beq $s1, $a1, transfer_end
	blt $s1, $s2, transfer_skip

	lb $t3, 0($t1)
	sb $t3, 0($t0)
	addi $t0, $t0, 1

transfer_skip:
	addi $s1, $s1, 1
	j transfer

transfer_end:
    	jr $ra