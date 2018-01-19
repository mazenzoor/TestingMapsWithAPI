package cloud.thecode.testingmapswithapi;

/**
 * Created by Mazen on 1/18/2018.
 */

public class LocationPoint {
    String longitude, latitude;

    public LocationPoint(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public LocationPoint() {

    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return longitude + ", " + latitude;
    }
}
