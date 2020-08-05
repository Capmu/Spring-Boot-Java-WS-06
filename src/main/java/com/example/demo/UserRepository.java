package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User /* On table 'User' */, Integer /* type of primary key */> {

}
