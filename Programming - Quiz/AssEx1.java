/* 
    Instructions - Assessed Exercise 1
    - This exercise tests the things you've learnt in the first week of the semester.
    - Add your code to this file, leaving the main method unchanged (except for task 3).
    - Add all of your methods *below* the main method, in question order.
    - Each of the tasks involves writing a single method. You do not need to add additional main methods.
    - The total number of marks is 22.
    - Read the instructions for each task *carefully*.
    - Submit a single .java file on moodle by the deadline (details on moodle).
    - Do not change the name of the Java file, but ensure you add your name and 
        matric as requested below...
    - You do not need to add any additional import lines.
    - Everything you need to do these tasks is covered in the week 1 lectures and slides.
*/

/*
    Non task-specific marks:
     - Add a comment with your name and matric here - Danny Caulwell - 2589561c@student.gla.ac.uk
     - Clear code commenting [1 mark]
     - Use of correct Java variable and method naming conventions [1 mark]
*/
import java.util.Scanner;

public class AssEx1 {

    public static void welcome(String date){

        Scanner s  = new Scanner(System.in);

        System.out.println("Please enter your name...");

        String name = s.nextLine();

        System.out.println("Hello " + name + " - " + date);
    }

    public static void divisors(int n){

        // For every number up to and including n
        for(int i = 1; i<=n; i++){
            // if the remainder of n / i == 0, print i
            if(n % i == 0){
                System.out.println(i);
            }
        }
    }

    public static boolean check(int n){

        // Checked = true if statements are true
        boolean checked = n == 12 || (n > 5 && n < 10);

        return checked;
    }

    
    public static void calculator(){

        Scanner s = new Scanner(System.in);

        System.out.println("Please input an integer, an operator(*, /, + or -), and another integer, on the same line and seperated by spaces");

        //Save user input in String
        String userInput = s.nextLine();

        // Pass user input into another scanner
        Scanner d = new Scanner(userInput);
        
        // Seperate each element from user input
        int firstInt = d.nextInt();
        String operator = d.next();
        int secondInt = d.nextInt();

        double result = 0;

        // Depending on operator, perform operation on first and second passed integer - cast int as double in case of division
        if(operator.equals("/")){
            result = firstInt / (double)secondInt;
        } else if(operator.equals("*")){
            result = firstInt * secondInt;
        } else if(operator.equals("+")){
            result = firstInt + secondInt;
        } else if(operator.equals("-")){
            result = firstInt - secondInt;
        }

        String output = String.format("%d %s %d = %7.2f", firstInt, operator, secondInt, result);

        System.out.println(output);
    }

    // Method used in products method
    public static boolean checkInt(int n){

        // return true if n is less than 0, or more than 20
        boolean invalidInt = n < 0 || n > 20;

        return invalidInt;
    }


    public static void products(int rows, int columns){

        if(checkInt(rows)){
            System.out.println("The number of rows should be more than 0, and less than 20");
            return;
        }

        if(checkInt(columns)){
            System.out.println("The number of columns should be more than 0, and less than 20");
            return;
        }

        // Largest entry
        int largestVal = rows * columns;

        int length = 0;

        // Calculate number of spaces in each entry, based on largest value entry
        if(largestVal < 10){
            length = 2;
        } else if(largestVal >= 10 && largestVal < 100){
            length = 3;
        } else if(largestVal >= 100){
            length = 4;
        }

        
        String headers = "";
        String border = "";
        String dashBase = "";

        // Calculate non-entry components based on length
        if(length == 2){
            headers = "  |";
            dashBase = "--";
        } else if(length == 3){
            headers = "   |";
            dashBase = "----";
        } else if(length == 4){
            headers = "    |";
            dashBase = "-----";
        }

        // Format String for header spaces and entry spaces
        String formatString = "%" + (length + 1) + "d";

        // Top Row - The header
        for(int i = 1; i<=columns; i++){
                String headerEntry = String.format(formatString, i);
                headers += headerEntry;
        }

        // The Border
        for(int i = 0; i<= columns; i++){
            border += dashBase;
        }

        System.out.println(headers);
        System.out.println(border);

        // The Entries

        // For each row
        for(int i = 1; i<=rows; i++){

            String row = "";
            String formatStringRow = "%" + length + "d|";
            String rowHeader = String.format(formatStringRow, i);
            row += rowHeader;

            //For each column
            for(int j=1; j<=columns; j++){

                int product = i * j;
                String entry = String.format(formatString, product);
                row += entry;
            }

            System.out.println(row);
        }
            
    }
    


