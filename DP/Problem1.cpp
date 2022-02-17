#include <bits/stdc++.h>
using namespace std;

void lcs(char* s1,char* s2,int m,int n){
    int arr[m+1][n+1];
    int dir[m+1][n+1];
    for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            if(i==0||j==0){
                arr[i][j]=0;
                dir[i][j]=0;
            }
            else if(s1[i-1]==s2[j-1]){
                arr[i][j]=arr[i-1][j-1]+1;
                dir[i][j]=1;
            }
            else if(arr[i][j-1]>arr[i-1][j]){
                arr[i][j]=arr[i][j-1];
                dir[i][j]=2;
            }
            else{
                arr[i][j]=arr[i-1][j];
                dir[i][j]=3;
            }
        }
    }
    char s[arr[m][n]+1];
    int i=m;
    int j=n;
    int k= arr[m][n];
    s[k--]=0;
    while(i>0 && j>0){
        if(dir[i][j]==1){
            s[k--]=s1[i-1];
            i--;
            j--;
        }
        else if(dir[i][j]==2){
            j--;
        }
        else if(dir[i][j]==3){
            i--;
        }
    }
    cout<<arr[m][n]<<endl;
    cout<<s<<endl;
}

int main()
{
    char s1[51];
    char s2[51];
    cin>>s1;
    cin>>s2;
    lcs(s1,s2,strlen(s1),strlen(s2));
    return 0;
}

// ABCBDAB
// BDCABA

// ACCGGTCGAGTGCGCGGAAGCCGGCCGAA
// GTCGTTCGGAATGCCGTTGCTCTGTAAA
