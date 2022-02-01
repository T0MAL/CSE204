import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int t=0;
        File file = new File("in.txt");
        Scanner input = new Scanner(file);
        t=input.nextInt();
        BufferedWriter bw=new BufferedWriter(new FileWriter("out.txt"));
        while(0!=t--){
            int n,l,s,x;
            n=input.nextInt();
            x= input.nextInt();
            l= input.nextInt();
            LinkedList<Integer> adjL[]=new LinkedList[x+1];
            for(int i=1;i<=x;i++){
                adjL[i]=new LinkedList<>();
                for(int j=1;j+i<=x&&j<=n;j++){
                    adjL[i].add(i+j);
                }
            }
            HashMap<Integer,Integer> ladder = new HashMap<Integer, Integer>();
            HashMap<Integer,Integer> snake = new HashMap<Integer, Integer>();
            for(int i=0;i<l;i++){
                int f=input.nextInt();
                int tail=input.nextInt();
                adjL[f].clear();
                adjL[f].add(tail);
                ladder.put(f,tail);
            }

            s= input.nextInt();
            for(int i=0;i<s;i++){
                int f=input.nextInt();
                int tail=input.nextInt();
                adjL[f].clear();
                adjL[f].add(tail);
                snake.put(f,tail);
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
            LinkedList<Integer> q=new LinkedList<Integer>();
            q.add(1);
            while (q.size()!=0){
                int tmp=q.poll();
                //System.out.println(tmp+" ");
                for(int i=0;i<adjL[tmp].size();i++){
                    int gg=adjL[tmp].get(i);
                    if(!tick[gg]) {
                        q.add(gg);
                        dist[gg]=dist[tmp]+1;
                        prev[gg]=tmp;
                        tick[gg] = true;
                    }
                }
            }

            LinkedList<Integer> path = new LinkedList<Integer>();
            path.add(x);
            while (prev[path.getLast()] != -1) {
                if(ladder.containsKey(path.getLast())){
                    dist[x]--;
                }
                if(snake.containsKey(path.getLast())){
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
