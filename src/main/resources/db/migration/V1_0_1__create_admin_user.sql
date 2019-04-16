insert IGNORE into roles(role_id, role) VALUE (1, 'admin');

insert IGNORE into users(username, password, email, first_name, last_name, is_account_non_expired,
                         is_account_non_locked, is_credentials_non_expired, is_enabled)
values ('XPlay', '$2a$10$cJTYjQ5wj.w8cGiYxqEy6.j4rLBJ5Lprdx7Iz2QGxZbfQxPhsAgRS', 'j_adamczyk@hotmail.com', 'Jan',
        'Adamczyk', true, true, true, true);

insert IGNORE into users_authorities(jwt_user_id, authorities_role_id)
SELECT users.id, roles.role
from users,
     roles
where username = 'XPlay'
  and role = 'admin;'