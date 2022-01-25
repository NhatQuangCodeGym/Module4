package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Page<Customer> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);

    Page<Customer> findAllByIdEqualsOrFirstNameContainingOrLastNameContaining(Long id, String firstName, String lastName, Pageable pageable);

    @Query(value = "SELECT * FROM customers AS c WHERE c.id LIKE %:keySearch% OR c.firstName LIKE %:keySearch% OR c.lastName LIKE %:keySearch% ", nativeQuery = true)
    Page<Customer> searchByAll(@Param("keySearch") String keySearch, Pageable pageable);

}
