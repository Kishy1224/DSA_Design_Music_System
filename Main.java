package com.kishy.j_comp;

import java.util.*;

import static com.kishy.j_comp.close.findclosestdistance;
import static com.kishy.j_comp.close.sortSongsByFrequency;

public class Main {

    private static ArrayList<Music_album> musicalbums = new ArrayList<>();
    private static ArrayList<Music_album> musical_ids = new ArrayList<>();


    public static void main(String[] args) {

        Music_album musicalbum = new Music_album("Album1","ARR");

        musicalbum.addSong("Arabic kadaloram",4.5);
        musicalbum.addSong("Kana lane",3.5);
        musicalbum.addSong("Nila kaigiradae",5.0);
        musicalbum.addSong("Ore Kana",6.0);
        musicalbum.addSong("Ale Ale",5.7);
        musicalbum.addSong("venilave venilave",4.0);
        musicalbums.add(musicalbum);

        musicalbum = new Music_album("Album2","Eminem");

        musicalbum.addSong("Rap god",4.5);
        musicalbum.addSong("Not Afraid",3.5);
        musicalbum.addSong("Lose yourself",4.5);
        musicalbum.addSong("8 mile",3.52);
        musicalbum.addSong("venom",3.56);
        musicalbum.addSong("Without me",3.58);

        musicalbums.add(musicalbum);



        LinkedList<Song> playList_1 = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> playList_2 = new PriorityQueue<>();

        musicalbums.get(0).addToPlayList("Arabic kadaloram",playList_1);
        musicalbums.get(0).addToPlayList("Kana lane",playList_1);
        musicalbums.get(0).addToPlayList("Nila kaigiradae",playList_1);
        musicalbums.get(1).addToPlayList("Rap god",playList_1);
        musicalbums.get(1).addToPlayList("Lose yourself",playList_1);
        musicalbums.get(0).addToPlayList("Ore Kana",playList_1);
        musicalbums.get(0).addToPlayList("venilave venilave",playList_1);
        musicalbums.get(0).addToPlayList("Ale Ale",playList_1);
        musicalbums.get(1).addToPlayList("8 mile",playList_1);
        musicalbums.get(1).addToPlayList("Not Afraid",playList_1);
        musicalbums.get(1).addToPlayList("venom",playList_1);
        musicalbums.get(1).addToPlayList("Without me",playList_1);

        /////  Respective song ids below

        play(playList_1);

        System.out.println();
        System.out.println("\n Passing the respective SOng IDs into priority Queue");
        System.out.println();

        playList_2.add(12);
        playList_2.add(13);
        playList_2.add(13);
        playList_2.add(5);
        playList_2.add(14);
        playList_2.add(3);
        playList_2.add(60);
        playList_2.add(30);
        playList_2.add(13);
        playList_2.add(1);
        playList_2.add(10);
        playList_2.add(4);

        System.out.println();
        System.out.println("Random Shuffling of Playlist");

        for (int songid : playList_2) {


            System.out.print(songid + " ");

        }

        System.out.println();
        System.out.println();
        System.out.println("Getting the songs in the original order....");

        for (int i =0 ;i<12;i++){

            System.out.println("Song" + i + ":" + playList_2.poll());
        }

        System.out.println();
        System.out.println();
        System.out.println("Prioritizing songs based on the most played songs");
        System.out.println();

        int[] arr =  {12,13,13,5,14,3,60,30,13,1,10,4};

        int []freqSorted = sortSongsByFrequency(arr);

        System.out.println(Arrays.toString(freqSorted));
        System.out.println();

        int []x = {12,13,40,5,14,3};
        int []y = {3,30,50,1,10,4};

        //(5,3) are similar pair of songs ,(1,4) are similar pair of songs ->closest pair
        System.out.println("Closest distance between similar songs : "+ findclosestdistance(x,y,x.length));
        System.out.println();
        System.out.println("Therefore similar songs are  with ID's (3,5) and (1,4)....");
    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println();
            System.out.println("Now playing " + listIterator.next().toString());
            System.out.println();
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }
                    break;


            }
        }


    }



    private static void printMenu(){
        System.out.println("Music Player \n");
        System.out.println("Choose any options below :");
        System.out.println();
        System.out.println("0 - to Exit Playlist\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");

    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("");
    }

}


