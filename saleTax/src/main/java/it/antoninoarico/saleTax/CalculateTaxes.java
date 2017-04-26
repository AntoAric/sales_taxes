package it.antoninoarico.saleTax;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class CalculateTaxes {

	public static void main(String[] args) throws IOException {
		FileInputStream fstream;

		fstream = new FileInputStream("./src/main/java/it/antoninoarico/saleTax/resource/shopping_baskets.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		HashMap<String, Integer> taxProduct = new HashMap<String, Integer>();
		taxProduct.put("music CD", 10);
		taxProduct.put("book", 0);
		taxProduct.put("chocolate bar", 0);
		taxProduct.put("box of chocolates", 0);
		taxProduct.put("bottle of perfume", 10);
		taxProduct.put("packet of headache pills", 0);

		String strLine;
		List<Product> shoppingBaskets = new ArrayList<Product>();
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			System.out.println(strLine);
			if (strLine.trim().isEmpty()) {
				calculateTaxed(shoppingBaskets);
				shoppingBaskets.removeAll(shoppingBaskets);
			} else {
				String[] ary = strLine.split(" ");
				Product p = new Product();
				String product = "";
				for (int i = 1; i < ary.length - 1; i++) {
					product = product + " " + ary[i];
				}

				p.setProductName(product);
				p.setImported(p.getProductName().contains("imported"));
				p.setQuantity(Integer.parseInt(ary[0]));
				p.setTotal(Double.parseDouble(ary[ary.length - 1]) * p.getQuantity());

				Object value = taxProduct.get(p.getProductName().replace("imported", "").trim());
				int tax = value != null ? Integer.parseInt(value.toString()) : 0;

				if (p.isImported())
					tax += 5;
				p.setTax((tax * p.getTotal() / 100));
				shoppingBaskets.add(p);
			}
		} 

		// Close the input stream
		br.close();

	}

	public static void calculateTaxed(List<Product> shop) {
		System.out.println("OUTPUT");
		double total = 0;
		double tax = 0;
		for (Product p : shop) {
			total += p.getTotal();
			tax += Math.round(p.getTax() * 20) / 20.0;
			double arr = Math.floor((p.getTotal() + p.getTax()) * 100 + 0.5) / 100;
			System.out.println(p.getQuantity() + " " + p.getProductName() + ":" + arr);
		}
		System.out.println("Total " + Math.floor((total + tax) * 100 + 0.5) / 100);
		System.out.println("Sales Taxes " + Math.floor( tax * 100 + 0.5) / 100);
		System.out.println("\n");
	}

}