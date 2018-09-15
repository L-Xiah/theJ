-- 创建学生表：
create table student (
	id number primary key, 
	name varchar2(20) not null,
	age number check(age > 0),
	score number(8,2)
)

-- 插入一条数据
insert into student values(
	seq_student_id_increment.nextval, 
	'Lilei', 20, 90.5
)

-- 创建一个自增序列
create sequence seq_student_id_increment
	increment by 1
	start with 1
	nomaxvalue
	nocycle
	nocache

-- 创建触发器
create trigger trg_student_identified
	before insert on student for each row
	begin
	select seq_student_id_increment.nextval into:new.id from dual;
	end;

