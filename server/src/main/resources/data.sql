TRUNCATE TABLE users RESTART IDENTITY CASCADE;
TRUNCATE TABLE roles RESTART IDENTITY CASCADE;
TRUNCATE TABLE roles_users RESTART IDENTITY CASCADE;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";



INSERT INTO users (public_id, username, password, email, birthdate, title, level, image)
VALUES
    (uuid_generate_v4(), 'user1', crypt('password1', gen_salt('bf')), 'user1@example.com', '1990-01-01', 'Cadet', 10, 'https://fbi.cults3d.com/uploaders/29259792/illustration-file/eb222196-d4ac-4a7e-8e23-01526d0d8242/helldiver-SCOUT_2024.02.20_18.49.13_PathTracer_0000.png'),
    (uuid_generate_v4(), 'user2', crypt('password2', gen_salt('bf')), 'user2@example.com', '1991-02-01', 'Sergeant', 12, 'https://dotesports.com/wp-content/uploads/2024/02/HELLDIVERS2_padding-armor.jpg'),
    (uuid_generate_v4(), 'user3', crypt('password3', gen_salt('bf')), 'user3@example.com', '1992-03-01', 'Space Cadet', 25, 'https://i.kinja-img.com/image/upload/c_fill,h_675,pg_1,q_80,w_1200/500b29949183e2bdcb71c0d281458dcd.jpg'),
    (uuid_generate_v4(), 'user4', crypt('password4', gen_salt('bf')), 'user4@example.com', '1993-04-01', 'Chief', 50, 'image4.png'),
    (uuid_generate_v4(), 'user5', crypt('password5', gen_salt('bf')), 'user5@example.com', '1994-05-01', 'Master Sergeant', 29, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNRc7NTyt2m0ZE9lK9TKbI111RK5vIV4u8WQ&s'),
    (uuid_generate_v4(), 'user6', crypt('password6', gen_salt('bf')), 'user6@example.com', '1995-06-01', 'Chief', 105, 'https://cdn.mos.cms.futurecdn.net/222z2cVPy56NDqNndTe5nZ.jpg'),
    (uuid_generate_v4(), 'user7', crypt('password7', gen_salt('bf')), 'user7@example.com', '1996-07-01', 'Chief', 100, 'https://editors.dexerto.com/wp-content/uploads/2024/02/19/How-to-get-Helldivers-2-Twitch-drops-TR-117-Alpha-Commander-armor.jpg'),
    (uuid_generate_v4(), 'user8', crypt('password8', gen_salt('bf')), 'user8@example.com', '1997-08-01', 'Chief', 150, 'https://cdn.mos.cms.futurecdn.net/8SveXzuJEJSHWx5QJkL7Ni.jpg');

INSERT INTO roles (name)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN'),
    ('ROLE_GUILD_MEMBER'),
    ('ROLE_GUILD_MASTER');

INSERT INTO roles_users (users_id, roles_id)
SELECT id AS user_id, (SELECT id FROM roles WHERE name = 'ROLE_USER') AS role_id
FROM users;

INSERT INTO roles_users (users_id, roles_id)
SELECT id AS user_id, (SELECT id FROM roles WHERE name = 'ROLE_ADMIN') AS role_id
FROM users
WHERE username = 'user1';