package com.dthang.myapp.view.Cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.dthang.myapp.R;
import com.dthang.myapp.adapter.CartAdapter;
import com.dthang.myapp.model.objectclass.Product;
import com.dthang.myapp.presenter.cart.PresenterLogicCart;

import java.util.List;

public class CartActivity extends AppCompatActivity implements IViewCart {

    RecyclerView rcvCart;
    PresenterLogicCart presenterLogicCart;

    private ImageView bt_back;

    private CartActivity cartActivity = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cart);

        rcvCart = findViewById(R.id.rcvCart);
        presenterLogicCart = new PresenterLogicCart(this);
        presenterLogicCart.GetListProductInCart(this);

        bt_back = findViewById(R.id.bt_back);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartActivity.finish();
            }
        });

    }

    @Override
    public void ShowListProductInCart(List<Product> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvCart.setLayoutManager(layoutManager);

        CartAdapter adapter = new CartAdapter(this,list);
        rcvCart.setAdapter(adapter);
    }
}
