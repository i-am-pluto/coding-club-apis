#include <bits/stdc++.h>
using namespace std;

int minim(vector<int> d, vector<bool> visited)
{
    int mini = INT_MAX;
    int index = 0;
    for (int i = 0; i < d.size(); i++)
    {
        if (d[i] < mini and !visited[i])
        {
            mini = d[i];
            index = i;
        }
    }
    return index;
}
void print(vector<int> parent)
{
    for (int i = 0; i < parent.size(); i++)
    {
        cout << parent[i] << " - " << i << endl;
    }
}
void prims(vector<vector<int>> g)
{

    vector<int> bw(g.size(), INT_MAX);
    vector<bool> visited(g.size(), false);
    vector<int> parent(g.size());
    parent[0] = -1;
    bw[0] = 0;

    for (int i = 0; i < g.size(); i++)
    {

        //visit a node
        int m = minim(bw, visited);
        visited[m] = true;
        for (int j = 0; j < g.size(); j++)
        {

            if (g[m][j] != 0 and g[m][j] < bw[j] and !visited[j])
            {
                parent[j] = m;
                bw[j] = g[m][j];
            }
        }
    }
    print(parent);
}

int main()
{
    vector<vector<int>> g{{0, 2, 0, 6, 0},
                          {2, 0, 3, 8, 5},
                          {0, 3, 0, 0, 7},
                          {6, 8, 0, 0, 9},
                          {0, 5, 7, 9, 0}};
    prims(g);
    return 0;
}