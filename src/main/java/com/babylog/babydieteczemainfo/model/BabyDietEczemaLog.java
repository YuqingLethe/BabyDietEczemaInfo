package com.babylog.babydieteczemainfo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "baby_diet_eczema_logs")
public class BabyDietEczemaLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 记录日期
    private LocalDate date;

    // 当天吃的食物详情
    @Column(columnDefinition = "TEXT")
    private String foodDescription;

    // 发物（如牛羊肉等）
    private boolean triggeringFood; // true 表示吃了

    // 鸡蛋或者蛋汤
    private boolean eggOrEggSoup; // true 表示吃了

    // 虾
    private boolean shrimp; // true 表示吃了

    // 当晚表现
    @Column(columnDefinition = "TEXT")
    private String eveningReaction;

    // 挠屁股严重程度 (Scale 1-3)
    private int scratchingBottomScale;

    // 新的湿疹或加重程度 (Scale 1-3)
    private int eczemaWorseningScale;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getFoodDescription() { return foodDescription; }
    public void setFoodDescription(String foodDescription) { this.foodDescription = foodDescription; }

    public boolean isTriggeringFood() { return triggeringFood; }
    public void setTriggeringFood(boolean triggeringFood) { this.triggeringFood = triggeringFood; }

    public boolean isEggOrEggSoup() { return eggOrEggSoup; }
    public void setEggOrEggSoup(boolean eggOrEggSoup) { this.eggOrEggSoup = eggOrEggSoup; }

    public boolean isShrimp() { return shrimp; }
    public void setShrimp(boolean shrimp) { this.shrimp = shrimp; }

    public String getEveningReaction() { return eveningReaction; }
    public void setEveningReaction(String eveningReaction) { this.eveningReaction = eveningReaction; }

    public int getScratchingBottomScale() { return scratchingBottomScale; }
    public void setScratchingBottomScale(int scratchingBottomScale) { this.scratchingBottomScale = scratchingBottomScale; }

    public int getEczemaWorseningScale() { return eczemaWorseningScale; }
    public void setEczemaWorseningScale(int eczemaWorseningScale) { this.eczemaWorseningScale = eczemaWorseningScale; }
}
