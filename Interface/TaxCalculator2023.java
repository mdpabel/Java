package Interface;

public class TaxCalculator2023 implements TaxCalculator {
  private double income;

  public TaxCalculator2023(double income) {
    this.income = income;
  }

  public double calculateTex() {
    return income * 0.3;
  }
}
