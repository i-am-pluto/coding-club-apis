#include<bits/stdc++.h>
using namespace std;

int karatsuba(int x,int y){
    // break x = 10*n/2*a+b
    // if digits are equal in number
    int dig = floor(log10(x)+1);
    if(dig==1 or x==0)
        return x*y;
    int b = x%((int)pow(10,dig/2));
    int a = x/ (int)pow(10,dig/2);
    int d = y%((int)pow(10,dig/2));
    int c = y/ (int)pow(10,dig/2);
    // now we compute a.c and b.d and (a+b).(c+d) recursively
    int ac = karatsuba(a,c);
    int bd = karatsuba(b,d);
    int t = karatsuba(a+b,c+d);
    int ad_bc= t-bd-ac;
    return pow(10,dig)*ac+pow(10,dig/2)*ad_bc+bd;
}
// fails at some times
int main(){
    cout<<karatsuba(9777,6255)<<endl;
    return 0;
}