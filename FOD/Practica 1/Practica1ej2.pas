program Practica1ej2;
type archivo= file of integer;

var
	archivo_logico: archivo;
	nombre: String;
	x:integer;
	i:integer;
	prom:real;
	cant:integer;
	menMilKi:integer;
begin
	i:=0;
	cant:=0;
	prom:=0;
	menMilKi:=0;
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
		prom:= prom + i;
		cant:= cant + 1;
		if i < 1500 then begin
			menMilKi:= menMilKi + 1;
		end;
		writeln ('El numero ingresado es: ', i);
	end;
	writeln('');
	writeln('');
	writeln ('El promedio es: ', prom/cant:2:2);
	writeln('');
	writeln('');
	writeln('Cantidad de numeros menores a 1500: ', menMilKi);
	writeln('El nombre del archivo es: ', nombre);
	Close (archivo_logico);
end.

