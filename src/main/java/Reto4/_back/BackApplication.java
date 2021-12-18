package Reto4._back;


import Reto4._back.interfaces.InterfaceOrder;
import Reto4._back.interfaces.InterfacePeripherals;
import Reto4._back.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component

public class BackApplication implements CommandLineRunner{

@Autowired
    private InterfacePeripherals  crudRepository;
    @Autowired
    private InterfaceUser userCrudRepository;
    @Autowired
    private InterfaceOrder orderCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
@Override
    public void run(String... args) throws Exception {
        
//      SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }
}
