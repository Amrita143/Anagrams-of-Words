class T{
    
}


class EmptyArrList extends Exception{
    public EmptyArrList(String s){
        super(s);
    }
}

public class ArrList<T> {
   

    Object[] arr= new Object[1];
    int top_index=-1;
 
     public Object[] increaseSize(Object[] arr)
     {
         Object[] newarray = new Object[2*arr.length];
         for(int i=0;i< arr.length;i++)
         {
             newarray[i]=arr[i];
         }
         return newarray;
     }
     public void add(T item){
        top_index++;
        if(top_index>= arr.length)
        arr= increaseSize(arr); 

        arr[top_index]=item;
    }
    public boolean isEmpty() {
        if(top_index<0)
            return true;
        else
            return false;
 
      }

      public int size() {
        return top_index+1;
    }

    public T get(int index) throws EmptyArrList{
        if(top_index<0)
        throw new EmptyArrList("ArrayList is empty");
        else
        return (T) arr[index];
     }

     public void set(int index,T value) throws EmptyArrList{
        if(top_index<0)
        throw new EmptyArrList("ArrayList is empty");
        else
        arr[index]=value;
     }

     public T remove(int index) throws EmptyArrList{

        if(top_index<0)
        throw new EmptyArrList("ArrayList is empty");
        else
    {
            Object temp = arr[index];
        for(int i=index;i<=top_index-1;i++)
        {
          arr[i]=arr[i+1];
        }
        top_index--;
        return (T) temp;
    }
}
     public void print(){
       //  int[] output_arr = new int[top_index+1];
       String s="";
         for(int i=0;i<=top_index;i++){
            // output_arr[i]=arr[i];
            s= s+" "+arr[i];
         }
        System.out.println(s);
     }

 public static void main(String[] args){
   try{
   
    ArrList<String> a= new ArrList<String>();
    a.add("I");
    a.print();;
    a.add("Love");
    a.print();
    a.add("you");
    a.print();
   System.out.println(a.remove(1)); 
    a.print();
    a.add("very");
    a.add("much");
    a.print();
   System.out.println(a.remove(2));
   a.print(); 
   System.out.println(a.remove(0)); 
   a.print();
    a.add("hello");
    a.set(2,"hii");
    a.add("Amrita");
    a.add("Mandal");

    System.out.println(a.get(3));
    a.add("Sweet");
    a.add("yogi");

    a.print();
    System.out.println(a.size());
   System.out.println(a.remove(4)); 
    a.print();
  System.out.println(a.remove(3));  
    a.print();
    System.out.println(a.remove(0));
    System.out.println(a.remove(0));
    System.out.println(a.remove(0));
    System.out.println(a.remove(0));
    System.out.println(a.remove(0));
    System.out.println(a.remove(0));
   }
   catch(EmptyArrList e){
       System.out.println(e.getMessage());
   }
    
 }
    
}
