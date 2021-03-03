package service.customer;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService{

    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(0,"thinh0","thinh0@email.com","thai binh 0"));
        customerList.add(new Customer(1,"thinh1","thinh1@email.com","thai binh 1"));
        customerList.add(new Customer(2,"thinh2","thinh2@email.com","thai binh 2 "));
        customerList.add(new Customer(3,"thinh3","thinh3@email.com","thai binh 3"));
        customerList.add(new Customer(4,"thinh4","thinh4@email.com","thai binh 4"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId()==id){
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public void create(Customer customer) {

        customerList.add(customer);

    }

    @Override
    public void update(Customer customer) {
        int index = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId()==customer.getId()){
                index=i;
            }
        }
        customerList.set(index,customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = this.findById(id);

        customerList.remove(customer);
    }
}
