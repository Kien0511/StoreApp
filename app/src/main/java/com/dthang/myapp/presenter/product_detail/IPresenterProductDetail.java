package com.dthang.myapp.presenter.product_detail;

import android.content.Context;

import com.dthang.myapp.model.objectclass.Product;

public interface IPresenterProductDetail {
    void getProductDetail(int product_id);
    void AddCart(Product product, Context context);

}
