package br.com.gii.airports.services;

import br.com.gii.airports.dto.AirportMinDTO;
import br.com.gii.airports.entities.Airport;
import br.com.gii.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DIT2A
 */
@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> findAll() {
        List<Airport> result = airportRepository.findAll();
        return result;

    }

    /**
     * Retornae DTO Airports filtrado por idade
     *
     * @param city
     * @return
     */
    public List<Airport> findByCity(String city) {
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
    }

    /**
     * Retornar DTO Airport filtrado por country (país)
     *
     * @param country
     * @return
     */
    public List<AirportMinDTO> findByCountry(String country) {
        List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);

        List<AirportMinDTO> resultDTO = resultAirport.stream()
                .map(x -> new AirportMinDTO(x)).toList();
        return resultDTO;
    }
    
    
    
}
