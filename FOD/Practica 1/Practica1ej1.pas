program Practica1ej1;
type archivo= file of integer;

var
	archivo_logico: archivo;
	nombre: String;
	x:integer;
	i:integer;
begin
	i:=0;
	writeln ('Ingrese el nombre del archivo');
	readln (nombre);
	assign(archivo_logico,nombre);
	writeln ('Ingrese el numero al archivo');
	readln (x);
	Rewrite (archivo_logico);
	while x <> 30000 do begin
		write (archivo_logico,x);
		writeln ('Ingrese el numero al archivo');
		readln (x);
	end;
	
	Close (archivo_logico);
	Reset (archivo_logico);
	while not EOF (archivo_logico) do begin
		read (archivo_logico, i);
		writeln ('El numero ingresado es: ', i);
	end;
	Close (archivo_logico)

end.
