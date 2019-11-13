CREATE TABLESPACE COMP_Project
DATAFILE 'C:\app\alfo\oradata\orcl\COMP_project.dbf'
SIZE 50M
AUTOEXTEND ON
NEXT 3M
MAXSIZE 500M;

CREATE USER compAdmin IDENTIFIED BY user1782
DEFAULT TABLESPACE COMP_Project          --사용자의 객체가 생성될 테이블 스페이스
TEMPORARY TABLESPACE temp;               --사용자의 작업처리를 위한 임시객체 생성장소 설정

GRANT CONNECT, RESOURCE TO compAdmin;





