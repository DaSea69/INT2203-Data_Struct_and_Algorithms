/**
 * @author Bien
 */ 
class StackByArrays {
    //final int sizeMax = 10000;
    private int[] lists;
    private int n;
    public StackByArrays() {
        lists = new int[1];
        n = 0;
    }
    private void resize(int size) {
        int[] tmp = new int[size];
        for(int i = 0; i < lists.length; i++) {
            tmp[i] = lists[i];
        }
        lists = tmp;
        //delete old lists
    }
    public void push(int item) {
        if (this.n == lists.length) {
            resize(lists.length * 2);
        }
        this.lists[n] = item;
        n++;
    }
    public int pop() {
        int item = this.lists[--n];
        //delete node
        if (this.n > 2 && this.n == lists.length / 4) {
            resize(lists.length / 2);
        }
        return item;
    }
    public boolean isEmpty() {
        return this.n == 0;
    }
    public int size() {
        return this.n;
    }
}
