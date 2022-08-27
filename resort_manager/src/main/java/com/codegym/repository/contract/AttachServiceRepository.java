package com.codegym.repository.contract;

import com.codegym.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {

    @Query(value = "select * from attach_service where attach_service_id = :id ", nativeQuery = true)
    AttachService findById2(@Param("id") Integer id);
}
