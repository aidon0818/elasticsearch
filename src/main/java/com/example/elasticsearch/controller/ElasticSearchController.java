package com.example.elasticsearch.controller;


import com.example.elasticsearch.dao.EmployeeRepository;
import com.example.elasticsearch.model.Employee;
import com.google.gson.Gson;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository er;


    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public String add(@RequestBody Map<String, String> req) {
        Employee employee = new Employee();
        employee.setId(req.get("id"));
        employee.setFirstName(req.get("name"));
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        er.save(employee);
        return "success";
    }

    //删除,http://localhost:8080/es/delete/1
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Employee employee = new Employee();
        employee.setId(id);
        er.delete(employee);
        return "success";
    }

    //局部更新,http://localhost:8080/es/update?id=2&age=21
    @RequestMapping("/update")
    public String update(@PathParam("id") String id, @PathParam("age") Integer age) {

        Employee employee = er.queryEmployeeById(id);
        employee.setAge(age);
        er.save(employee);
        return "success";
    }

    //查询
    @RequestMapping("/query")
    public Employee query() {
        Employee accountInfo = er.queryEmployeeById("1");
        System.err.println(new Gson().toJson(accountInfo));
        return accountInfo;
    }

    // 复合查询
    @RequestMapping("/queryList")
    public List<Employee> getQueryList() {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        //设置模糊搜索
        builder.must(QueryBuilders.fuzzyQuery("lastName", "zh"));
        //设置要查询博客的标题中含有关键字
//        builder.must(new QueryStringQueryBuilder("id").field("1"));
        //排序是依次降低
        FieldSortBuilder sort = SortBuilders.fieldSort("age").order(SortOrder.DESC);
        //设置分页(从第一页开始，一页显示10条)
        //注意开始是从0开始，有点类似sql中的方法limit 的查询
        PageRequest page = new PageRequest(0, 10);
        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);
        //将分页设置到构建中
        nativeSearchQueryBuilder.withPageable(page);
        //将排序设置到构建中
        nativeSearchQueryBuilder.withSort(sort);
        //生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder.build();

        //3.执行方法1
        Page<Employee> ls = er.search(query);
//        List<Employee> blogList = elasticsearchTemplate.queryForList(query, Employee.class);
        List<Employee> content = ls.getContent();
        return content;
    }

}
