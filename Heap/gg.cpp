#include<iostream>
#include<fstream>
#include<cstdio>
#include <vector>
#include<queue>
#include<ctime>
#include "heap.h" //You need to implement this.

using namespace std;

int main(){
    vector<int> v;
    
    v.push_back(5);
    v.push_back(9);
    v.push_back(0);
    v.push_back(3);
    v.push_back(60);
    
    heapsort(v);
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<endl;
    }
}