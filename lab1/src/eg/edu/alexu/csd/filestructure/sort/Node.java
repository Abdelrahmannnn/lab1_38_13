package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Vector;
public class Node<T extends Comparable<T>> implements INode<T> {
    private T node=null;
    private int index;
    private Heap heap ;
    ArrayList<INode> k ;

    public Node( Heap h){
        heap = h ;
        node=null ;

    }
    public Node () {

    }
    @Override
    public INode<T> getLeftChild() {
        if((index*2)>=heap.getLastPosititon()){
            return null;
        }
        return (INode<T>) heap.unordered.get(index*2);
    }
    @Override
    public INode<T> getRightChild() {
        if(((index*2)+1)>=heap.getLastPosititon()){
            return null;
        }
        return (INode<T>) heap.unordered.get(index*2+1);
    }
    @Override
    public INode<T> getParent() {
        if(index==1){
            return null;
        }
        return (INode<T>) heap.unordered.get((int) Math.floor((index)/2));
    }
    @Override
    public T getValue() {
        if(node==null){
            return  null ;
        }

        return  node;
    }
    @Override
    public void setValue(T value) {
        node=value;
    }
    public void setIndex (int i){
        index=i ;
    }
    public int getIndex () {
        return index ;
    }


}