program Parcial_3;
Const
Type
empleado = record
	numero:integer;
	nombre: string [30];
	apellido: string [30];
	dni: integer;
	fecha: string [50];
	genero: boolean;
end;

arch_emp = file of empleado;


procedure leerEmpleado (var emp: empleado);
begin
	readln (emp.numero);
	readln (emp.nombre);
	readln (emp.apellido);
	readln (emp.dni);
	readln (emp.fecha);
	readln (emp.genero);
end;

function ExisteEmpleado (var arch: arch_emp; var cod: integer;) : integer;
var
	ok: boolean;
	emp: empleado;
	i:integer;
begin
	ok:=false;
	i:=0;
	reset (arch);
	while ((not(EOF(arch))) and (ok = false)) do begin
		read (arch, emp);
		if emp.numero = cod then
			ok:=true;
			i:= filepos(arch);
	end;
	close (arch);
	ExisteEmpleado:= i;
end;

procedure AltaEmpleado (var arch: arch_emp);
var
	nuevoEmp: empleado;
	cabe: empleado;
begin
	
	leerEmpleado (nuevoEmp);
	if ExisteEmpleado (arch, nuevoEmp.numero) == 0 then begin
		reset (arch);
		read (arch, cabe);
		if (cabe.numero = 0) then begin
			seek (arch, filepos(arch);
			write (arch, nuevoEmp);
		end
		else begin
			seek (arch, (cabe.numero * -1));
			read (arch, cabe);
			seek (arch, (filepos (arch) -1);
			write (arch nuevoEmp);
			//cabe.numero:= cabe.numero * -1;
			seek (arch, 0);
			write (arch, cabe);
		end;
		close (arch);
	end
	else
		writeln ('El empleado ya existe');
end;

procedure BajaEmpleado (var arch: arch_emp);
var
	num: integer;
	pos: integer;
	cabe: empleado;
begin
	readln (num);
	pos := ExisteEmpleado (arch, num);
	if (pos <> 0) then begin
		reset (arch);
		read (arch, cabe);
		seek (arch, filepos(pos);
		write (arch, cabe);
		cabe.numero:= pos *-1;
		seek (arch, 0);
		write (arch, cabe);
		close (arch);
	end
	else begin
		writeln ('el empleado no existe');	
	end;
end;








		
		











