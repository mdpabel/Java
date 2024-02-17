package Interface;

public class TaxCalculator2024 implements TaxCalculator {

  private double income;

  public TaxCalculator2024(double income) {
    this.income = income;
  }


  public double calculateTex() {
    return income * 0.4;
  }
  
}