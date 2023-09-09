<template>
  <el-container  class="home">
    <!-- 导航 -->
    <el-header style="padding:0">
      <Header />
    </el-header>
    

    <!-- 页面主体 -->
    <el-container >
        <el-aside width="200px">
          <el-menu
          router
          class="el-menu-vertical-demo"
          background-color='white'
          text-color="black"
          active-text-color="#808080">         

            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="/user">职工列表</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          
        </el-menu>
        </el-aside>

        <el-container>
          <el-main><router-view/></el-main>
        </el-container>
    </el-container>
  </el-container>
</template>


<script>
// @ is an alias to /src
import Header from '@/components/Header.vue'
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    Header
  }
}
</script>
<style>
  .home{
    height: 100vh;
    display: flex;
  }
</style>
