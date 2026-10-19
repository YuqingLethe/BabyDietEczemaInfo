package com.babylog.babydieteczemainfo.repository;

import com.babylog.babydieteczemainfo.model.BabyDietEczemaLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyLogRepository extends JpaRepository<BabyDietEczemaLog, Long>,
        JpaSpecificationExecutor<BabyDietEczemaLog> {
    // 这里不需要写任何代码，JpaRepository 自带 save(), findById(), findAll() 等方法
}