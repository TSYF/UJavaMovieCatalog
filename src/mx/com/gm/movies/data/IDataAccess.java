package mx.com.gm.movies.data;

import java.util.List;
import mx.com.gm.movies.domain.Movie;

/**
 *
 * @author tomas
 */
public interface IDataAccess {
    
    // METHODS
    
    boolean exists(String fileName);
    
    List<Movie> read(String name);
    
    void write(Movie movie, String fileName, boolean append);
    
    String search(String fileName, String toSearch);
    
    void create(String fileName);
    
    void delete(String fileName);
}
