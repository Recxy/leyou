package com.leyou.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.exception.BusinessException;
import com.leyou.common.result.BaseResult;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author itw_liuqp
 * @date 2020/7/17 17:26
 * @describe
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResult<String> queryCategoryListByParentId(@RequestParam(value = "pid",defaultValue = "0") Long id){
        BaseResult<String> objectBaseResult = new BaseResult<>("");
        try{
            String data = categoryService.queryCategoryListByParentId(id);
            objectBaseResult.setCode("0");
            objectBaseResult.setData(data);
            objectBaseResult.setMessage("success");
        }catch (BusinessException e){
            objectBaseResult.setCode("-1");
            objectBaseResult.setMessage("error");
        }

        return objectBaseResult;
    }
}
