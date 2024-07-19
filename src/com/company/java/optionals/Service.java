package com.company.java.optionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Service {

   void execute(){
       List<Integer> customerIdList = Arrays.asList(100, 101, 102, 103, 104, 105);
       List<String> customerNames = customerIdList.stream()
               .map(Service::getCustomerById)// getCustomerById will return empty optional for 102
               .filter(Optional::isPresent)// we will just filter out customer which are not present
               .map(Optional::get)  // then get those customers
               .map(Customer::getCustomerName) // then get customer names
               .collect(Collectors.toList()); // to a string
       customerNames.forEach(System.out::println);

       List<String> customerNamesList = customerIdList.stream()
               .map(Service::getCustomerById)
               .filter(Optional::isPresent)
               .map(Optional::get)
               .map(Customer::getCustomerName)
               .collect(Collectors.toList());


      List<String> list =  customerIdList.stream()
               .map(Service::getCustomerById)
               .filter(Optional::isPresent)
               .map((Optional::get))
               .map(Customer::getCustomerName)
               .collect(Collectors.toList());
   }

    private static List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(100, "Don"),
                new Customer(101, "Joe"),
                new Customer(103, "Sam"),
                new Customer(104, "Paul"),
                new Customer(105, "Ron")
        );
    }

    private static Optional<Customer> getCustomerById(int customerId){

        BiFunction<Integer, Customer, Boolean> matchCustomer = (customerId1, customer) -> customer.getCustomerId() == customerId1;

        Customer queriedCustomer = getCustomers().stream()
                .filter(customer -> matchCustomer.apply(customerId, customer))
                .findAny()
                .orElse(null);

        BiFunction<Integer, Integer, Integer> sumInts = Integer::sum;
        return Optional.ofNullable(queriedCustomer);
    }
}
