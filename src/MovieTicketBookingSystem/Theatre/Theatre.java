package MovieTicketBookingSystem.Theatre;

import MovieTicketBookingSystem.Location.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String address;
    private City city;
    private List<Screen> screen;
    private List<Show> shows;

    public Theatre() {
        screen = new ArrayList<>();
        shows = new ArrayList<>();
    }

    public Theatre(int theatreId, String address, City city) {
        this.theatreId = theatreId;
        this.address = address;
        this.city = city;
        screen = new ArrayList<>();
        shows = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", screen=" + screen +
                ", shows=" + shows +
                '}';
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
