public class SortedDate212List extends Date212List {
    public SortedDate212List() {
        super();
    }

    
    /** 
     * adds a node to our linkedlist
     * <p>takes in a Date212 object and adds it to a sorted linked list.The method traverses the linked list and chacks where to put the node.
     * @param data the data we want to add to our linkedlist
     */
    public void add(Date212 data) {
        Date212Node d = new Date212Node(data);
        Date212Node current = first;

        while (current.next != null) {
            if (current.next.data.compareTo(data) == 1) {
                d.next = current.next;
                current.next = d;
                length++;
                return;
            } else {
                current = current.next;
            }
        }

       
        current.next = d;
        length++;
    }

}
