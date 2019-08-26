package pkg2si4_lab_5;
import java.util.Arrays;

/**
 *
 * @author moham
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6};
        MaxHeap heapA = new MaxHeap(a);
        heapA.insert(6);
        heapA.insert(8);
        heapA.insert(0);
        System.out.println("We are going to print heap A then print the max element that was removed: ");
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        System.out.println(heapA.deleteMax());
        System.out.println(heapA.toString());
        
        
        
        
        System.out.println("---------------------------");
        MaxHeap heapB = new MaxHeap(5);
        System.out.print("This is heap B before the insertion of any elements: ");
        System.out.println(heapB.toString());
        heapB.insert(2);
        heapB.insert(15);
        heapB.insert(20);
        heapB.insert(0);
        heapB.insert(1);
        heapB.insert(50);
        System.out.print("This is heap B after the insertion of all elements: ");
        System.out.println(heapB.toString());
        System.out.print("This is heap B's heap size (number of elements in the heap): ");
        System.out.println(heapB.getHeapSize());
        System.out.print("This is heap B's array size (number spaces available for elements to be added to the heap): ");
        System.out.println(heapB.getArraySize());
        
        
        
        
        System.out.println("---------------------------");
        System.out.print("This is the array before heapsort: ");
        System.out.println(Arrays.toString(a));
        MaxHeap.heapsort(a);
        System.out.print("This is the array after heapsort: ");
        System.out.println(Arrays.toString(a));
    }
    
}
