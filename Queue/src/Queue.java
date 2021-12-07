public interface Queue<Type>{
    void clear();
    void enqueue(Type item);
    Type dequeue();
    int length();
    Type frontValue();
    Type rearValue();
    Type leaveQueue();
}
