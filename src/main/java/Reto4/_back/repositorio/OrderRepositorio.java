package Reto4._back.repositorio;

import Reto4._back.interfaces.InterfaceOrder;
import Reto4._back.modelo.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositorio {
    @Autowired
    private InterfaceOrder orderCrudRepository;

    public List<Order> getAll() {
       // return (List<Order>) orderCrudRepository.findAll();
       return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    // cambios 
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    //<--
    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }
    
    public List<Order> getBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);    
    }
    
    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }
    
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer Id){
        try {        
        return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-mm-dd").parse(registerDay), Id);
    } catch (ParseException e) {
        e.printStackTrace();
        return null; 
            }
        }
    }

