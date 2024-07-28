public abstract class Date212List {
    /**
     * lenght of our linked list
     */
    int length;
    /**
     * create a dummy node called first that is at the beginning of our list
     */
    protected Date212Node first;
    /**
     * create a node that will be used to add mode nodes to our list
     */
    protected Date212Node last;

    /**
     * constructor for creating the default list
     */
    public Date212List() { // constructor to build a list
        Date212Node dn = new Date212Node(null); // dummy node
        length = 0;
        first = dn;
        last = dn;

    }

    /**
     * adds a Date212 object to the end of our linkedlist
     * <p>
     * create a node from the date212 object, then have the next value of the last
     * node point to our new node, and increase the length
     * 
     * @param data date212 object
     */
    public void append(Date212 data) {
        Date212Node d = new Date212Node(data);
        last.next = d;
        last = d;
        length++;
    }

}