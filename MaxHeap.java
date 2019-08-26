/**
 *
 * @author moham
 */

public class MaxHeap {
    private Integer[] heap; //this is the array that will store out max heap.
    private int arraySize; //the size of the "heap" array
    private int heapSize; //number of items in heap
    
    public MaxHeap(int s){
        this.arraySize = s; //setting the size
        this.heap = new Integer[s]; //initalizing a new array
        this.heapSize = 0;
    }
    
    public MaxHeap(Integer[] someArray){
        this.arraySize = someArray.length;
        heap = new Integer[arraySize];
        
        for(int i=0; i<arraySize; i++){
            this.insert(someArray[i]);
        }
    }
    
    public void insert(int n){
        int nIndex, percTemp, parentIndex;
        
        if((this.heapSize+1)>this.arraySize){
            Integer[] temp = new Integer[this.arraySize * 2]; // the temp array will store our new heap with the inserted element which will be copied to our heap object
            //copying array using available method
            System.arraycopy(heap, 0, temp, 0, this.arraySize); //copying over old heap
            //manual array copy
            /*for(int i=0; i<this.arraySize; i++){
                temp[i] = heap[i]; //copying over old heap
            }*/
            temp[this.arraySize] = (Integer) n; //inserting the new element in the last spot
            nIndex = this.arraySize;
            this.heap = temp;
            this.arraySize = temp.length;
            this.heapSize++;
        }
        else{
            //we find the end of the heap and insert our element
            int i=0;
            while(heap[i]!=null){
                i++;
            }
            nIndex = i;
            heap[i] = (Integer) n;
            this.heapSize++;
        }
        
        //now the element needs to percolate up
        if((nIndex%2)==0){
            parentIndex = (nIndex/2) - 1;
            if(parentIndex<0){parentIndex = 0;}
        }
        else{
            parentIndex = nIndex/2;
        }
        
        while(heap[parentIndex].intValue() < n){
            percTemp = heap[parentIndex];
            heap[parentIndex] = (Integer) n;
            heap[nIndex] = (Integer) percTemp;
            nIndex = parentIndex;
            
            if((nIndex%2)==0){
                parentIndex = (nIndex/2) - 1;
                if(parentIndex<0){parentIndex = 0;}
            }
            else{
                parentIndex = nIndex/2;
            }
        }
    }
    
    //make this private
    public int deleteMax(){
        int temp, maxVal, leftChildNode, rightChildNode, nIndex, i=0;
        maxVal = heap[0];
        while(heap[i]!=null){
            i++;
            if(i==(this.arraySize)){
                break;
            }
        }
        heap[0] = heap[i-1];
        heap[i-1] = null;
        nIndex = 0;
        this.heapSize--;
        
        //now the element needs to percolate down
        leftChildNode = nIndex*2 + 1;
        rightChildNode = leftChildNode + 1;
        
        if((heap[leftChildNode]==null) && (heap[rightChildNode]==null)){
            return maxVal;
        }
        
        if((heap[leftChildNode]==null) || (heap[rightChildNode]==null)){
            if((heap[leftChildNode]==null)&&(heap[nIndex]<heap[rightChildNode])){
                temp = (int) heap[rightChildNode];
                heap[rightChildNode] = heap[nIndex];
                heap[nIndex] = (Integer) temp;
                return maxVal;
            }
            else if((heap[rightChildNode]==null)&&(heap[nIndex]<heap[leftChildNode])){
                temp = (int) heap[leftChildNode];
                heap[leftChildNode] = heap[nIndex];
                heap[nIndex] = (Integer) temp;
                return maxVal;
            }
        }
        
        while((heap[nIndex]<heap[leftChildNode]) || (heap[nIndex]<heap[rightChildNode]) || (nIndex<(this.arraySize-1))){
            if(heap[leftChildNode]<=heap[rightChildNode]){
                temp = (int) heap[rightChildNode];
                heap[rightChildNode] = heap[nIndex];
                heap[nIndex] = (Integer) temp;
                
                nIndex = rightChildNode;
                leftChildNode = nIndex*2 + 1;
                rightChildNode = leftChildNode + 1;
            }
            else if(heap[leftChildNode]>heap[rightChildNode]){
                temp = (int) heap[leftChildNode];
                heap[leftChildNode] = heap[nIndex];
                heap[nIndex] = (Integer) temp;
                
                nIndex = leftChildNode;
                leftChildNode = nIndex*2 + 1;
                rightChildNode = leftChildNode + 1;
            }
            
            if(rightChildNode >= (this.arraySize-1)){
                rightChildNode = leftChildNode;
            }
            if((leftChildNode >= (this.heapSize)) || (rightChildNode >= (this.heapSize))){
                break;
            }
        }
        
        return maxVal;
    }
    
    public String toString(){
        String heapString="";
        
        if(heap[0]==null){
            heapString+="**empty heap**";
            return heapString;
        }
        
        heapString = Integer.toString(heap[0]);
        for(int i=1; i<(this.heapSize); i++){
            heapString = heapString + ", " + Integer.toString(heap[i]);
        }
        //heapString += Integer.toString(heap[heapSize-1]);
        
        return heapString;
    }
    
    public static void heapsort(Integer[] arrayToSort){
        MaxHeap sortedHeap = new MaxHeap(arrayToSort);
        
        for(int i=0; i<sortedHeap.heapSize; i++){
            arrayToSort[i] = (Integer) sortedHeap.deleteMax();
        }
    }
    
    public int getHeapSize(){
        return this.heapSize;
    }
    
    public int getArraySize(){
        return this.arraySize;
    }
}
