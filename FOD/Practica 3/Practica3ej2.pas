program Practica3ej2;
Const
valorAlto = 9999;
type
asistente = record
	nro: integer;
	apellido: string [30];
	nombre: string [30];
	email: string [50];
	telefono: integer;
	dni: integer;
end;
archivoAs = file of asistente;
procedure leerAsistente (var a: asistente);
begin
	writeln ('Ingrese su numero de asistente ');
	readln (a.nro);
	if (a.nro <> -1) then begin
		writeln ('Ingrese su apellido ');
		readln (a.apellido);
		writeln ('Ingrese su nombre ');
		readln (a.nombre);
		writeln ('Ingrese su Email ');
		readln (a.email);
		writeln ('Ingrese su telefono ');
		readln (a.telefono);
		writeln ('Ingrese su dni ');
		readln (a.dni);
	end;
end;
procedure crearArchivo (var arch: archivoAs);
var
	a:asistente;
begin
	
	leerAsistente (a);
	while (a.nro <> -1) do begin
		write (arch, a);
		leerAsistente (a);
	end;
	
end;
procedure leerArch (var archivo: archivoAs; var a:asistente);
begin
	if (not(EOF(archivo))) then 
		read (archivo, a)
	else
		a.nro := valorAlto;
end;

procedure deleteMenorMil (var arch: archivoAs);
var
	auxA: asistente;
begin
	leerArch (arch, auxA);
	while (auxA.nro <> valorAlto) do begin
		if (auxA.nro < 1000) then begin
			auxA.nombre := '***';
			write (arch, auxA);
		end;
		leerArch (arch,auxA);
	end;
end;

var
	arch:archivoAs;
begin
	assign (arch, 'archivo_asistentes');
	rewrite (arch);
	crearArchivo (arch);
	close (arch);
	reset (arch);
	deleteMenorMil (arch);
	close (arch);
end.
