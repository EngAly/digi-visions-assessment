DROP TABLE IF EXISTS "Training_details";
DROP  TABLE  IF EXISTS "User";

-- user table
create TABLE "User" (
	username varchar,
	user_id bigint,
	PRIMARY KEY(user_id)
);

-- Training_details table
create TABLE "Training_details" (
	user_training_id bigint,
	user_id bigint,
	training_id bigint,
	training_date date,
	CONSTRAINT FK_TRAINING_DETAILS_USER FOREIGN KEY ( user_id ) REFERENCES "User" ( user_id )
);