    public static void main(String[] args) {
        String date = "01/01/21";
        
        /* EXAMPLE TASK
            This is just here to show you what you should do.
            Create a method called comment that includes nothing but a single comment.
            It will be called by the line below.
            Look below main to 
        */
        comment();

        /* Task 1 [2 marks]
            Create a method called welcome that:
                - prompts the user to enter their name
                - saves their name in a string variable
                - prints the word "Hello" followed by whatever the user entered, followed by
                - whatever is stored in the String date.
        */


        welcome(date);

        /* Task 2 [3 marks]
            Write a method called divisors that is passed a single integer
            argument n. It should print out (on separate lines) all of the integers
            between 1 and n that divide n exactly (i.e. with remainder zero).
            For example divisors(12) should print:
            1
            2
            3
            4
            6
            12
            Your method *must* use a loop
        */


        int n = 10;
        divisors(n); 

        /* Task 3 [3 marks]
            Write a method called check that takes an integer as an argument and 
            returns a boolean value that is true if the integer is equal to 12, or is greater
            than 5 and less than 10. It should return false otherwise.
            Call the method four times with the integers
            1, 6, 11 and 12 respectively, printing the output each time on a new line. 
            You *must* use the and (&&) operator in your solution
        */



        System.out.println(check(1));
        System.out.println(check(6));
        System.out.println(check(11));
        System.out.println(check(12));
        
        

        
        /* Task 4 [6 marks]
            Write a method called calculator that prompts the user to input 
            an integer, an operator ('+', '-', '*', or '/') and finally another integer.
            The user should enter them *on the same line* and *separated by spaces*.
            (the space separation is important!!)
            The method should then perform the calculation, storing the result
            as a double. The operator '/' should perform floating point (not int) division.
            The full expression including the result should be printed using String.format
            where the result should be 7 characters long and have two digits after the decimal point.
            e.g. if the user types:
            4 / 3
            The program should output:
            "4 / 3 =    1.33"
            You don't need to do any error checking on the user input.
            Hint: if you have the whole expression stored as a String, you can
            split it up using a Scanner initialised with the String.
        */

        calculator();

        /* Task 5 [5 marks]
            Write a method called products. It should takes two integers as arguments, 
            corresponding to a number of rows and a number of columns.
            If either number is less than 0 or bigger than 20, the method should print an 
            error and return. This checking of the row and column numbers should use a separate method that
            checks if a single integer is <0 or >20. This method should be called twice from within products,
            once for the number of rows, once for columns.

            If the number of rows and columns is >=0 and <=20, the method should 
            print a table in which each entry is the product of the row and column positions (which
            go from 1 to the number of rows / columns respectively).


            The table should include heading rows and columns.
            For example, if rows=4 and columns=5, the table should look *exactly* like this:

   |  1  2  3  4  5
-------------------
  1|  1  2  3  4  5
  2|  2  4  6  8 10
  3|  3  6  9 12 15
  4|  4  8 12 16 20

            Each entry should be printed using String.format and its length should be the length of
            the largest value in the table plus one (i.e. in the example above, each entry has length
            3 because the largest value is 20 ("20" is two characters)).
            So, if, for example, the largest number is >= 100 then all lengths should be longer.
            For example, a table with 12 rows and 13 columns should look *exactly* like this:

    |   1   2   3   4   5   6   7   8   9  10  11  12  13
---------------------------------------------------------
   1|   1   2   3   4   5   6   7   8   9  10  11  12  13
   2|   2   4   6   8  10  12  14  16  18  20  22  24  26
   3|   3   6   9  12  15  18  21  24  27  30  33  36  39
   4|   4   8  12  16  20  24  28  32  36  40  44  48  52
   5|   5  10  15  20  25  30  35  40  45  50  55  60  65
   6|   6  12  18  24  30  36  42  48  54  60  66  72  78
   7|   7  14  21  28  35  42  49  56  63  70  77  84  91
   8|   8  16  24  32  40  48  56  64  72  80  88  96 104
   9|   9  18  27  36  45  54  63  72  81  90  99 108 117
  10|  10  20  30  40  50  60  70  80  90 100 110 120 130
  11|  11  22  33  44  55  66  77  88  99 110 121 132 143
  12|  12  24  36  48  60  72  84  96 108 120 132 144 156

            
        */
         products(13,7);
         products(-2,7);
         products(5,25);
         products(3,6);
         products(12,13);
        
    }

    /*
        Here's an example of how you write the solutions!
        Hint: you may find it easier to comment out method calls above
        until you've written the methods!
    */
    public static void comment() {
        // just a comment!
    }

}