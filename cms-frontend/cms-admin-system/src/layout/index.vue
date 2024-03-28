<script setup lang="ts">
import SideBar from "./SideBar/index.vue";
import TopBar from "./TopBar/index.vue";
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="180px">
        <SideBar />
      </el-aside>
      <el-container>
        <el-header>
          <TopBar />
        </el-header>
        <el-main>
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style lang="scss" scoped>
.el-header {
  padding: 0 0;
}
</style>
