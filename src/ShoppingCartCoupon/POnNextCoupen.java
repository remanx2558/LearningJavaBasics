package ShoppingCartCoupon;

public class POnNextCoupen extends Coupen{

    double pPercent;
    double[] oldpercentDecrease;
    double[] oldrupeeDecrease;

    POnNextCoupen(double p){
        pPercent=p;
    }

    @Override
    void apply(CoupedCart cart) {
        //size is less
        int newsize=cart.size+1;
        double[] newpercentDecrease=new double[newsize];
        double[] newrupeeDecrease=new double[newsize];

        for(int i=0;i<newsize-1;i++){
            newrupeeDecrease[i]=cart.rupeeDecrease[i];
            newpercentDecrease[i]=cart.percentDecrease[i];
        }

        newpercentDecrease[newsize-1]=pPercent;

        //change it
        oldpercentDecrease=cart.percentDecrease;
        oldrupeeDecrease=cart.rupeeDecrease;

        //
        cart.percentDecrease=newpercentDecrease;
        cart.rupeeDecrease=newrupeeDecrease;

    }

    @Override
    void remove(CoupedCart cart) {
        cart.percentDecrease=oldpercentDecrease;
        cart.rupeeDecrease=oldrupeeDecrease;
        cart.size=oldpercentDecrease.length;

    }
}
