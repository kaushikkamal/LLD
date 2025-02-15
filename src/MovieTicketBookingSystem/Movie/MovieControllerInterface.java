package MovieTicketBookingSystem.Movie;

import MovieTicketBookingSystem.Location.City;

import java.util.List;

public interface MovieControllerInterface {
    void addMovie(City city, Movie movie);

    void deleteMovie(int movieId);

    Movie getMovieByName(String movieName);

    List<Movie> getMoviesByCity(City city);
}
