/* Creating a dynamic array which support all data types */

@SuppressWarnings("unchecked")
public class DynamicArray<T>{
	
	private T[] arr;
	private int len = 0; // length of array that user knowns
	private int capacity = 0;// actual capacity of array

	// Default Constructor 
	public DynamicArray()
	{
		arr = (T[]) new Object[16];
		this.capacity = 16; 
	}

	// Constructor which takes capacity as input parameter
	public DynamicArray(int capacity)
	{
		if(capacity < 0)System.out.println("Array size cannot be negative");
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}


	public int size(){
		return len; // return number of elements present in array
	}

	public boolean isEmpty()
	{
		return len == 0; 
	}

	public T get(int index)
	{
		return arr[index];
	}

	public void set(int index, T value)
	{
		arr[index] = value;
	}

	public void clear()
	{
		for(int i = 0 ; i < capacity ; ++i)
		{
			arr[i] = null;
		}
	}
	public void add(T value)
	{
		if(len+1 > capacity)// when array is full 
		{
			if(capacity == 0) capacity = 1;// array is empty
			else capacity *= 2; // double the capacity
			T[] newArr = (T[]) new Object[capacity];//create a new arrays with double capacity
			for(int i = 0 ; i < len ; ++i)// copy array elements into new array
			{
				newArr[i] = arr[i];
			}
			arr = newArr;//change reference of new Array to arr
		}
		arr[len++] = value;//add the elemnet to array
	}
	public T removeAt(int index)
	{
		if(index >= len && index < 0) System.out.println("IndexOutOfBounds");
		T data = arr[index];
		for(int i = index ; i < len - 1 ; ++i)
		{
			arr[i] = arr[i + 1];
			
		}
		arr[len - 1] = null;
		len--;
		return data;
	}
	public boolean remove(T data)
	{
		for(int i = 0 ; i < len ; ++i)
		{
			if(arr[i].equals(data))
			{
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	public int indexOf(T data)
	{
		for(int i = 0 ; i < len ; ++i)
		{
			if(arr[i].equals(data)) return i;
		}
		return -1;
	}
	public boolean contains(T data)
	{
		return indexOf(data) != -1;
	}

	@Override public String toString()
	{
		if(len == 0) return "[]";
		else
		{
			StringBuilder sb = new StringBuilder(len).append("[");
			for(int i = 0 ; i < len -1 ; ++i)
			{
				sb.append(arr[i]+", ");
			}
			return sb.append(arr[len - 1] + "]").toString();
		}
	}
	public static void main(String[] args) {
		DynamicArray<Integer> arr = new DynamicArray<Integer>(20);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		System.out.println(arr);
		arr.set(3,10);
		System.out.println(arr);
		//System.out.println(arr.get(1));
		arr.removeAt(1);
		System.out.println(arr);
		System.out.println(arr.size());
		System.out.println(arr.isEmpty());
		System.out.println(arr.contains(2));
		//System.out.println(arr.remove(1));
		arr.remove(3);
		System.out.println(arr);
	}
}