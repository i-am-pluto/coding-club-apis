#include <stdio.h>
#include <string.h>
#include <curses.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <stdlib.h>
#include "Headers/structs.h"
#include "Headers/computation.h"
#include "Headers/print.h"
void evaluate(char c)
{
    int s;
    Student *relevantRecord = makeRecords(c, &s);
    Final *result = findRelevant(relevantRecord, s);
    printf("EVALUATED RECORD OF STUDENTS OF %c\n", c);
    printResult(result);
}

int main()
{
    int pid = fork();
    if (pid == 0)
    {
        //find do the process for A
        evaluate('A');
        exit(0);
    }

    waitpid(pid, NULL, 0);
    int s;
    evaluate('B');
    return 0;
}