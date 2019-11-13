CREATE TABLESPACE COMP_Project
DATAFILE 'C:\app\alfo\oradata\orcl\COMP_project.dbf'
SIZE 50M
AUTOEXTEND ON
NEXT 3M
MAXSIZE 500M;

CREATE USER compAdmin IDENTIFIED BY user1782
DEFAULT TABLESPACE COMP_Project          --������� ��ü�� ������ ���̺� �����̽�
TEMPORARY TABLESPACE temp;               --������� �۾�ó���� ���� �ӽð�ü ������� ����

GRANT CONNECT, RESOURCE TO compAdmin;





