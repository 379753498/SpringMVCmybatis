# SSM
 SSM框架——详细整合教程（Spring+SpringMVC+MyBatis）
 博客地址http://www.cnblogs.com/zyw-205520/p/4771253.html
本人对项目源码进行修改 修正一些错误 并启用mybaits注解开发模式的案例
启动项目后访问http://localhost/SpringMVCmybatis/user/showUser

数据库建表语句
 CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(60) DEFAULT NULL COMMENT '用户名',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8