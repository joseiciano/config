#include <iostream>
#include <cstdlib>
#include <string>
#include <vector>
#include <math.h>
#include <unordered_set>

using namespace std;

void uf();

int find(int);

int connected(int, int);

void unify(int, int);

int gcd(int, int);

vector<int> sz;

vector<int> id;

int size;

int numComp;

int main()
{
    int numSteps, currStep, comp1, comp2, num = 1, denom = 1, counter = 1;

    unordered_set<int> nodes;

    cin >> numComp;
    cin >> numSteps;

    uf();

    for (int i = 0; i < numSteps; i++)
    {
        cin >> currStep;

        if (currStep == 1)
        {
            cin >> comp1;
            cin >> comp2;

            unify(comp1, comp2);

            num = 0;
            denom = numComp;

            for (int i = 0; i < sz.size(); i++)
            {
                if (id.at(i) != i)
                    continue;

                num += pow(sz.at(i), 2);
            }

            int div = gcd(num, denom);

            num /= div;
            denom /= div;
        }
        else if (currStep == 2)
            cout << num << "/" << denom << endl;
    }

    return 0;
}

int gcd(int num, int denom)
{
    return num == 0 ? denom : gcd(denom % num, num);
}

void uf()
{
    size = numComp;

    for (int i = 0; i < size; i++)
    {
        id.push_back(i);
        sz.push_back(1);
    }
}

int find(int p)
{
    int root = p;
    while (root != id[root])
        root = id[root];

    while (p != root)
    {
        if (p >= id.size())
            break;
        int next = id.at(p);
        id.at(p) = root;
        p = next;
    }

    return root;
}

int connected(int p, int q)
{
    return find(p) == find(q);
}

void unify(int p, int q)
{
    if (connected(p, q))
        return;

    int root1 = find(p);
    int root2 = find(q);

    if (sz.at(root1) < sz.at(root2))
    {
        sz.at(root2) += sz.at(root1);
        id.at(root1) = root2;
    }
    else
    {
        sz.at(root1) += sz.at(root2);
        id.at(root2) = root1;
    }

    numComp--;

    return;
}