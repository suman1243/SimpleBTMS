
--creating trigger for insert_bankinguser

		create or replace trigger accnum_trigger
		before insert
		on bankinguser
		referencing new as new
		for each row
		begin
		select acc_sequence.nextval into :new.accnum from dual;
		end;
		/

creating table
		--craete table banking user(name varchar(50),accnum varchar(50),password varchar(50))

--craeting sequence
		--create sequence acc_sequence
		--start with 220524001
		--increment by 1;