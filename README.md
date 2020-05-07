# learningspring
learn spring
## 项目结构介绍
    - common：主要一些公共方法存放，mybatis已经crud代码生成
    - demo：主要是一些学习代码
    - oauthserver：oauth 2.0服务器，
                   使用数据库、redis存储token，
                   token支持jwt，支持验证码，
                   支持自定义登录界面
    - oauthclient：测试客户端，支持使用spring session，使用数据库、redis存储session
    - job： spring job的一些应用
## 创建项目与模块
 - 新建一个项目，依赖全部不选
 - 修改pom.xml文件，添加`<packaging>pom</packagine>`
 - 删除除.idea、pom.xml、*.iml文件外其他文件
 - 添加其他modules
 - 修改module界面中parent信息，修改为父项目信息
 - 在module中添加对common的引用：
    <!---->
            <!--添加对common的引用-->
            <dependency>
                <groupId>com.yifan</groupId>
                <artifactId>learningspring</artifactId>
                <version>0.0.1-SNAPSHOT</version>
            </dependency>
 - 修改父项目的pom文件，添加modules节点，添加子项目
 - 删除子项目的启动界面以及resources文件中内容
