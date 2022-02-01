#include <iostream>
#include<algorithm>

using namespace std;

int main()
{
    int n,k;
    cin>>n>>k;
    int a[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    sort(a,a+n,greater<int>());
    int price=0;
    int i=0;
    int j=0;
    while(j<n){
        for(int l=0;l<k;l++){
            if(j==n)
                break;
            price+=((i+1)*a[j++]);
        }
        i++;
    }
    cout<<price<<endl;
    return 0;
}