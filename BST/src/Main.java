import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BST gg=new BST();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        while(true) {
            String s = br.readLine();
            if(s==null)
                break;
            String[] ss = s.split(" ");
            if (ss[0].equalsIgnoreCase("F")) {
                System.out.println(gg.find(Integer.parseInt(ss[1])));
            }
            else if (ss[0].equalsIgnoreCase("I")) {
                gg.insert(Integer.parseInt(ss[1]));
            }
            else if (ss[0].equalsIgnoreCase("D")) {
                //System.out.println("here");
                gg.delete(Integer.parseInt(ss[1]));
            }
            else if (ss[0].equalsIgnoreCase("T")) {
                gg.traverse(ss[1]);
            }
        }
    }
}
