package com.dthang.myapp.presenter.cart;

import android.content.Context;

import com.dthang.myapp.model.cart.ModelCart;
import com.dthang.myapp.model.objectclass.Product;
import com.dthang.myapp.view.Cart.IViewCart;

import java.util.List;

public class PresenterLogicCart implements IPresenterCart {
    ModelCart modelCart;
    IViewCart iViewCart;
    public PresenterLogicCart(IViewCart iViewCart) {
        modelCart = new ModelCart();
        this.iViewCart = iViewCart;
    }

    @Override
    public void GetListProductInCart(Context context) {
        modelCart.open(context);
        List<Product> list = modelCart.getListProductInCart();
        if(list.size()>0)
        {
            iViewCart.ShowListProductInCart(list);
        }
    }
}
