<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { NButton, NInput } from 'naive-ui'
import { ref } from 'vue'
import axios from 'axios'

// 表单数据
const studentId = ref('')
const password = ref('')
const agreed = ref(false)
const loading = ref(false)
const errorMessage = ref('')

// 处理登录/注册
const handleLogin = async () => {
  // 前端验证
  if (!studentId.value.trim()) {
    errorMessage.value = '请输入学号'
    return
  }
  
  if (!password.value.trim()) {
    errorMessage.value = '请输入密码'
    return
  }
  
  if (!agreed.value) {
    errorMessage.value = '请同意用户协议'
    return
  }
  
  // 清空错误信息
  errorMessage.value = ''
  loading.value = true
  
  try {
    // 发送请求到后端
    const response = await axios.post('http://localhost:8080/api/auth/login', {
      studentId: studentId.value,
      password: password.value
    })
    
    // 处理成功响应
    const data = response.data
    alert(`${data.message}！`)
  } catch (error) {
    // 处理网络错误
    console.error('登录请求失败:', error)
    errorMessage.value = '网络错误，请稍后重试'
  } finally {
    loading.value = false
  }
}
</script>

<template>

  <body>
    <div class="header">
      <div class="main-title">
        <h1>学生成绩与竞赛活动综合评价一体化系统</h1>
        <h2>Standard Evaluation Go</h2>
        <hr>
      </div>
    </div>
    <p>Welcome!</p>

    <div class="loginBox">
      <h3>请登录或注册</h3>
      <table id="loginTable"><tbody>
      <tr>
      <td>学号:</td>
      <td><n-input v-model:value="studentId" id="stuid" type="text" placeholder="请输入学号" /></td>
      </tr>
      <tr>
      <td>密码:</td>
      <td><n-input v-model:value="password" id="pwd" type="password" show-password-on="mousedown" placeholder="请输入密码" :maxlength="28" /></td>
      </tr>
      </tbody></table>
      <br>
      <input v-model="agreed" type="checkbox" name="eula" value="true"> 我已阅读并同意<a href="#">用户协议</a>
      <br>
      <br>
      <n-button :loading="loading" :disabled="!agreed" @click="handleLogin">
        登录或注册
      </n-button>
    </div>

    <!-- <div class="sidebar">
      <h2>导航</h2>
      <ul>
        <li><RouterLink to="/">首页</RouterLink></li>

        <li><RouterLink to="/about">关于我们</RouterLink></li>
      </ul>
    </div> -->

    <div class="footer">
      <p>© 2025 BIrdT org. All rights reserved.</p>
      <p>Powered by lamaper & omnipotent-ys & zjh_6z</p>
    </div>
  </body>
</template>

<style scoped>
.main-title {
  text-align: center;
  margin-top: 20px;
  line-height: 0.7
}

.loginBox {
  width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-align: center;
}

.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  padding: 10px;
  background-color: #f1f1f1;
}

.sidebar {
  position: fixed;
  top: 0;
  left: 0;
  width: 200px;
  height: 100%;
  background-color: #f8f9fa;
  padding: 20px;
}
#loginTable {
  width: 100%;
  margin: 0 auto;
  
}
</style>
