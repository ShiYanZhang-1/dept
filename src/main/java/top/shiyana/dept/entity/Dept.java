package top.shiyana.dept.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    @TableId(value = "deptno",type = IdType.AUTO)
    private Integer deptno;

    private String dname;
    private String loc;

    @TableLogic
    private Integer deleted;

    public Dept(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
