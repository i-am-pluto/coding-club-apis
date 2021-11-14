#include "structs.h"
#include <stdio.h>
void printResult(Final *result)
{
    printf("----------------------------\n");
    printf("|  Assignment  |   avg     |\n");
    printf("----------------------------\n");
    for (int i = 0; i < 6; i++)
    {
        printf("|       %d      | %f|\n", result[i].id, result[i].score);
        printf("----------------------------\n");
    }
    // printf("-------------------\n");
}
void printRecord(Student *record, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%6s   %c %d %d %d %d %d %d\n", record[i].id, record[i].section, record[i].score[0], record[i].score[1], record[i].score[2], record[i].score[3], record[i].score[4], record[i].score[5]);
    }
}