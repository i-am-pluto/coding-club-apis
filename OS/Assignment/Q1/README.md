a.c does the required task using fork() function and waitpid() functions.
fork() function is a linux system call which creates a new process
called child process which runs concurrently with the parent process
fork() returns an intiger value pid
which if 0 indivates that the current programme is in the child process and it being positive indicates that it is in parent process.

waitpid is used for inorder to make the programme in which it is present to wait till the process that is mentioned in using its pid argument where the pid of the process is mentioned has finished.

the programme first makes seperate records for both the sections a/b and evaluate them seperately parallely by adding each value and dividing it with the total number of students to find the average in each assignment.

b.c does the required tasks parelly by using pthread_craete() which starts the given routine parallely on a different thread.
it is passed with arguments that signifies the ID of type `pthread_t` where the ID of the newly created thread is present.
the attributes argument is passed as NULL as we want the default attributs only. we pass out function routine in the next argument, and the required arguments for the function routine is passed as a struct in its next argument of pthread_create().
the pthread_join() acts like waitpid as it pauses the execution of the rest of the programme till the thread given with id in its argument has finished execution. status argument of this function is passed as NULL as we dont need to store the exit status of the programme.

The programme similar to the previous function computes the resulting average in each test and as the structs passed in arguments give us access to the result arrays in the main function we can find the avg. performance of students in each assignment of bot the sections in the main, by simply adding and dividing by 2.
