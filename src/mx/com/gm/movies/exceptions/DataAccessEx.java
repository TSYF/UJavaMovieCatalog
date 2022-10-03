package mx.com.gm.movies.exceptions;

/**
 *
 * @author tomas
 */
public class DataAccessEx extends RuntimeException {

    public DataAccessEx() {
    }

    public DataAccessEx(String message) {
        super(message);
    }
    
    
}
