import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.awt.*;




class Link{



    public Link(Account A, Owner O){
        this.A = A;
        this.O = O ;
    }

    public Account A ;
    public Owner O;


}



class Bank{



    public ArrayList<Link> link_list = new ArrayList<>() ;

    public HashSet<Account> Account_list = new HashSet<>();

    public HashSet<Owner> Owner_list = new HashSet<>();


    public void insert(Link l){
        
        link_list.add(l);
    }





}



class Owner{


    public Owner(String s, String l){
        this.surname = s;
        this.lastname = l;
    }


    public String surname;
    public String lastname;


}

class Account{

    public Account(int numbers, int money_amount){
        this.numbers = numbers;
        this.money_amount = money_amount;
    }

    public void add_money(int money_amount){
        this.money_amount+=money_amount;
    }


    public void draw_money(int money_amount){
        this.money_amount-=money_amount;
    }



    @Override
    public String toString(){
        return String.valueOf(money_amount);
    }

    public int numbers;
    public int money_amount;

}






public class MainApp {

    public static void main(String[] args) {

        Bank bank = new Bank();
        View view = new View();

        Owner owner_1 = new Owner("Joaquim","JUSSEAU");
        Owner owner_2 = new Owner("John","SMITH");
        Owner owner_3 = new Owner("Steven","STRANGE");
        Owner owner_4 = new Owner("Gordon","FREEMAN");

        Account account_1 = new Account(2805,800);
        Account account_2 = new Account(756,200);
        Account account_3 = new Account(42,50000);
        Account account_4 = new Account(198,280);

        bank.Owner_list.add(owner_1);
        bank.Owner_list.add(owner_2);
        bank.Owner_list.add(owner_3);
        bank.Owner_list.add(owner_4);

        bank.Account_list.add(account_1);
        bank.Account_list.add(account_2);
        bank.Account_list.add(account_3);
        bank.Account_list.add(account_4);


        Link link_1 = new Link(account_1,owner_1);
        Link link_2 = new Link(account_2,owner_2);
        Link link_3 = new Link(account_3,owner_3);
        Link link_4 = new Link(account_4,owner_4);
        Link link_5 = new Link(account_3,owner_2);

        bank.insert(link_1);
        bank.insert(link_2);
        bank.insert(link_3);
        bank.insert(link_4);
        bank.insert(link_5);



        view.initialize_window(bank);
    }
}
