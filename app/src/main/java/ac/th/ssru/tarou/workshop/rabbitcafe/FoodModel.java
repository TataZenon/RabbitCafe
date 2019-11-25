package ac.th.ssru.tarou.workshop.rabbitcafe;

public class FoodModel {
    String name;
    String price;
    String image;

    public FoodModel(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
