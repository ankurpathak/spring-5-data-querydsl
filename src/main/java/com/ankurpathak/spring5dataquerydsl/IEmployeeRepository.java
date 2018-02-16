package com.ankurpathak.spring5dataquerydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository("employeeRepository")
public interface IEmployeeRepository extends MongoRepository<Employee, String>, QueryDslPredicateExecutor<Employee> , IEmployeeRepositoryCustom{
    Optional<Employee> findByEmployeeId(@Param("employeeId")BigInteger employeedId);
    List<Employee> findBySalary(@Param("salary")BigDecimal salary);
}
