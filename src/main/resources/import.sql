                                                 -------------- Database assessment -------------
-- user data
insert into "User"  (user_id, username) values (1,'John Doe');
insert into "User"  (user_id,username) values (2,'Jane Don');
insert into "User"  (user_id,username) values (3, 'Alice Jones');
insert into "User"  (user_id,username) values (4, 'Lisa Romero');

-- Training_details data
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (1, 1, 1, '2015-08-02');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (2, 2, 1, '2015-08-03');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (3, 3, 2, '2015-08-02');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (4, 4, 2, '2015-08-04');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (5, 2, 2, '2015-08-03');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (6, 1, 1, '2015-08-02');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (7, 3, 2, '2015-08-04');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (8, 4, 3, '2015-08-03');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (9, 1, 4, '2015-08-03');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (10, 3, 1,'2015-08-02');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (11, 4, 2,'2015-08-04');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (12, 3, 2, '2015-08-02');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (13, 1, 1, '2015-08-02');
insert  into "Training_details" (user_training_id, user_id, training_id, training_date) values (14, 4, 3,'2015-08-03');


         --------------- application permission setup ----------------

-- permission_groups setup
insert into permission_groups (id , group_name) values (1,'admin group');
insert into permission_groups (id , group_name) values (2,'empployee group');

-- permissions setup
insert into permissions (id, user_email, permission_level, group_id) values (1,'user1@test.com',0,(select id from permission_groups where group_name='admin group'));
insert into permissions (id, user_email, permission_level, group_id) values (2,'user2@test.com', 1,(select id from permission_groups where group_name='admin group'));
insert into permissions (id, user_email, permission_level, group_id) values (3,'user3@test.com', 1,(select id from permission_groups where group_name='empployee group'));



