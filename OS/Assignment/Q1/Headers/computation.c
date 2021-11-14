#include "structs.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

Student *makeRecords(char given, int *sz)
{
    int fd = open("/home/lutopc/Documents/OS/Q1/Headers/student_record.csv", O_RDONLY);
    if (fd < 0)
    {
        printf("ERROR OPENING THE FILE");
        return NULL;
    }
    // FILE *filePointer = fopen("student_record.csv", "r");

    else
    {
        char buffer[1024];
        int size = read(fd, buffer, 1024);
        buffer[size] = '\0';
        close(fd);
        int iterator = 0;
        // char garbage = fgetc(filePointer);
        while (buffer[iterator] != '\n')
        {
            iterator++;
        }
        iterator++;
        Student *record;
        record = (Student *)malloc(100 * sizeof(Student));
        int a = 0;
        while (1)
        {
            if (iterator > size)
            {
                break;
            }
            char *StudentID = (char *)malloc(6 * sizeof(char));
            int i = 0;
            while (i != 6)
            {
                StudentID[i++] = buffer[iterator++];
            }
            iterator++;
            char Section = buffer[iterator++];
            iterator++;
            int *ass = (int *)malloc(6 * sizeof(int));
            for (int i = 0; i < 6; i++)
            {
                //get marks must be converted from char to string
                char num[4];
                int temp = 0;
                while (iterator < size && buffer[iterator] != ',' && buffer[iterator] != '\n')
                {
                    num[temp++] = buffer[iterator++];
                }
                iterator++;
                num[temp] = '\0';
                ass[i] = atoi(num);
            }
            // printf("%s %c", StudentID, Section);
            if (Section == given)
            {
                record[a].id = StudentID;
                record[a].score = ass;
                record[a].section = Section;
                a++;
            }
            else
            {
                continue;
            }
        }
        *sz = a;
        return record;
    }
}

Final *findRelevant(Student *record, int size)
{
    Final *result = (Final *)malloc(6 * sizeof(Final));
    for (int j = 0; j < 6; j++)
    {
        float sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += record[i].score[j];
        }
        float avg = sum / size;
        result[j].id = j + 1;
        result[j].score = avg;
    }
    return result;
}