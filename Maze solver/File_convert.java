package mazesolver;

import java.io.*;
import java.util.Scanner;


public class File_convert {


    public static int[][] file_array() throws IOException {
        File fil = new File("C:\\Users\\joaqu\\OneDrive\\Bureau\\TC04\\Oriented Object Programming\\AI_project\\src\\main\\java\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(fil));
        BufferedReader br2 = new BufferedReader(new FileReader(fil));
        FileInputStream fIS = new FileInputStream(fil);
        Scanner sc = new Scanner(fil);
        Scanner sc2 = new Scanner(fil);
        Scanner sc3 = new Scanner(fil);
        int[] solve = new int[4];
        for (int i = 0; i < solve.length; i++) {
            solve[i] = 0;
        }
        int z = 0;
        int c = 0;
        int row = 0;
        int columns = sc2.nextLine().length();
        while (sc.hasNextLine()) {
            sc.nextLine();

            row++;
        }
        row -= 2;

        while ((c = br.read()) != -1) {
            if (Character.isDigit((char) c)) {
                solve[z] = Character.getNumericValue(c);
                z++;
            }

        }
        System.out.println("DEPART ARRIVEE :");
        for (int i = 0; i < solve.length; i++) {
            System.out.print(solve[i] + " ");
        }
        System.out.println();


        System.out.println(columns + ", " + row);
        //initialize_array(row,columns);


        int[][] maze = new int[row][columns];


        for (int i = 0; sc3.hasNextLine() && i < row; i++) {
            char[] chars = sc3.nextLine().toCharArray();
            for (int j = 0; j < columns && j < chars.length; j++) {
                    /*if (i==solve[0] & j==solve[1]){
                        maze[i][j] = 8;
                    }*/
                if (i == solve[2] & j == solve[3]) {
                    maze[i][j] = 9;
                } else if (chars[j] == '-' | chars[j] == '|')
                    maze[i][j] = 1;
                else if (chars[j] == ' ')
                    maze[i][j] = 0;
            }

        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        return maze;

    }


    public static void main(String[] args) {
        
    }
}
