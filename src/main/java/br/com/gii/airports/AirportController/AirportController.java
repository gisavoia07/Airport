package br.com.gii.airports.AirportController;

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
   * Endpoint / airports/airport
   * Retorna TODOS os aeroporto da base de dados
   * @retun
   */
  @GetMapping("/airport")
  public List<Airport> findAll(){
      List<Airport> result = airportService.findAll();
      return result;
  }
  /**
   * Endpoint /airport/city/{cityName}
   * @param cityName
   * @return
   */
  @GetMapping("/city/{cityName}")
  public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
      List<Airport> result = airportService.findByCity(cityName);
      
      
      if (result.isEmpty()) {
          // Ops.. lista vazia...
          // notFoumd devolve 404
          return ResponseEntity.notFound().build();
          
      } else{
          //Eba! Tem dados!
          // ok devolve 200
          return ResponseEntity.ok(result);
          
      }
  }

  
  

  
}

