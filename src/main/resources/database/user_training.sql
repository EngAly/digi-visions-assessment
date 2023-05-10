-- user table
create TABLE "User" (
	username varchar NULL,
	user_id bigint NULL
);

-- user data
insert into "User"  (user_id, username) values (1,'John Doe');
insert into "User"  (user_id,username) values (2,'Jane Don');
insert into "User"  (user_id,username) values (3, 'Alice Jones');
insert into "User"  (user_id,username) values (4, 'Lisa Romero');

-- Training_details table
create TABLE "Training_details" (
	user_training_id bigint,
	user_id bigint,
	training_id bigint,
	training_date date
);

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

-- Query to get the list of users who took the training lesson more than once at the same day,
--grouped by user and training lesson, each ordered from the most recent lesson date to oldest
--date.
select
	u.username,
	u.user_id,
	td.training_id,
	td.training_date,
	count(u.user_id)
from
	"User" u
join "Training_details" td on
	u.user_id = td.user_id
group by
	u.username ,
	u.user_id,
	td.training_id,
	td.training_date
having
	count(u.user_id) > 1
order by
	td.training_date desc ;