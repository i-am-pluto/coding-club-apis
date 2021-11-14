In main.c

we externally declare `extern B()` and `extern C()`  so as to C inform the compiler about the external linkage and to make the functions usable across files inside the `A()` function we take a `long` input from the user and pass it as an argument in `B()` with the address of function `C()` so that we can use that address later in our `B()` function to modify the stack.

In B.c

we first in `section .data` define bytes to "inside function B"
i.e. in the data segment of the memory
in `section .bss` we reserve 8 bytes for the uninitiallised string which we will later assign to the 64 bit argument passed earlier
in `section .text` is where we write our actual code 
here we first mark `B and C` as global to make them visible to the linker so that other object files of main and C can use them.
Now we define our B function with the `B:` label. here we first move `rdi` to `[buff]` i.e. set the data at `buff` as that of `rdi`
and then we pop the return address off the stack
Now we push `rsi` into the stack which is containing the second argument hence fooling the return keyword to believe that it is the return address. now we simpally use `sys_write()`
by setting
    mov rax, 1
	mov rdi, 1
	mov rsi, text
	mov rdx, 20
	syscall
rax has the ID
rdi has the `standard output` file desciptor therefore 1
rsi has the data to be printed
rdx the size of the data.
and hence prinintg the desired data

In C.c
after the function B returns it calls the function C which simply prints that it is inside function C and `exit()` tp stop execution.
