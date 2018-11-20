import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

class User {
    private long id;
    private String name;
    private BigDecimal balance;

    User(long id, String name, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String toString() {
        return String.format("%d %s %s", getId(), getName(), getBalance());
    }
}

class Service {
    private long id;
    private String name;
    private BigDecimal price;

    Service(long id, String name, BigDecimal price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("%d %s %s", getId(), getName(), getPrice());
    }
}

public class OrderTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        //Create users
        User[] users = new User[3];
        users[0] = new User(1, "Kanssare", new BigDecimal(30.00));
        users[1] = new User(2, "Kankurang", new BigDecimal(10.00));
        users[2] = new User(3, "Djongagu", new BigDecimal(23.00));

        //create services
        Service[] services = new Service[2];
        services[0] = new Service(1, "Confeicção de passaporte", new BigDecimal(19.00));
        services[1] = new Service(2, "Bilhete de identidade", new BigDecimal(10.00));

        Map<Long, BigDecimal> userOrder = new HashMap<>();

        long id, serviceId;
        int serviceQuantity;
        int quantity;
        User user = null;

        while (true) {
            System.out.printf("%n Digite id do usuário:%n");
            id = scanner.nextLong();
            user = getUser(id, users);
            System.out.printf("%nQuantos serviços ?%n");
            serviceQuantity = scanner.nextInt();

            for (int i = 0; i < serviceQuantity; i++) {
                System.out.printf("%n Digite o identificador do serviço%n");
                serviceId = scanner.nextLong();

                Service service = getService(serviceId, services);
                System.out.printf("Quanto(a)s %s você deseja ?", service.getName());
                quantity = scanner.nextInt();

                userOrder.put(serviceId, service.getPrice().multiply(
                    new BigDecimal(quantity)
                ));
            }
            
            
            boolean compute = (userOrder.values().stream().reduce(BigDecimal.ZERO, 
            BigDecimal::add).compareTo(user.getBalance()) <= 0);
            
            if (compute)   
                System.out.printf("%n %s, a sua compra foi confirmada%n", user.getName());
            else      
                System.out.printf("%n %s, você não tem crédito suficiente!%n", user.getName());
        }
    }

    private static Service getService(long id, Service[] services) {
        boolean found = false;
        Service service = null;
        for (int i = 0; ((!found) && (i < services.length)); i++) {
            if (id == services[i].getId()) {
                found = true;
                service = services[i];
            }
        }
        return service;
    }

    private static User getUser(long id, User[] users) {
        boolean found = false;
        User user = null;

        for (int i = 0; ((!found)&&(i<users.length)); i++)
            if (id == users[i].getId()) {
                found = true;
                user = users[i];
            }
        return user;    
    }
}