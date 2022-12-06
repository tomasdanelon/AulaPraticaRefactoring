public class NewReleasePrice extends Price {
    public double getCharge(int daysRented){
        return daysRented * 3;
      } 
      public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
 }