/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/5/29 9:55:07                            */
/*==============================================================*/


drop table if exists AREA;

drop table if exists BASE_INFO;

drop table if exists PARAM_DEFINE;

drop table if exists PARAM_DETAIL;

drop table if exists PRICE_INFO;

drop table if exists QUEUE_LOG;

drop table if exists TASK_CONF;

drop table if exists TASK_FAIL_DB;

drop table if exists TASK_MGR;

/*==============================================================*/
/* Table: AREA                                                  */
/*==============================================================*/
create table AREA
(
   ID                   int(8) auto_increment comment 'ID',
   AREA_CODE            varchar(8) comment '编码',
   AREA_NAME            varchar(16) comment '名称',
   PARENT_AREA_CODE     varchar(16) comment '父编码',
   PARENT_AREA_NAME     varchar(16) comment '父编码名称',
   REGION_CODE          varchar(16) comment '区域编码',
   REGION_NAME          varchar(16) comment '区域名称',
   PARENT_REGION_CODE   varchar(16) comment '父区域编码',
   PARENT_REGION_NAME   varchar(16) comment '父区域名称',
   REMARK               varchar(256) comment '备注',
   primary key (ID)
);

/*==============================================================*/
/* Table: BASE_INFO                                             */
/*==============================================================*/
create table BASE_INFO
(
   ID                   int(16) auto_increment comment 'ID',
   H_ID                 varchar(16) not null comment '房源编号',
   H_T_ROOM             int(2) comment '户型_室',
   H_T_HALL             int(2) comment '户型_厅',
   H_T_KITCHEN          int(2) comment '户型_厨',
   H_T_BATHROOM         int(2) comment '户型_卫',
   ROOM_SIZE            float(8) comment '建筑面积',
   ROOM_AGE             int(4) comment '年代',
   ROOM_TOWARDS         varchar(32) comment '朝向',
   ROOM_FLOOR           int(4) comment '楼层',
   ROOM_FLOOR_TOTAL     int(4) comment '楼层_总数',
   ROOM_STRUCTURE       varchar(32) comment '结构',
   ROOM_DECORATE        varchar(32) comment '装修',
   ROOM_TYPE            varchar(32) comment '住宅类型',
   ROOM_PROPERTY        varchar(32) comment '产权性质',
   ROOM_FEATURE         varchar(64) comment '房源特点',
   ROOM_SOURCE          varchar(32) comment '房源来源',
   ROOM_TITLE           varchar(128) comment '房源标题',
   VIEW_TIME            varchar(32) comment '看房时间',
   PROJECT_TYPE         varchar(32) comment '建筑类别',
   PROJECT_NAME         varchar(64) comment '楼盘名称',
   PROJECT_REGION_CODE  varchar(16) comment '楼盘区域',
   PROJECT_EQUIPMENT    varchar(128) comment '配套设施',
   RELEASE_TIME         datetime comment '发布时间',
   CREATE_TIME          datetime comment '创建时间',
   UPDATE_TIME          datetime comment '修改时间',
   REMARK               varchar(256) comment '备注',
   primary key (ID)
);

/*==============================================================*/
/* Table: PARAM_DEFINE                                          */
/*==============================================================*/
create table PARAM_DEFINE
(
   ID                   int(8) auto_increment comment 'ID',
   PARAM_CODE           varchar(32) comment '参数编码',
   PARAM_NAME           varchar(64) comment '参数名称',
   REMARK               varchar(256) comment '备注',
   primary key (ID)
);

/*==============================================================*/
/* Table: PARAM_DETAIL                                          */
/*==============================================================*/
create table PARAM_DETAIL
(
   PARAM_CODE           varchar(32) not null comment '参数编码',
   PARAM_VALUE          varchar(16) not null comment '参数值',
   PARAM_VALUE_NAME     varchar(32) comment '参数值名称',
   IDX                  int(4) comment '排列顺序',
   REMARK               varchar(256) comment '备注',
   primary key (PARAM_CODE, PARAM_VALUE)
);

/*==============================================================*/
/* Table: PRICE_INFO                                            */
/*==============================================================*/
create table PRICE_INFO
(
   H_ID                 varchar(16) comment '房源编号',
   TOTAL_PRICE          float(16) comment '总价',
   AVERAGE_PRICE        float(16) comment '均价',
   DOWN_PAYMENT         float(16) comment '参考首付',
   MONTH_PAYMENT        float(16) comment '参考月供',
   CREATE_TIME          datetime comment '创建时间',
   REMARK               varchar(256) comment '备注'
);

/*==============================================================*/
/* Table: QUEUE_LOG                                             */
/*==============================================================*/
create table QUEUE_LOG
(
   ID                   int(12) auto_increment comment 'ID',
   CREATE_TIME          datetime not null comment '创建时间',
   TOT                  int(32) comment '业务总量',
   APD                  int(32) comment '业务增量',
   AVG                  int(32) comment '业务均量',
   TIME_SEG             int(32) comment '时间间隔',
   Q_TOT                int(32) comment '队列总量',
   Q_APD                int(32) comment '队列增量',
   Q_AVG                int(32) comment '队列均量',
   REMARK               varbinary(256) comment '备注',
   primary key (ID)
);

/*==============================================================*/
/* Table: TASK_CONF                                             */
/*==============================================================*/
create table TASK_CONF
(
   ID                   int(12) auto_increment comment 'ID',
   TASK_BEG_NUM         int(32) not null comment '初始任务号',
   TASK_SEG_NUM         int(32) not null comment '执行任务段',
   VERSION              datetime not null comment '版本号',
   primary key (ID)
);

/*==============================================================*/
/* Table: TASK_FAIL_DB                                          */
/*==============================================================*/
create table TASK_FAIL_DB
(
   BEG_TASK_NUM         int(32) comment '开始任务号',
   END_TASK_NUM         int(32) comment '结束任务号',
   CREATE_TIME          datetime comment '创建时间'
);

/*==============================================================*/
/* Table: TASK_MGR                                              */
/*==============================================================*/
create table TASK_MGR
(
   ID                   int(12) auto_increment,
   T_ID                 varchar(128) not null comment 'ID_TIME_nextInt(1000)',
   T_STATE              varchar(3) not null comment 'REG:注册,EXE:正常,END:完成,FAL:失败',
   T_STATE_TIME         datetime not null comment '线程发送的最后一次心跳包时间',
   USER                 varchar(128) not null comment '创建线程的主机名称',
   REG_TIME             datetime not null comment '注册时间',
   END_TIME             datetime comment '完成时间',
   TASK_NUM             int(32) comment '任务总数',
   SUCC_NUM             int(32) comment '成功总数',
   FAIL_NUM             int(32) comment '失败总数',
   BEG_TASK_ID          varchar(32) comment '开始任务号',
   END_TASK_ID          varchar(32) comment '结束任务号',
   EXEC_MIL             int(32) comment '执行总时间',
   REMARK               varchar(256) comment '备注',
   primary key (ID)
);

insert into task_conf (task_beg_num, task_seg_num, version) values (160000000, 100, SYSDATE());