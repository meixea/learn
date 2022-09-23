package com.mycompany.problem;
 
public class DataStructure {
    
    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
    public void printEven() {
        
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    public void print(DataStructureIterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    interface DataStructureIterator extends java.util.Iterator<Integer> { } 

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
    
    private class EvenIterator implements DataStructureIterator {
        
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
        
        private EvenIterator() {}
        private EvenIterator(int start_index) {
            nextIndex = start_index;
        }
        
        public boolean hasNext() {
            
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }        
        
        public Integer next() {
            
            // Record a value of an even index of the array
            //Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            Integer retValue = arrayOfInts[nextIndex];
            
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
    
    public void print(java.util.function.Function<Integer, Boolean> iterator2){
        for (Integer i = 0; i < SIZE; i++) {
            if ( iterator2.apply(i) )
                System.out.print(arrayOfInts[i] + " ");
        }
        System.out.println();
    }
    
    public static Boolean isEvenIndex(Integer i){
        return i % 2 == 0;
    }
    public static Boolean isOddIndex(Integer i){
        return i % 2 == 1;
    }
    
    public static void main(String s[]) {
        
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        //ds.print((i) -> { return i % 2 == 1; });
        //ds.print(ds.new EvenIterator(1));
        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);
    }
}
