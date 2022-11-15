package mazesolver ;


import java.awt.Color;

import java.awt.Graphics;

import java.awt.event.KeyEvent;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import javax.swing.*;


public class View extends JFrame {


    long startTime ;

    long stopTime;

    long duration ;


    double dfsTime;



    private int [][] maze = File_convert.file_array();



    private final List<Integer> path = new ArrayList<Integer>();

    private int pathIndex;



    public View() throws IOException {

        startTime = System.nanoTime();

        setTitle("Simple Maze Solver");






        setSize(640, 480);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        DFS.searchPath(maze, 1, 1, path);


        stopTime = System.nanoTime();



        duration = stopTime - startTime;

        dfsTime =  (double)duration / 1000000;
        System.out.println(String.format("Time %1.3f ms", dfsTime));


        JOptionPane.showMessageDialog(null,  "Execution time of bfs " +  dfsTime);


        pathIndex = path.size() - 2;






    }



    public void update() {

        pathIndex -= 2;

        if (pathIndex < 0) {

            pathIndex = 0;

        }

    }



    @Override

    public void paint(Graphics g) {

        super.paint(g);



        g.translate(50, 50);



        // draw the maze

        for (int row = 0; row < maze.length; row++) {

            for (int col = 0; col < maze[0].length; col++) {

                Color color;


                switch (maze[row][col]) {

                    case 1 : color = Color.BLACK; break;

                    case 9 : color = Color.RED; break;

                    default : color = Color.WHITE;

                }

                g.setColor(color);

                g.fillRect(30 * col, 30 * row, 30, 30);

                g.setColor(Color.BLACK);

                g.drawRect(30 * col, 30 * row, 30, 30);

            }

        }



        // draw the path list

        for (int p = 0; p < path.size(); p += 2) {

            int pathX = path.get(p);

            int pathY = path.get(p + 1);

            g.setColor(Color.YELLOW);



            g.fillRect(pathX * 30, pathY * 30, 30, 30);

        }



        // draw the ball on path

        try{

        int pathX = path.get(pathIndex);

        int pathY = path.get(pathIndex + 1);

        g.setColor(Color.RED);

        g.fillRect(pathX * 30, pathY * 30, 30, 30);}

        catch (Exception e){
            JOptionPane.showMessageDialog(null,  "IMPOSSIBLE TO SOLVE" );
        }

    }



    @Override

    protected void processKeyEvent(KeyEvent ke) {

        if (ke.getID() != KeyEvent.KEY_PRESSED) {

            return;

        }

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

            pathIndex -= 2;

            if (pathIndex < 0) {

                pathIndex = 0;

            }

        }

        else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

            pathIndex += 2;

            if (pathIndex > path.size() - 2) {

                pathIndex = path.size() - 2;

            }

        }

        repaint();

    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                View view = null;
                try {
                    view = new View();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                view.setVisible(true);

            }

        });

    }



}