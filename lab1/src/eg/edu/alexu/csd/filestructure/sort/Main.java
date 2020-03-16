package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

   Heap h = new Heap();

   ArrayList<Comparable> j = new ArrayList<>() ;
   j.add(3);
   j.add(1);
   j.add(9);
   j.add(0);
   j.add(2);


       h.build(j);
        int limit =j.size()-1 ;
        while (h.size()>0){
            Comparable e = h.extract() ;
            j.set(limit,  e);
            limit--;
        }
        System.out.println(j.get(0));





    }
}
