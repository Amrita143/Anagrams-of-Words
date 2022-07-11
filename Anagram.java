import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class Anagram {



    public int HashValue_Of_Character(char c)      //prime no. assignment to all the 26 characters
    {
        if(c=='a')
        return 2;
        else if(c=='b')
        return 3;
        else if(c=='c')
        return 5;
        else if(c=='d')
        return 7;
        else if(c=='e')
        return 11;
        else if(c=='f')
        return 13;
        else if(c=='g')
        return 17;
        else if(c=='h')
        return 19;
        else if(c=='i')
        return 23;
        else if(c=='j')
        return 29;
        else if(c=='k')
        return 31;
        else if(c=='l')
        return 37;
        else if(c=='m')
        return 41;
        else if(c=='n')
        return 43;
        else if(c=='o')
        return 47;
        else if(c=='p')
        return 53;
        else if(c=='q')
        return 59;
        else if(c=='r')
        return 61;
        else if(c=='s')
        return 67;
        else if(c=='t')
        return 71;
        else if(c=='u')
        return 73;
        else if(c=='v')
        return 79;
        else if(c=='w')
        return 83;
        else if(c=='x')
        return 89;
        else if(c=='y')
        return 97;
        else if(c=='z')
        return 101;
        else if(c=='0')
        return 103;
        else if(c=='1')
        return 107;
        else if(c=='2')
        return 109;
        else if(c=='3')
        return 113;
        else if(c=='4')
        return 127;
        else if(c=='5')
        return 131;
        else if(c=='6')
        return 137;
        else if(c=='7')
        return 139;
        else if(c=='8')
        return 149;
        else if(c=='9')
        return 151;
        else 
        return 157;


    }

    public long  HashValue_Of_String(String S)
    {
         long hashValue=1;

        for(int i=0;i<S.length();i++)
        {
           hashValue = hashValue*HashValue_Of_Character(S.charAt(i));
        }

        return hashValue;
    }

  public  void sortLexicographically(ArrList<String> FinalAnagrams)
    {
        for (int i = 0; i < FinalAnagrams.size(); i++) {
            for (int j = i + 1; j < FinalAnagrams.size(); j++) {

         try{
                if (FinalAnagrams.get(i).compareToIgnoreCase(FinalAnagrams.get(j)) > 0) {

                    String temp = FinalAnagrams.get(i);
                    FinalAnagrams.set(i, FinalAnagrams.get(j));
                      FinalAnagrams.set(j, temp);
                     }
                 } catch (EmptyArrList e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        public void RemoveDuplicates(ArrList<String> FinalAnagrams){
    try {
        
   
            for(int i=0;i<FinalAnagrams.size()-1;i++)
            {
                for(int j=i+1;j<FinalAnagrams.size();j++){

                    if(FinalAnagrams.get(j).equals(FinalAnagrams.get(i)))
                    FinalAnagrams.remove(j);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
     }
      


  
  
    public void printAnagram(String s,ArrList<String> vocabularyWords) throws FileNotFoundException
    {
          
        

       ArrList<String> partsOf_Anagram = new ArrList<String>();
      /// ArrayList<String> Complementary_partsOf_Anagram = new ArrayList<>(no_of_vocabulary);

       
       
    for(int i=0;i<vocabularyWords.size();i++){
        
        try {
            if(HashValue_Of_String(s) % HashValue_Of_String(vocabularyWords.get(i))==0)
                try {
                    partsOf_Anagram.add(vocabularyWords.get(i));
                } catch (EmptyArrList e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        } catch (EmptyArrList e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

       
       
       
       
       
     //    Set<String> treeSet = new TreeSet<>();

        ArrList<String> FinalAnagrams = new ArrList<String>();


       for(int i=0;i<partsOf_Anagram.size();i++)
       {
           try {
            if(HashValue_Of_String(partsOf_Anagram.get(i))==HashValue_Of_String(s))
               {
                   FinalAnagrams.add(partsOf_Anagram.get(i));
                   continue;
               }
        } catch (EmptyArrList e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           int j;
           for(j=0;j<partsOf_Anagram.size();j++)
           {
               if(i==j)
               continue;
            else
                try {
                    if(HashValue_Of_String(partsOf_Anagram.get(i))*HashValue_Of_String(partsOf_Anagram.get(j))==HashValue_Of_String(s))
                       {
                           FinalAnagrams.add(partsOf_Anagram.get(i)+" "+partsOf_Anagram.get(j));
                           continue;
                       }
                } catch (EmptyArrList e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
           
           int k;
           for(k=0;k<partsOf_Anagram.size();k++)
           {
              if(i==k || j==k)
              continue;
            else
                try {
                    if(HashValue_Of_String(partsOf_Anagram.get(i))*HashValue_Of_String(partsOf_Anagram.get(j))*HashValue_Of_String(partsOf_Anagram.get(k))==HashValue_Of_String(s)) 
                      {
                         FinalAnagrams.add(partsOf_Anagram.get(i)+" "+partsOf_Anagram.get(j)+" "+partsOf_Anagram.get(k));
                      }
                } catch (EmptyArrList e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
           }
       }  
    }

    
    RemoveDuplicates(FinalAnagrams);
    sortLexicographically(FinalAnagrams);

  //  System.out.println(FinalAnagrams.size());

    for(int i=0;i<FinalAnagrams.size();i++)
    {
        try {
            System.out.println(FinalAnagrams.get(i));
        } catch (EmptyArrList e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

  //  Iterator<String> i = treeSet.iterator();

  //  while(i.hasNext())
  //  System.out.println(i.next());



    System.out.println(-1);
    

    }

   public static void main(String[] args)
    {
        Anagram a = new Anagram();

       
    try {
        FileInputStream  Vocabularyfile = new FileInputStream(args[0]);   // taking input as vocabulary.txt
        Scanner sc = new Scanner(Vocabularyfile);
     
       
       int  no_of_vocabulary = sc.nextInt();

       ArrList<String> vocabularyWords = new ArrList<String>();
      /// ArrayList<String> Complementary_partsOf_Anagram = new ArrayList<>(no_of_vocabulary);

       
       
       while(sc.hasNext())
        vocabularyWords.add(sc.next());

         



        FileInputStream Inputfile = new FileInputStream(args[1]);
        
            Scanner scan = new Scanner(Inputfile);
            scan.nextLine();


             while(scan.hasNext())
              a.printAnagram(scan.next(),vocabularyWords);
             

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
             
        
       
    }
    
}
