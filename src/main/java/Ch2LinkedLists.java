import java.util.HashMap;
public class Ch2LinkedLists {

    public static void main(String[] args){
        Node head = new Node(1);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(4);

        System.out.println(head);
        removeDupsNoBuffer(head);
        System.out.println(head);

    }

    static class Node{
        Node next = null;
        Node previous = null;
        int data;

        public Node(int d){
            data =d;
        }

        void appendToTail(int d){
            Node end = new Node(d);
            Node n = this;

            while(n.next !=null){
                n=n.next;
            }

            n.next = end;
            n.next.previous = n;
        }
        Node deleteNode(Node head, int d){
            if (head==null) return null;

            Node n = head;
            if (n.data==d){
                head.previous = null;
                return head.next;
            }

            while (n.next!=null){
                if (n.next.data==d){

                    n.next = n.next.next; //erasing n.next
                    n.next.next.previous = n;
                    return head;
                }
                n=n.next;
            }
            return head;
        }
        @Override
        public String toString() {
            String returnString ="";
            Node n = this;

            if (n == null) returnString+="This list is empty";

            else{
                returnString+=n.data + " ";
                while (n.next!=null){
                    returnString+=n.next.data + " ";
                    n=n.next;
                }
            }

            return returnString;
        }

    }

    //2.1 Write code to remove duplicates from an unsorted linked list
    static void removeDups(Node head){
        //create hashmap to keep track of occurences
        HashMap<Integer,Integer> occurences = new HashMap<Integer, Integer>();
        if(head!=null) {
            occurences.put(head.data, 1);
            Node prev = head;
            Node current = head;
            while (current.next != null) {
                current = current.next;
                if (occurences.get(current.data) != null) {
                    prev.next = current.next;
                    current = prev;
                }
                else {
                    occurences.put(current.data, 1);
                    prev=prev.next;
                }
            }

        }
    }

    //2.1 Follow-up, same problem but no buffer allowed
    static void removeDupsNoBuffer(Node head){
        //for each entry, run to the end of the list and check if there are duplicates, if so remove them
        if(head!=null){
            Node current = head;
            Node runner;
            while(current.next!=null){
                runner=current;
                while(runner.next!=null){
                    runner = runner.next;
                    if (runner.data==current.data){
                        runner.previous.next = runner.next;
                        runner.next.previous =  runner.previous;
                    }

                }
                current = current.next;
            }
        }
    }

}
