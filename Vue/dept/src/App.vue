<template>
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

<script>
  export default {
    name: 'App',
    provide (){
      return {
        reload:this.reload
      }
    },
    data(){
      return {
        isRouterAlive:true
      }
    },
    methods:{
      reload (){
        this.isRouterAlive = false
        this.$nextTick(function(){
          this.isRouterAlive = true
        })
      }
    }
  }
</script>
