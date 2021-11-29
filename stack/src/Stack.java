public interface Stack<Type> {
    void clear();
    void push(Type item);
    Type pop();
    int length();
    Type topValue();
    void setDirection(int dir);
}
