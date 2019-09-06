package com.infotech.client;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FetchDataClientTest {

    public static void main(String[] args) {
//getEmployeeAndAddressByEmployeeId();
        getEmployeeAndAddressByAddressId();

    }

    private static void getEmployeeAndAddressByAddressId() {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            Address address = session.get(Address.class, 1);
            System.out.println(address);
            System.out.println(address.getEmployee());
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    private static void getEmployeeAndAddressByEmployeeId() {
        Employee employee = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(Employee.class, 1);
            System.out.println(employee);
            Address address = employee.getAddress();
            System.out.println(address);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}