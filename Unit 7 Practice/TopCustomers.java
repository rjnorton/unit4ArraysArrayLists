import java.util.ArrayList;
import java.util.Scanner;
public class TopCustomers
{
    private ArrayList<String> customers;
    private ArrayList<Double> amounts;
    
    public topCustomers()
    {
        customers = new ArrayList<String>();
        amounts = new ArrayList<Double>();
    }
    
    public void addSale(String customerName, double amount)
    {
        customers.add(customerName);
        amount.add(amount);
    }
    
    public String nameOfBestCustomer()
    {
        
    }
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        TopCustomers cust = new TopCustomers();
        
        while (true)
        {
            System.out.print("Enter customer name: ");
            String name = s.next();
            
            System.out.print("Enter amount customer paid: ");
            Double amount = s.nextDouble();
            
            cust.addSale(name,amount);
            
            System.out.print("Add another customer?(y/n): ")
            
        }
    }
}
