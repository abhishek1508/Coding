import java.util.HashMap;

public class LRUImplementation {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;
    private int capacity;

    LRUImplementation() {
        this(10);
    }

    LRUImplementation(int capacity) {
        this.capacity = capacity;
    }

    private void deleteNode(Node node) {
        // node here is end
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            end = node.getPrev();
        }
    }

    private void addNodeAtTop(Node node) {
        node.setNext(head);
        node.setPrev(null);
        if (head != null) {
            head.setPrev(node);
        }
        head = node;
        if (end == null) {
            end = head;
        }
    }

    private void set(int key, int value) {
        if (map.containsKey(key)) {
            // Do something to replace
            Node old = map.get(key);
            deleteNode(old);
            old.value = value;
            addNodeAtTop(old);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                //remove the last entry from map
                map.remove(end.key);
                //delete the last node
                deleteNode(end);
            }
            //add the new node to the top
            addNodeAtTop(node);
            map.put(key, node);
        }
    }

    private int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addNodeAtTop(node);
            return node.getValue();
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUImplementation lru  = new LRUImplementation(3);
        lru.set(1, 23);
        lru.set(2, 29);
        lru.set(3, 32);
        lru.set(4, 35);
    }

    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public Node getPrev() {
            return this.prev;
        }

        public Node getNext() {
            return this.next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
