#include<bits/stdc++.h>
using namespace std;

void countSort(int *arr,int size,int t=1){
    
    // make an empty array of size = max element of arr

    int cnt[9];
    for(int i=0;i<9;i++){
        cnt[i]=0;
    }

    // now
    for(int i=0;i<size;i++){
        cnt[(arr[i]/t) %10]++;
    }

    // now that we have a record now let us make an prefix array
    // fill it with starting index for all
    for(int i=1;i<9;i++){
        cnt[i]+=cnt[i-1];
    }  
    //rotate
    for(int i=1;i<9;i++){
        cnt[i]=cnt[i-1];
    }
    // now this array holds the starting pnts of the array
    cnt[0]=0;
    int out[size];
    for(int i=0;i<size;i++){
        int p = cnt[(arr[i]/t) %10]++;
        out[p]=arr[i];
    }
    //keep doing this and now copy this array into our original array
    for(int i=0;i<size;i++){
        arr[i]=out[i];
    }
}//O(N+K) N is the size of array and k is the range of the array

void radixSort(int *arr,int n){
    // get the max digit from the largest element in the array
    // let the max digits be 5;
    for(int i=0;i<5;i++){
        int t = pow(10,i);
        // now 10^i the digit, therefore can be givin by any number 
        // x/t % 10
        // therefore
        countSort(arr,n,t); 
    }
}
void bucketSort(float*arr,int n){
    
    vector<vector<float>> buckets(n);
    for(int i=0;i<n;i++){
        buckets[arr[i]*n].push_back(arr[i]);
    }
    // now sort each individually
    for(int i=0;i<n;i++){
        sort(buckets[i].begin(),buckets[i].end());
    }
    // now add them
    int index=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<buckets[i].size();j++){
            arr[index++]=buckets[i][j];
        }
    }
}
void shellSort(int arr[],int n){
    // make shells
    // usually n/w
    int N=n;
    while(N>1){
        N/=2;
        // now N is the gap 
        // now change insertion sort
        for(int iterator=N;iterator<n;iterator++){
            
            // now we apply an insertion sort by gaps

            // compare j and j-N
            // int j = iterator-N;
            int j= iterator;
            while(arr[j]<arr[j-N] and j>=N){
                swap(arr[j],arr[j-N]);
                j-=N;
            }
        }
    }
}
void insertionSort(int arr[],int N){
    for(int i=1;i<N;i++){
        int j = i;
        while(arr[j]<arr[j-1] and j>0){
            swap(arr[j],arr[j-1]);
            j-=1;
        }
    }
}
void printArray(int array[], int size) {
  int i;
  for (i = 0; i < size; i++)
    cout << array[i] << " ";
  cout << endl;
}

void heapify(int arr[],int size,int i){
    int largest = i;
    int l = i*2+1;
    int r = i*2+2;

    if(l<size and arr[largest]<arr[l])
        largest=l;
    if(r<size and arr[largest]<arr[r])
        largest=r;
    
    if(largest!=i){
        swap(arr[largest],arr[i]);
        heapify(arr,size,largest);
    }
}

void heapSort(int arr[],int size){
    //build heap
    for(int i=size-1;i>=0;i--){
        heapify(arr,size,i);
    }
    // extract 0th index
    // swap the last element with the 0th index
    // call heapify for the new 0th index
    // size--
    while(size>1){
        swap(arr[size-1],arr[0]);
        size--;
        heapify(arr,size,0);
    }
}
int main(){
    int arr[]= {6,5,7,3,9,6,2};
    // shellSort(arr,7);
    insertionSort(arr,7);

    printArray(arr,7);
    return 0;
}