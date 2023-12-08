package com.example.Restaurantservice;

import com.example.Restaurantservice.filter.RestaurantFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterUrl()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new RestaurantFilter());

		filterRegistrationBean.addUrlPatterns("/api/v1/restaurant/addRestaurant",
				"/api/v1/restaurant/update/*",
				"/api/v1/restaurant/delete/*",
				"/api/v1/cuisine/addNewCuisine/*",
				"/api/v1/cuisine/update/*",
				"/api/v1/cuisine/delete/*",
				"/api/v1/restaurant/addItem/*",
				"/api/v1/restaurant/updateItem/*",
				"/api/v1/restaurant/deleteItem/*");
		return filterRegistrationBean;
	}
}
