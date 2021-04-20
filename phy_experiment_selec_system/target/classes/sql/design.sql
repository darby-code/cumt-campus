CREATE TABLE experiment(
experiment_id int(8) NOT NULL AUTO_INCREMENT COMMENT '每个物理实验唯一标识符',
experiment_name varchar(100) NOT NULL COMMENT '物理实验名称',
experiment_time TIMESTAMP NOT NULL,
experiment_place VARCHAR(50) NOT NULL,
capacity int(5) NOT NULL COMMENT '物理实验可选容量',
teacher_id int(11) NOT NULL COMMENT '上物理实验教师id',
selected_number int(5) NOT NULL COMMENT '物理实验已选容量',
PRIMARY KEY(experiment_id)
)ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

CREATE TABLE student(
student_id INT(11) NOT NULL COMMENT '学生学号，也是账号',
student_name VARCHAR(50) NOT NULL COMMENT '学生姓名',
password VARCHAR(100) NOT NULL COMMENT '学生登录密码',
college_id INT(11) NOT NULL COMMENT '学生所在学院id',
college_name VARCHAR(50) NOT NULL COMMENT '学生所在学院名称',
PRIMARY KEY(student_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE college(
college_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '学院id',
college_name VARCHAR(50) NOT NULL COMMENT '学院名称',
PRIMARY KEY(college_id)
)ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8;

CREATE TABLE teacher(
teacher_id INT(11) NOT NULL COMMENT '教师工号',
teacher_name VARCHAR(50) NOT NULL COMMENT '教师姓名',
password VARCHAR(100) NOT NULL COMMENT '登录密码',
PRIMARY KEY(teacher_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE experiment_selected_list(
serial_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '学生选择实验后的流水号，唯一标识符',
student_id INT(11) NOT NULL COMMENT '学生学号',
experiment_id INT(8) NOT NULL COMMENT '学生选择实验的id',
score INT(11) NOT NULL COMMENT '学生实验分数',
PRIMARY KEY(serial_id)
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

CREATE TABLE experiment_limit_list(
condition_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '限制条件唯一标识符',
experiment_id INT(8) NOT NULL COMMENT '具有限制条件的实验',
college_id INT(11) NOT NULL COMMENT '能选该实验的学院id',
PRIMARY KEY(condition_id)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

ALTER TABLE teacher ADD INDEX (teacher_name(8));

ALTER TABLE college ADD UNIQUE (college_name(10));

ALTER TABLE student ADD UNIQUE (student_name(8));
ALTER TABLE student ADD INDEX (college_name(10));
ALTER TABLE student ADD FOREIGN KEY (college_id)
REFERENCES college (college_id) ON UPDATE CASCADE;

ALTER TABLE experiment ADD UNIQUE (experiment_name(10));
ALTER TABLE experiment ADD INDEX (teacher_id);
ALTER TABLE experiment ADD FOREIGN KEY (teacher_id)
REFERENCES teacher (teacher_id) ON DELETE CASCADE ON UPDATE CASCADE ;

ALTER TABLE experiment_selected_list ADD UNIQUE (student_id);
ALTER TABLE experiment_selected_list ADD FOREIGN KEY (student_id)
REFERENCES student (student_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE experiment_selected_list ADD FOREIGN KEY (experiment_id)
REFERENCES experiment (experiment_id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE experiment_limit_list ADD FOREIGN KEY (experiment_id)
REFERENCES experiment (experiment_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE experiment_limit_list ADD FOREIGN KEY (college_id)
REFERENCES college (college_id) ON UPDATE CASCADE ON DELETE CASCADE;



