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
        if(n>floor(heapSize/2)){
            return;
        }
        int l=2*n;
        int r=2*n+1;
        int max=n;
        if(l<=heapSize&&arr[l]>arr[max]){
            max=l;
        }
        if(r<=heapSize&&arr[r]>arr[max]){
            max=r;
        }
        if(max!=n){
            swap(&arr[max],&arr[n]);
            heapify(max);
        }
    }
    public:
    Heap(std::vector<int> &v){
        maxSize=v.size();
        heapSize=v.size();
        arr=new int[maxSize+1];
        for(int i=1;i<=heapSize;i++){
            arr[i]=v[i-1];
        }
        //arr=v.data();
        
        for(int i=(floor(heapSize/2));i>0;i--){
            heapify(i);
        }
    }
    
    Heap(int size=10){
        arr=new int[size+1];
        maxSize=size;
        heapSize=0;
    }
    void insert(int n){
        if(heapSize==maxSize){
            return;
        }
        arr[++heapSize]=n;
        insertHelp(heapSize);
    }
    int size(){
        return heapSize;
    }
    int getMax(){
        // if(heapSize==0){
        //     return ;
        // }
        return arr[1];
    }
    void deleteKey(){
        if(heapSize==0){
            return;
        }
        swap(&arr[1],&arr[heapSize--]);
        heapify(1);
    }

};

void heapsort(std::vector<int> &v){
    Heap* h=new Heap(v);
    for(int i=0;i<v.size();i++){
        v[i]=h->getMax();
        h->deleteKey();
    }
}
