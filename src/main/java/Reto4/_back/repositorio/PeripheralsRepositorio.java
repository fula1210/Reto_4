package Reto4._back.repositorio;


import Reto4._back.interfaces.InterfacePeripherals;
import Reto4._back.modelo.Peripherals;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PeripheralsRepositorio {
  @Autowired
    private InterfacePeripherals repository;

    public List<Peripherals> getAll() {
        return repository.findAll();
    }
public Optional<Peripherals> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Peripherals create(Peripherals clothe) {
        return repository.save(clothe);
    }

    public void update(Peripherals clothe) {
        repository.save(clothe);
    }
    
    public void delete(Peripherals clothe) {
        repository.delete(clothe);
    }
}
