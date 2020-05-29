CREATE TABLE `tb_produce_version` IF NOT EXISTS(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品版本主键',
  `version_id` varchar(32) DEFAULT NULL COMMENT '产品版本uuid',
  `type` varchar(20) DEFAULT NULL COMMENT '产品版本类型 CTSERVER , DOLPHIN',
  `version` varchar(20) DEFAULT '1.0' COMMENT '海豚版本',
  `status` varchar(10) DEFAULT NULL COMMENT '0删除1启用',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
);

CREATE TABLE `tb_demand` IF NOT EXISTS(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '需求主键',
  `demand_id` varchar(32) DEFAULT NULL COMMENT '需求uuid',
  `production_site_name` varchar(200) DEFAULT NULL COMMENT '生产现场名',
  `dolphin_version` varchar(20) DEFAULT '1.0' COMMENT '海豚版本',
  `deploy_type` varchar(10) DEFAULT NULL COMMENT '部署类型 XZ 新增 SJ 升级',
  `ct_server_old_version` varchar(20) DEFAULT NULL COMMENT '产品原版本',
  `ct_server_new_version` varchar(20) DEFAULT NULL COMMENT '产品所需最新版本',
  `status` varchar(10) DEFAULT NULL COMMENT '需求状态 TGWJ 提供文件，BSZ 部署中 BSWC,部署完成',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;