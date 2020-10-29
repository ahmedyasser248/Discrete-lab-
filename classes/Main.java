package classes;

import java.util.Scanner;



public class Main {
    static String str=null;
    static String st=null;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SLL list = new SLL();
        Methods method = new Methods();
        System.out.print("Enter the Universe ( U ) : ");
        str = scan.nextLine();
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        String[] universe = str.split(" ");
        System.out.print("Enter the number of sets : ");
        int n = scan.nextInt();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Set : ");
            if (flag == 0) {
                st = scan.nextLine();
                flag++;
            }
            st = scan.nextLine();
            st = st.trim(); // remove leading and trailing spaces
            String stt = st.replaceAll("\\s+", " "); // remove multiple spaces
            String[] sets = stt.split(" ");
            if (st.equals("")) {
                System.out.println("Sorry , Empty set isn't available → please try again");
                i--;
            } else if (sets.length == 0) {
                System.out.println("Sorry , Empty set isn't available → please try again");
                i--;
            } else {
                String[] set = method.dup(sets);
                list.add(set);
            }
        }
        while (true) {
            System.out.println("\n");
            System.out.println("Type a number to choose an operation to be done between two sets ");
            System.out.println("1-Union of two sets");
            System.out.println("2-Intersection of two sets");
            System.out.println("3-Complement of a set");
             System.out.println("4-exit");
            int choose = scan.nextInt();
            if (choose == 1) {
                System.out.println("Choose the two sets by their arranged number ");
                System.out.println("0 → Universe");
                method.printAll(list);
                int a, b;
                a = scan.nextInt();
                b = scan.nextInt();
                if (a == 0 || b == 0) {
                    System.out.print("Union is : ");
                    for (String s : universe) {
                        System.out.print(s + " ");
                    }
                } else {
                    String[] A = method.getArray(list, a);
                    String[] B = method.getArray(list, b);
                    String[] union = method.Union(A, B);
                    System.out.print("Union is : ");
                    for (int i = 0; i < union.length; i++) {
                        System.out.print(union[i] + " ");
                    }
                }
            } else if (choose == 2) {
                System.out.println("Choose the two sets by their number ");
                System.out.println("0 → Universe");
                method.printAll(list);
                int a, b;
                a = scan.nextInt();
                b = scan.nextInt();
                if (a == 0) {
                    System.out.print("Intersection is : ");
                    String[] B = method.getArray(list, b);
                    for (String s : B) {
                        System.out.print(s + " ");
                    }
                } else if (b == 0) {
                    System.out.print("Intersection is : ");
                    String[] A = method.getArray(list, a);
                    for (String s : A) {
                        System.out.print(s + " ");
                    }
                } else {
                    String[] A = method.getArray(list, a);
                    String[] B = method.getArray(list, b);
                    String[] intersection;
                    if (A.length < B.length) {
                        intersection = method.Intersection(A, B);
                    } else {
                        intersection = method.Intersection(B, A);
                    }
                    System.out.print("Intersection is : ");
                    if (intersection.length == 0) {
                        System.out.print("Ø");
                    } else {
                        for (String s : intersection) {
                            System.out.print(s + " ");
                        }
                    }
                }
            } else if (choose == 3) {
                System.out.println("Choose the set by its number ");
                System.out.println("0 → Universe");
                method.printAll(list);
                int a;
                a = scan.nextInt();
                if (a == 0) {
                    System.out.println("Complement is : Ø");
                } else {
                    String[] A = method.getArray(list, a);
                    String[] complement = method.Complement(universe, A);
                    System.out.print("Complement is : ");
                    for (String s : complement) {
                        System.out.print(s + " ");

                    }
                }
            }else {
                break ;
            }
        }
    }
}
