package com.itheima.mp.domain.dto;


import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {
    private Integer total;
    private Integer pages;
    private List<T> list;
}
