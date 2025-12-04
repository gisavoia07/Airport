package br.com.gii.airports.AirportController;

import br.com.gii.airports.dto.AirportMinDTO;
import br.com.gii.airports.entities.Airport;
import br.com.gii.airports.services.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DIT2A
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    /**
     * Endpoint / airports/airport Retorna TODOS os aeroporto da base de dados
     *
     * @retun
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }

    // Adicionar findByCity
    @GetMapping("/city/{cityName}")
    public List<Airport> findByCountryIgonreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);
        
        if (result.isEmpty()) {
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            //Eba! Tem dados !
            // ok devolve 200
            return ResponseEntity.ok(result);

        }
    }
    // Adicionar o findByCountry
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgonreCase(@PathVariable String countryName) {
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        if (result.isEmpty()) {
            //Ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            //Eba! Tem dados !
            // ok devolve 200
            return ResponseEntity.ok(result);

        }
    }

    /**
     * Endpoint /airport/city/{cityName}
     *
     * @param cityName
     * @return
     */
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);

        if (result == null) {
            // Ops.. Aeroporto vazio...
            // notFoumd devolve 404
            return ResponseEntity.notFound().build();

        } else {
            //Eba! Tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);

        }
    }

}
