CREATE TABLE TB_AREA (
AREA_ID NUMBER(2),
AREA_NAME VARCHAR2(50) NOT NULL UNIQUE,
PRIORITY NUMBER(2) DEFAULT (0) NOT NULL ,
CREATE_TIME DATE DEFAULT NULL,
LAST_EDIT_TIME DATE DEFAULT NULL,
CONSTRAINT TB_AREA_PK PRIMARY KEY (AREA_ID)
);

CREATE SEQUENCE TB_AREA_SEQ START WITH 1 INCREMENT BY 1;



insert into tb_area(area_id,
                    area_name,
                    priority,
                    create_time)
values(tb_area_seq.nextval,'North York',2,sysdate);                    


insert into tb_area(area_id,
                    area_name,
                    priority,
                    create_time)
values(tb_area_seq.nextval,'Toronto',1,sysdate);             


insert into tb_area(area_id,
                    area_name,
                    priority,
                    create_time)
values(tb_area_seq.nextval,'Markham',3,sysdate);  