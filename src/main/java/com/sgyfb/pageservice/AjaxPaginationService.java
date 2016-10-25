package com.sgyfb.pageservice;

import java.util.List;

/**
 * ProjectName: educationOA
 * PackageName: com.sg.sgyfb.core.controller.teachingaffair.examinationmanagement.service
 * Created by lizhe on 2016/10/25.
 */
public interface AjaxPaginationService {
    /**
     *
     * @param pageNow 当前页
     * @param data 传入数据
     * @return List<String> [0]放入分页内容[1]放入分页页码列表
     */
    public List<String> getPagination(Integer pageNow, Object data);
}
