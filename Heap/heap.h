#include<iostream>
#include<fstream>
#include<cstdio>
#include<queue>
#include<cmath>
#include <vector>

void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

// void heapsort(vector<int> &v){
    
// }


class Heap{
    private:
    int *arr;
    int heapSize;
    int maxSize;
    void insertHelp(int n){
        int t=floor(n/2);
        if(t>=1&&arr[t]<arr[n]){
            swap(&arr[t],&arr[n]);
            insertHelp(t);
        }
    }
    void heapify(int n){
        if(n>floor(heapSize)){
            return;
        }
        int l=2*n;
        int r=2*n+1;
        int max=n;
        if(l<=heapSize&&arr[l]>arr[n]){
            max=l;
        }
        if(r<=heapSize&&arr[r]>arr[n]){
            max=r;
        }
        if(max!=n){
            swap(&arr[max],&arr[n]);
            heapify(max);
        }
    }
    public:
    Heap(){
        arr=new int[10];
        maxSize=9;
        heapSize=0;
    }
    Heap(int size){
        arr=new int[size+1];
        maxSize=size;
        heapSize=0;
    }
    void insert(int n){
        arr[++heapSize]=n;
        insertHelp(heapSize);
    }
    int size(){
        return heapSize;
    }
    int getMax(){
        return arr[1];
    }
    void deleteKey(){
        swap(&arr[1],&arr[heapSize--]);
        heapify(arr[1]);
    }

};
