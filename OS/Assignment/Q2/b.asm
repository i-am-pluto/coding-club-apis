section .data
	text db "INSIDE FUNCTION B",10
section .bss
    buff resb 8
; extern C
section .text
	global B
	global C

B:

    mov [buff],rdi
	push rsi
	
	mov rax, 1
	mov rdi, 1
	mov rsi, text
	mov rdx, 20
	syscall
    
    mov rax, 1
	mov rdi, 1
	mov rsi, buff
	mov rdx, 8
	syscall
	ret
