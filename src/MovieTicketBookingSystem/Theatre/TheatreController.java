package MovieTicketBookingSystem.Theatre;

import MovieTicketBookingSystem.Location.City;
import MovieTicketBookingSystem.Movie.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController implements TheatreControllerInterface {
    private final Map<City, List<Theatre>> cityVsTheatre;
    private final List<Theatre> allTheatre;

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    @Override
    public void addTheatre(City city, Theatre theatre) {
        List<Theatre> theatreList = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatreList.add(theatre);
        cityVsTheatre.put(city, theatreList);

        allTheatre.add(theatre);
    }

    @Override
    public void deleteTheatre(int theatreId) {

    }

    @Override
    public Map<Theatre, List<Show>> getAllShows(City city, Movie movie) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        for (Theatre eachTheatre : cityVsTheatre.get(city)) {
            List<Show> givenMovieShows = new ArrayList<>();
            for (Show eachShow : eachTheatre.getShows()) {
                if (eachShow.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(eachShow);
                }
            }

            if (!givenMovieShows.isEmpty()) {
                theatreVsShows.put(eachTheatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }
}
