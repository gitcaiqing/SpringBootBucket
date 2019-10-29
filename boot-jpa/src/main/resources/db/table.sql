DROP TABLE IF EXISTS tb_user;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户uuid',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `identity_card` varchar(30) DEFAULT NULL COMMENT '身份证号',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birth_date` date DEFAULT NULL COMMENT '出生日期',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_account;
CREATE TABLE `tb_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(32) DEFAULT NULL COMMENT '账户uuid',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户uuid关联用户',
  `money` double DEFAULT NULL COMMENT '账户金额',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_account_oper;
CREATE TABLE `tb_account_operate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operate_id` varchar(32) DEFAULT NULL COMMENT '账户操作uuid',
  `account_id` varchar(32) DEFAULT NULL COMMENT '账户uuid',
  `operate_type` varchar(1) DEFAULT NULL COMMENT '账户操作类型 0充值1消费扣除',
  `money` double DEFAULT NULL COMMENT '操作金额',
  `operate_user_id` varchar(32) DEFAULT NULL COMMENT '操作人id',
  `operate_user_name` varchar(32) DEFAULT NULL COMMENT '操作人名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
