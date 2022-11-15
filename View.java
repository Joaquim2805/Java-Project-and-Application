import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class View {
    public void initialize_window(Bank B){




        JFrame frame = new JFrame("Bank");
        JPanel panel = new JPanel();

        // Définir le menu principal
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("New Account");
        JMenu edit = new JMenu("Add money");
        JMenu help = new JMenu("Show owners");
        JMenu draw = new JMenu("Draw Money");
        JMenu sum = new JMenu("Your money");
        JMenu owner_sum = new JMenu("All your money");
        JMenu all_account = new JMenu("All your account");
        JMenu listing = new JMenu("Listing");



        listing.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame listing_order = new JFrame("Listing");


                JTextField text1 = new JTextField("Account number");
                text1.setBounds(50,70,200,28);


                JButton btn = new JButton("Compare by descending money amount");
                btn.setBounds(50,130,300,28);

                JButton btn1 = new JButton("Compare by ascending money amount");
                btn1.setBounds(50,160,300,28);

                JButton btn2 = new JButton("Compare by Owner");
                btn2.setBounds(50,190,300,28);






                btn2.addActionListener(new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        try {
                            boolean check = false ;
                            ArrayList<Owner> Owner_v = new ArrayList<>();

                            for (Link l : B.link_list) {
                                if (l.A.numbers == Integer.parseInt(text1.getText())) {
                                    Owner_v.add(l.O);
                                    check = true;
                                    System.out.println(l.O.lastname);
                                }
                            }

                            Collections.sort(Owner_v, new OwnerComparator());


                            String data[][] = new String[Owner_v.size()][2];
                            String[] column = {"Lastname", "name"};
                            int i = 0;

                            for (Owner O : Owner_v) {
                                data[i][0] = O.lastname;
                                data[i][1] = O.surname;
                                i++;
                            }

                            if (check){

                                JFrame compare = new JFrame("Owner of account number : " + text1.getText());

                                JTable table = new JTable(data, column);
                                table.setBounds(50, 100, 200, 300);
                                JScrollPane scroll = new JScrollPane(table);
                                compare.add(scroll);

                                compare.setSize(500, 500);

                                ((JFrame) compare).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                compare.setVisible(true);}
                            else
                                JOptionPane.showMessageDialog(null,  " Wrong account number");


                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(null,  " Write an integer please");

                        }

                    }
                });


                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String data[][] = new String[B.Account_list.size()][2];
                        String[] column =  { "Account number", "Money amount"};
                        int i = 0;



                        ArrayList<Account> account_array = new ArrayList<>(B.Account_list);

                        Collections.sort(account_array,new MoneyComparator());

                        Collections.reverse(account_array);


                        for (Account A: account_array) {
                            System.out.println(A.money_amount + " " + A.numbers);
                        }


                        for (Account A: account_array) {
                            data[i][0] = String.valueOf(A.numbers);
                            data[i][1] = String.valueOf(A.money_amount);
                            i++;
                        }



                        JFrame compare = new JFrame("Account owner");

                        JTable table = new JTable(data,column);
                        table.setBounds(50,100,200,300);
                        JScrollPane scroll = new JScrollPane(table);
                        compare.add(scroll);

                        compare.setSize(500, 500);

                        ((JFrame) compare).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        compare.setVisible(true);








                    }
                });







                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String data[][] = new String[B.Account_list.size()][2];
                        String[] column =  { "Account number", "Money amount"};
                        int i = 0;



                        ArrayList<Account> account_array = new ArrayList<>(B.Account_list);

                        Collections.sort(account_array,new MoneyComparator());


                        for (Account A: account_array) {
                            System.out.println(A.money_amount + " " + A.numbers);
                        }


                        for (Account A: account_array) {
                            data[i][0] = String.valueOf(A.numbers);
                            data[i][1] = String.valueOf(A.money_amount);
                            i++;
                        }

                        JFrame compare = new JFrame("Account owner");

                        JTable table = new JTable(data,column);
                        table.setBounds(50,100,200,300);
                        JScrollPane scroll = new JScrollPane(table);
                        compare.add(scroll);

                        compare.setSize(500, 500);

                        ((JFrame) compare).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        compare.setVisible(true);









                    }
                });



                listing_order.add(text1);
                listing_order.add(btn);
                listing_order.add(btn1);
                listing_order.add(btn2);


                listing_order.setSize(500, 500);
                listing_order.setLayout(null);
                listing_order.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                listing_order.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        all_account.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame account_owner = new JFrame("Account owner");


                JTextField text1 = new JTextField("Account number");
                text1.setBounds(50,70,200,28);



                JButton btn = new JButton("Validate");
                btn.setBounds(50,130,200,28);


                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int check=0 ;

                        for (Link l: B.link_list) {
                            if (l.A.numbers == Integer.parseInt(text1.getText())){
                                check++;

                            }
                        }
                        System.out.println(check);

                        String data[][] = new String[check][2];
                        int i = 0;

                        for (Link l: B.link_list) {
                            if (l.A.numbers == Integer.parseInt(text1.getText())){

                                data[i][0] = l.O.lastname;
                                data[i][1] = l.O.surname;

                                i++;


                                System.out.println("YESS");
                            }
                        }


                        for (int j = 0; j < data.length; j++) {
                            System.out.println(data[j][0]);
                            System.out.println(data[j][1]);
                        }

                        String[] column =  { "Name", "Lastname"};
                        JFrame recap = new JFrame("Account owner");

                        JTable table = new JTable(data,column);
                        table.setBounds(50,100,200,300);
                        JScrollPane scroll = new JScrollPane(table);
                        recap.add(scroll);

                        recap.setSize(500, 500);

                        ((JFrame) recap).setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        recap.setVisible(true);

                    }
                });


                account_owner.add(text1);
                account_owner.add(btn);




                account_owner.setSize(500, 500);
                account_owner.setLayout(null);
                account_owner.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                account_owner.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



        owner_sum.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame owner_money = new JFrame("All your money");

                JTextField text1 = new JTextField("Lastname");
                text1.setBounds(50,70,200,28);



                JButton btn = new JButton("Validate");
                btn.setBounds(50,130,200,28);


                owner_money.add(text1);
                owner_money.add(btn);


                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int money_sum = 0;

                        for ( Link l: B.link_list) {
                            if (Objects.equals(l.O.lastname, text1.getText())){
                                System.out.println("YESS");
                                money_sum+=l.A.money_amount;
                                System.out.println(money_sum);
                            }
                        }
                        JOptionPane.showMessageDialog(null,  " On all your account, you have " +  money_sum + " Zloty");





                    }


                });



                owner_money.setSize(500, 500);
                owner_money.setLayout(null);
                owner_money.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                owner_money.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });






        sum.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JFrame your_money = new JFrame("Your money");


                JTextField text1 = new JTextField("Account number");
                text1.setBounds(50,70,200,28);

                JButton btn = new JButton("Validate");
                btn.setBounds(50,130,200,28);


                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        for (Account A:B.Account_list) {
                            if (A.numbers ==Integer.parseInt(text1.getText()) ){
                                JOptionPane.showMessageDialog(null,  "You have " +  A.money_amount + " Zloty");


                            }

                        }

                    }

                });



                your_money.add(text1);
                your_money.add(btn);
                your_money.setSize(500, 500);
                your_money.setLayout(null);
                your_money.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                your_money.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });






        draw.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                JFrame frame_draw_money = new JFrame("Draw money");

                JTextField text1 = new JTextField("Account number");
                text1.setBounds(50,70,200,28);

                JTextField text2 = new JTextField("Money amount to draw");
                text2.setBounds(50,100,200,28);

                JButton btn = new JButton("Validate");
                btn.setBounds(50,130,200,28);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        for (Account A:B.Account_list) {
                            if (A.numbers == Integer.parseInt(text1.getText())){
                                if (A.money_amount>Integer.parseInt(text2.getText())){
                                    A.draw_money(Integer.parseInt(text2.getText()));

                                    JOptionPane.showMessageDialog(null,  "Money amount after operation : " + A.money_amount);
                                }
                                else
                                    JOptionPane.showMessageDialog(null,  "Insuffisant sold " +  JOptionPane.INFORMATION_MESSAGE);




                            }

                        }


                    }


                });






                frame_draw_money.add(text1);
                frame_draw_money.add(text2);
                frame_draw_money.add(btn);
                frame_draw_money.setSize(800, 800);
                frame_draw_money.setLayout(null);
                frame_draw_money.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_draw_money.setVisible(true);


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });





        help.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame_owners = new JFrame("Show owners");

                String data[][] = new String[B.Owner_list.size()][2];



                int i =0;

                for (Owner X: B.Owner_list) {

                    data[i][0] = X.surname;
                    data[i][1] = X.lastname;
                    i++;
                }


                for (Owner X: B.Owner_list) {
                    System.out.println(X.lastname+" "+X.surname);
                }

                System.out.println("*******");

                for (int j = 0; j < 3; j++) {
                    System.out.println(data[j][0]+" "+data[j][1]);
                }



                String[] column =  { "Name", "Lastname"};

                JTable table = new JTable(data,column);
                table.setBounds(50,100,200,300);
                JScrollPane scroll = new JScrollPane(table);
                frame_owners.add(scroll);


                frame_owners.setSize(500, 500);

                frame_owners.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_owners.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        edit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame_add_money = new JFrame("Add money");




                JTextField text2 = new JTextField("Account number");
                text2.setBounds(50,70,200,28);

                JTextField text3 = new JTextField("Money amount to add");
                text3.setBounds(50,100,200,28);

                JButton btn = new JButton("Validate");
                btn.setBounds(50,130,200,28);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        boolean check = false ;


                        for (Account A:B.Account_list) {
                            if (A.numbers == Integer.parseInt(text2.getText()))

                                try {
                                    check =true;
                                    A.add_money(Integer.parseInt(text3.getText()));
                                    frame.setVisible(true);
                                    frame_add_money.setVisible(false);
                                    JOptionPane.showMessageDialog(null,  "Money amount after operation : " + A.money_amount);

                                }catch (NumberFormatException nfe){
                                    JOptionPane.showMessageDialog(null,  "Write an Integer for money account " +  JOptionPane.INFORMATION_MESSAGE);

                                }



                        }

                        if (!check)
                            JOptionPane.showMessageDialog(null,  "This account doesn't exist " );





                    }
                });







                frame_add_money.add(text2);
                frame_add_money.add(text3);
                frame_add_money.add(btn);
                frame_add_money.setSize(500, 500);
                frame_add_money.setLayout(null);
                frame_add_money.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_add_money.setVisible(true);


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });





        file.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JFrame frame_account_creation = new JFrame("Account creation");


                JTextField text1 = new JTextField("Surname");
                text1.setBounds(50,40,200,28);

                JTextField text2 = new JTextField("Lastname");
                text2.setBounds(50,70,200,28);

                JTextField text3 = new JTextField("Money Amount");
                text3.setBounds(50,100,200,28);

                JButton btn = new JButton("Create Account");
                btn.setBounds(50,130,200,28);


                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {



                    }

                });


                frame_account_creation.add(text1);
                frame_account_creation.add(text2);
                frame_account_creation.add(text3);
                frame_account_creation.add(btn);




                frame_account_creation.setSize(500, 500);
                frame_account_creation.setLayout(null);
                frame_account_creation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame_account_creation.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });











        frame.validate();




        menu.add(file);
        menu.add(edit);
        menu.add(help);
        menu.add(draw);
        menu.add(sum);
        menu.add(owner_sum);
        menu.add(all_account);
        menu.add(listing);

        frame.setLayout(new GridLayout(5, 1));

        frame.add(menu);
        frame.add(panel);
        frame.pack();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }


}


