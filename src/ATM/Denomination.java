package ATM;

public enum Denomination {
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    ONE_HUNDRED(100);

    int val;
    Denomination(int val){
        this.val=val;
    }

}
