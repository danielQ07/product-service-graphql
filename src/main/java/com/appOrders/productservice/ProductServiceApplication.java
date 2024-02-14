package com.appOrders.productservice;

import com.appOrders.productservice.model.Category;
import com.appOrders.productservice.model.Product;
import com.appOrders.productservice.repository.CategoryRepository;
import com.appOrders.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;


@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CategoryRepository categoriaRepository,
											   ProductRepository productoRepository
	){
		return args -> {
			List.of("computadoras", "impresoras","smartphones").forEach
					(cat ->{
						Category categoria = Category.builder().categoryName(cat).build();
						categoriaRepository.save(categoria);
					});
			categoriaRepository.findAll().forEach(categoria -> {
				for (int i = 0; i<10;i++){
					Product producto = Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Computadora"+i)
							.price(100+Math.random()*200)
							.quantity(100)
							.category(categoria)
							.build();
					productoRepository.save(producto);
				}
			});
		};
	}
}
