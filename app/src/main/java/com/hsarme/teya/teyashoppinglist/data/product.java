package com.hsarme.teya.teyashoppinglist.data;

/**this class represent a product that willl br at the shoping
 * Created by teya on 06/11/2017.
 */

public class product
{
    /**
     * the name of the product
     */
    private String name;
    /**
     * the price
     */
    private double price;
    private double amount;
    /**
     * if the product is bought .
     */
    private boolean isCompleted;
    /**
     * the path of product's image
     */
    private String imgpath;
    /**
     * A SPECIAL KEY OR ID UNIQUE FOR EACH PRODUCT (PRIMARY KEY)
     */
    private String keyId;

    /**
     * bulding object
     * @param name
     * @param price
     * @param amount
     */

    public product(String name, double price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        isCompleted=false;
        imgpath=null;
    }

    public product(String name, double price, double amount, boolean isCompleted, String imgpath, String keyId) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isCompleted = isCompleted;
        this.imgpath = imgpath;
        this.keyId = keyId;
    }

    public product() {
    }
}
