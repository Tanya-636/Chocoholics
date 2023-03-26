package choco.web.model;

public class Product {
private int id;
private String name;
private String type;
private String filling;
private int price;
private String image;
public Product() {
	super();
}
public Product(int id, String name, String type, String filling, int price, String image) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.filling = filling;
	this.price = price;
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getFilling() {
	return filling;
}
public void setFilling(String filling) {
	this.filling = filling;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", type=" + type + ", filling=" + filling + ", price=" + price
			+ ", image=" + image + "]";
}



}
