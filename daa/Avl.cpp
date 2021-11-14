#include <bits/stdc++.h>
using namespace std;

struct node
{
    node *left;
    node *right;
    int data;
    int h;
};

int getHieght(node *root)
{
    if (root == NULL)
    {
        return -1;
    }
    else
        return root->h;
}

void updateHeight(node *root)
{
    if (root->left == NULL and root->right == NULL)
        root->h = 0;
    else
        root->h = max(getHieght(root->left), getHieght(root->right)) + 1;
}

node *rotateLeft(node *root)
{

    node *temp = root->right;
    root->right = temp->left;
    temp->left = root;

    root->h = max(getHieght(root->left) + 1, getHieght(root->right) + 1);
    temp->h = max(getHieght(temp->left) + 1, getHieght(temp->right) + 1);

    return temp;
}
node *rotateRight(node *root)
{
    node *temp = root->left;
    root->left = temp->right;
    temp->right = root;

    root->h = max(getHieght(root->left) + 1, getHieght(root->right) + 1);
    temp->h = max(getHieght(temp->left) + 1, getHieght(temp->right) + 1);

    return temp;
}

node *insert(node *root, int data)
{

    if (root == NULL)
    {
        node *newNode = new node();
        newNode->data = data;
        newNode->h = 0;
        newNode->left = NULL;
        newNode->right = NULL;
        return newNode;
    }
    if (root->data > data)
    {
        root->left = insert(root->left, data);
    }
    else if (root->data < data)
    {
        root->right = insert(root->right, data);
    }
    updateHeight(root);
    //find left hieght
    int lh = getHieght(root->left) + 1;
    int rh = getHieght(root->right) + 1;
    int b = lh - rh;
    if (b < 1 and data < root->left->data)
    { //ll
        root = rotateRight(root);
    }
    if (b < 1 and data < root->left->data)
    { //lr
        root->left = rotateLeft(root->left);
        root = rotateRight(root);
    }
    if (b > -1 and data < root->right->data)
    {
        root->right = rotateRight(root->right);
        root = rotateLeft(root);
    }
    if (b > -1 and data > root->right->data)
    {
        root = rotateLeft(root);
    }
    return root;
}
void preOrder(node *root)
{
    if (root != NULL)
    {
        cout << root->data << " ";
        preOrder(root->left);
        preOrder(root->right);
    }
}
node *maximum(node *root)
{
    if (root->right == NULL)
        return root;
    return maximum(root->right);
}
int getBalance(node *root)
{
    if (root == NULL)
        return 0;
    int lh = getHieght(root->left) + 1;
    int rh = getHieght(root->right) + 1;
    return lh - rh;
}
node *del(node *root, int data)
{
    if (root->data < data)
    {
        root->right = del(root->right, data);
    }
    else if (root->data > data)
    {
        root->left = del(root->left, data);
    }
    else
    {
        // case 1
        if (!root->left and !root->right)
        {
            free(root);
            return NULL;
        }
        // case 2
        else if (!root->right)
        {
            node *temp = root;
            root = root->left;
            free(temp);
        }
        else if (!root->left)
        {
            node *temp = root;
            root = root->right;
            free(temp);
        }
        //case 3
        else
        {
            node *temp = root;
            root->data = maximum(root->right)->data;
            root->right = del(root->right, data);
        }
    }
    if (root == NULL)
        return NULL;
    updateHeight(root);
    int lh = getHieght(root->left) + 1;
    int rh = getHieght(root->right) + 1;
    int b = lh - rh;

    if (b > 1)
    {
        if (getBalance(root->left) >= 0)
        {
            return rotateRight(root);
        }
        else
        {
            root->left = rotateLeft(root->left);
            return rotateRight(root);
        }
    }
    if (b < -1)
    {
        if (getBalance(root->right) <= 0)
        {
            return rotateLeft(root);
        }
        else
        {
            root->right = rotateRight(root->right);
            return rotateLeft(root);
        }
    }
}
int main()
{
    node *root = NULL;

    /* Constructing tree given in
    the above figure */
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    /* The constructed AVL Tree would be
                30
            / \
            20 40
            / \ \
        10 25 50
    */
    cout << "Preorder traversal of the "
            "constructed AVL tree is \n";
    preOrder(root);

    return 0;
}
