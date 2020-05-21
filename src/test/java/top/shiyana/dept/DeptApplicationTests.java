package top.shiyana.dept;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.shiyana.dept.entity.Dept;
import top.shiyana.dept.mapper.DeptMapper;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DeptApplicationTests {

    @Resource
    DeptMapper deptMapper;

    @Test
    void contextLoads() {

        List<Dept> depts = deptMapper.selectList(null);
//        depts.forEach(dept ->{
//            System.out.println(dept);
//        });

        depts.forEach(System.out::println);

    }

    @Test
    void page() {
        IPage<Dept> page = new Page<>(0,20);
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<Dept>();
        IPage<Dept> page1 = deptMapper.selectPage(page, null);
        List<Dept> records = page1.getRecords();
        records.forEach(  System.out::println);
    }

    @Test
    void add() {
        int insert = deptMapper.insert(new Dept("哈哈哈123", "我在河南呀"));
        System.out.println(insert);
    }

    @Test
    void update() {
        int insert = deptMapper.updateById(new Dept(1,"哈哈哈", "我在河南呀"));
        System.out.println(insert);
    }

    @Test
    void findById() {
        System.out.println(deptMapper.selectById(1));
    }

    @Test
    void delete() {
        int i = deptMapper.deleteById(15);
        System.out.println(i);
    }
}
