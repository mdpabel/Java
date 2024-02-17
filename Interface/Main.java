package Interface;

public class Main {
  public static void main(String[] args) {
    var taxCalculator = new TaxCalculator2023(100_000); // constructor dependency injection
    var report2023 = new TaxReport(taxCalculator);
    report2023.show();

    var report2024 = new TaxReport(new TaxCalculator2024(100_000));
    report2024.show();

    report2024.setTaxCalculator(new TaxCalculator2024(100_000));
    report2024.show();
    
    report2024.show(new TaxCalculator2024(10_00));

    
  }
}
