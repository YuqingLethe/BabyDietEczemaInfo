package com.babylog.babydieteczemainfo.service.impl;

import com.babylog.babydieteczemainfo.model.BabyDietEczemaLog;
import com.babylog.babydieteczemainfo.repository.BabyLogRepository;
import com.babylog.babydieteczemainfo.service.InputConsoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class InputConsoleServiceImpl implements InputConsoleService {

    private final BabyLogRepository babyLogRepository;

    public void startConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== 宝宝饮食与湿疹记录控制台录入 ======");

        BabyDietEczemaLog log = new BabyDietEczemaLog();
        log.setDate(LocalDate.now());

        System.out.print("请输入今天吃的食物详情: ");
        log.setFoodDescription(scanner.nextLine());

        System.out.print("是否吃了发物(牛羊肉等)? (true/false): ");
        log.setTriggeringFood(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("是否吃了鸡蛋或蛋汤? (true/false): ");
        log.setEggOrEggSoup(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("是否吃了虾? (true/false): ");
        log.setShrimp(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("请输入当晚表现: ");
        log.setEveningReaction(scanner.nextLine());

        System.out.print("挠屁股严重程度 (Scale 1-3): ");
        log.setScratchingBottomScale(Integer.parseInt(scanner.nextLine()));

        System.out.print("新的湿疹或加重程度 (Scale 1-3): ");
        log.setEczemaWorseningScale(Integer.parseInt(scanner.nextLine()));

        // 调用 JPA save 保存到数据库
        BabyDietEczemaLog savedLog = babyLogRepository.save(log);
        System.out.println("====== 保存成功！数据库中的记录ID为: " + savedLog.getId() + " ======");
    }
}