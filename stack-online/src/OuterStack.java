public class OuterStack<Type> implements Stack<Type>{
        private int size;
        private int top;
        private int chunk;
        private Arr[] st;
        private int dir;
        private int currSt;
        private int totalStack;

        OuterStack(int size,int chunk){
            this.chunk=chunk;
            this.size=size;
            currSt=0;
            st=new Arr[1];
            st[currSt]=new Arr(size,chunk);
            top=-1;
            dir=1;
            totalStack=1;
        }

        OuterStack(Type[] lst,int dir){
//            this.dir=dir;
//            this.chunk=lst.length;
//            this.size=lst.length;
//            if(dir==-1){
//                top=size;
//
//            }
//            else{
//                top=-1;
//            }
            //stack=lst;
            //System.out.println(stack);
        }

        @Override
        public void clear() {
//            int l=length();
//            assert l>0:"Stack is empty";
//            if(dir==1) {
//                top = -1;
//            }
//            else{
//                top=size;
//            }
            currSt=0;
            for(int i=0;i<=currSt;i++){
                st[i].clear();
            }
            totalStack=1;
            size=0;
            top=-1;
        }

        @Override
        public void push(Type item) {
//            if(dir==1) {
//                if (top < size-1)
//                    stack[++top] = item;
//                else {
//                    Type[] tmp = stack;
//                    size=size+chunk;
//                    stack = (Type[]) new Object[size];
//                    top=-1;
//                    for (int i = 0; i < tmp.length; i++) {
//                        push(tmp[i]);
//                    }
//                    push(item);
//                }
//            }
//            else if(dir==-1){
//                if (top>0){
//                    stack[--top] = item;}
//                else {
//                    Type[] tmp = stack;
//                    size=size+chunk;
//                    stack = (Type[]) new Object[size];
//                    top=size;
//                    for (int i = 0; i < tmp.length; i++) {
//                        push(tmp[i]);
//                    }
//                    push(item);
//                }
//            }
            int l=length();
//            if(l==size*totalStack){
//             //   Arr[] gt=st;
//                Type[] a= (Type[]) new Object[l];
//                for(int i=0;i<a.length;i++){
//                    a[i]= (Type) st[currSt].pop();
//                }
//                totalStack+=1;
//                st=new Arr[totalStack];
//               // st[0]=new Arr(size,chunk);
//              //  totalStack=size+chunk;
//                currSt=0;
//                for(int i=l-1;i>=0;i--){
//                    push(a[i]);
//                }
//            }
            if(st[currSt].length()<size){
                st[currSt].push(item);
            }
            else{
                   Arr[] gt=st;
//                Type[] a= (Type[]) new Object[l];
//                for(int i=0;i<a.length;i++){
//                    a[i]= (Type) st[currSt].pop();
//                }
                totalStack+=1;
                st=new Arr[totalStack];
                // st[0]=new Arr(size,chunk);
                //  totalStack=size+chunk;
                for(int i=0;i<gt.length;i++){
                    st[i]=gt[i];
                }
                currSt++;
                st[currSt]=new Arr(this.size,this.chunk);
                push(item);
            }
        }

        @Override
        public Type pop() {
            int l=length();
            assert l>0:"Stack is empty";
//            if(dir==1)
//                return stack[top--];
//            else
//                return stack[top++];
            if(st[currSt].length()>1) {
                return (Type) st[currSt].pop();
            }
            else{
                currSt--;
                totalStack--;
                return (Type) st[currSt+1].pop();
            }
        }

        @Override
        public int length() {
//            if(dir==1)
//                return top+1;
//            else
//                return (size-top);
            int l=0;
            for(int i=0;i<=currSt;i++){
                l+=st[i].length();
            }
            return l;
        }

        @Override
        public Type topValue() {
            int l=length();
            assert l>0:"Stack is empty";
            return (Type) st[currSt].topValue();
        }

        @Override
        public void setDirection(int dir) {
            if(top==-1&&dir==-1){
                top=size;
                this.dir=dir;
            }
            else if(top==size&&dir==1){
                top=-1;
                this.dir=dir;
            }
        }

    public static void main(String[] args) {
        OuterStack<Integer> os=new OuterStack<>(2,2);
        os.push(1);
        os.push(2);
        os.push(3);
        os.push(4);
        os.push(5);
        os.push(6);

        System.out.println(os.pop());
        System.out.println(os.length());
        System.out.println(os.topValue());
        os.clear();
        System.out.println(os.length());
    }
}
