package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String plus = "+";
        String minus = "-";
        String umn = "*";
        String del = "/";

        double first, last, res;
        res = 0;

        Scanner scanner = new Scanner(System.in);

        first = scanner.nextDouble();
        String deistv = scanner.next();
        last = scanner.nextDouble();

       /* switch (deistv) {
            case ("+"):
                res = first + last;
                System.out.println(res);
                break;
            case ("-"):
                res = first - last;
                System.out.println(res);
                break;
            case ("*"):
                res = first * last;
                System.out.println(res);
                break;
            case ("/"):
                res = first / last;
                System.out.println(res);
                break;
        }*/
       if (deistv.equals(plus)){
           res=first+last;
           System.out.println(res);}

       else if (deistv.equals(minus)){
           res=first-last;
           System.out.println(res);
       }
       else if (deistv.equals(umn)){
           res=first*last;
           System.out.println(res);
       }
       else if (deistv.equals(del)){
           res=first/last;
        System.out.println(res);}

    }
    }

