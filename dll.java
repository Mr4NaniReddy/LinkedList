public class dll {
    
    private Node head;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        Node temp = head;
        if(head == null){
            node.prev = null;
            head = node;
            
        }
        while(temp.next!=null){
            temp = temp.next;
        }
        node.next = null;
        temp.next = node;
        node.prev = temp;
    }
    public void insert(int after,int val){
        Node p = find(after);
        if(p == null){
            System.out.println("Does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.val +" -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.print("END\n");
        while(last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START\n");
    }

    
    private class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(int val,Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
        public static void main(String[] args) {
            dll list = new dll();
            list.insertFirst(4);
            list.insertFirst(10);
            list.insertFirst(20);
            list.insertFirst(16);
            list.insertFirst(12);
            list.display();
            list.insert(20, 80);
            list.display();
        }
    }

