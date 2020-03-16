package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Heap<T extends Comparable<T>> implements IHeap<T> {
    private Node left;
    private Node right;
    private Node largest;
    private Node swap;
    private Node temp;
    private Node temp2 ;
    private Node temp3 ;
    ArrayList<Node> unordered = new ArrayList();
    private int index;
    private int lastPosititon = 1;
    private int position =1;
    private int a, b,c;

    //public Heap(ArrayList unordered) {
    // for (int i=0;i<unordered.size();i++){
    // INode s=new Node();
    //s.setValue((Comparable) unordered.get(i));
    // this.unordered.add(i,s);
    //}
    //}
    public Heap() {
        unordered.add(null) ;
    }

    /*public static  Heap ob=new Heap();
    public static Heap getInst() {
        if(ob==null) {
            return new Heap();
        }
        return ob;
    }*/

    @Override
    public INode<T> getRoot() {
        if(lastPosititon==1){
            return  null ;
        }
        return this.unordered.get(1);
    }

    @Override
    public int size() {
        return lastPosititon-1;
    }

    @Override
    public void heapify(INode<T> node) {
        if (node == null) {
            return;
        }
         Node t = (Node) node;

            left = (Node) node.getLeftChild();
            right = (Node) node.getRightChild();

            a = t.getIndex();
            largest = (Node) node;

            if(left!=null) {
                if (left.getValue().compareTo(t.getValue()) > 0) {
                    largest = left;
                }
                else {
                    largest = (Node) node;
                }
            }
            if(right!=null) {

                if (right.getValue().compareTo(t.getValue()) > 0) {
                    largest = right;
                }
            }

            b = largest.getIndex();
            if (a != b && b < lastPosititon && a < lastPosititon) {
                swap = largest;
               // this.unordered.remove(b);
                t.setIndex(b);
                //this.unordered.add(b, t);
                this.unordered.set(b,t) ;
               // this.unordered.remove(a);
                swap.setIndex(a);
                //this.unordered.add(a, swap);
                this.unordered.set(a,swap);
                heapify(largest);
            }
            return;

    }


    @Override
    public T extract() {
        if(lastPosititon==1){
            return  null ;
        }
        temp=this.unordered.get(1);
        temp3=this.unordered.get(lastPosititon-1);
        //this.unordered.remove(1);
        this.unordered.set(1,temp3);
        this.unordered.get(1).setIndex(1);
        this.unordered.set(lastPosititon-1,temp);
        this.unordered.get(lastPosititon-1).setIndex(lastPosititon-1);

        //this.unordered.add(1,temp3);
        //this.unordered.remove(this.unordered.size()-1);
        //this.unordered.get(1).setValue(this.unordered.get(this.unordered.size()-1).getValue());
        //this.unordered.get(this.unordered.size()-1).setValue(temp.getValue());

        lastPosititon-- ;
        if(this.unordered.size()!=1) {
            temp2 = this.unordered.get(1);
            heapify(temp2);
        }
        return (T) temp.getValue();
    }

    /*private void trickleDown(int parent) {
        if (parent * 2 + 1 == lastPosititon && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 1)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 1));
            this.unordered.remove(parent*2+1);
            this.unordered.add(parent*2+1, swap);
            return;
        }
        if (parent * 2 + 2 == lastPosititon && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 2)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 2));
            this.unordered.remove(parent*2+2);
            this.unordered.add(this.unordered.indexOf(parent * 2 + 2), swap);
            return;
        }
        if (parent * 2 + 1 >= lastPosititon || parent * 2 + 2 >= lastPosititon) {
            return;
        }
        if ((int) this.unordered.get(parent * 2 + 1) > (int) this.unordered.get(parent * 2 + 2) && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 1)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 1));
            this.unordered.remove(parent*2+1);
            this.unordered.add(parent * 2 + 1, swap);
            trickleDown(parent * 2 + 1);
        } else if ((int) this.unordered.get(parent * 2 + 2) > (int) this.unordered.get(parent * 2 + 1) && (int) this.unordered.get(parent) < (int) this.unordered.get(parent * 2 + 2)) {
            swap = (Node) this.unordered.get(parent);
            this.unordered.remove(parent);
            this.unordered.add(parent, this.unordered.get(parent * 2 + 2));
            this.unordered.remove(parent*2+2);
            this.unordered.add(parent * 2 + 2, swap);
            trickleDown(parent * 2 + 2);
        }
    }*/

    @Override
    public void insert(T element) {
        if(element==null){
            return;
        }
        //build(this.unordered);
        Node n = new Node(this);
        n.setIndex(lastPosititon);
        n.setValue(element);
        if(lastPosititon>=this.unordered.size()){
            this.unordered.add(n);
        }else{
            this.unordered.set(lastPosititon,n);
        }
        lastPosititon++ ;
        //e.arr.add(n) ;
        //trickleUp(lastPosititon-1);
        int i=lastPosititon-1;
       while(i!=1&&i!=0 &&((unordered.get(i).getValue()).compareTo( unordered.get(i/2).getValue())>0)) {
            T temp= (T) unordered.get(i).getValue();
            unordered.get(i).setValue(unordered.get(i/2).getValue());
            unordered.get(i/2).setValue(temp);
            i=i/2;
        }

    }






    @Override
    public void build(java.util.Collection<T> unordered) {
        if(unordered==null){
            lastPosititon=1;
            return;
        }

        lastPosititon=(unordered.size())+1;
        this.unordered.clear();
        this.unordered.add(null);

        Iterator<T> r=unordered.iterator();
         int i=1;
        while (r.hasNext()){
            Node n =new Node(this);
            n.setIndex(i);
            n.setValue(r.next());
            this.unordered.add(n);
            i++ ;
        }
        int e = (unordered.size())/2 ;
        int b = get ((unordered.size())/2) ;
        while (b>0){
            for (i=b;i<=e;i++){
                heapify(this.unordered.get(i));
            }
            e=b-1 ;
            b/=2 ;
        }
    }


   public void setLastPosititon(int z){
        lastPosititon=z;

   }

    public int getLastPosititon(){
       return lastPosititon;
    }
    public int get (int index ){
        int i =0 ;
        while ((index/2)!=0) {
            index/=2 ;
            i++ ;
        }
        int q = 1<<i ;
        return q ;
    }
}
