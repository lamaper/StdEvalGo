<script setup>
import { RouterLink, RouterView } from 'vue-router'
// Removed Vite configuration as it should not be in a Vue component file.
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
    <!-- <div class="sidebar">

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
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  padding: 10px;
  background-color: #f1f1f1;
}
.sidebar{
  position: fixed;
  top: 0;
  left: 0;
  width: 200px;
  height: 100%;
  background-color: #f8f9fa;
  padding: 20px;
}
</style>
