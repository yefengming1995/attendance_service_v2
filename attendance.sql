/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/12 19:57:08                           */
/*==============================================================*/

/*==============================================================*/
/* Author:Lanshuxiu 170327097                      */
/*==============================================================*/

drop table if exists t_admin;

drop table if exists t_course;

drop table if exists t_dictionary;

drop table if exists t_dictionary_detail;

drop table if exists t_major;

drop table if exists t_permission;

drop table if exists t_place;

drop table if exists t_role;

drop table if exists t_signIn;

drop table if exists t_student;

drop table if exists t_student_course;

drop table if exists t_teacher;

drop table if exists t_teacher_course;

drop table if exists t_timetable;

drop table if exists t_user;

drop table if exists t_user_login;

drop table if exists t_user_permission;

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
   admin_id             varchar(50) not null,
   admin_pass           varchar(50) not null,
   admin_name           varchar(50),
   admin_sex            varchar(30),
   admin_tel            varchar(30),
   role_idm             varchar(30),
   primary key (admin_id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;  

alter table t_admin comment '管理员表';

/*==============================================================*/
/* Table: t_course                                              */
/*==============================================================*/
create table t_course
(
   course_id            varchar(50) not null,
   place_id             varchar(50),
   time_unitId          int,
   course_name          varchar(50),
   course_score         varchar(50),
   course_time          varchar(50),
   first_week           varchar(50),
   week_begin           int,
   week_end             int,
   primary key (course_id)
);

alter table t_course comment '课程表';

/*==============================================================*/
/* Table: t_dictionary                                          */
/*==============================================================*/
create table t_dictionary
(
   dictnry_id           varchar(50) not null,
   dictnry_descript     varchar(100),
   date:dictnry_set_time date,
   dictnry_set_pers     varchar(50),
   dictnry_mdfy_time    date,
   dictnry_mdfy_pers    varchar(50),
   primary key (dictnry_id)
);

alter table t_dictionary comment '数据字典表';

/*==============================================================*/
/* Table: t_dictionary_detail                                   */
/*==============================================================*/
create table t_dictionary_detail
(
   dictionary_detail_recd_id int not null,
   dictnry_id           varchar(50),
   item_key             varchar(50),
   item_value           varchar(50),
   value_isDefault      int,
   dictnry_detail_set_time date,
   dictnry_detail_set_pers varchar(50),
   dictnry_detail_mdfy_time date,
   dictnry_detail_mdfy_pers varchar(50),
   primary key (dictionary_detail_recd_id)
);

alter table t_dictionary_detail comment '数据字典明细表';

/*==============================================================*/
/* Table: t_major                                               */
/*==============================================================*/
create table t_major
(
   major_id             varchar(50) not null,
   major_name           varchar(100),
   major_college        varchar(100),
   primary key (major_id)
);

alter table t_major comment '专业表';

/*==============================================================*/
/* Table: t_permission                                          */
/*==============================================================*/
create table t_permission
(
   perms__id            varchar(50) not null,
   perms_name           varchar(50),
   perms_addrs          varchar(50),
   perms_way            varchar(50),
   value_isDefault      int,
   perms_isPage         int,
   perms_isAction       int,
   perms_descript       varchar(100),
   perms_level          int,
   perms_positn         int,
   perms_path           varchar(50),
   parentId             int,
   dictnry_detail_set_time date,
   dictnry_detail_set_pers varchar(50),
   dictnry_detail_mdfy_time date,
   dictnry_detail_mdfy_pers varchar(50),
   primary key (perms__id)
);

alter table t_permission comment '权限表';

/*==============================================================*/
/* Table: t_place                                               */
/*==============================================================*/
create table t_place
(
   place_id             varchar(50) not null,
   place_name           varchar(50),
   place_longitude      int,
   place_latitude       int,
   primary key (place_id)
);

alter table t_place comment '教学场所';

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   role_id              varchar(50) not null,
   role_name            varchar(50),
   role_set_time        date,
   role_set_pers        varchar(50),
   role_mdfy_time       date,
   role_mdfy_pers       varchar(50),
   primary key (role_id)
);

alter table t_role comment '角色表';

/*==============================================================*/
/* Table: t_signIn                                              */
/*==============================================================*/
create table t_signIn
(
   sign_id              int not null,
   sign__stuId          varchar(50),
   sign_courseId        varchar(50),
   signIn_time          datetime,
   signOut_time         datetime,
   signIn_longitude     int,
   signIn_latitude      int,
   sign_time_sta        int,
   sign_scope           int,
   primary key (sign_id)
);

alter table t_signIn comment '签到表';

