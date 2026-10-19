package com.babylog.babydieteczemainfo.service.impl;

import com.babylog.babydieteczemainfo.model.BabyDietEczemaLog;
import com.babylog.babydieteczemainfo.repository.BabyLogRepository;
import com.babylog.babydieteczemainfo.service.BabyLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyLogServiceImpl implements BabyLogService {

    // 注意这里也是injection
    private final BabyLogRepository babyLogRepository;

    @Override
    public BabyDietEczemaLog createLog(BabyDietEczemaLog log) {
        return babyLogRepository.save(log);
    }

    @Override
    public BabyDietEczemaLog getLog(Long id) {
        return babyLogRepository.getReferenceById(id);
    }

    @Override
    public List<BabyDietEczemaLog> getLogs(Date date, Boolean eggOrEggSoup, String sortBy) {
        Specification<BabyDietEczemaLog> spec =
                (root, query, criteriaBuilder) -> {
                    var predicate = criteriaBuilder.conjunction();
                    if (date != null) {
                        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date"), date));
                    }
                    if (eggOrEggSoup != null) {
                        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("eggOrEggSoup"), eggOrEggSoup));
                    }

                    return predicate;
                };
        Sort sort = Sort.unsorted();
        if (sortBy != null && !sortBy.isBlank()) {
            sort = Sort.by(Sort.Direction.ASC, sortBy);
        }

        return babyLogRepository.findAll(spec, sort);
    }
}
