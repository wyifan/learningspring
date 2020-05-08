/*
 Navicat Premium Data Transfer

 Source Server         : PostgreSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 110007
 Source Host           : localhost:5432
 Source Catalog        : testcsvdb
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110007
 File Encoding         : 65001

 Date: 08/05/2020 23:43:14
*/


-- ----------------------------
-- Sequence structure for batch_job_execution_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."batch_job_execution_seq";
CREATE SEQUENCE "public"."batch_job_execution_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for batch_job_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."batch_job_seq";
CREATE SEQUENCE "public"."batch_job_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for batch_step_execution_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."batch_step_execution_seq";
CREATE SEQUENCE "public"."batch_step_execution_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for batch_job_execution
-- ----------------------------
DROP TABLE IF EXISTS "public"."batch_job_execution";
CREATE TABLE "public"."batch_job_execution" (
  "job_execution_id" int8 NOT NULL,
  "version" int8,
  "job_instance_id" int8 NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "start_time" timestamp(6),
  "end_time" timestamp(6),
  "status" varchar(10) COLLATE "pg_catalog"."default",
  "exit_code" varchar(2500) COLLATE "pg_catalog"."default",
  "exit_message" varchar(2500) COLLATE "pg_catalog"."default",
  "last_updated" timestamp(6),
  "job_configuration_location" varchar(2500) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for batch_job_execution_context
-- ----------------------------
DROP TABLE IF EXISTS "public"."batch_job_execution_context";
CREATE TABLE "public"."batch_job_execution_context" (
  "job_execution_id" int8 NOT NULL,
  "short_context" varchar(2500) COLLATE "pg_catalog"."default" NOT NULL,
  "serialized_context" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for batch_job_execution_params
-- ----------------------------
DROP TABLE IF EXISTS "public"."batch_job_execution_params";
CREATE TABLE "public"."batch_job_execution_params" (
  "job_execution_id" int8 NOT NULL,
  "type_cd" varchar(6) COLLATE "pg_catalog"."default" NOT NULL,
  "key_name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "string_val" varchar(250) COLLATE "pg_catalog"."default",
  "date_val" timestamp(6),
  "long_val" int8,
  "double_val" float8,
  "identifying" char(1) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for batch_job_instance
-- ----------------------------
DROP TABLE IF EXISTS "public"."batch_job_instance";
CREATE TABLE "public"."batch_job_instance" (
  "job_instance_id" int8 NOT NULL,
  "version" int8,
  "job_name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "job_key" varchar(32) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for batch_step_execution
-- ----------------------------
DROP TABLE IF EXISTS "public"."batch_step_execution";
CREATE TABLE "public"."batch_step_execution" (
  "step_execution_id" int8 NOT NULL,
  "version" int8 NOT NULL,
  "step_name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "job_execution_id" int8 NOT NULL,
  "start_time" timestamp(6) NOT NULL,
  "end_time" timestamp(6),
  "status" varchar(10) COLLATE "pg_catalog"."default",
  "commit_count" int8,
  "read_count" int8,
  "filter_count" int8,
  "write_count" int8,
  "read_skip_count" int8,
  "write_skip_count" int8,
  "process_skip_count" int8,
  "rollback_count" int8,
  "exit_code" varchar(2500) COLLATE "pg_catalog"."default",
  "exit_message" varchar(2500) COLLATE "pg_catalog"."default",
  "last_updated" timestamp(6)
)
;

-- ----------------------------
-- Table structure for batch_step_execution_context
-- ----------------------------
DROP TABLE IF EXISTS "public"."batch_step_execution_context";
CREATE TABLE "public"."batch_step_execution_context" (
  "step_execution_id" int8 NOT NULL,
  "short_context" varchar(2500) COLLATE "pg_catalog"."default" NOT NULL,
  "serialized_context" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "id" int4 NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default",
  "dept" varchar(50) COLLATE "pg_catalog"."default",
  "salary" int4,
  "time" timestamp(6)
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."batch_job_execution_seq"', 9, true);
SELECT setval('"public"."batch_job_seq"', 9, true);
SELECT setval('"public"."batch_step_execution_seq"', 9, true);

-- ----------------------------
-- Primary Key structure for table batch_job_execution
-- ----------------------------
ALTER TABLE "public"."batch_job_execution" ADD CONSTRAINT "batch_job_execution_pkey" PRIMARY KEY ("job_execution_id");

-- ----------------------------
-- Primary Key structure for table batch_job_execution_context
-- ----------------------------
ALTER TABLE "public"."batch_job_execution_context" ADD CONSTRAINT "batch_job_execution_context_pkey" PRIMARY KEY ("job_execution_id");

-- ----------------------------
-- Uniques structure for table batch_job_instance
-- ----------------------------
ALTER TABLE "public"."batch_job_instance" ADD CONSTRAINT "job_inst_un" UNIQUE ("job_name", "job_key");

-- ----------------------------
-- Primary Key structure for table batch_job_instance
-- ----------------------------
ALTER TABLE "public"."batch_job_instance" ADD CONSTRAINT "batch_job_instance_pkey" PRIMARY KEY ("job_instance_id");

-- ----------------------------
-- Primary Key structure for table batch_step_execution
-- ----------------------------
ALTER TABLE "public"."batch_step_execution" ADD CONSTRAINT "batch_step_execution_pkey" PRIMARY KEY ("step_execution_id");

-- ----------------------------
-- Primary Key structure for table batch_step_execution_context
-- ----------------------------
ALTER TABLE "public"."batch_step_execution_context" ADD CONSTRAINT "batch_step_execution_context_pkey" PRIMARY KEY ("step_execution_id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table batch_job_execution
-- ----------------------------
ALTER TABLE "public"."batch_job_execution" ADD CONSTRAINT "job_inst_exec_fk" FOREIGN KEY ("job_instance_id") REFERENCES "public"."batch_job_instance" ("job_instance_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table batch_job_execution_context
-- ----------------------------
ALTER TABLE "public"."batch_job_execution_context" ADD CONSTRAINT "job_exec_ctx_fk" FOREIGN KEY ("job_execution_id") REFERENCES "public"."batch_job_execution" ("job_execution_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table batch_job_execution_params
-- ----------------------------
ALTER TABLE "public"."batch_job_execution_params" ADD CONSTRAINT "job_exec_params_fk" FOREIGN KEY ("job_execution_id") REFERENCES "public"."batch_job_execution" ("job_execution_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table batch_step_execution
-- ----------------------------
ALTER TABLE "public"."batch_step_execution" ADD CONSTRAINT "job_exec_step_fk" FOREIGN KEY ("job_execution_id") REFERENCES "public"."batch_job_execution" ("job_execution_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table batch_step_execution_context
-- ----------------------------
ALTER TABLE "public"."batch_step_execution_context" ADD CONSTRAINT "step_exec_ctx_fk" FOREIGN KEY ("step_execution_id") REFERENCES "public"."batch_step_execution" ("step_execution_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
