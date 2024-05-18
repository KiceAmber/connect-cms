<script setup lang="ts">
import {
  UserOutlined,
  LockOutlined,
  GithubOutlined,
} from "@ant-design/icons-vue";
</script>

<template>
  <div class="login-container">
    <div class="left-login-box">
      <div class="title">CONNECT-CMS</div>
      <div class="login-form">
        <a-input placeholder="Enter Passport">
          <template #prefix>
            <UserOutlined />
          </template>
        </a-input>
        <a-input-password placeholder="Enter Password">
          <template #prefix>
            <LockOutlined />
          </template>
        </a-input-password>
        <a-button class="login-btn" type="primary" size="large">Login</a-button>
        <a-button class="third-login-btn" type="primary" size="large">
          <template #icon><GithubOutlined /></template>
          Sign in with GitHub
        </a-button>
      </div>
    </div>
    <div class="right-pic-box">
      <div class="logo"></div>
      <span>Welcome!</span>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.login-container {
  width: 100%;
  height: 100vh;
  background-color: rgba(255, 255, 255, 0.61);
  display: flex;
  justify-content: space-between;

  .left-login-box {
    border-right: 1px solid rgba(255, 255, 255, 0.452);
    width: 50%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;

    .title {
      text-align: center;
      margin: 30px 0;
      font-size: 30px;
      font-weight: 900;
      color: rgb(196, 107, 255);
    }

    .login-form {
      display: flex;
      width: 76%;
      margin-left: 12%;
      flex-direction: column;

      .ant-input-affix-wrapper {
        color: rgb(196, 107, 255);
        &:hover {
          border-color: rgb(196, 107, 255);
        }
        &:focus {
          border-color: rgb(196, 107, 255);
        }
        margin: 10px 0;
      }
      .ant-input-affix-wrapper-focused {
        border-color: rgb(196, 107, 255);
      }

      .login-btn {
        margin: 10px 0;
        background-color: rgb(196, 107, 255);
      }
      .third-login-btn {
        margin: 10px 0;
        background-color: rgba(0, 0, 0, 0.623);
      }
    }
  }
  .right-pic-box {
    width: 50%;
    height: 100%;
    background-color: rgba(111, 111, 111, 0.1);
    display: flex;
    justify-content: center;
    align-items: center;

    .logo {
      width: 100px;
      height: 100px;
      background-image: url("@/assets/images/logo.png");
      background-repeat: no-repeat;
      background-size: cover;
      margin-right: 20px;
    }
  }
}
</style>
