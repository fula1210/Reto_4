package Reto4._back.interfaces;

import Reto4._back.modelo.Peripherals;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfacePeripherals extends MongoRepository<Peripherals, String> {
    
}
