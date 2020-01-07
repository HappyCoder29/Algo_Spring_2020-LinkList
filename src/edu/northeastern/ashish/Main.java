package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        LinkList list1 = new LinkList();

        //Node startOfCycle = list.findStartCycle();
        //System.out.println(list.isCyclic());

        list1.addHead(1);
        list1.addTail(3);
        list1.addTail(5);

        LinkList list2 = new LinkList();
        list2.addHead(2);
        list2.addTail(4);
        list2.addTail(6);

        Node test = mergeSortedList(list1.head, list2.head);

       // list.printList();
        //Node mid = list.breakListInHalf(list.head);
//        //System.out.println(list.count());
//        list.printList();
//        list.reverse();
//        list.printList();

        //System.out.println(list.isCyclic());

    }

    private static Node mergeSortedList(Node node1, Node node2){
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
}
