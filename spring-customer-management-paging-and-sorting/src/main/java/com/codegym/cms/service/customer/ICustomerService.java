package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Page<Customer> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);

    Page<Customer> findAllByIdEqualsOrFirstNameContainingOrLastNameContaining(Long id, String firstName, String lastName, Pageable pageable);

    Page<Customer> searchByAll(@Param("keySearch") String keySearch, Pageable pageable);

}
