package mx.com.gm.movies.business;



import static javax.swing.JOptionPane.*;
import mx.com.gm.movies.data.*;
import mx.com.gm.movies.domain.*;
import java.util.List;
import mx.com.gm.movies.exceptions.*;

/**
 *
 * @author tomas
 */
public class MovieCatalog implements IMovieCatalog {
    IDataAccess data;

    public MovieCatalog() {
        data = new DataAccess();
    }

    @Override
    public void addMovie(String movieName, String fileName) {
        
        Movie movie = new Movie(movieName);
        
        try {
            
            data.write(movie, fileName, true);
            
            showMessageDialog(null, "Successfully added");
            
        } catch (DataAccessEx ex) {
            
            showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void listMovies(String fileName) {
        
        try {
            
            List<Movie> movieList = data.read(fileName);
            
            String reading = "MOVIE CATALOG:";

            for (Movie movie : movieList) {
                reading += "\n" + movie.getName();
            }
            
            showMessageDialog(null, reading);
            
        } catch (DataAccessEx ex) {
            showMessageDialog(null, ex.getMessage());
        }

        
        
        
    }

    @Override
    public void searchMovie(String fileName, String search) {
        try {
            
            String reading = data.search(fileName, search);
            
            showMessageDialog(null, reading);
            
        } catch (DataAccessEx ex) {
            
            showMessageDialog(null, ex.getMessage());
        }
        
    }

    @Override
    public void createFile(String fileName) {
        data.create(fileName);
    }
    
    
}
