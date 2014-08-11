package ua.net.itlabs.beans;

import ua.net.itlabs.model.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgenii on 04.08.2014.
 */
@ManagedBean(name = "createOrderBean")
@SessionScoped
public class CreateOrderBean {
    private Order order = new Order();

    public Order getOrder() {
        return order;
    }

    private Map<String, String> status = new HashMap<String, String>();

    public CreateOrderBean() {
        status.put("ordered","ordered");
        status.put("canceled","canceled");

    }

    public Map<String, String> getStatus() {
        return status;
    }

    public String create(){
        return "ordered";
    }
}
