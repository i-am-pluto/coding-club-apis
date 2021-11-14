#include <stdio.h>
extern void B(long, void (*)());
extern void C();
void A()
{
    printf("Inside function A\n");
    printf("Enter the 64 bit integer: ");
    long arg;
    scanf("%ld", &arg);
    B(arg, &C);
}

int main()
{
    A();
    return 0;
}