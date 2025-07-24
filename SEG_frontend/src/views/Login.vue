<script>

</script>

<template>
    <div class="loginBox">
      <p>请登录或注册</p>

      学号:<input type="text" name="username">
      <br>
      密码:<input type="password" name="password">
      <br>
      <br>
      <input type="checkbox" name="eula" value="true"> 我已阅读并同意<a href="#">用户协议</a>
      <br>
      <br>
      <button class="btn btn-primary">
        <RouterLink to="/login">登录或注册</RouterLink>
      </button>
    </div>
</template>

<style>
.loginBox {
  width: 300px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: center;
}
</style>