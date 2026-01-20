program Parcial_2023_23_05;

Type
	profesional = record
		dni: integer;
		nombre: string [30];
		apellido: string [30];
		sueldo: real;
	end;
tArchivo = file of profesional;

procedure crear (var arch: tArchivo; var info: TEXT);
var
	pro: profesional;
begin
	rewrite (arch);
	reset (info);
	while (not(EOF(info))) do begin
		with pro do begin
			readln (info, dni, sueldo, nombre, apellido);
		end;
		write (arch, pro);
	end;
	close (info);
	close (arch);
end;

function ExisteProfesional (var arch: tArchivo; dni: integer) : boolean;
var
	ok:boolean;
	p: profesional;
begin
	reset (arch);
	ok:=false;
	while ((not(EOF(arch))) and (not ok)) do begin
		read (arch, p);
		if (p.dni = dni) then ok:=true;
	end;
	close (arch);
	ExisteProfesional:=ok;
end;

procedure agregar (var arch: tArchivo; p:profesional);
var
	cabe: profesional;
begin
	if (not(ExisteProfesional (arch, p.dni))) then begin
		reset (arch);
		read (arch, cabe);
		if (cabe.dni = 0) then begin
			seek (Arch, filesize (arch));
			write (arch, p);
		end
		else begin
			seek (arch, (cabe.dni *-1));
			read (arch, cabe);
			seek (arch, filepos(arch) -1);
			write (arch, p);
			seek (arch, 0);
			write (arch, cabe);
		end;
		close (Arch);
	end
	else writeln ('El profesional ya existe');
end;


// se supone que el archivo de bajas no existe y se crea dentro de este procedimiento. Assign programa principal;
procedure eliminar (var arch: tArchivo; DNI: integer; var bajas: TEXT);
var
	cabe: profesional;
	aux: profesional;
begin
	if (ExisteProfesional (arch, DNI)) then begin
		reset (arch);
		rewrite (bajas);
		read (arch, cabe);
		read (arch, aux);
		while (aux.dni <> DNI) do begin
			read (arch, aux);
		end;
		seek (arch, filepos (arch) -1);
		write (arch, cabe);
		cabe.dni:= ((filepos(arch) -1) * -1);
		seek (arch, 0);
		write (arch, cabe);
		with aux do begin
			writeln (bajas, dni, ' ', sueldo, ' ', nombre, ' ', apellido);
		end;
		close (bajas);
		close (arch);
	end
	else writeln ('El profesional no existe');
end;

var
	arch: tArchivo;
	informe: TEXT;
	bajas: TEXT;
	p:profesional;
begin
	crear (arch, informe);
	readln (p.dni);
	readln (p.nombre);
	readln (p.apellido);
	readln (p.sueldo);
	assign (arch, ' archivo binario');
	assign (informe, 'informe texto');
	assign (bajas, 'bajas realizadas');
	agregar(arch, p);
	eliminar (arch, 45, bajas);
end.
	
		

		






