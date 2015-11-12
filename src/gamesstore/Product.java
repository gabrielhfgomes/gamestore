/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;

/**
 *
 * @author s2it_ggomes
 */
public abstract class Product {
    protected String name;
    protected String manufacturer;
    protected float price;
    protected int stock;

    public abstract String getName();

    public abstract void setName(String name); 

    public abstract String getManufacturer();
    
    public abstract void setManufacturer(String manufacturer);

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
