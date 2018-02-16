package com.ankurpathak.spring5dataquerydsl;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class Spring5DataQuerydslApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5DataQuerydslApplication.class, args);
	}
}


@Component
class Spring5DataQuerydslApplicationRunner implements ApplicationRunner{

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		employeeRepository.save(new Employee(BigInteger.ONE, "Ankur Pathak", BigDecimal.valueOf(1000)));

		Query query = new Query(Criteria.where("employeeId").is(BigInteger.ONE));
		Employee employee = mongoTemplate.findOne(query, Employee.class);
		System.out.println(employee);


		Query queryList = new Query(Criteria.where("salary").gt(BigDecimal.valueOf(900)));
		List<Employee> employees = mongoTemplate.find(query, Employee.class);
		System.out.println(employees.size());

		QEmployee qEmployee = new QEmployee("employee");
        Predicate employeeIdPredicate = qEmployee.employeeId.eq(BigInteger.ONE);

		Employee employeeByEmployeeIdPredicate = employeeRepository.findOne(employeeIdPredicate);
        System.out.println(employeeByEmployeeIdPredicate);

        Predicate employeeSalaryPredicate = qEmployee.salary.between(BigDecimal.valueOf(900), BigDecimal.valueOf(1100));
        Iterable<Employee> employeesBySalaryPredicate = employeeRepository.findAll(employeeIdPredicate);
        Iterator<Employee> employeeIterator = employeesBySalaryPredicate.iterator();
        if(employeeIterator.hasNext()){
            System.out.println(employeeIterator.next());
        }








    }
}