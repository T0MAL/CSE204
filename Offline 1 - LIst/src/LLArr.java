public class LLArr<Type> implements List <Type>{
    Arr<Integer> value ;
    Arr<Integer> link;
    int size;

    public LLArr(){
        value=new Arr<>();
        link=new Arr<>();
    }

    @Override
    public void clear() {

    }

    @Override
    public void insert(Type item) {

    }

    @Override
    public void append(Type item) {

    }

    @Override
    public Type remove() {
        return null;
    }

    @Override
    public void moveToStart() {

    }

    @Override
    public void moveToEnd() {

    }

    @Override
    public void prev() {

    }

    @Override
    public void next() {

    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int currPos() {
        return 0;
    }

    @Override
    public void moveToPos(int pos) {

    }

    @Override
    public Type getValue() {
        return null;
    }

    @Override
    public int Search(Type item) {
        return 0;
    }
}
