package edu.northeastern.ashish;

public class LinkList {

    public Node head;

    public LinkList(){
        head = null;
        //createCycle();
    }

    private void createCycle(){
        head = new Node(5);
        Node temp = head;
        temp.next = new Node(7);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        Node three = temp;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(-1);
        temp = temp.next;
        temp.next = new Node(6);
        temp = temp.next;
        temp.next = new Node(8);
        temp = temp.next;
        temp.next = three;




    }

    public void addHead(int data){
        Node add = new Node(data);

        add.next = head;
        head = add;
    }

    public void printList(){
        if(head == null)
            return;

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ->");
            temp = temp.next;

        }
        System.out.println("NULL");
    }


    public void addTail(int data){
        Node add = new Node(data);

        if(head == null)
        {
            head = add;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = add;

    }

    public int count(){
        if(head == null)
            return  0;

        int count = 1;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return  count;
    }


    public void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node back = null;
        Node mid = head;
        Node front = head.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid  = front;
            front = front.next;
        }
        mid.next = back;
        head = mid;
    }

    public Node reverse(Node node){
        if(node == null || node.next == null){
            return node;
        }

        Node back = null;
        Node mid = node;
        Node front = node.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid  = front;
            front = front.next;
        }
        mid.next = back;
        return mid;
    }

    public  Node breakListInHalf(Node node){
        if(node == null || node.next == null)
            return null;
        Node front = node;
        Node back = node;
        while(front.next != null  ){
            front = front.next;
            if(front.next  != null){
                front = front.next;
                back = back.next;
            }
        }

        Node temp = back.next;
        back.next = null;
        return  temp;

    }

    public Node findStartCycle(){
        if (head == null )
            return null;

        Node front = head;
        Node back = head;

        while(front!= null  ){
            front = front.next;
            if(front == null)
                return  null;
            front = front.next;
            back = back.next;

            if(front == back)
                break;
        }

        if(front != back)
            return  null;

        front = head;
        while(front != back){

            // Make some change here to flatten
            front = front.next;
            back = back.next;
        }

        return  front;
    }

    public boolean isCyclic(){
        if (head == null )
            return false;

        Node front = head;
        Node back = head;

        while(front!= null  ){
            front = front.next;
            if(front == null)
                return  false;
            front = front.next;
            back = back.next;

            if(front == back)
                return  true;
        }
        return  false;
    }

    public boolean isPalindrome(){
        if (head == null || head.next == null)
            return true;
        Node firstHalf = head;
        Node secondHalf = breakListInHalf(head);
        secondHalf = reverse(secondHalf);

        Node first = head;
        Node second = secondHalf;

        boolean palindrome = true;

        while(first != null && second != null){
            if(first.data != second.data){
                palindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        secondHalf = reverse(secondHalf);

        Node temp = firstHalf;

        while(temp.next != null)
            temp = temp.next;
        temp.next = secondHalf;
        return  palindrome;
    }


    private Node mergeSortedList(Node node1, Node node2){
        Node result = null;
        if(node1 == null)
            return  node2;
        if(node2 == null)
            return node1;

        if(node1.data >= node2.data){
            result = node1;
            result.next = mergeSortedList(node1.next, node2);
        }else{
            result = node2;
            result.next = mergeSortedList(node1, node2.next);
        }

        return  result;

    }

    public void zipMerge(){
        Node secondHalf = breakListInHalf(head);
        Node firstHalf = head;
        secondHalf = reverse(secondHalf);

        head = zipMerge( firstHalf, secondHalf, true);
    }
    private Node zipMerge(Node node1, Node node2, boolean bSwitch){
        Node result = null;
        if(node1 == null)
            return  node2;
        if(node2 == null)
            return node1;

        if(bSwitch){
            result = node1;
            result.next = zipMerge(node1.next, node2, false);
        }else{
            result = node2;
            result.next = zipMerge(node1, node2.next, true);
        }

        return  result;

    }

    public void deleteElement(int value){
        if(head == null)
            return;
        while(head.data != value){
            Node temp = head;
            head = head.next;
            temp = null;
            if(head == null)
                return;

        }
        Node temp = head;

        while (temp.next != null) {
            if(temp.next.data == value){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
    }
}
