import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class merge {

   private ArrayList<String> Result;

    public merge(){
        Result = new ArrayList<String>();
    }

    private ArrayList<String> mergeList(ArrayList<String> Original, ArrayList<String> add, ArrayList<String> rem){
        int i,j;
        i=j=0;
        while(i<Original.size()){
                Result.add(Original.get(i));
            i++;
        }
        i=0;
        while(i<add.size()){
            if (!Result.contains(add.get(i))) {
                Result.add(add.get(i));
            }
            i++;
        }
        i=0;
        while(i<rem.size()){
            Result.remove(rem.get(i));
            i++;
        }
        i=0;
        String alph="";

        Result.sort(Comparator.comparing(String::length).reversed());
        while(i<Result.size()-1){
            while(j<Result.size()-1-i){
                if((Result.get(j).length()==Result.get(j+1).length())&&(Result.get(j).compareToIgnoreCase(Result.get(j+1))<1)){
                    alph = Result.get(j+1);
                    Result.set(j+1,Result.get(j));
                    Result.set(j,alph);
                }
                j++;
            }
            i++;
        }
        return Result;
    }

    public static void main(String[] args){
        merge List = new merge();

        ArrayList<String> A = new ArrayList<String>();
        ArrayList<String> B = new ArrayList<String>();
        ArrayList<String> C = new ArrayList<String>();
        A.add("one");
        A.add("too");
        A.add("two");
        A.add("three");

        B.add("one");
        B.add("two");
        B.add("five");
        B.add("six");

        C.add("two");
        C.add("five");

        System.out.println(List.mergeList(A,B,C));
    }
}