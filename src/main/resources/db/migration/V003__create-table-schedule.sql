create table tb_schedules(

	id bigint not null auto_increment,
    client_id bigint not null,
    status varchar(20) not null,
    date_request datetime not null,
    date_finishing datetime,
    date_scheduling_client date not null,
    time_scheduling_client time not null,
    
    constraint pk_id_schedule primary key(id),
	constraint fk_tb_schedules_client_id foreign key (client_id) references tb_clients (id)
    
);