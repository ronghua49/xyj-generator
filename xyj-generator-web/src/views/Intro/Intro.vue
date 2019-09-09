<template>
  <div class="page">
    <h2 class="header">XYJSOFT Generator</h2>
    <div class="intro">
      <p>XYJSOFT代码生成器，可以通过界面配置快速生成包括 model，dao，service，controller 以及页面的相关代码。</p>
    </div>
    <div>
      <div class="title">使用指南</div>
      <div class="step">
        <span>1.配置数据源</span>
      </div>
    </div>
    <div>
      <div class="step">
        <span>2.选择数据库表</span>
      </div>
    </div>
    <div>
      <div class="step">
        <span>3.编辑信息，生成代码</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Intro'
}
</script>

<style>
.header {
  font-size: 28px;
  text-align: left;
  padding: 10px;
}
.intro {
  font-size: 18px;
  text-align: left;
  padding-left: 10px;
}
.title {
  font-size: 30px;
  text-align: left;
  padding: 10px;
}
.step {
  font-size: 18px;
  text-align: left;
  padding: 10px;
}
.image {
  text-align: left;
  padding: 10px;
}
img {
  
  width: 1000px;
  height: 500px;
}
</style>
