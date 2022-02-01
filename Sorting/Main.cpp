#include <iostream>
#include<ctime>
#include<algorithm>
#include <fstream>

using namespace std;

void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

int pivot(int a[],int start,int end){
    int i=start;
    for(int j=start;j<end;j++){
        if(a[j]<=a[end]){
            swap(a[j],a[i]);
            i++;
        }
    }
    swap(a[i],a[end]);
    return i;
}

void quickSort(int a[],int start,int end){
    if(start<end){
        int p=pivot(a,start,end);
        quickSort(a,start,p-1);
        quickSort(a,p+1,end);
    }

}

int randomPivot(int a[],int start,int end){
    int t=rand() % (end-start+1) + start;
    swap(a[t],a[end]);
    return pivot(a,start,end);
}

void randomized_quickSort(int a[],int start,int end){
    if(start<end){
        int p=randomPivot(a,start,end);
        quickSort(a,start,p-1);
        quickSort(a,p+1,end);
    }

}

void insertionSort(int a[],int n){
    for(int i=1;i<n;i++){
        int key=a[i];
        int j=i-1;
        while(j>=0&&a[j]>key){
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=key;
    }
}

void merge(int a[],int start,int mid,int end){
    int sizeL=mid-start+1;
    int sizeR=end-mid;
    int *leftArr=new int[sizeL+1];
    int *rightArr=new int[sizeR+1];
    leftArr[sizeL]=INT32_MAX;
    rightArr[sizeR]=INT32_MAX;
    for(int i=0;i<sizeL;i++){
        leftArr[i]=a[start+i];
    }
    for(int i=0;i<sizeR;i++){
        rightArr[i]=a[mid+1+i];
    }
    int i=0;
    int j=0;
    for(int t=start;t<=end;t++){
        if(leftArr[i]<=rightArr[j]){
            a[t]=leftArr[i];
            i++;
        }
        else{
            a[t]=rightArr[j];
            j++;
        }
    }
}

void mergeSort(int a[],int start,int end){

    if(start<end){
        int mid=start+(end-start)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,mid,end);
    }
}


int main(){
    ofstream mf;
    mf.open("out.csv");
    mf << "n , Merge Sort , QuickSort , Randomized QuickSort , Insertion Sort , Quicksort with Sorted Input , Randomized Quicksort with SOrted Input , STL sort() func" << endl;
    srand(1);
    const int n[]={5,10,100,1000,10000,100000};
    int size=6;
    double time[7][size];
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            for(int j=0;j<n[i];j++){
                arr[j]=rand()%100000;
            }
            clock_t t = clock();
            mergeSort(arr,0,n[i]-1);
            tmp+= (double(clock() - t) / CLOCKS_PER_SEC);
        }
        time[0][i]=(tmp/20);
        delete arr;
    }
    cout<<"done"<<endl;
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            for(int j=0;j<n[i];j++){
                arr[j]=rand();
            }
            clock_t t = clock();
            quickSort(arr,0,n[i]-1);
            tmp+= (double(clock() - t) / CLOCKS_PER_SEC);
        }
        tmp=(tmp/20);
        time[1][i]=(tmp);
        delete arr;
    }
    cout<<"done"<<endl;
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            for(int j=0;j<n[i];j++){
                arr[j]=rand();
            }
            clock_t t = clock();
            randomized_quickSort(arr,0,n[i]-1);
            tmp+= double(clock() - t) / CLOCKS_PER_SEC;
        }
        time[2][i]=(tmp/20);
        delete arr;
    }
    cout<<"done"<<endl;
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            for(int j=0;j<n[i];j++){
                arr[j]=rand();
            }
            clock_t t = clock();
            insertionSort(arr,n[i]);
            tmp+= double(clock() - t) / CLOCKS_PER_SEC;
        }
        time[3][i]=(tmp/20);
        delete arr;
    }
    cout<<"done"<<endl;
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            for(int j=0;j<n[i];j++){
                arr[j]=rand();
            }
            clock_t t = clock();
            sort(arr,arr+n[i]);
            tmp+= (double(clock() - t) / CLOCKS_PER_SEC);
        }
        time[6][i]=(tmp/20);
        delete arr;
    }
    cout<<"done"<<endl;
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            // for(int j=0;j<n[i];j++){
            //     arr[j]=rand();
            // }
            // sort(arr,arr+n[i]);
            clock_t t = clock();
            randomized_quickSort(arr,0,n[i]-1);
            tmp+= (double(clock() - t) / CLOCKS_PER_SEC);
        }
        time[5][i]=(tmp/20);
        delete arr;
    }
    cout<<"done"<<endl;
    for(int i=0;i<size;i++){
        int *arr=new int[n[i]];
        double tmp=0.0;
        for(int k=0;k<20;k++){
            // for(int j=0;j<n[i];j++){
            //     arr[j]=rand();
            // }
            //sort(arr,arr+n[i]);
            clock_t t = clock();
            quickSort(arr,0,n[i]-1);
            tmp+= (double(clock() - t) / CLOCKS_PER_SEC);
        }
        time[4][i]=(tmp/20);
        delete arr;
    }
    cout<<"done"<<endl;

    for(int i=0;i<size;i++){
        mf<<n[i]<<","<<time[0][i]<<","<<time[1][i]<<","<<time[2][i]<<","<<time[3][i]<<","<<time[4][i]<<","<<time[5][i]<<","<<time[6][i]<<endl;
    }
    mf.close();
    return 0;
}
