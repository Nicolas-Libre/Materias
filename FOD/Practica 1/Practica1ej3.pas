program Practica1ej3;
type 
empleado = record
numero: integer;
apellido: String;
nombre: String;
edad:integer;
dni: integer;
end;
archivo = file of empleado;
procedure leerEmpleado (var e:empleado);
begin
	writeln('Ingrese el apellido ');
	readln (e.apellido);
	if e.apellido <> 'fin' then begin
		writeln('Ingrese el nombre ');
		readln (e.nombre);
		writeln('Ingrese el numero ');
		readln (e.numero);
		writeln('Ingrese la edad ');
		readln (e.edad);
		writeln('Ingrese el dni ');
		readln (e.dni);
	end;
end;

procedure imprimirEmpleado (i:empleado);
begin
	writeln ('Apellido: ', i.apellido);
	writeln ('Nombre: ', i.nombre);
	writeln ('Numero: ', i.numero);
	writeln ('Edad: ', i.edad);
	writeln ('DNI: ', i.dni);
	writeln ('');
	writeln ('-----------------');
	writeln ('');
end;

procedure mostrarOpciones();
begin
	writeln ('Ingrese la opcion deseada');
	writeln ('1 - Abrir Archivo ');
	writeln ('2 - Agregar Empleados al archivo (Apellido = "fin" para terminar)');
	writeln ('3 - Buscar Empleado (nombre o apellido) ');
	writeln ('4 - Mostrar todos los Empleados ');
	writeln ('5 - Mostrar jubilados (Mayores a 70)');
	writeln ('6 - Salir ');
end;

function buscarNombre (x: String; var arch:archivo) : boolean;
var
	i: empleado;
	existe: boolean;
begin
	seek (arch, 0);
	existe:= False;
	while not EOF (arch) do begin
		read (arch, i);
		if ((i.apellido = x) or (i.nombre = x)) then begin
			imprimirEmpleado (i);
			existe:= true;
		end;
	end;
	buscarNombre:= existe;
end;

procedure imprimirTodo (var arch:archivo);
var
	i:empleado;
begin
	seek (arch, 0);
	while not EOF (arch) do begin
		read (arch,i);
		imprimirEmpleado (i);
	end;
end;
var
	opcion: integer;
	archivo_logico: archivo;
	nombre: String;
	e: empleado;
	i: empleado;
	x: String;
	seCreo: boolean;
	encontre: boolean;
begin
	mostrarOpciones();
	readln (opcion);
	seCreo:= False;
	encontre:= false;
	while opcion <> 6 do begin
		if opcion = 1 then begin
			if seCreo = False then begin
				writeln('Ingrese el nombre del Archivo');
				readln (nombre);
				assign (archivo_logico,nombre);
				rewrite (archivo_logico);
				seCreo:= True;
			end
			else
				writeln ('El archivo ya se creo');
		end
		else if opcion = 2 then begin
			if seCreo = True then begin
				writeln('Ingrese los datos del empleado: ');
				leerEmpleado (e);
				while e.apellido <> 'fin' do begin
					write (archivo_logico, e);
					leerEmpleado (e);
				end;
			end
			else writeln ('El archivo no se creo');	
		end
		else if opcion = 3 then begin
			if seCreo = True then begin	
				writeln ('Ingrese el apellido o nombre a buscar');
				readln (x);
				encontre:= buscarNombre (x, archivo_logico);
				if encontre = False then writeln ('No existe el empleado');
			end
			else writeln ('El archivo no se creo');
		end
		else if opcion = 4 then begin
			if seCreo = True then begin
				imprimirTodo (archivo_logico);
			end
			else
				writeln ('El archivo no se creo');
		end
		else if opcion = 5 then begin
			if seCreo = True then begin
				seek (archivo_logico, 0);
				writeln ('Empleados proximos a jubilarse: ');
				while not EOF (archivo_logico) do begin
					read (archivo_logico, i);
					if i.edad > 70 then begin
						imprimirEmpleado (i);
					end;
				end;
			end
			else 
				writeln ('El archivo no se creo');
		end;
		mostrarOpciones();
		readln (opcion);
	end;
	if ((seCreo = true) and (opcion = 6)) then begin
		Close (archivo_logico);
		writeln ('Se cerro el archivo');
	end;

end.
	


