package mx.com.gm.movies.business;

/**
 *
 * @author tomas
 */
public interface IMovieCatalog {
    
    void addMovie(String movieName, String fileName);
    
    void listMovies(String fileName);
    
    void searchMovie(String fileName, String search);
    
    void createFile(String fileName);
}
