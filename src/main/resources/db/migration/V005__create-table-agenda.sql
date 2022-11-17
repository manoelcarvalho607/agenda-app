create table tb_agenda(

	id bigint not null auto_increment,
   	status varchar(20) not null,
    date_request datetime not null,
    date_finishing datetime,
    date_scheduling_client date not null,
    time_scheduling_client time not null,
    cliente_id bigint not null,
    
    constraint pk_id_tb_agenda primary key(id),
	constraint fk_tb_agenda_cliente_id foreign key (cliente_id) references tb_clientstest (id)
    
);