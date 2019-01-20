
insert INTO jpa.role(role_name) VALUES ('USER');
insert INTO jpa.role(role_name) VALUES ('ADMIN');

INSERT INTO jpa.member_role (member_id,role_id) VALUES (1,1);
INSERT INTO jpa.member_role (member_id,role_id) VALUES (2,2);