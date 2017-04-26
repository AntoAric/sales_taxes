package it.antoninoarico.saleTax;

public class Product {

	private int quantity;
	private String productName;
	private double total;
	private double tax;
	private boolean isImported;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isImported() {
		return isImported;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
}
