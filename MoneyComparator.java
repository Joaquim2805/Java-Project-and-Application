import java.util.Comparator;




class OwnerComparator implements Comparator<Owner>{

    @Override
    public int compare(Owner o1, Owner o2) {
        return o1.lastname.compareTo(o2.lastname);
    }
}



public class MoneyComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.money_amount - o2.money_amount;
    }
}
