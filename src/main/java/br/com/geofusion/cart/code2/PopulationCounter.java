package br.com.geofusion.cart.code2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class PopulationCounter {

    /**
     * Conta o numero de pessoas em cada cidade e as retorna em ordem decrescente de populacao.
     * Caso existam cidades com a mesma quantidade de pessoas, deve-se retornar em ordem alfabética.
     *
     * @param people pessoas e suas respectivas cidades
     * @return lista de cidades em ordem decrescente de populacao
     */
    public List<PopulationInCity> count(Collection<Person> people) {
        Map<String, List<Person>> grouped = people.stream().collect(Collectors.groupingBy(person -> person.getCity()));

        List<PopulationInCity> populationInCities = new ArrayList<>();
        for (Map.Entry<String, List<Person>> entry : grouped.entrySet()) {
            String city = entry.getKey();
            int population = entry.getValue().size();
            populationInCities.add(new PopulationInCity(city, population));
        }

        return populationInCities.stream()
                .sorted((o1, o2) -> {
                    int c = o2.getPopulation() - o1.getPopulation();
                    if (c == 0) {
                        return o1.getCityName().compareTo(o2.getCityName());
                    }
                    return c;
                }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Person> people =
                Arrays.asList(new Person("Mauro", "Campinas"), new Person("Maria", "Santos"),
                        new Person("Manuel", "Campinas"), new Person("Juliana", "Santos"),
                        new Person("Pedro", "Valinhos"), new Person("Augusto", "Salvador"),
                        new Person("Alexandre", "Manaus"), new Person("Wilson", "Campinas"),
                        new Person("Jonas", "Salvador"), new Person("Lucas", "Santos"),
                        new Person("Viviane", "Manaus"), new Person("Joaquim", "Campinas"),
                        new Person("Tiago", "Curitiba"), new Person("Joca", "Salvador"));
        List<PopulationInCity> pop = new PopulationCounter().count(people);


        List<String> expectedCities =
                Arrays.asList("Campinas", "Salvador", "Santos", "Manaus", "Curitiba", "Valinhos");
        AssertUtil.assertEquals(expectedCities.size(), pop.size());
        for (int i = 0; i < expectedCities.size(); i++) {
            AssertUtil.assertEquals(expectedCities.get(i), pop.get(i).getCityName());
        }
    }

}
