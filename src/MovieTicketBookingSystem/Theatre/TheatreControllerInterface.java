package MovieTicketBookingSystem.Theatre;

import MovieTicketBookingSystem.Location.City;
import MovieTicketBookingSystem.Movie.Movie;

import java.util.List;
import java.util.Map;

public interface TheatreControllerInterface {
    void addTheatre(City city, Theatre theatre);

    void deleteTheatre(int theatreId);

    Map<Theatre, List<Show>> getAllShows(City city, Movie movie);
}
