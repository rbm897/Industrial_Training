package pizzaordersystem.bean;

public class Pizza {

	private int pizzaId;
	private String pizzaName;
	private String size;
	private float price;
	private String pizzaType;

	public Pizza(int pizzaId, String pizzaName, String size, float price, String pizzaType) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.size = size;
		this.price = price;
		this.pizzaType = pizzaType;
	}

	public Pizza() {
		super();

		// TODO Auto-generated constructor stub
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", size=" + size + ", price=" + price
				+ ", pizzaType=" + pizzaType + "]";
	}

}
