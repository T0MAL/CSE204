#include <bits/stdc++.h>
using namespace std;

int a[10][10];
int n;
int memory[1024];

void bin(unsigned n)
{
    unsigned i;
    for (i = 1 << 31; i > 0; i = i / 2)
        (n & i) ? printf("1") : printf("0");
    cout<<endl;
}

unsigned int countSetBits(unsigned int n)
{
    unsigned int count = 0;
    while (n) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}

int cost(int mask,int j){
    int val=a[j][j];
    for(int i=0;i<n;i++){
        if(mask&(1<<(i))&&i!=j){
            val+=a[j][i];
        }
    }
    return val;
}

int visit(int mask){
    bin(mask);
    int val=INT32_MAX;
    for(int i=0;i<n;i++){
        if(!(mask&(1<<i))){
            int tmp=(mask|(1<<(i)));
            int t;
            if(memory[tmp]!=-1){
                t=cost(tmp,i)+memory[tmp];
            }
            else{
                memory[tmp]=visit(tmp);
                t=cost(tmp,i)+memory[tmp];
            }
            val=min(val,t);
        }
    }
    return val;
}

int main(){
    cin>>n;
    int gg=pow(2,n);
    for(int i=0;i<gg;i++){
        memory[i]=-1;
    }
    
    memory[gg-1]=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>a[i][j];
        }
    }
    int mask=0;
    int val=INT32_MAX;
    for(int i=0;i<n;i++){
        int tmp=(mask|(1<<(i)));
            int t;
            if(memory[tmp]!=-1){
                t=cost(tmp,i)+memory[tmp];
            }
            else{
                memory[tmp]=visit(tmp);
                t=cost(tmp,i)+memory[tmp];
            }
            val=min(val,t);
    }
    cout<<val<<endl;
}