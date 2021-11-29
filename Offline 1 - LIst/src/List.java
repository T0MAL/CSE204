public interface List<Type>{
    void clear();
    void insert(Type item);
    void append(Type item);
    Type remove();
    void moveToStart();
    void moveToEnd();
    void prev();
    void next();
    int length();
    int currPos();
    void moveToPos(int pos);
    Type getValue();
    int Search(Type item);
}
