package MovieTicketBookingSystem.Movie;

import MovieTicketBookingSystem.Location.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController implements MovieControllerInterface {
    private final Map<City, List<Movie>> cityVsMovies;
    private final List<Movie> allMovies;

    public MovieController() {
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    @Override
    public void addMovie(City city, Movie movie) {
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);

        allMovies.add(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        for (City eachCity : cityVsMovies.keySet()) {
            List<Movie> movies = cityVsMovies.get(eachCity);
            movies.removeIf((eachMovie) -> eachMovie.getMovieId() == movieId);
            cityVsMovies.put(eachCity, movies);
        }

        boolean isDeleted = allMovies.removeIf(eachMovie -> eachMovie.getMovieId() == movieId);
        if (isDeleted) {
            System.out.println("Movie is deleted");
        } else {
            System.out.println("Error in movie delete");
        }
    }

    @Override
    public Movie getMovieByName(String movieName) {
        List<Movie> list = allMovies.stream().filter((Movie eachMovie) -> eachMovie.getMovieName().equals(movieName)).toList();
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.getOrDefault(city, new ArrayList<>());
    }
}
