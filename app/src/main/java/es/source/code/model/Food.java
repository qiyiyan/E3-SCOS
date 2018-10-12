package es.source.code.model;

public class Food {

    private String foodName;
    private String foodPrice;
    public Food(String foodName,String foodPrice){
        this.foodName=foodName;
        this.foodPrice=foodPrice;
    }
    public void setFoodName(String foodName){
        this.foodName = foodName;
    }
    public String getFoodName(){
        return this.foodName;
    }
    public void setFoodPrice(String foodPrice){
        this.foodPrice = foodPrice;
    }
    public String getFoodPrice(){
        return this.foodPrice;
    }
}
