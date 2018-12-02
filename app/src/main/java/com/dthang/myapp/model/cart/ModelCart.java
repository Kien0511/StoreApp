package com.dthang.myapp.model.cart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dthang.myapp.model.objectclass.Product;

import java.util.ArrayList;
import java.util.List;

public class ModelCart {

    SQLiteDatabase database;
    DataProduct dataProduct;


    public void open(Context context)
    {
        dataProduct = new DataProduct(context);
        database = dataProduct.getWritableDatabase();
    }

    public boolean AddCart(Product product)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataProduct.TB_CART_PRODUCT_ID,product.getPRODUCT_ID());
        contentValues.put(DataProduct.TB_CART_PRODUCT_NAME,product.getPRODUCT_NAME());
        contentValues.put(DataProduct.TB_CART_PRODUCT_PRICE,product.getPRODUCT_PRICE());
        contentValues.put(DataProduct.TB_CART_PRODUCT_IMAGE,product.getCart_image());

        long id = database.insert(DataProduct.TB_CART,null,contentValues);

        if(id > 0)
        {
            return true;
        }
        return false;
    }

    public List<Product> getListProductInCart()
    {
        List<Product> list = new ArrayList<>();

        String query = "select * from " + DataProduct.TB_CART;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            int product_id = cursor.getInt(cursor.getColumnIndex(DataProduct.TB_CART_PRODUCT_ID));
            String product_name = cursor.getString(cursor.getColumnIndex(DataProduct.TB_CART_PRODUCT_NAME));
            int product_price = cursor.getInt(cursor.getColumnIndex(DataProduct.TB_CART_PRODUCT_PRICE));
            byte[] product_image = cursor.getBlob(cursor.getColumnIndex(DataProduct.TB_CART_PRODUCT_IMAGE));

            Product product = new Product();
            product.setPRODUCT_ID(product_id);
            product.setPRODUCT_NAME(product_name);
            product.setPRODUCT_PRICE(product_price);
            product.setCart_image(product_image);

            list.add(product);

            cursor.moveToNext();
        }
        cursor.close();
        Log.e("cussoor",cursor.getCount()+"");
        Log.e("accccc",list.size()+"");
        return list;
    }

}