class close{
    public static double distance(points p1, points p2) {

        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static double calculatecase3(ArrayList<points> arr, int size, double minDistance) {

        double minValue = minDistance;

        for (int i = 0; i < size; i++) {

            for (int j = i + 1; j < Math.min(size, i + 1 + 7); j++) {

                minValue = Math.min(minValue, distance(arr.get(i), arr.get(j)));
            }
        }
        return minValue;
    }


    public static double Brute_force(ArrayList<points> arrx, int count) {

        double result = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {

            for (int j = i + 1; j < count; j++) {

                result = Math.min(result, distance(arrx.get(i), arrx.get(j)));
            }

        }
        return result;
    }


    public static double closestRecursive(ArrayList<points> arrX, ArrayList<points> arrY, int count) {

        //base condition

        if (count <= 3) {
            return Brute_force(arrX, arrX.size());     //we'll use bruteforce method
        }

        //finding the midpoint

        int mid = count / 2;
        points midpoint = arrX.get(mid);

        //now create two seperate list which contains elements on left and elements on right

        ArrayList<points> newArrx1 = new ArrayList<>();
        ArrayList<points> newArrx2 = new ArrayList<>();

        for (int i = 0; i < mid; i++) {

            newArrx1.add(arrX.get(i));

        }

        for (int i = mid; i < arrX.size(); i++) {

            newArrx2.add(arrX.get(i));

        }

        //now call the recursive function

        double distanceleft = closestRecursive(newArrx1, arrY, mid);
        double distanceright = closestRecursive(newArrx2, arrY, count - mid);

        double minDistance = Math.min(distanceleft, distanceright);


        //now for case 3 one point form each side of mid

        ArrayList<points> arr_case3 = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            if (Math.abs(arrY.get(i).x - midpoint.x) < minDistance) {

                arr_case3.add(arrY.get(i));

            }
        }
        return Math.min(minDistance, calculatecase3(arr_case3, arr_case3.size(), minDistance));

    }


    public static double findclosestdistance(int[] x, int[] y, int count) {

        ArrayList<points> arrX = new ArrayList<>();
        ArrayList<points> arrY = new ArrayList<>();

        for (int i = 0; i < x.length; i++) {

            points p = new points(x[i], y[i]);

            arrX.add(p);
            arrY.add(p);

        }


        Collections.sort(arrX, (a, b) -> a.x - b.x);//sort wrt to x-axis
        Collections.sort(arrY, (a, b) -> a.y - b.y);//sort wrt to y-axis


        return closestRecursive(arrX, arrY, arrX.size());
    }


    static int[] sortSongsByFrequency(int[] arr) {

        //calculate frequencies of songs
        Map<Integer, Integer> freqMap = SongFrequencyMap(arr);


        //Comparator for storing value, frequency tuples in priority queue (max heap)

        Comparator< Map.Entry<Integer,Integer> > descFreqComparator = (e1, e2) -> e2.getValue() - e1.getValue();

        PriorityQueue< Map.Entry<Integer, Integer> > pq = new PriorityQueue<>(descFreqComparator);

        //Add map entries to max heap
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            pq.add(entry);
        }

        //Form the result array by deleting elements from priority queue
        int []result = new int[arr.length];
        int i = 0;
        while( !pq.isEmpty() ) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            for(int j = 0; j < entry.getValue(); j++) {
                result[i++] = entry.getKey();
            }
        }
        return result;
    }

    private static Map<Integer, Integer> SongFrequencyMap(int []arr) {
        //LinkedHashMap to preserve the original order of elements in arr
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        int i;
        for(i = 0; i < arr.length; i++) {
            if(freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i])+1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }
        return freqMap;
    }
}
class points
    {
        int x;
        int y;

        points(int x, int y){

            this.x = x;
            this.y = y;
        }

    }

