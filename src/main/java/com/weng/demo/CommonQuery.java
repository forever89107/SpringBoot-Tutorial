package com.weng.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * 搜尋常用參數
 */
@Getter
@Setter
public class CommonQuery {
    // 依據 (id or level) 排序
    private String sortBy;
    // 排序規則 (asc、desc)
    private String sortRule;
}
