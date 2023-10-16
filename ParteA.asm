.data
prompt1: .asciiz "Introduzca el primer numero: "
prompt2: .asciiz "Introduzca el segundo numero: "
result:  .asciiz "El MCD es: "

.text
.globl main
main:
    sub $sp,$sp,8     # Reservar espacio en la pila para guardar registros
    sw $ra,0($sp)     # Guardar dirección de retorno

    # Imprimir mensaje solicitando el primer número
    li $v0, 4
    la $a0, prompt1
    syscall

    # Leer el primer número y guardarlo en $t2
    li $v0, 5
    syscall
    move $t2, $v0

    # Imprimir mensaje solicitando el segundo número
    li $v0, 4
    la $a0, prompt2
    syscall

    # Leer el segundo número
    li $v0, 5
    syscall
    move $a0, $t2     # Mover el primer número a $a0
    move $a1, $v0     # Mover el segundo número a $a1

    # Llamar a la función euc para calcular el MCD
    jal euc

    # Guardar el resultado en la pila
    sw $v0, 4($sp)

    # Imprimir el mensaje "El MCD es: "
    li $v0, 4
    la $a0, result
    syscall

    # Imprimir el valor del MCD
    li $v0, 1
    lw $a0, 4($sp)
    syscall

    # Recuperar dirección de retorno y volver al sistema
    lw $ra, 0($sp)
    add $sp, $sp, 8
    jr $ra

euc:
    sub $sp, $sp, 4   # Reservar espacio en la pila para guardar $s0
    sw $s0, 0($sp)    # Guardar el valor de $s0

    L1:
        # Si $a1 es 0, terminar y devolver $a0 como el MCD
        beq $a1, $zero, EXIT

        # Calcular el residuo de $a0 / $a1
        rem $t4, $a0, $a1

        # Actualizar valores de $a0 y $a1
        move $a0, $a1
        move $a1, $t4
        j L1

    EXIT:
        move $v0, $a0   # Mover el resultado a $v0 para devolverlo
        lw $s0, 0($sp)  # Recuperar el valor original de $s0
        add $sp, $sp, 4 # Restaurar el puntero de la pila
        jr $ra          # Regresar al código que llamó esta función
