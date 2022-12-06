import java.util.Enumeration;
public class HtmlStatement extends Statement {
    private String setHeader(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() +
        "</EM></H1><P>\n";
    }
    private String setBody(Rental aRental) {
        return aRental.getMovie().getTitle()+ ": " +
            String.valueOf(aRental.getCharge()) + "<BR>\n";
    }
    private String setFooter(Customer aCustomer) {
        return "<P>You owe <EM>" +
        String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" + 
        "On this rental you earned <EM>" + 
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        "</EM> frequent renter points<P>";
    }
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = setHeader(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += setBody(each);
        }
        //add footer lines
        result += setFooter(aCustomer);
        return result;
    }
}