--CREATE DATABASE IF NOT EXISTS grab_third DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
drop table if exists t_vrv_config;
create table t_vrv_config (
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  ip VARCHAR(16) NOT NULL UNIQUE,
	name varchar(64) not null,
	cycle INT not null default 60000,
	last_refresh_date BIGINT not null default 0
);

ALTER TABLE t_vrv_config OWNER TO postgres;
COMMENT ON TABLE t_vrv_config IS 'vrv配置信息';
COMMENT ON COLUMN t_vrv_config.ip IS 'vrv服务器地址';
COMMENT ON COLUMN t_vrv_config.name IS 'vrv服务器名称';
COMMENT ON COLUMN t_vrv_config.cycle IS '刷新周期';
COMMENT ON COLUMN t_vrv_config.last_refresh_date IS 'vrv服务器刷新时间';

drop table if exists t_vrv_target;
create table t_vrv_target (
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  config_id uuid NOT NULL,
	sl INT not null,
	xmid INT not null,
	xmmc varchar(64)
);

ALTER TABLE t_vrv_target OWNER TO postgres;
COMMENT ON TABLE t_vrv_target IS 'vrv监控指标统计信息';
COMMENT ON COLUMN t_vrv_target.config_id IS 'vrv服务器配置信息';
COMMENT ON COLUMN t_vrv_target.sl IS 'vrv监控指标统计结果';
COMMENT ON COLUMN t_vrv_target.xmid IS 'vrv监控指标id';
COMMENT ON COLUMN t_vrv_target.xmmc IS 'vrv监控指标名称';

drop table if exists t_h3c_realtime_fault;
create table t_h3c_realtime_fault (
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  fault_id varchar(64) NOT NULL,
	level varchar(32),
	source varchar(128),
	fault_type varchar(32),
	info varchar(512),
	date_time varchar(32),
	analyse_report varchar(512)
);

ALTER TABLE t_h3c_realtime_fault OWNER TO postgres;
COMMENT ON TABLE t_h3c_realtime_fault IS 'h3c告警信息';
COMMENT ON COLUMN t_h3c_realtime_fault.fault_id IS '告警id';
COMMENT ON COLUMN t_h3c_realtime_fault.level IS '级别';
COMMENT ON COLUMN t_h3c_realtime_fault.source IS '源';
COMMENT ON COLUMN t_h3c_realtime_fault.fault_type IS '类型';
COMMENT ON COLUMN t_h3c_realtime_fault.info IS '信息';
COMMENT ON COLUMN t_h3c_realtime_fault.date_time IS '时间';
COMMENT ON COLUMN t_h3c_realtime_fault.analyse_report IS '分析报告';

drop table if exists t_idcs_notification;
create table t_idcs_notification (
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  notification_id varchar(32) NOT NULL,
	notification_type varchar(64),
	title varchar(512),
	date_time varchar(32),
	release_unit varchar(32),
	valid varchar(8),
	last_refresh_date BIGINT not null default 0
);

ALTER TABLE t_idcs_notification OWNER TO postgres;
COMMENT ON TABLE t_idcs_notification IS 'idcs通知';
COMMENT ON COLUMN t_idcs_notification.notification_id IS '通知id';
COMMENT ON COLUMN t_idcs_notification.notification_type IS '类型';
COMMENT ON COLUMN t_idcs_notification.title IS '标题';
COMMENT ON COLUMN t_idcs_notification.date_time IS '发布时间';
COMMENT ON COLUMN t_idcs_notification.release_unit IS '发布单位';
COMMENT ON COLUMN t_idcs_notification.valid IS '是否有效';
COMMENT ON COLUMN t_idcs_notification.last_refresh_date IS '刷新时间';

drop table if exists t_idcs_todo;
create table t_idcs_todo (
  id VARCHAR(32) PRIMARY KEY NOT NULL,
  todo_id varchar(32) NOT NULL,
	todo_type varchar(64),
	title varchar(512),
	last_refresh_date BIGINT not null default 0
);

ALTER TABLE t_idcs_todo OWNER TO postgres;
COMMENT ON TABLE t_idcs_todo IS 'idcs代办';
COMMENT ON COLUMN t_idcs_todo.todo_id IS '代办id';
COMMENT ON COLUMN t_idcs_todo.todo_type IS '类型';
COMMENT ON COLUMN t_idcs_todo.title IS '标题';
COMMENT ON COLUMN t_idcs_todo.last_refresh_date IS '刷新时间';










