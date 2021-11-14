#ifndef STRUCTS_H
#define STRUCTS_H
typedef struct Student
{
    char *id;
    char section;
    int *score;
} Student;
typedef struct Final
{
    int id;
    float score;
} Final;
typedef struct Result
{
    char c;
    Final *solution;
} Result;
#endif
