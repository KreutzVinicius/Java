create table pessoa(
	id serial,
	nome varchar (50),
	cpf int,
	telefone int,
	primary key (id)
);

create table endereco(
	id serial,
	rua varchar (50),
	numero integer,
	cidade varchar (50),
	id_pessoa integer,
	primary key (id),
	foreign key (id_pessoa) references pessoa
	);
)