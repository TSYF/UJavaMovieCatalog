package cpjfinallab;

import mx.com.gm.movies.business.*;

import static javax.swing.JOptionPane.*;


/**
 *
 * @author tomas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var catalog = new MovieCatalog();
        String fileName;
        String movieName;
        int option;
        
        do {
            
            try {
                
                option = Integer.parseInt(showInputDialog(
                        "MOVIE CATALOG MENU\n"
                        + "=================================\n"
                        + "Choose an option:\n\n"
                        + "1.- Start movie catalog\n"
                        + "2.- Add movie\n"
                        + "3.- List movies\n"
                        + "4.- Search movie\n"
                        + "0.- Exit\n"
                        + "\n==============================="
                ));
                
            } catch (NumberFormatException ex) {
                
                showMessageDialog(null, "Please enter a valid number");
                continue;
            }
            
            switch (option) {
                
                case 1:
                    
                    fileName = showInputDialog("Name the new catalog").trim();
                    catalog.createFile(fileName);
                    break;
                    
                case 2:
                    
                    fileName = showInputDialog("Name of the catalog").trim();
                    movieName = showInputDialog("Name of the new movie").trim();
                    catalog.addMovie(movieName, fileName);
                    break;
                    
                case 3:
                    
                    fileName = showInputDialog("Name of the catalog").trim();
                    catalog.listMovies(fileName);
                    break;
                    
                case 4:
                    
                    fileName = showInputDialog("Name of the catalog").trim();
                    movieName = showInputDialog("Name of the movie").trim();
                    catalog.searchMovie(fileName, movieName);
                    break;
                    
                case 0:
                    
                    System.exit(0);
                    break;
            }
            
        } while (true);
    }
    
}
