#include<bits/stdc++.h>
using namespace std;
struct Pair
{
    int max;
    int min;
};

Pair getMinMax(int*arr,int low,int high){
    Pair p;
    if(low==high){
        p.max=arr[low];
        p.min=arr[low];
    }
    else if(high-low==1){
        p.max=max(arr[low],arr[high]);
        p.min=min(arr[low],arr[high]);
    }
    else{
        int mid=(low+high)/2;
        Pair l = getMinMax(arr,low,mid);
        Pair r = getMinMax(arr,mid+1,high);
        // find true max
        p.max = max(l.max,r.max);
        p.min=min(l.min,r.min);
    }
    return p;

}

int main(){

}