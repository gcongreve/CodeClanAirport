public enum AirportType {
    DUNDEE("DUN01"),
    BROUGHTY_FERRY("BRF01"),
    CARNOUSTIE("CRN01");

    private final String airportCode;

    AirportType(String airportCode){
        this.airportCode = airportCode;
    }

    public String getAirportCode() {
        return airportCode;
    }
}
