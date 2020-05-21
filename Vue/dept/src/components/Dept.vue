<template>
    <div>
      <table>
        <tr>
          <td>部门编号</td>
          <td>部门名称</td>
          <td>部门地址</td>
        </tr>
        <tr v-for="dept in depts" :key="dept.deptno">
          <td>{{dept.deptno}}</td>
          <td>{{dept.dname}}</td>
          <td>{{dept.loc}}</td>
        </tr>
      </table>
      {{msg}}
    </div>
</template>

<script>
    export default {
        name: "Dept",
        data () {
          return  {
              msg: '123',
            depts: [
              {
                deptno: 1,
                dname: '试验部',
                loc: '北京'
              },
              {
                deptno: 2,
                dname: '人事部',
                loc: '北京'
              },
              {
                deptno: 3,
                dname: '财务部',
                loc: '北京'
              }
            ]
          }
        },
      created() {
        this.$http.get('http://localhost:8888/dept/findAll').then(resp=>{
          this.depts=resp.data;
        })
      }
    }
</script>

<style scoped>

</style>
