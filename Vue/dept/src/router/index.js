import Vue from 'vue'
import Router from 'vue-router'
import Dept from "../components/Dept";
import DeptList from "../components/DeptList";
import AddDept from "../components/AddDept";
import DeptManage from "../components/DeptManage";
import App from "../App";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '部门管理',
      component: DeptManage,
      redirect: '/DeptList' ,
      children: [
        {
          path: '/DeptList',
          name: '部门列表',
          component: DeptList
        },
        {
          path: '/AddDept',
          name: '部门添加',
          component: AddDept
        }
      ]

    },
    {
      path: '/Dept',
      name: 'Dept',
      component: Dept
    }
  ]
})
