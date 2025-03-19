import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private String title;
    private String genre;
    private int year;

    public Movie(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - Genre: " + genre;
    }
}

class NetflixCLI {
    private List<Movie> movies;
    private List<Movie> favorites;

    public NetflixCLI() {
        movies = new ArrayList<>();
        favorites = new ArrayList<>();
        initializeMovies();
    }

    private void initializeMovies() {
        movies.add(new Movie("The Avengers", "Action", 2012));
        movies.add(new Movie("The Avengers: Infinity War", "Action", 2018));
        movies.add(new Movie("John Wick", "Action", 2014));
        movies.add(new Movie("The Fast and Furious", "Adventure", 2001));
        movies.add(new Movie("Pacific Rim", "Sci-Fi", 2013));
    }

    public void displayMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }

    public void addToFavorites(int movieIndex) {
        if (movieIndex >= 0 && movieIndex < movies.size()) {
            favorites.add(movies.get(movieIndex));
            System.out.println(movies.get(movieIndex).toString() + " has been added to your favorites.");
        } else {
            System.out.println("Invalid movie selection.");
        }
    }

    public void viewFavorites() {
        if (favorites.isEmpty()) {
            System.out.println("You have no favorite movies.");
        } else {
            System.out.println("\nYour Favorite Movies:");
            for (Movie movie : favorites) {
                System.out.println(movie);
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Netflix CLI ---");
            System.out.println("1. View Movies");
            System.out.println("2. Add Movie to Favorites");
            System.out.println("3. View Favorite Movies");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayMovies();
                    break;
                case "2":
                    displayMovies();
                    System.out.print("Enter the number of the movie to add to favorites: ");
                    String movieChoice = scanner.nextLine();
                    try {
                        int index = Integer.parseInt(movieChoice) - 1;
                        addToFavorites(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;
                case "3":
                    viewFavorites();
                    break;
                case "4":
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Netflix {
    public static void main(String[] args) {
        NetflixCLI netflixCLI = new NetflixCLI();
        netflixCLI.run();
    }
}