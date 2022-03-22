package com.kishy.j_comp;

public class Doubly_LL {


        private Node head;
        private Node current;
        private int size;
        private Node tail;

    public Doubly_LL() {
        this.size = size;
    }

    private class Node{

            int value;
            Node next;
            Node prev;

            public Node(int value){
                this.value = value;

            }

        }

        public int insert_first(int SongID) {
            Node node = new Node(SongID);
            node.next = head;
            node.prev = null;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            size++;
            return SongID;

        }

        public void next_song(){



        }

        public int insert_song_last(int value){
            Node node = new Node(value);
            Node last = head;

            //node.next = null;


            if (head == null){
                node.prev = null;
                head = node;
                return 0;
            }

            while (last.next != null){
                last = last.next;
            }

            last.next = node;
            node.prev = last;
            node.next = null;

            size++;
            return value;
        }

        public int insert_song_pos(int after, int val){
            Node p = find(after);

            //this node might not exist
            if (p == null){
                System.out.println("does not exist");
                return after;
            }

            Node node = new Node(val);

            node.next = p.next;
            p.next = node;
            node.prev = p;

            if (node.next != null) {
                node.next.prev = node;
            }
            size++;
            return 0;
        }


        public Node find(int value){
            Node node = head;
            while (node!=null){
                if (node.value == value){
                    return node;
                }
                node = node.next;
            }
            return null;
        }

        public int delete_beg(){

            if (head == null){
                System.out.println("List is empty");
            }

            head = head.next;
            Node last = null;
            Node temp = head;
            while (temp!=null){
                System.out.print(temp.value + " -> ");
                last = temp;
                temp = temp.next;

            }
            System.out.print("END");
            System.out.println();

//            while (last!=null && last.prev != null){
//                System.out.print(last.value + " -> ");
//                last = last.prev;
//            }
//            System.out.print("BEG");
            size--;

            return 0;
        }

        public int delete_last(){
            if (size<=1){
                delete_beg();
            }

            Node ref = get(size-2);
            tail = ref;
            tail.next = null;

            return 0;
        }

        public int delete_song_index(int index){

            if (index == 0){
                delete_beg();
            }
            if (index == size-1){
                delete_last();
            }

            Node node =get(index-1);
            node.next = node.next.next;
            node.next.next.prev = node;

            Node temp = head;
            Node last = null;

            while (temp!=null){
                System.out.print(temp.value + " -> ");
                last = temp; //end of the loop it will point to last node
                temp = temp.next;
            }
            System.out.print("END");

            System.out.println();


            return 0;
        }

    public Node get(int index){ //returns reference pointer to that node

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


        public void display(){

            Node temp = head;
            Node last = null;
            while (temp!=null){
                System.out.print(temp.value + " -> ");
                last = temp; //end of the loop it will point to last node
                temp = temp.next;
            }
            System.out.print("END");

            System.out.println();
//            System.out.println("Print in reverse order");
//
//            while (last!=null){
//                System.out.print(last.value + " -> ");
//                last = last.prev;
//            }
//            System.out.print("BEG");
        }


}
