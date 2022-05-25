public class Queue {
    private Position[] arr;
    private int first = 0;
    private int last = 0;

    Queue(int maxSize) {
        this.arr = new Position[maxSize];        
    }

    public Position getFirstItem() {
        return this.arr[this.first];
    }

    public Position getLastItem() {
        return this.arr[this.last - 1];
    }

    public void increaseSize() { //Creates a new array to increase the max size of the queue.
        Position[] newArr = new Position[2 * this.size()]; //Creates new array.

        int newArrIndex = 0; //Moves the queue items to the new array.
        for (Position item : this.arr) {
            newArr[newArrIndex] = item;
            newArrIndex ++;
        }

        this.arr = newArr;

        return;
    }

    public int size() {
        int size = this.last - this.first;

        return size;
    }

    public void insert(Position item) { //Inserts an item in the queue's last position. 
        if (this.last < this.arr.length) {
            this.arr[this.last] = item;
            this.last += 1;
        } else {
            this.increaseSize();
            this.arr[this.last] = item;
            this.last += 1;
        }

        return;
    }      

    public Position pop() { //Removes first item in queue and returns it.
        if (this.isEmpty()) {
            System.out.println("Queue is empty");

            return new Position(-1, -1, -1);
        }

        Position lastItem = this.arr[this.first];
            this.first += 1;

            return lastItem;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public String toString() {
        String str = "";
        for (int i = this.first; i < this.last; i++) {
            str += this.arr[i];
            str += ". ";
        }

        return str;
    }
}
