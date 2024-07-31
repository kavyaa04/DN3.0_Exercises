public class DependencyInjectionExample {

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        Customer customer = service.findCustomerById(1);
        System.out.println("Customer Name: " + customer.getName());
    }

    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public Customer findCustomerById(int id) {
            // Simulate finding a customer by ID
            if (id == 1) {
                return new Customer("John Doe", 1);
            }
            return null;
        }
    }

    static class Customer {
        private String name;
        private int id;

        public Customer(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    static class CustomerService {
        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public Customer findCustomerById(int id) {
            return repository.findCustomerById(id);
        }
    }
}

