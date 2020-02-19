DROP TABLE IF EXISTS tb_order;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单uuid',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `account` bigint(20) DEFAULT NULL COMMENT '订单金额 单位分',
  `user_name`
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;