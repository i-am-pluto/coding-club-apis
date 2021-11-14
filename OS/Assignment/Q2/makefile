main: main.c c.c b.asm
	nasm -f elf64 -o b.o b.asm
	gcc -o main -no-pie b.o main.c c.c
clean:
	rm *.o main