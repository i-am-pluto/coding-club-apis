#include <bits/stdc++.h>
using namespace std;

class BSTnode{
    private:
        int data;
        BSTnode*left;
        BSTnode*right;
    public:
        BSTnode(int data){
            this->data=data;
            this->left=NULL;
            this->right=NULL;
        }
};


int main()
{
    BSTnode *newNode  = new BSTnode(23);
    BSTnode secondNode(21);
    return 0;
}