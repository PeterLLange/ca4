
package mainclasstest;
import REST.AllFlights;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainDatabase
{

    public static void main(String[] args)
    {
//        Persistence.generateSchema("ca4", null);
//        FlightFacade f = new FlightFacade(Persistence.createEntityManagerFactory("ca4"));
//        
//        f.getAllFlights();
      try {
          new AllFlights().getAirline("CPH", "2017-01-03T00:00:00.000Z", "1");
      } catch (Exception ex) {
          Logger.getLogger(REST.AllFlights.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
