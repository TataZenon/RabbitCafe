package ac.th.ssru.tarou.workshop.rabbitcafe;

public class FoodModel {
    String name;
    String price;
    String img;

    public FoodModel(){}

    public FoodModel(String name, String price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
