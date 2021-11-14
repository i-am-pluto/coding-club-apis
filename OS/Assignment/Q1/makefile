all:a b
a:a.c Headers/computation.c Headers/computation.h Headers/structs.h Headers/print.c Headers/print.h
	gcc -o a a.c Headers/computation.c Headers/computation.h Headers/structs.h Headers/print.c Headers/print.h
b:b.c Headers/computation.c Headers/computation.h Headers/structs.h Headers/print.c Headers/print.h
	gcc -o b b.c Headers/computation.c Headers/computation.h Headers/structs.h Headers/print.c Headers/print.h -pthread
clean:
	rm a bm