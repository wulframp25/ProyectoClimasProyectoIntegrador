package co.edu.udea.arquitectura.modelo;

public class WeatherDTO {

    private String city;
    private Double temperature;
    private Double windSpeed;
    private int humidity;
    private int cloudsNumber;
    private Boolean theCityExists;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloudsNumber() {
        return cloudsNumber;
    }

    public void setCloudsNumber(int cloudsNumber) {
        this.cloudsNumber = cloudsNumber;
    }

    public Boolean getTheCityExists() {
        return theCityExists;
    }

    public void setTheCityExists(Boolean theCityExists) {
        this.theCityExists = theCityExists;
    }
}
