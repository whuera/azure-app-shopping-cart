package test;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CustomerRepository;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void createCustomer_Success() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer created = customerService.createCustomer(customer);

        assertNotNull(created);
        assertEquals(ShoppingCartEnum.CUSTOMER_CREATE.type, customer.getStatus());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void createCustomer_Null() {
        Customer created = customerService.createCustomer(null);
        assertNull(created);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void updateCustomer_Success() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer updated = customerService.updateCustomer(customer);

        assertNotNull(updated);
        assertEquals(ShoppingCartEnum.CUSTOMER_UPDATE.type, customer.getStatus());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void updateCustomer_NotFound() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        Customer updated = customerService.updateCustomer(customer);

        assertNull(updated);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void deleteCustomer_Success() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer deleted = customerService.deleteCustomer(1L);

        assertNotNull(deleted);
        assertEquals(ShoppingCartEnum.CUSTOMER_DELETE.type, deleted.getStatus());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void deleteCustomer_NotFound() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        Customer deleted = customerService.deleteCustomer(1L);

        assertNull(deleted);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void getCustomer_Success() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer found = customerService.getCustomer(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
    }

    @Test
    void listAllCustomer_Success() {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        List<Customer> customers = Arrays.asList(c1, c2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.listAllCustomer();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
