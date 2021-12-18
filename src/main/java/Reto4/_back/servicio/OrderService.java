
package Reto4._back.servicio;

import Reto4._back.modelo.Order;
import Reto4._back.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
 @Autowired
    private OrderRepositorio orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        // cambios
////        obtiene el maximo id existente en la coleccion
        Optional<Order> orderIdMaxima = orderRepository.lastUserId();
        
////        si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.create(order);            
        }else{
            return order;
        } 
        
        //<--
//////            if (order.getId() == null){
//////                    return order;
//////                } else {
//////                    return orderRepository.create(order);
//////                }
    }

    public Order update(Order order) {
        // cambios    
        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
        //<--

//            if (order.getId() == null){
//                    return order;
//            } else {
//                    return orderRepository.create(order);
//                }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }
    
    public List<Order> getBySalesManId(Integer id){
        return orderRepository.getBySalesManId(id);    // en caso de error revisar el By
    }
    
    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);    // en caso de error revisar el By
    }
    
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer Id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay, Id);
    }

}

