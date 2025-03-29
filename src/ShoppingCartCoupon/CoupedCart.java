package ShoppingCartCoupon;

public class CoupedCart extends Cart {

    CoupedCart baseCart;
    Coupen currentCoupen;
    boolean isCoupenApplied;

    double[]percentDecrease;
    double[]rupeeDecrease;
    int size;

    double allPercentDecrease;
    double allRupeeDecrease;

    double cartPercentDecrease;
    double cartRupeeDecrease;

    CoupedCart(CoupedCart coupedCart){
        baseCart=coupedCart;
        if(baseCart==null){
            this.size=items.size();
            percentDecrease=new double[size];
            rupeeDecrease=new double[size];

            allPercentDecrease=0;
            allRupeeDecrease=0;

            cartPercentDecrease=0;
            cartRupeeDecrease=0;

        }
        else{
            this.percentDecrease=baseCart.percentDecrease;
            this.rupeeDecrease=baseCart.rupeeDecrease;
            this.size= baseCart.size;

            allPercentDecrease= baseCart.allPercentDecrease;
            allRupeeDecrease=baseCart.allRupeeDecrease;

            cartPercentDecrease=baseCart.cartPercentDecrease;
            cartRupeeDecrease=baseCart.cartRupeeDecrease;
        }
    }

    void appleyCoupen(Coupen coupen){
        currentCoupen=coupen;
        coupen.apply(baseCart);
        isCoupenApplied=true;
    }

    void removeCoupen(){
        if(isCoupenApplied==false){
            return;
        }
        this.currentCoupen.remove(baseCart);

    }


}
