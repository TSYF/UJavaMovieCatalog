package mx.com.gm.movies.domain;

/**
 *
 * @author tomas
 */
public class Movie {
    
    // ATTRS
    private String name;
    
    
    // CONSTRUCTORS

    public Movie() {
        this.name = null;
    }

    public Movie(String name) {
        this.name = name;
    }
    
    
    // GETTERS

    public String getName() {
        return name;
    }

    
    // SETTERS
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    // OVERRIDES

    @Override
    public String toString() {
        return "Movie\n" + "name:" + name;
    }
    
    
}
