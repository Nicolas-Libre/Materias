program Parcial_2023_6_6_T2;
Type
	empleado = record
		dni: integer;
		nom: string [30];
		apellido: string [30];
		edad: integer;
		domicilio: string [60];
		fecha_nac: string [30];
	end;

archivo = file of empleado;

procedure completarEmpleado (var e: empleado);
begin
	readln (e.nom);
	readln (e.apellido);
	readln (e.edad);
	readln (e.domicilio);
	readln (e.fecha_nac);
end;

function ExisteEmpleado (var a:archivo; dni: integer): boolean;
var
	ok: boolean;
	e:empleado;
begin
	reset (a);
	ok:=false;
	while ((not(EOF(a))) and (ok = false)) do begin
		read (a,e);
		if (e.dni = dni) then begin
			ok:=true;
		end;
	end;
	close (a);
	ExisteEmpleado:= ok;
end;
	
procedure AgregarEmpleado (var a: archivo);
var
	e: empleado;
	cabe: empleado;
begin
	
	readln (e.dni);
	if (not(ExisteEmpleado (a,e.dni)))then begin
		reset (a);
		completarEmpleado (e);
		read (a,cabe);
		if (cabe.dni= 0) then begin
			seek (a, filesize(a));
			write (a,e);
		end
		else begin
			seek (a, (cabe.dni) *-1);
			read (a, cabe);
			seek (a, filepos(a) -1);
			write (a, e);
			seek (a,0);
			write (a, cabe);
		end;
		close (a);
	end
	else writeln ('El empleado ya existe');
end;

procedure QuitarEmpleado (var a: archivo);
var
	dni: integer;
	cabe: empleado;
	e: empleado;
begin
	readln (dni);
	if (ExisteEmpleado (a, dni)) then begin
		reset (a);
		read (a, cabe);
		read (a, e);
		while (e.dni <> dni) do begin
			read (a,e);
		end;
		seek (a, filepos(a) -1);
		write (a, cabe);
		cabe.dni:= (filepos(a) -1) *-1;
		seek (a,0);
		write (a,cabe);
		close (a);
	end
	else writeln ('El empleado no existe');
end;
		

var
	a: archivo;
begin
	assign (a, 'lista invertida');
	AgregarEmpleado (a);
	QuitarEmpleado (a);
end.



