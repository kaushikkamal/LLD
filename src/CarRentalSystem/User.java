package CarRentalSystem;

public class User {

    private final int userId;
    private final String userName;
    private final String drivingLicense;

    public User(int userId, String userName, String drivingLicense) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicense = drivingLicense;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }
}