/*==============================================================*/
/* Table: t_student                                             */
/*==============================================================*/
create table t_student
(
   student_id           varchar(50) not null,
   student_passwd         varchar(50) not null,
   major_id             varchar(50),
   student_name         varchar(50),
   student_sex          varchar(30),
   student_tel          varchar(50),
   role_ids             varchar(30),
   primary key (student_id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8; 

alter table t_student comment '学生表';

/*==============================================================*/
/* Table: t_student_course                                      */
/*==============================================================*/
create table t_student_course
(
   student_id           varchar(50) not null,
   course_id            varchar(50) not null,
   primary key (student_id, course_id)
);

alter table t_student_course comment '学生选课表';

/*==============================================================*/
/* Table: t_teacher                                             */
/*==============================================================*/
create table t_teacher
(
   teacher_id           varchar(50) not null,
   teacher_passwd         varchar(50) not null,
   major_id             varchar(50),
   teacher_name         varchar(50),
   teacher_sex          varchar(30),
   teacher_tel          varchar(30),
   role_idr             varchar(30),
   primary key (teacher_id)
);

alter table t_teacher comment '教师表';

/*==============================================================*/
/* Table: t_teacher_course                                      */
/*==============================================================*/
create table t_teacher_course
(
   teacher_id           varchar(50) not null,
   course_id            varchar(50) not null,
   primary key (teacher_id, course_id)
);

alter table t_teacher_course comment '教师授课表';

/*==============================================================*/
/* Table: t_timetable                                           */
/*==============================================================*/
create table t_timetable
(
   time_unitId          int not null,
   day                  varchar(50),
   class_units          varchar(50),
   class_begin          time,
   class_over           time,
   primary key (time_unitId)
);

alter table t_timetable comment '作息时间表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   user_id              varchar(50) not null,
   role_id              varchar(50),
   user_paswd           varchar(50),
   user_name            varchar(50),
   last_login           date,
   user_pict            longblob,
   primary key (user_id)
);

alter table t_user comment '用户基本信息表';

/*==============================================================*/
/* Table: t_user_login                                          */
/*==============================================================*/
create table t_user_login
(
   login_recd_id        int not null,
   user_id              varchar(50),
   login_id             varchar(50),
   login_paswd          varchar(50),
   login_way            int,
   primary key (login_recd_id)
);

alter table t_user_login comment '用户登录信息表';

/*==============================================================*/
/* Table: t_user_permission                                     */
/*==============================================================*/
create table t_user_permission
(
   user_id              varchar(50) not null,
   perms__id            varchar(50) not null,
   primary key (user_id, perms__id)
);

alter table t_user_permission comment '用户权限关系表';

alter table t_course add constraint FK_t_class_place foreign key (place_id)
      references t_place (place_id) on delete restrict on update restrict;

alter table t_course add constraint FK_t_class_time foreign key (time_unitId)
      references t_timetable (time_unitId) on delete restrict on update restrict;

alter table t_dictionary_detail add constraint FK_dictionary foreign key (dictnry_id)
      references t_dictionary (dictnry_id) on delete restrict on update restrict;

alter table t_student add constraint FK_t_stu_major foreign key (major_id)
      references t_major (major_id) on delete restrict on update restrict;

alter table t_student_course add constraint FK_t_student_course foreign key (student_id)
      references t_student (student_id) on delete restrict on update restrict;

alter table t_student_course add constraint FK_t_student_course2 foreign key (course_id)
      references t_course (course_id) on delete restrict on update restrict;

alter table t_teacher add constraint FK_t_tea_major foreign key (major_id)
      references t_major (major_id) on delete restrict on update restrict;

alter table t_teacher_course add constraint FK_t_teacher_course foreign key (teacher_id)
      references t_teacher (teacher_id) on delete restrict on update restrict;

alter table t_teacher_course add constraint FK_t_teacher_course2 foreign key (course_id)
      references t_course (course_id) on delete restrict on update restrict;

alter table t_user add constraint FK_t_user_role foreign key (role_id)
      references t_role (role_id) on delete restrict on update restrict;

alter table t_user_login add constraint FK_t_user_login foreign key (user_id)
      references t_user (user_id) on delete restrict on update restrict;

alter table t_user_permission add constraint FK_t_user_permission foreign key (user_id)
      references t_user (user_id) on delete restrict on update restrict;

alter table t_user_permission add constraint FK_t_user_permission2 foreign key (perms__id)
      references t_permission (perms__id) on delete restrict on update restrict;





create table t_course
(
   course_id            varchar(50) not null,
   place_id             varchar(50),
   time_unitId          int,
   course_name          varchar(50),
   course_score         varchar(50),
   course_single_double varchar(50),
   course_day            varchar(50),
   first_week           varchar(50),
   week_begin           int,
   week_end             int,
   primary key (course_id)
);

alter table t_course comment '课程表';




create table t_course
(
   course_id            varchar(50) not null,
   place_id             varchar(50),
   place_name           varchar(50),
   course_name          varchar(50),
   course_score         varchar(50),
   course_time          varchar(50),
   course_single_double varchar(50),
   course_day           varchar(50),
   class_scope          varchar(50),
   course_towho         varchar(50),
   class_weekscope      varchar(50),
   primary key (course_id)
);

alter table t_course comment '课程表';