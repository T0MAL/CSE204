import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int t=0;
        File file = new File("file.txt");
        Scanner input = new Scanner(file);
        t=input.nextInt();
        BufferedWriter bw=new BufferedWriter(new FileWriter("out.txt"));
        while(0!=t--){
            int n,l,s,x;
            n=input.nextInt();
            x= input.nextInt();
            l= input.nextInt();
            LinkedList<Integer> ll[]=new LinkedList[x+1];
            for(int i=1;i<=x;i++){
                ll[i]=new LinkedList<>();
                for(int j=1;j+i<=x&&j<=n;j++){
                    ll[i].add(i+j);
                }
            }
            HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
            for(int i=0;i<l;i++){
                int f=input.nextInt();
                int tail=input.nextInt();
                ll[f].clear();
                ll[f].add(tail);
                hm.put(f,tail);
            }

            s= input.nextInt();
            for(int i=0;i<s;i++){
                int f=input.nextInt();
                int tail=input.nextInt();
                ll[f].clear();
                ll[f].add(tail);
            }
            boolean[] tick=new boolean[x+1];
            tick[1]=true;
            int[] prev = new int[x+1];
            int[] dist = new int[x+1];
            for(int i=1;i<=x;i++) {
                prev[i] = -1;
                dist[i] = Integer.MAX_VALUE;
            }
            dist[1]=0;
            LinkedList<Integer> lList=new LinkedList<Integer>();
            lList.add(1);
            while (lList.size()!=0){
                int tmp=lList.poll();
                //System.out.println(tmp+" ");
                for(int i=0;i<ll[tmp].size();i++){
                    int gg=ll[tmp].get(i);
                    if(!tick[gg]) {
                        lList.add(gg);
                        dist[gg]=dist[tmp]+1;
                        prev[gg]=tmp;
                        tick[gg] = true;
                    }
                }
            }

            LinkedList<Integer> path = new LinkedList<Integer>();
            path.add(x);
            while (prev[path.getLast()] != -1) {
                if(hm.containsKey(path.getLast())){
                    dist[x]--;
                }
                path.add(prev[path.getLast()]);

            }
            if(tick[x]){
                bw.write(dist[x]+"\n");
                for (int i = path.size() - 1; i >= 0; i--) {
                    bw.write(path.get(i)+" ");
                    if(i!=0)
                        bw.write("-> ");
                }
                bw.write("\n");
            }
            else{
                bw.write("-1\n");
                bw.write("No solution\n");
            }
            boolean flag=false;
            for(int i=1;i<=x;i++){
                if(!tick[i]){
                    bw.write(i+" ");
                    flag=true;
                }
            }
            if(!flag){
                bw.write("All reachable\n");
            }
            else
                bw.write("\n");
            bw.write("\n");
        }
        bw.close();
    }
}
