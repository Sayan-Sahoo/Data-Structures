

import java.io.*;

public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node insertAtAnyPosition(Node list, int data, int pos){
        Node head = list;

        if(pos ==  1){
            Node newnode = new Node(data);
            newnode.next = list;
            head = newnode;
        }else{
            while(pos-- != 0){
                if(pos == 1){
                    Node newnode = getNode(data);
                    newnode.next = head.next;
                    head.next = newnode;
                    break;
                }
                head = head.next;
            }
            if (pos != 1){
                System.out.println("Position out of range");
            }
        }
        return head;
    }

    public static Node getNode(int data){
        return new Node(data);
    }

    public static LinkedList insert(LinkedList list, int data){
        Node newnode = new Node(data);
        newnode.next = null;

        if(list.head == null){
            list.head = newnode;
        }
        else{
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newnode;
        }

        return list;
    }

    public static LinkedList deleteAtPosition(LinkedList list, int index){
        Node currNode = list.head, prev = null;

        if(index == 0 && currNode != null){
            list.head = currNode.next;
            System.out.println(index + " position element deleted");

            return list;
        }

        int counter = 0;

        while(currNode != null){
            if(counter == index){
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if(currNode == null){
            System.out.println(index + " position element not found");
        }

        return list;
    }

    public static void printList(LinkedList list){
        Node currNode = list.head;
        System.out.println("LinkedList: ");
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static LinkedList deleteByKey(LinkedList list, int key){
        Node currNode = list.head, prev = null;

        if(currNode != null && currNode.data == key){
            list.head = currNode.next;
            System.out.println(key + "found and deleted");

            return list;
        }

        while(currNode != null && currNode.data != key){
            prev = currNode;
            currNode = currNode.next;
        }

        if(currNode != null){
            prev.next = currNode.next;
            System.out.println(key + "found and deleted");
        }

        if(currNode == null){
            System.out.println(key + " not found");
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insert(list,1);
        list = insert(list,2);
        list = insert(list,3);
        list = insert(list,4);
        list = insert(list,5);
        list = insert(list,6);
        list = insert(list,7);
        list = insert(list,8);

        printList(list);

        deleteByKey(list, 1);
        printList(list);
        deleteByKey(list, 4);
        printList(list);
        deleteByKey(list, 10);
        printList(list);

        deleteAtPosition(list,0);
        printList(list);
        deleteAtPosition(list,10);
        printList(list);
    }

}
