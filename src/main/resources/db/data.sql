INSERT INTO user_role(role_id, role_name, description) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb','admin', 'Base role for admin') ON CONFLICT DO NOTHING;
INSERT INTO user_role(role_id, role_name, description) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8','client', 'Base role for client') ON CONFLICT DO NOTHING;

INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e33', '/users', 'create.user', 'POST') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('2a861f86-5e1e-422c-9173-66b79928b346', '/users', 'get.user', 'GET') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('053119f1-5aaf-4259-aabe-5d2bd458c19d', '/login', 'login', 'POST') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('f87e6127-a551-4caa-95ed-a41171ee0aeb', '/orders', 'get.order', 'GET') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('a0b05a09-df8f-4057-b49a-34ddf0b43ffe', '/orders', 'create.order', 'POST') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('08f23e83-cf7d-41ec-97c9-222696a5d6a8', '/orders', 'update.order', 'PUT') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('2b478193-23fe-4647-9978-af031962e2fe', '/orders', 'delete.order', 'DELETE') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('188cfe58-7503-479d-8b76-dbd4f9ba5b95', '/items', 'get.item', 'GET') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('72eb9f65-556f-40a3-bc77-3efada7e5f78', '/items', 'create.item', 'POST') ON CONFLICT DO NOTHING;
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('46cdb2d3-46d6-45f7-8899-2759fea7c55f', '/items', 'update.item', 'PUT') ON CONFLICT DO NOTHING;

INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'ccc7ff73-1989-413a-ab52-9bec7a049e33') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '2a861f86-5e1e-422c-9173-66b79928b346') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '053119f1-5aaf-4259-aabe-5d2bd458c19d') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'f87e6127-a551-4caa-95ed-a41171ee0aeb') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '08f23e83-cf7d-41ec-97c9-222696a5d6a8') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '2b478193-23fe-4647-9978-af031962e2fe') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '188cfe58-7503-479d-8b76-dbd4f9ba5b95') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '72eb9f65-556f-40a3-bc77-3efada7e5f78') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', '46cdb2d3-46d6-45f7-8899-2759fea7c55f') ON CONFLICT DO NOTHING;

INSERT INTO role_permission(role_id, permission_id) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'ccc7ff73-1989-413a-ab52-9bec7a049e33') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', '053119f1-5aaf-4259-aabe-5d2bd458c19d') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'f87e6127-a551-4caa-95ed-a41171ee0aeb') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', 'a0b05a09-df8f-4057-b49a-34ddf0b43ffe') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', '2b478193-23fe-4647-9978-af031962e2fe') ON CONFLICT DO NOTHING;
INSERT INTO role_permission(role_id, permission_id) VALUES ('d5af90ef-7ef5-4e28-a5b1-55ad69e121a8', '188cfe58-7503-479d-8b76-dbd4f9ba5b95') ON CONFLICT DO NOTHING;
