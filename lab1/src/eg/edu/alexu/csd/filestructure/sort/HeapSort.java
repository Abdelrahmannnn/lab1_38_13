package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Collections;

public class HeapSort <T extends Comparable<T>> implements ISort<T> {
    private Object temp;
    private ArrayList heapsort;
    private Comparable k;


    @Override
    public IHeap<T> heapSort(ArrayList<T> unordered) {
        if(unordered==null||unordered.size()==0) {
            IHeap<T> N=new Heap<T>();
            return N;
        }
         Heap<T> h=new Heap();
        int f = unordered.size() ;
         h.build(unordered);
        int limit =unordered.size()-1 ;
        while (h.size()>0){
            unordered.set(limit--,h.extract());
        }
        h.setLastPosititon(f);
        return h;
    }
    @Override
    public void sortSlow(ArrayList<T> unordered) {
        //Bubble sort...
        if(unordered==null) {
            return;
        }
        for(int i = 0;i<unordered.size()-1;i++){
            for(int j = i+1;j<unordered.size();j++){
                if((unordered.get(i).compareTo(unordered.get(j)))>=1){
                    Collections.swap(unordered, i, j);
                }
            }
        }
    }
    @Override
    public void sortFast(ArrayList<T> unordered) {
        if(unordered==null) {
            return;
        }
        doMergeSort( unordered);

    }
    private void doMergeSort(ArrayList<T> numbers){
        int middle;
        ArrayList<T> left = new ArrayList<>();
        ArrayList<T> right = new ArrayList<>();

        if (numbers.size() > 1) {
            middle = numbers.size() / 2;

            for (int i = 0; i < middle; i++)
                left.add(numbers.get(i));

            for (int j = middle; j < numbers.size(); j++)
                right.add(numbers.get(j));

            doMergeSort(left);
            doMergeSort(right);

            merge(numbers, left, right);
        }
    }

    private  void merge(ArrayList<T> numbers, ArrayList<T> left, ArrayList<T> right){

        ArrayList<T> temp = new ArrayList<>();

        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) .compareTo(right.get(rightIndex) )<0) {
                numbers.set(index, left.get(leftIndex));
                leftIndex++;
            } else {
                numbers.set(index, right.get(rightIndex));
                rightIndex++;
            }
            index++;
        }

        int tempIndex = 0;
        if (leftIndex >= left.size()) {
            temp =  right;
            tempIndex = rightIndex;
        }
        else {
            temp = left;
            tempIndex = leftIndex;
        }

        for (int i = tempIndex; i < temp.size(); i++) {
            numbers.set(index, temp.get(i));
            index++;
        }
    }
}
