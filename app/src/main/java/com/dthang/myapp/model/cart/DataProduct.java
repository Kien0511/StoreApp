package com.dthang.myapp.model.cart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataProduct extends SQLiteOpenHelper {
    public static String TB_CART = "CART";
    public static String TB_CART_PRODUCT_ID = "PRODUCT_ID";
    public static String TB_CART_PRODUCT_NAME = "PRODUCT_NAME";
    public static String TB_CART_PRODUCT_PRICE = "PRODUCT_PRICE";
    public static String TB_CART_PRODUCT_IMAGE = "IMAGE";

    public static String TB_FAVORITE = "FAVORITE";
    public static String TB_FAVORITE_PRODUCT_ID = "PRODUCT_ID";
    public static String TB_FAVORITE_PRODUCT_NAME = "PRODUCT_NAME";
    public static String TB_FAVORITE_PRODUCT_PRICE = "PRODUCT_PRICE";
    public static String TB_FAVORITE_PRODUCT_IMAGE = "IMAGE";


    public DataProduct(Context context) {
        super(context, "SQLPRODUCT", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCart = "create table " + TB_CART + " (" + TB_CART_PRODUCT_ID + " integer primary key, " + TB_CART_PRODUCT_NAME + " text, " + TB_CART_PRODUCT_PRICE + " real, " + TB_CART_PRODUCT_IMAGE + " blob)";
        String queryFavorite = "create table " + TB_FAVORITE + " (" + TB_FAVORITE_PRODUCT_ID + " integer primary key, " + TB_FAVORITE_PRODUCT_NAME + " text, " + TB_FAVORITE_PRODUCT_PRICE + " real, " + TB_FAVORITE_PRODUCT_IMAGE + " blob";

        sqLiteDatabase.execSQL(queryCart);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TB_CART);
    }
}
