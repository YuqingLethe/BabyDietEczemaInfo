package com.babylog.babydieteczemainfo.service;

import com.babylog.babydieteczemainfo.model.BabyDietEczemaLog;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface BabyLogService {
    BabyDietEczemaLog createLog(BabyDietEczemaLog log);
    BabyDietEczemaLog getLog(Long id);
    List<BabyDietEczemaLog> getLogs(Date date, Boolean eggOrEggSoup, String sortBy);
}
