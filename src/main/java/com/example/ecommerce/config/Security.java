package com.example.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Security {

   /* public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails salih= User.builder()
                .username("salih")
                .password("{noop}salih123")
                .roles("USER")
                .build();
        UserDetails ali = User.builder()
                .username("ali")
                .password("{noop}ali123")
                .roles("USER", "MANAGER")
                .build();
        UserDetails veli= User.builder()
                .username("veli")
                .password("{noop}veli123")
                .roles("USER", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(salih, ali, veli);

    }+/

    */



    @Bean
    JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);

    }


@Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(configurer->

            configurer
                    .requestMatchers(
                            "/swagger-ui/**",
                            "/v3/api-docs/**"
                    ).permitAll()


                    .requestMatchers(HttpMethod.GET,"/api/categories").hasRole("USER")
            .requestMatchers(HttpMethod.POST,"/api/categories").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE,"/api/categories/{categoriesId}").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.GET,"/api/products").hasRole("USER")
            .requestMatchers(HttpMethod.POST,"/api/products").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"/api/products/{productId}").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.GET, "/api/users").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/users/{usersId}").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.GET, "/api/users/{usersId}").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/adress").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/adress/{adressId}").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/adress").hasRole("USER")
                    .requestMatchers(HttpMethod.DELETE, "/api/adress/{adressId}").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/carts").hasRole("USER")
            .requestMatchers(HttpMethod.POST, "/api/carts").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/carts/{cartsId}").hasRole("MANAGER")
            .requestMatchers(HttpMethod.GET, "/api/carts/{cartsId}").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/cart-items").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/cart-items/**").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/cart-items").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/cart-items/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.GET, "/api/orders").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/orders/**").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/orders").hasRole("USER")
                    .requestMatchers(HttpMethod.DELETE, "/api/orders/**").hasRole("MANAGER")

                    .requestMatchers(HttpMethod.GET, "/api/order-items").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/order-items/**").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/order-items").hasRole("USER")
                    .requestMatchers(HttpMethod.DELETE, "/api/order-items/**").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/orders/**").hasRole("USER")

    );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

    return http.build();





    }







}
