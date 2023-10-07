import java.util.Scanner;

    public class IT_Calculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Taxable Income: $");
            double taxableIncome = scanner.nextDouble();

            double taxRate;
            double taxPaidPerYear;
            double taxPayablePerMonth;

            if (taxableIncome <= 25000) {
                taxRate = 0.0;
            } else if (taxableIncome <= 50000) {
                taxRate = 0.10;
            } else if (taxableIncome <= 75000) {
                taxRate = 0.20;
            } else {
                taxRate = 0.30;
            }

            taxPaidPerYear = taxableIncome * taxRate;
            taxPayablePerMonth = taxPaidPerYear / 12;

            System.out.println("Taxable Income: $"+taxableIncome);
            System.out.println("Tax Rate: $"+taxRate);
            System.out.println("Annual Tax Paid: $" + taxPaidPerYear);
            System.out.println("Monthly Tax Payable: $" + taxPayablePerMonth);

            scanner.close();
        }
    }