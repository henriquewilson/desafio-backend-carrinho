package br.com.geofusion.cart.code2;

public class PopulationInCity {

  private String cityName;

  private int population;

  public PopulationInCity(String cityName, int population) {
    this.cityName = cityName;
    this.population = population;
  }

  public String getCityName() {
    return cityName;
  }

  public int getPopulation() {
    return population;
  }



}
