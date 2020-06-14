
package projeto1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Formatar_data {
    
     public static Date StringToDate(String dob) throws ParseException {
      //Instantiating the SimpleDateFormat class
      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      //Parsing the given String to Date object
      Date date = formatter.parse(dob);
      return date;
   }
     
    
}
