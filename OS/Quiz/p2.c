#include <stdio.h>
int main()
{
    int x = -2;
    unsigned int y = -33;
    int z;
    z = x + y;
    printf("%u %u %d\n", x, y, z);
    printf("%d %d % d\n", x, y, z);
    return 0;
}