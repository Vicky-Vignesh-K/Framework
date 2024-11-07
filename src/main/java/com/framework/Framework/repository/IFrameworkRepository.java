package com.framework.Framework.repository;

import com.framework.Framework.entity.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrameworkRepository extends JpaRepository<Framework,Long> {

}
