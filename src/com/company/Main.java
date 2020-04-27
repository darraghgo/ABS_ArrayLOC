package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //String containing desire LOC segments
        String myStr = "UNA:+.? 'UNB+UNOC:3+2021000969+4441963198+180525:1225+3VAL2MJV6EH9IX+KMSV7HMD+CUSDECU-IE++1++1'UNH+EDIFACT+CUSDEC:D:96B:UN:145050'BGM+ZEM:::EX+09SEE7JPUV5HC06IC6+Z'LOC+17+IT044100'LOC+18+SOL'LOC+35+SE'LOC+36+TZ'LOC+116+SE003033'DTM+9:20090527:102'DTM+268:20090626:102'DTM+182:20090527:102'";

        //ArrayList which will store the elements
        //arraylist is used because it dosent need a fixed size
        ArrayList<String> myArray = new ArrayList<>();


        System.out.println("--------------");

        //use  variables, makes it easier to change them out later
        String x = "LOC";
        int index = 0;
        int start = 0;


        //for loop to traverse the length of the String
        for (int j = 0; j <= myStr.length()-3;j++){

            //looks for LOC
            if(myStr.substring(j,j+3).matches(x)){

                //If LOC is found we make a record of the index
                index = j+3;
                System.out.println("At index " + j + " : "  + myStr.substring(j,j+3));

                //starting point of the element after the +
                start = j+4;

                //use second loop to search along the elements
                for (int k = start; k < myStr.length();k++){

                    //if a second + is found it marks the end of the second element and beginning of the third
                    if(myStr.charAt(k) == '+'){
                        System.out.println("second element : " + myStr.substring(start,k));

                        //add second element to the arraylist
                        myArray.add(myStr.substring(start,k));
                        //mark new starting point after the second +
                        start = k;
                    }

                    // the end of the third element is marked by '
                    if(myStr.charAt(k) == '\''){

                        System.out.println("third element : " +myStr.substring(start+1,k));
                        myArray.add(myStr.substring(start+1,k));
                        //after third element is added we break out of the second loop to stop the next LOC being added to same index
                        break;
                    }



                }

            }

        }


        System.out.println("************************");

        System.out.println("elements of array printed");
        for(String y : myArray){
            System.out.println(y);
        }
    }
}