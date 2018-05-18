# SSM Demo

 SSM框架——详细整合教程（Spring+SpringMVC+MyBatis）

 
 CREATE TABLE `userinfo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` VARCHAR(60) DEFAULT NULL COMMENT '用户名',
    `password` VARCHAR(60) DEFAULT NULL COMMENT '密码',

   `Phone` VARCHAR(60) DEFAULT NULL COMMENT 'Phone',
    `Email` VARCHAR(60) DEFAULT NULL COMMENT 'Email',
  `EmailUUid` VARCHAR(60) DEFAULT NULL COMMENT 'EmailUUid',
  `state` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8


经过修改成javaConfig形式去web.XML 运行正常；
集成了 Redis Swagger2 JavaMail 
详细请看Config目录代码；
