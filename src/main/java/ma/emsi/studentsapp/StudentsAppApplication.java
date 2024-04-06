package ma.emsi.studentsapp;

import ma.emsi.studentsapp.entities.Product;
import ma.emsi.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.PrivateKey;
import java.util.List;

@SpringBootApplication
public class StudentsAppApplication  implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository ;
    public static void main(String[] args) {

        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"computer",4500,3));
        //productRepository.save(new Product(null,"mouse",450,9));
        //productRepository.save(new Product(null,"keybord",300,12));
        List<Product> products=productRepository.findAll();
        products.forEach(p->{
                    System.out.println(p.toString());

                });



        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("*************");
        System.out.println("-------------");
        List<Product> productList= productRepository.findByNameContains("k");
        productList.forEach(p->{
            System.out.println(p);

        });



        System.out.println("/////////////////");
        List<Product> productList2= productRepository.search("%c%");
        productList2.forEach(p->{
            System.out.println(p);

        });



        System.out.println("/-/-/-/-/-/-/-/-/-/-/-");
        List<Product> productList3= productRepository.findByPriceGreaterThan(300);
        productList3.forEach(p->{
            System.out.println(p);

        });


    }
}
