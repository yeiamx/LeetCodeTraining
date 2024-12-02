class ListNode {
    // 结点的值
    int val;

    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    private final ListNode dummyHead;
    public MyLinkedList() {
        dummyHead = new ListNode();
    }

    public int get(int index) {
        int curIndex = 0;
        ListNode cur = dummyHead.next;
        while (cur != null && curIndex != index) {
            cur = cur.next;
            curIndex++;
        }
        if (cur != null) {
            return cur.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = dummyHead.next;
        dummyHead.next = newHead;
    }

    public void addAtTail(int val) {
        ListNode cur = dummyHead;
        while (cur.next != null) cur = cur.next;
        cur.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        //检查cur的next的index是否等于目标index，是的话插在cur后面
        ListNode cur = dummyHead; int curIndex = 0;
        while (cur != null) {
            if (curIndex == index) {
                ListNode newNode = new ListNode(val);
                newNode.next = cur.next;
                cur.next = newNode;
                return;
            }
            cur = cur.next;
            curIndex++;
        }

    }

    public void deleteAtIndex(int index) {
        ListNode cur = dummyHead; int curIndex = 0;
        while (cur.next != null) {
            if (curIndex == index) {
                cur.next = cur.next.next;
                return;
            } else {
                cur = cur.next;
                curIndex++;
            }

        }
    }
}
