package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Methods {

    public String[]  getArray(SLL ll,int index){
        String[] ar= (String[]) ll.get(index-1);
        return ar ;
    }

    public void printAll(SLL ll){
        for(int i=0;i<ll.size();i++){
            String[] str = (String[]) ll.get(i);
            int j=0;
            System.out.print(i+1 + " → "+str[j]+" ");
            while(j<str.length && j+1<str.length){
                System.out.print(str[j+1]+" ");
                j++;
            }
            System.out.println();
        }
    }

    public String[] Union(String[] arr1,String[] arr2){
        ArrayList<String> arlist = new ArrayList<String>();
        if(arr1.length>arr2.length){
            for(int i=0;i<arr1.length;i++){
                arlist.add(arr1[i]);
            }
            int count=0;
            for(int i=0;i<arr2.length;i++) {
                for (int j = 0; j < arr1.length; j++) {
                    if (!(arr2[i].equals(arr1[j])) ) {
                        count++;
                    }
                }
                if(count==arr1.length){
                    arlist.add(arr2[i]);
                }
                count=0;
            }
        }else if(arr1.length<=arr2.length){
            for(int i=0;i<arr2.length;i++){
                arlist.add(arr2[i]);
            }
            int count=0;
            for(int i=0;i<arr1.length;i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (!(arr1[i].equals(arr2[j]))) {
                        count++;
                    }
                }
                if(count==arr2.length){
                    arlist.add(arr1[i]);
                }
                count=0;
            }

        }
        String[] result = (String[]) arlist.toArray(new String[arlist.size()]);
        return result;
    }

    public String[] dup(String[] arr ){
        ArrayList<String> arlist = new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].equals(arr[j])){
                    break;
                }
                if(j==arr.length-1){
                    arlist.add(arr[i]);
                }
            }
            if(i==arr.length-1){
                arlist.add(arr[i]);
            }
        }


        String[] result = (String[]) arlist.toArray(new String[arlist.size()]);
        return result;
    }

    public String [] Intersection(String[] arr1 , String [] arr2){
        ArrayList<String> arr3 = new ArrayList<String>();
        for (String s : arr1) {
            boolean found = Arrays.asList(arr2).contains(s);
            if (found) {
                arr3.add(s);
            }
        }
        String[] intersection = new String [arr3.size()];
        intersection = arr3.toArray(intersection);
        return  intersection ;
    }
    public String [] Complement(String [] universe ,String [] arr){
        ArrayList<String> arr2 = new ArrayList<String>();
        for (String s : universe) {
            boolean found = Arrays.asList(arr).contains(s);
            if (!found) {
                arr2.add(s);
            }
        }
        String[] complement = new String [arr2.size()];
        complement = arr2.toArray(complement);
        return complement ;
    }
}
