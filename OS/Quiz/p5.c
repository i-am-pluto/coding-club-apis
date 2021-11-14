#include <stdio.h>
#include <string.h>
void copy_arr(char *p1, char p2[])
{
    memcpy(p2, p1, sizeof(p1));
    memcpy(p2, "ABCD", 4);
}

int main()
{
    int a = 2;
    int *b = &a;
    printf("%p\n", b);
    printf("%p\n", b + 1);
    printf("%p\n", (char *)b + 1);
    printf("%p\n", (void *)b + 1);
}