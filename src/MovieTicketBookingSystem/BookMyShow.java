package MovieTicketBookingSystem;

import MovieTicketBookingSystem.BookingAndPayment.Booking;
import MovieTicketBookingSystem.Location.City;
import MovieTicketBookingSystem.Movie.Movie;
import MovieTicketBookingSystem.Movie.MovieController;
import MovieTicketBookingSystem.Movie.MovieControllerInterface;
import MovieTicketBookingSystem.Theatre.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieControllerInterface movieController;
    TheatreControllerInterface theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public void start() {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        // user1
        bookMyShow.createBooking(City.BLR, "RRR");
        // user2
        bookMyShow.createBooking(City.BLR, "KGF");
        // user3
        bookMyShow.createBooking(City.BLR, "RRR");
    }

    private void createBooking(City city, String movieName) {
        // 1. search movie by my location
        List<Movie> moviesByCity = movieController.getMoviesByCity(city);

        // 2. select the movie which you want to see. i want to see RRR
        Movie interestedMovie = null;
        for (Movie movie : moviesByCity) {
            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        if (interestedMovie == null) {
            System.out.println("No movie with this movie name");
            return;
        }
        // 3. get all show of this movie in BLR location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShows(city, interestedMovie);

        // 4. select the particular show user is interested in
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        // 5. select the seat
        int seatNumber = 30;

        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();

        if (bookedSeats.contains(seatNumber)) {
            // throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        bookedSeats.add(seatNumber);
        // start Payment
        Booking booking = new Booking();
        List<Seat> myBookedSeats = new ArrayList<>();
        for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
            if (screenSeat.getSeatId() == seatNumber) {
                myBookedSeats.add(screenSeat);
            }
        }
        booking.setBookedSeats(myBookedSeats);
        booking.setBookedShow(interestedShow);
        System.out.println("BOOKING SUCCESSFUL: " + booking);
    }

    private void initialize() {
        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    private void createMovies() {
        Movie newMovie1 = new Movie(1, "RRR", 180);
        Movie newMovie2 = new Movie(2, "KGF", 160);

        movieController.addMovie(City.BLR, newMovie1);
        movieController.addMovie(City.CCU, newMovie1);

        movieController.addMovie(City.BLR, newMovie2);
        movieController.addMovie(City.CCU, newMovie2);
    }

    private void createTheatre() {

        Movie rrrMovie = movieController.getMovieByName("RRR");
        Movie kgfMovie = movieController.getMovieByName("KGF");

        // theatre1

        Theatre theatre1 = new Theatre();
        theatre1.setTheatreId(1);
        theatre1.setAddress("BLR");
        theatre1.setCity(City.BLR);
        theatre1.setScreen(createScreens());

        Show morningShow = createShows(1, rrrMovie, theatre1.getScreen().get(0), 10);
        Show eveningShow = createShows(2, kgfMovie, theatre1.getScreen().get(0), 14);

        theatre1.setShows(Arrays.asList(morningShow, eveningShow));

        theatreController.addTheatre(City.BLR, theatre1);

        // theatre2

        Theatre theatre2 = new Theatre();
        theatre2.setTheatreId(2);
        theatre2.setAddress("CCU");
        theatre2.setCity(City.CCU);
        theatre2.setScreen(createScreens());

        Show morningShow2 = createShows(1, rrrMovie, theatre1.getScreen().get(0), 10);
        Show eveningShow2 = createShows(2, kgfMovie, theatre1.getScreen().get(0), 14);

        theatre2.setShows(Arrays.asList(morningShow2, eveningShow2));

        theatreController.addTheatre(City.CCU, theatre1);
    }

    private Show createShows(int showId, Movie movie, Screen screen, int startTime) {
        Show show1 = new Show();
        show1.setShowId(showId);
        show1.setMovie(movie);
        show1.setScreen(screen);
        show1.setShowStartTime(startTime);

        return show1;
    }


    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        // 1-29 : SILVER
        for (int i = 1; i <= 29; i++) {
            Seat newSeat = new Seat(i, i / 10, SeatCategory.SILVER);
            seats.add(newSeat);
        }

        // 30-49 : GOLD
        for (int i = 30; i <= 49; i++) {
            Seat newSeat = new Seat(i, i / 10, SeatCategory.GOLD);
            seats.add(newSeat);
        }

        // 50-59 : PLATINUM
        for (int i = 50; i <= 59; i++) {
            Seat newSeat = new Seat(i, i / 10, SeatCategory.PLATINUM);
            seats.add(newSeat);
        }

        return seats;
    }


}
