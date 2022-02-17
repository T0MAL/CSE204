#include <bits/stdc++.h>
using namespace std;

int cost(int** a,int n,int mask,int j){
    int val=0;
    for(int i=0;i<n;i++){
        if(mask&(1<<(i))){
            val+=a[j][i];
        }
    }
    return val;
}

int visit(int** a,int n,int* memory,int mask){
    int val=INT32_MAX;
    for(int i=0;i<n;i++){
        if(!(mask&(1<<i))){
            int tmp=(mask|(1<<(i)));
            int t;
            if(memory[tmp]!=-1){
                t=cost(a,n,tmp,i)+memory[tmp];
            }
            else{
                memory[tmp]=visit(a,n,memory,tmp);
                t=cost(a,n,tmp,i)+memory[tmp];
            }
            val=min(val,t);
        }
    }
    return val;
}

int main(){
    int n;
    cin>>n;
    int memorySize=pow(2,n);
    int* memory=new int[memorySize];
    int **a=new int*[n];
    for(int i=0;i<n;i++){
        a[i]=new int[n];
        for(int j=0;j<n;j++){
            cin>>a[i][j];
        }
    }
    for(int i=0;i<memorySize;i++){
        memory[i]=-1;
    }
    memory[memorySize-1]=0;
    cout<<visit(a,n,memory,0)<<endl;
    for(int i=0; i<n; i++){
        delete[] a[i];
    }
    delete[] a;
    delete[] memory;
    return 0;
}

// 2
// 100 100
// 5000 100

// 3
// 25 100 0
// 0 25 0
// 150 100 25

// 3
// 30 75 95
// 120 45 20
// 105 30 90