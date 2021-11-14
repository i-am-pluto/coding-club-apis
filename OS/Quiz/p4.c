#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
int main()
{
    pid_t pid1;
    printf(" before fork()");
    if ((pid1 = fork()) > 0)
    {
        waitpid(pid1, NULL, 0);
        printf("nothing to see here\n");
    }
    else if (pid1 == 0)
    {
        if (execl("/usr/bin/bash", "bash", (char *)NULL))
            printf("eror");
        printf(" done launching the shell \n");
    }

    else
    {
        perror(" fork() ");
    }
}
