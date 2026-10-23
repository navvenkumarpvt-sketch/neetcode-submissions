class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer,Node> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node node = cacheMap.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            removeNode(node);
        }

        Node node = new Node(key, value);
        cacheMap.put(key, node);
        addNode(node);

        if(cacheMap.size()>capacity){
            Node nodeToDelete = tail.prev;
            removeNode(nodeToDelete);
            cacheMap.remove(nodeToDelete.key);
        }

    }

    private void addNode(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        node.prev = head;
        nextNode.prev = node;
    }

    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
