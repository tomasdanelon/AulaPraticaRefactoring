import java.util.Enumeration;
public class TextStatement extends Statement {
    private String setHeader(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }
    private String setBody(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle()+ "\t" +
            String.valueOf(aRental.getCharge()) + "\n";
    }
    private String setFooter(Customer aCustomer) {
        return "Amount owed is " +
        String.valueOf(aCustomer.getTotalCharge()) + "\n" + 
        "You earned " +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        " frequent renter points";
    }
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = setHeader(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += setBody(each);
        }
        //add footer lines
        result += setFooter(aCustomer);
        return result;
    }
}