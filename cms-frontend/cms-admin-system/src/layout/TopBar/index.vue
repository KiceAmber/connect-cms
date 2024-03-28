<script setup lang="ts">
import { Ref, ref } from "vue";

const avatarUrl: Ref<string> = ref(
  "https://s21.ax1x.com/2024/03/28/pFopWbq.jpg"
);
</script>

<template>
  <div class="nav">
    <div class="view-name">首页</div>
    <div class="user-operation">
      <!-- 这里还需要加入其他操作，比如消息提示，亮色暗色主题切换 -->
      <el-dropdown class="user-info">
        <el-avatar :size="40" :src="avatarUrl" />
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>账户信息</el-dropdown-item>
            <el-dropdown-item>账户登出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.nav {
  height: 100%;
  background-color: white;
  color: black;
  border-bottom: 1px solid rgba(107, 107, 107, 0.227);
  box-shadow: 0 1px 2px rgba(196, 196, 196, 0.232);
  display: flex;
  align-items: center;
  justify-content: space-between;

  .view-name {
    padding-left: 20px;
  }

  .user-operation {
    padding-right: 20px;

    .el-dropdown-link {
      display: flex;
      align-items: center;
    }
  }
}
</style>
