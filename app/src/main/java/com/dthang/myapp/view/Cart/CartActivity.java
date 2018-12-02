package com.dthang.myapp.view.Cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dthang.myapp.R;
import com.dthang.myapp.adapter.CartAdapter;
import com.dthang.myapp.model.objectclass.Product;
import com.dthang.myapp.presenter.cart.PresenterLogicCart;

import java.util.List;

public class CartActivity extends AppCompatActivity implements IViewCart {

    RecyclerView rcvCart;
    PresenterLogicCart presenterLogicCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cart);

        rcvCart = findViewById(R.id.rcvCart);
        presenterLogicCart = new PresenterLogicCart(this);
        presenterLogicCart.GetListProductInCart(this);

    }

    @Override
    public void ShowListProductInCart(List<Product> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvCart.setLayoutManager(layoutManager);

        CartAdapter adapter = new CartAdapter(this,list);
        rcvCart.setAdapter(adapter);
    }
}
