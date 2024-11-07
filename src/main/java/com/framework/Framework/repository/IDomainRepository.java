package com.framework.Framework.repository;

import com.framework.Framework.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomainRepository extends JpaRepository<Domain,Long> {

}
