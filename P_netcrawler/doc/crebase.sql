------------------------------------------------------------------------------------------------
--20140610
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/6/10 11:31:38                           */
/*==============================================================*/


drop table if exists NET_INDEX;

drop table if exists NET_INFO;

drop table if exists NET_INFO_FAIL;

drop table if exists NET_INFO_SUCCESS;

drop table if exists NET_STATUS;

drop table if exists NET_QUEUE_LOG;

drop table if exists NET_LOG;

/*==============================================================*/
/* Table: NET_INDEX                                             */
/*==============================================================*/
create table NET_INDEX
(
   NET_ID               int(12) not null comment '标识',
   NET_URL              varchar(100) not null comment '网址',
   STS_ID               int(2) comment '状态',
   EXEC_MSG             varchar(100) comment '异常原因',
   CREATE_TIME          datetime comment '创建时间',
   UPDATE_TIME          datetime comment '状态时间',
   primary key (NET_ID)
);

/*==============================================================*/
/* Table: NET_INFO                                              */
/*==============================================================*/
create table NET_INFO
(
   NET_ID               int(12) not null comment '标识',
   ENCODE               varchar(32) comment '编码',
   NET_TITLE            varchar(128) comment '标题',
   NET_KEYS             varchar(256) comment '关键字',
   NET_DESC             varchar(512) comment '描述',
   CREATE_TIME          datetime comment '创建时间',
   RES_CODE             varchar(16) comment '返回编码',
   PARSE_TIME           int(10) comment '解析时间',
   primary key (NET_ID)
);

/*==============================================================*/
/* Table: NET_INFO_FAIL                                         */
/*==============================================================*/
create table NET_INFO_FAIL
(
   NET_ID               int(12) not null comment '标识',
   primary key (NET_ID)
);

/*==============================================================*/
/* Table: NET_INFO_SUCCESS                                      */
/*==============================================================*/
create table NET_INFO_SUCCESS
(
   NET_ID               int(12) not null comment '标识',
   primary key (NET_ID)
);

/*==============================================================*/
/* Table: NET_STATUS                                            */
/*==============================================================*/
create table NET_STATUS
(
   STS_ID               int(2) not null comment '标识',
   STS_NAME             varchar(20) comment '名称',
   NOTE                 varchar(256) comment '备注',
   primary key (STS_ID)
);

/*==============================================================*/
/* Table: NET_QUEUE_LOG                                         */
/*==============================================================*/
create table NET_QUEUE_LOG
(
   LOG_ID               int(12) auto_increment not null,
   QUE_TYPE             int(2) comment '1:任务队列;2:索引新增队列;3:索引变更队列;4:数据队列;',
   QUE_SIZE             int(10),
   QUE_LEN              int(10),
   QUE_CURR_LEN         int(10) comment '记录队列的当前值',
   CONS_NUM             int(10),
   CONS_TIME            int(10) comment '消费队列的时间间隔，单位秒',
   CREATE_TIME          datetime,
   NOTE                 varchar(256),
   primary key (LOG_ID)
);

/*==============================================================*/
/* Table: NET_LOG                                               */
/*==============================================================*/
create table NET_LOG
(
   LOG_ID               int(12) auto_increment not null comment '日志流水',
   CREATE_TIME          datetime comment '创建时间',
   TIME_SEG             int(10) comment '时间间隔',
   TIME_UNIT            int(2) comment '时间单位(1:秒;2:分;3:小时;4:天;5:月;6:年;)',
   TOTAL_NUM            int(16) comment '数据总量',
   TOTAL_NUM_APPD       int(10) comment '数据增量',
   STS_10               int(10),
   STS_11               int(10),
   STS_12               int(10),
   STS_13               int(10),
   STS_21               int(10),
   STS_10_APPD          int(10),
   STS_11_APPD          int(10),
   STS_12_APPD          int(10),
   STS_13_APPD          int(10),
   STS_21_APPD          int(10),
   NOTE                 varchar(256),
   primary key (LOG_ID)
);



------------------------------------------------------------------------------------------------
--201403
insert into net_addr(net_id, net_url, sts_id, create_time, update_time)values(0, 'http://www.baidu.com', 11, now(), now());

drop table net_status;
drop table net_log;
drop table net_addr;
drop table net_addr_ext;
drop table net_addr_compare;

create table net_status(
sts_id int(2) not null,
sts_name VARCHAR(20),
note VARCHAR(256));
insert into net_status(sts_id, sts_name, note) values( 10, '初始', '');
insert into net_status(sts_id, sts_name, note) values( 11, '新增', '');
insert into net_status(sts_id, sts_name, note) values( 12, '处理', '');
insert into net_status(sts_id, sts_name, note) values( 13, '完成', '');
insert into net_status(sts_id, sts_name, note) values( 21, '异常', '');

create table net_addr(
net_id int(12) not null auto_increment PRIMARY KEY,
net_url VARCHAR(100) not null,
sts_id int(2) not null,
exec_msg VARCHAR(100),
create_time datetime not null,
update_time datetime not null);
alter table net_addr add index idx_net_addr (net_url);
alter table net_addr add unique(net_url);

create table net_addr_ext(
net_id int(12) not null PRIMARY KEY,
res_code varchar(10),
encode varchar(20),
net_title varchar(100),
net_key varchar(200),
net_desc varchar(500),
parse_time int(10),
create_time datetime);

create table net_log(
log_id int(12) not null auto_increment PRIMARY KEY,
create_time datetime,
time_segm int(12),
time_unit int(2),
all_amt int(12),
sts10_amt int(12),
sts11_amt int(12),
sts12_amt int(12),
sts13_amt int(12),
sts21_amt int(12),
all_ext_amt int(12),
rq_appd_amt int(12),
wq_pars_amt int(12),
appd_amt int(12),
pars_amt int(12));

create table net_addr_compare(
net_url_cmp VARCHAR(100) not null PRIMARY KEY,
t_id varchar(20));