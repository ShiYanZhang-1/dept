<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="deptno"
        label="部门编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="dname"
        label="部门名称"
        width="120">
      </el-table-column>
      <el-table-column
        prop="loc"
        label="部门地址"
        width="120">
      </el-table-column>
      <el-table-column
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="dialogFormVisible = true, edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="deleteDept(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="pageSize"
      :total= "total"
      @current-change="page"
      >
    </el-pagination>

<!--    <el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>-->
    <el-dialog title="修改部门信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="部门名称" :label-width="formLabelWidth">
          <el-input v-model="form.dname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门地址" :label-width="formLabelWidth">
          <el-input v-model="form.loc" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm('form')">修 改</el-button>
        <el-button @click="dialogFormVisible = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
  export default {
    methods: {
      edit(row) {
        // console.log(row.deptno);
        this.$http.get("http://localhost:8888/dept/findById/"+row.deptno).then(resp=>{
          // console.log(resp)
          this.form.deptno=resp.data.deptno;
          this.form.dname=resp.data.dname;
          this.form.loc=resp.data.loc;
        })
      },
      deleteDept(row){
        // console.log(row.deptno);
        this.$http.get("http://localhost:8888/dept/delete/"+row.deptno).then(resp=>{
          if (resp.data.resp=="删除成功！！！"){
            this.$alert(resp.data.resp, '消息', {
              confirmButtonText: '确定',
              callback: action => {
                this.reload()
              }
            });
          }

        })
      },
      page (currentPage){
        // console.log(currentPage++)
        this.$http.get("http://localhost:8888/dept/findAll/"+(currentPage-1)+"/6").then(resp=>{
        this.tableData=resp.data.records
        this.pageSize=resp.data.size
        this.total=resp.data.total
        })
      },
      submitForm(form){
        this.$http.post("http://localhost:8888/dept/update/",this.form).then(resp=>{
            // console.log(resp)
            if (resp.data.resp=="修改成功！！！"){
              this.$alert('修改成功', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  this.dialogFormVisible = false
                  this.reload()
                }
              });
            }
        })
      }
    },
    inject: ['reload'],
    data() {
      return {
        pageSize: 10,
        total: 100,
        tableData: [{
          deptno: '1',
          dname: '王小虎1',
          loc: '上海',
        }, {
          deptno: '2',
          dname: '王小虎2',
          loc: '上海',
        }, {
          deptno: '3',
          dname: '王小虎3',
          loc: '上海',
        }],
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
          dname: '',
          loc: '',
          deptno: ''
        },
        formLabelWidth: '120px'
      }
    },
    created() {
      this.$http.get('http://localhost:8888/dept/findAll/0/6').then(resp=>{
        // console.log(resp)
        this.tableData=resp.data.records
        this.pageSize=resp.data.size
        this.total=resp.data.total
      })
    }
  }

</script>
