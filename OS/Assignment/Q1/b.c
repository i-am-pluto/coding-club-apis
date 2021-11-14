#include <stdio.h>
#include <string.h>
#include <curses.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <pthread.h>
#include "Headers/structs.h"
#include "Headers/computation.h"
#include "Headers/print.h"

void *routine(void *vargp)
{
    Result *r = ((Result *)vargp);
    int s;
    Student *relevantRecord = makeRecords(r->c, &s);
    r->solution = findRelevant(relevantRecord, s);
    printf("\nEVALUATED RECORD OF STUDENTS OF %c\n", r->c);
    printResult(r->solution);
    return NULL;
}

int main()
{
    pthread_t thread_id1, thread_id2;
    Result *A = (Result *)malloc(sizeof(Result));
    (A->c) = 'A';
    pthread_create(&thread_id1, NULL, routine, A);
    pthread_join(thread_id1, NULL);
    Result *B = (Result *)malloc(sizeof(Result));
    (B->c) = 'B';
    pthread_create(&thread_id2, NULL, routine, B);
    pthread_join(thread_id2, NULL);
    Final *solution = (Final *)malloc(6 * sizeof(Final));
    for (int i = 0; i < 6; i++)
    {
        solution[i].score = (A->solution[i].score + B->solution[i].score) / (float)2;
        solution[i].id = i;
    }
    printf("\n\nTHE FINAL RESULT IS\n");
    printResult(solution);
    return 0;
}