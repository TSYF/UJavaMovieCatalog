package mx.com.gm.movies.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.com.gm.movies.domain.Movie;
import mx.com.gm.movies.exceptions.*;

/**
 *
 * @author tomas
 */
public class DataAccess implements IDataAccess {

    // ATTRS
    private final String dataDir = "data";
    private final String fileExtension = ".txt";
    
    
    
    // IMPLEMENTATIONS
    
    @Override
    public boolean exists(String fileName) {
        
        File file = new File(dataDir + File.separator + fileName + fileExtension);
        
        return file.exists() && file.isFile();
    }

    @Override
    public List<Movie> read(String fileName) throws DataAccessEx, DataReadingEx {
        
        if (!exists(fileName)){
            
            throw new DataAccessEx("File not found");
        }
        
        File file = new File(dataDir + File.separator + fileName + fileExtension);
        
        List<Movie> fullReading = new ArrayList<>();

        /**
         * output is the product of creating a Buffered File Reader.
         * This helps with reading a file line by line.
         */
        try (var output = new BufferedReader(new FileReader(file))) {
            
            /**
             * This loop reads through the file line by line
             * until there's no more lines to read.
             */
            for (String reading = output.readLine(); reading != null; reading = output.readLine()) {
                
                fullReading.add(new Movie(reading));
            }

        } catch (FileNotFoundException ex) {
            
            throw new DataAccessEx(ex.getMessage());
            
        } catch (IOException ex) {
            
            throw new DataReadingEx(ex.getMessage());
        }
        
        if (fullReading.isEmpty()) {
            
            throw new DataReadingEx("Catalog is empty");
        }
        
        return fullReading;
    }

    @Override
    public void write(Movie movie, String fileName, boolean append) throws DataAccessEx, DataWritingEx {
        
        if (!exists(fileName)){
            
            throw new DataAccessEx("File not found");
        }
        
        File file = new File(dataDir + File.separator + fileName + fileExtension);
        
        /**
         * openFile is the product of creating a PrintWriter isntance out of a FileWriter.
         * This helps with writing to a file line by line.
         */
        try (PrintWriter openFile = new PrintWriter(new FileWriter(file, append))) {
            
            openFile.println(movie.getName());
            
            openFile.close();
            
        } catch (FileNotFoundException ex) {

            throw new DataAccessEx(ex.getMessage());

        } catch (IOException ex) {

            throw new DataWritingEx(ex.getMessage());
        }
    }
    
    
    /**
     * TODO: throw <q>"movie not found"</q> if reading is null at the end of the function;
     * @param fileName name of the catalog file.
     * @param toSearch name of the movie to be searched for.
     * @return Whatever was found by the given search terms.
     */
    @Override
    public String search(String fileName, String toSearch) throws DataAccessEx, DataReadingEx {
        
        if (!exists(fileName)){
            
            throw new DataAccessEx("File not found");
        }
        
        File file = new File(dataDir + File.separator + fileName + fileExtension);
        
        /**
         * output is the product of creating a Buffered File Reader. This helps
         * with reading a file line by line.
         */
        try (var output = new BufferedReader(new FileReader(file))) {
           
            /**
             * This loop reads through the file line by line until there's no
             * more lines to read.
             */
            for (var reading = output.readLine(); reading != null; reading = output.readLine()) {
                
                if (reading.equals(toSearch)) {
                    
                    return reading;
                }
            }
            
        } catch (FileNotFoundException ex) {

            throw new DataAccessEx(ex.getMessage());

        } catch (IOException ex) {

            throw new DataReadingEx(ex.getMessage());
        }

        throw new DataReadingEx("Movie not found");
    }

    @Override
    public void create(String fileName) {
        
        File file = new File(dataDir + File.separator + fileName + fileExtension);
        
        /**
         * openFile is the product of creating a PrintWriter instance
         * which's purpose in this case is just to create the file.
         */
        try (PrintWriter openFile = new PrintWriter(file)) {
            
            openFile.close();
            
        } catch (FileNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void delete(String fileName) throws DataAccessEx {
        
        if (!exists(fileName)){
            
            throw new DataAccessEx("File not found");
        }
        
        File file = new File(dataDir + File.separator + fileName + fileExtension);
        
        if(!file.delete()) throw new DataAccessEx("Couldn't delete file");
    }
    
    
    
    
    
    
    
    
}
