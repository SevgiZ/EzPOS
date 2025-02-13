package com.main.ezpos;

public class Product {
    private String barcode;
    private String brand;
    private String name;
    private float size;
    private String size_unit;
    private String description;
    private float price_bought_for;
    private float price_selling_for;
    private String product_type;
    private int stock;
    private int number_sold_total;
    private int number_sold_last_month;
    private int number_refunded;
    private int number_written_off;
    private String put_on_shelf_date;
    private String last_sold_date;
    private String last_written_off_date;

    public Product(String barcode, String brand, String name, float size, String size_unit, String description,
                   float price_bought_for, float price_selling_for, String product_type, int stock,
                   int number_sold_total, int number_sold_last_month, int number_refunded, int number_written_off,
                   String put_on_shelf_date, String last_sold_date, String last_written_off_date) {

        this.barcode = barcode;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.size_unit = size_unit;
        this.description = description;
        this.price_bought_for = price_bought_for;
        this.price_selling_for = price_selling_for;
        this.product_type = product_type;
        this.stock = stock;
        this.number_sold_total = number_sold_total;
        this.number_sold_last_month = number_sold_last_month;
        this.number_refunded = number_refunded;
        this.number_written_off = number_refunded;
        this.put_on_shelf_date = put_on_shelf_date;
        this.last_sold_date = last_sold_date;
        this.last_written_off_date = last_written_off_date;


    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getSize_unit() {
        return size_unit;
    }

    public void setSize_unit(String size_unit) {
        this.size_unit = size_unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice_bought_for() {
        return price_bought_for;
    }

    public void setPrice_bought_for(float price_bought_for) {
        this.price_bought_for = price_bought_for;
    }

    public float getPrice_selling_for() {
        return price_selling_for;
    }

    public void setPrice_selling_for(float price_selling_for) {
        this.price_selling_for = price_selling_for;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNumber_sold_total() {
        return number_sold_total;
    }

    public void setNumber_sold_total(int number_sold_total) {
        this.number_sold_total = number_sold_total;
    }

    public int getNumber_sold_last_month() {
        return number_sold_last_month;
    }

    public void setNumber_sold_last_month(int number_sold_last_month) {
        this.number_sold_last_month = number_sold_last_month;
    }

    public int getNumber_refunded() {
        return number_refunded;
    }

    public void setNumber_refunded(int number_refunded) {
        this.number_refunded = number_refunded;
    }

    public String getPut_on_shelf_date() {
        return put_on_shelf_date;
    }

    public void setPut_on_shelf_date(String put_on_shelf_date) {
        this.put_on_shelf_date = put_on_shelf_date;
    }

    public String getLast_sold_date() {
        return last_sold_date;
    }

    public void setLast_sold_date(String last_sold_date) {
        this.last_sold_date = last_sold_date;
    }

    public String getLast_written_off_date() {
        return last_written_off_date;
    }

    public void setLast_written_off_date(String last_written_off_date) {
        this.last_written_off_date = last_written_off_date;
    }
    public int getNumber_written_off() {
        return number_written_off;
    }

    public void setNumber_written_off(int number_written_off) {
        this.number_written_off = number_written_off;
    }

}
