package com.itheima.mp.domain.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class PageQuery {
    private Integer pageNum;
    private Integer pageSize;
    private String sortBy;
    private Integer isAsc;
}
