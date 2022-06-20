package com.nexsoft.sorting;

public class CSorting {
	
	public void bubbleSort(int arr[], int n)
    {                                       
        if (n == 1)                     //passes are done
        {
            return;
        }

        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            if (arr[i] > arr[i+1])      //check if the elements are in order
            {                           //if not, swap them
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
            
        bubbleSort(arr, n-1);           //one pass done, proceed to the next
    }
	
	
	void display(int arr[])                 //display the array
    {  
        for (int i=0; i<arr.length; ++i) 
        {
            System.out.print(arr[i]+" ");
        } 
    } 
	
	
	public  void selectionSort(int arr[]) 
    { 
        int pos;
        int temp;
        for (int i = 0; i < arr.length; i++) 
        { 
            pos = i; 
            for (int j = i+1; j < arr.length; j++) 
           {
                if (arr[j] < arr[pos])                  //find the index of the minimum element
                {
                    pos = j;
                }
            }

            temp = arr[pos];            //swap the current element with the minimum element
            arr[pos] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
	
	public void insertionSort(int arr[], int n) 
    { 
        if (n <= 1)                             //passes are done
        {
            return; 
        }

        insertionSort( arr, n-1 );        //one element sorted, sort the remaining array
       
        int last = arr[n-1];                        //last element of the array
        int j = n-2;                                //correct index of last element of the array
       
        while (j >= 0 && arr[j] > last)                 //find the correct index of the last element
        { 
            arr[j+1] = arr[j];                          //shift section of sorted elements upwards by one element if correct index isn't found
            j--; 
        } 
        arr[j+1] = last;                            //set the last element at its correct index
    } 

}
