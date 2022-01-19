import java.util.ArrayList;

// linSearch, binSearch, bubbleSort, selectionSort, insertionSort
public class SortsNSearches {

  /**
     int linSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target
     post: returns index of first occurrence of target, or
     returns -1 if target not found
  **/
  public static int linSearch ( Comparable[] a, Comparable target )
  {
    int tPos = -1;
    int i = 0;

    while ( i < a.length ) {
        if (a[i] == target){
            tPos = i;
            break;
        }
        i++;
    }
    return tPos;
  }

  public static int linSearchint ( int[] a, int target )
  {
    int tPos = -1;
    int i = 0;

    while ( i < a.length ) {
        if (a[i] == target){
            tPos = i;
            break;
        }
        i++;
    }
    return tPos;
  }

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( Comparable[] a, Comparable target )
  {
    //uncomment exactly 1 of the 2 stmts below:

    return binSearchIter( a, target, 0, a.length-1 );
    //return binSearchRec( a, target, 0, a.length-1 );
  }

  public static int binSearchIter( Comparable[] a,
                                Comparable target,
                                int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while( lo <= hi ) { // run until lo & hi cross

      //update mid pos var
        m = (lo + hi) / 2;
      // target found
        if (a[m].compareTo(target) == 0){
            tPos = m;
            break;
        }
      // value at mid index higher than target
        if (a[m].compareTo(target) > 0){
            hi = m - 1;
        }
      // value at mid index lower than target
        else if (a[m].compareTo(target) < 0){
            lo = m + 1;
        }
    }
    return tPos;
  }//end binSearchIter

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order

/*
  ALGO:
  0. Starting from the end
  1. Compare the current element to the one before it (index - 1)
  2. If the current is less than the previous, swap the two
  3. Now go down and turn index - 1 into your new current and do steps 2 and 3 again until you make it to the element that is at the index (pass#)
  4. Repeat steps 0-3 for every pass until pass# == to arraylist length - 1
*/

  public static void bubbleSortV( ArrayList<Comparable> data )
  {

    for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
      System.out.println( "commencing pass #" + passCtr + "..." );

      //iterate thru first to next-to-last element, comparing to next
      for( int i = 0; i < data.size()-1; i++ ) {

        //if element at i > element at i+1, swap
        if ( data.get(i).compareTo(data.get(i+1) ) > 0 )
          data.set( i, data.set(i+1,data.get(i)) );

        //System.out.println(data); //diag: show current state of list
      }
    }

  }

  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  // Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    bubbleSortV( data );

    return data;
  }


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order

  /*
  ALGO:
  1. Select smallest element, move to end.
  2. Select next smallest, move to next-to-end.
  3. Wash, rinse, repeat.
  */

  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at rightmost end,

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; pass > 0; pass-- ) {
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
      maxPos = 0;
      for( int i = 1; i <= pass; i++ ) {
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag
        if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
          maxPos = i;
      }
      data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
      System.out.println( "after swap: " +  data );//diag
    }
  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  // Returns sorted copy of input ArrayList.

  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort

  public static void selectionSortVint( int[] data )
  {
    int n = data.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (data[j] < data[min_idx])
                    min_idx = j;

            // Swap
            int temp = data[min_idx];
            data[min_idx] = data[i];
            data[i] = temp;
    }
  }//end selectionSort

  public static int[] selectionSortint( int[] input )
  {
    //declare and initialize empty ArrayList for copying
    int[] data = new int[input.length];

    //copy input ArrayList into working ArrayList
    for( int i = 0; i < input.length; i++ ) {
      data[i] = input[i];
    }

    //sort working ArrayList
    selectionSortVint( data );

    return data;
  }//end selectionSort



  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order

  /*
  ALGO:
  1. Partition list into sorted and unsorted
  2. "Walk" element fron unsorted to where it belongs in cocoSorted
  3. Increase size of sorted by 1
  4. Repeat 2 and 3 until sorted
  */

  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for( int partition = 1; partition < data.size(); partition++ ) {
      //partition marks first item in unsorted region

      //diag:
      System.out.println( "\npartition: " + partition + "\tdataset:");
      System.out.println( data );

      //traverse sorted region from right to left
      for( int i = partition; i > 0; i-- ) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
          //diag:
          System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
          data.set( i, data.set( i-1, data.get(i) ) );
        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  // Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort

} //end SortsNSearches
