package Interface;

public class TaxReport {
  TaxCalculator taxCalculator;

  public TaxReport(TaxCalculator taxCalculator) {
    this.taxCalculator = taxCalculator;
  }

  public void show() {
    System.out.println(taxCalculator.calculateTex());
  }

  public void show(TaxCalculator taxCalculator) {
    System.out.println(taxCalculator.calculateTex());
  }

  public void setTaxCalculator(TaxCalculator taxCalculator) {
    this.taxCalculator = taxCalculator;
  }
}
