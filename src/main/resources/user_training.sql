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