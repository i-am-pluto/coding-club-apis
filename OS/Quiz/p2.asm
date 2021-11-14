section .text
    global _start
    global formatStr
    
formatStr:
	db `The int is %d\n`,0
_start:
    mov rax, 0x1234567812345678
    xor rsi, 0x11
    mov rdi, formatStr
    extern printf
    call printf
    
    xor rax, 0x11
    mov rdi, rax
    call printf
    ret