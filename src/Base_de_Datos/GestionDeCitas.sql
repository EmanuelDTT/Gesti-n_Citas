create database gestion_de_citas;

create table Medico(
idMedico int  primary key auto_increment,
MediIndentificacion varchar (40) not null unique,
MedNombre varchar (40) not Null,
MedApellido varchar (40) not null,
MedEspecialidad varchar (20) not null,
MedTelefono char (15) not null,
MedCorreo varchar (45) not null,
MedFoto longblob
);

alter table Medico modify MedEspecialidad varchar  (60) not null;

create table Empleado(
IdEmpleado int  Primary key auto_increment,
EmpIdentificacion varchar (40) not null unique,
EmpNombre varchar (40) not null,
EmpApellido varchar (40) not null,
EmpUsuario varchar (40) not null,
EmpContra varchar (40) not null,
EmpTipo varchar (50) not null,
EmpFoto longblob
);

create table Paciente(
IdPaciente int  primary key auto_increment,
PacIdentifiacion varchar (40) not null unique,
PacNombre  varchar (40) not null,
PacApellidos varchar (40) not null,
PacFechaNac date ,
PacSexo Enum ("Masculino", "Femenino") not null,
PacFoto  longblob
);

create table Consultorio(
IdConsultorio int  Primary key auto_increment,
NumConsul int not null unique unique,
ConNombre varchar (40) not null
);


create table Citas (
IdCitas Int  primary key unique auto_increment,
CitFecha date not null,
CitHora Time,
CitEstado Enum("Asiganada", "Atendida", "no asigando"),
CitObservacion text (500),
IDPAC int not null,
IDMEC int not null,
IDEMPLE int not null,
IDCONSUL int not null,
foreign key fk1 (IDPAC) references Paciente (IdPaciente),
foreign key fk2 (IDMEC) references Medico (IdMedico),
foreign key fk3 (IDEMPLE) references Empleado (IdEmpleado),
foreign key fk4 (IDCONSUL) references Consultorio (IdConsultorio)
);

alter table Citas modify CitHora varchar(50) not null;
