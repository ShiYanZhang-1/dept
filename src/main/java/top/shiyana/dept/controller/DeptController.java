package top.shiyana.dept.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;
import top.shiyana.dept.entity.Dept;
import top.shiyana.dept.mapper.DeptMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DeptController {

    @Resource
    private DeptMapper deptMapper;

    @GetMapping("findAll/{page}/{size}")
    public IPage<Dept> findAll(@PathVariable(value = "page",required = false)@DefaultValue("0") Integer page,
                              @PathVariable(value = "size",required = false)@DefaultValue("5")Integer size){
        IPage<Dept> page1 = new Page<>(page,size);
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<Dept>();
        IPage<Dept> page2 = deptMapper.selectPage(page1, null);
        return page2;
    }

    @PostMapping("save")
    public Map<String,Object> save(@RequestBody Dept dept){
        Map<String,Object> map = new HashMap<>();
        int insert = deptMapper.insert(dept);
        if(insert>0){
            map.put("resp", "添加成功！！！");
        }
        return map;
    }

    @PostMapping("update")
    public Map<String,Object> update(@RequestBody Dept dept){
        Map<String,Object> map = new HashMap<>();
        int update = deptMapper.updateById(dept);
        if(update>0){
            map.put("resp", "修改成功！！！");
        }
        return map;
    }



    @GetMapping("findById/{deptno}")
    public Dept findById(@PathVariable("deptno") Integer deptno){
        return deptMapper.selectById(deptno);
    }

    @GetMapping("delete/{deptno}")
    public Map<String,Object> delete(@PathVariable("deptno") Integer deptno){
        Map<String,Object> map = new HashMap<>();
        int i = deptMapper.deleteById(deptno);
        if(i>0){
            map.put("resp", "删除成功！！！");
        }
        return map;
    }

}
