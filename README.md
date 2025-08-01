# StdEvalGo

前端项目存放在SEG_frontend目录下，采用VUE3

后段项目存放在SEG_backend目录下，采用SpringFramework3.4.7，以Maven构建

前后端协同依赖axios

协作时先同步：
```bash
git pull
```

之后在dev分支上进行开发，首次开发：
```bash
git switch -c dev
```

之后
```bash
git checkout dev
```

提交时不要全部提交，仅提交已经修改过的

## 前端

前端项目采用VUE3 Vite构建。在windows上首先需要安装nvm。安装成功后以**管理员身份**运行PowerShell，即可使用命令。

此外，使用npm需要使用额外命令（或使用cmd）：
```powershell
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
```

以确保符合终端安全策略。

UI采用[Naive-UI](https://ui.naiveadmin.com/zh-CN/os-theme/docs)，可以查看docs来访问设计元素。

## 后端

注意，Spring服务在8080端口开启，VUE服务在5173端口开启，真正部署时需要Nignx进行反向代理以确保交互：
```nginx
http {
    include       mime.types;
    default_type  application/octet-stream;

    sendfile        on;
    keepalive_timeout  65;

    # 配置反向代理服务器
    server {
        listen       80;  # Nginx 监听 80 端口（前端通过此端口访问）
        server_name  localhost;  # 访问域名（本地开发用 localhost）

        # 1. 转发前端请求到 Vue 开发服务器（5173 端口）
        location / {
            proxy_pass http://localhost:5173;  # 转发到 Vue 前端
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
        }

        # 2. 转发 API 请求到 Spring 后端（8080 端口）
        # 所有以 /api 开头的请求，都转发到后端
        location /api/ {
            proxy_pass http://localhost:8080/;  # 注意结尾的 /，确保路径正确
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            # 解决跨域（允许前端携带 Cookie 等）
            add_header Access-Control-Allow-Origin http://localhost;
            add_header Access-Control-Allow-Methods "GET, POST, PUT, DELETE, OPTIONS";
            add_header Access-Control-Allow-Credentials "true";
        }
    }
}
```