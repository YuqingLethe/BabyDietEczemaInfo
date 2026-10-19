package com.babylog.babydieteczemainfo.controller;

import com.babylog.babydieteczemainfo.model.BabyDietEczemaLog;
import com.babylog.babydieteczemainfo.service.BabyLogService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/babylog/v1")
public class BabyLogController {

    private final BabyLogService babyLogService;

    // 1. 构造器必须是 public（或者去掉修饰符变成 package-private），且不要把非空校验写错
    public BabyLogController(BabyLogService babyLogService) {
        this.babyLogService = Objects.requireNonNull(babyLogService, "babyLogService shoiuld not be null");
    }

    @PostMapping
    public BabyDietEczemaLog createLog(@RequestBody @Validated BabyDietEczemaLog log) {
        return babyLogService.createLog(log);
    }

    @GetMapping("/{id}")
    public BabyDietEczemaLog getLog(@PathVariable @Validated Long id) {
        return babyLogService.getLog(id);
    }
    @GetMapping
    public List<BabyDietEczemaLog> getLogs(
            @RequestAttribute(required = false) Date date,
            @RequestAttribute(required = false) Boolean eggOrEggSoup,
            @RequestAttribute(required = false) String sortBy) {
        return babyLogService.getLogs(date, eggOrEggSoup, sortBy);
    }
}
