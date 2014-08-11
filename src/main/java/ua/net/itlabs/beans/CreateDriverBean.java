package ua.net.itlabs.beans;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.net.itlabs.entities.DriverEntity;
import ua.net.itlabs.model.Driver;
import ua.net.itlabs.utils.HibernateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgenii on 30.07.2014.
 */

@ManagedBean(name = "createDriverBean")
@SessionScoped
public class CreateDriverBean {
private Driver driver = new Driver();

private Map<String, String> brands = new HashMap<String, String>();
private Map<String, String> models = new HashMap<String, String>();

    public CreateDriverBean() {
        brands.put("Audi","Audi");
        brands.put("Nissan","Nissan");
        brands.put("Kia","Kia");
        brands.put("Opel","Opel");
        models.put("Cerato","Cerato");
    }

    public Driver getDriver() {
        return driver;

    }
    public Map<String, String> getModels() {
        return models;
    }
    public Map<String, String> getBrands() {
        return brands;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String create(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            DriverEntity driverEntity = new DriverEntity();
            driverEntity.setAutoPlate(driver.getAutoPlate());
            driverEntity.setBrand(driver.getBrand());
            driverEntity.setFirstName(driver.getFirstName());
            driverEntity.setLastName(driver.getLastName());
            driverEntity.setModel(driver.getModel());
            long driverId = (Long) session.save(driverEntity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


        return "view";
    }
}
