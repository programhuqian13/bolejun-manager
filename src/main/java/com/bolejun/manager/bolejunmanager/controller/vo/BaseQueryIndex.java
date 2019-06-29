package com.bolejun.manager.bolejunmanager.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by tony on 2019/4/11.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseQueryIndex<T> {

    private long total;

    private List<T> rows;
}
