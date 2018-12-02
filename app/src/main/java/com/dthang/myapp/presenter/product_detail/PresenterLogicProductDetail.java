package com.dthang.myapp.presenter.product_detail;

import android.content.Context;
import android.util.Log;

import com.dthang.myapp.model.cart.ModelCart;
import com.dthang.myapp.model.objectclass.Product;
import com.dthang.myapp.model.product_detail.ModelProductDetail;
import com.dthang.myapp.view.product_detail.IViewProductDetail;

import java.util.List;

public class PresenterLogicProductDetail implements IPresenterProductDetail{

    IViewProductDetail viewProductDetail;
    ModelProductDetail modelProductDetail;
    ModelCart modelCart;

    public PresenterLogicProductDetail()
    {
        modelCart = new ModelCart();
    }

    public PresenterLogicProductDetail(IViewProductDetail viewProductDetail){
        this.viewProductDetail = viewProductDetail;
        modelProductDetail = new ModelProductDetail();
        modelCart = new ModelCart();
    }

    @Override
    public void getProductDetail(int product_id) {
        Product product = modelProductDetail.GetProductDetail("getProductAndDetailsProduct","PRODUCTDETAIL",product_id);
        if(product.getPRODUCT_ID() > 0)
        {
            String[] linkProductImage = product.getPRODUCT_SMALL_IMAGE().split(",");
            viewProductDetail.ShowProductSlider(linkProductImage);
            viewProductDetail.ShowProductDetail(product);
        }
    }

    @Override
    public void AddCart(Product product,Context context) {
        modelCart.open(context);
        boolean check = modelCart.AddCart(product);
        if(check)
        {
            viewProductDetail.AddCartSuccess();
        }
        else
        {
            viewProductDetail.AddCartFailed();
        }
    }

    public int CountProductInCart(Context context)
    {
        modelCart.open(context);
        List<Product> list = modelCart.getListProductInCart();

        int count = list.size();

        return count;
    }
}
