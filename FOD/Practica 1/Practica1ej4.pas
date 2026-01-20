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
	writeln ('6 - Agregar Empleado al final');
	writeln ('7 - Modificar edad de un empleado'); 
	writeln ('8 - Hacer archivo de texto');
	writeln ('9 - Hacer archivo de texto sin DNI'); 
	writeln ('00 - Salir ');
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

function buscarNombre2 (z: integer; var arch:archivo) : boolean;
var
	i: empleado;
	existe: boolean;
begin
	seek (arch, 0);
	existe:= False;
	while ((not EOF (arch)) and (existe = False)) do begin
		read (arch, i);
		if  (i.numero = z) then begin
			existe:= true;
		end;
	end;
	buscarNombre2:= existe;
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

procedure deBinarioATexto (var arch: archivo; var archTXT: Text);
var
	i:empleado;
begin
	while not EOF (arch) do begin
		read (arch,i);
		WriteLn (archTXT,'Apellido: ',i.apellido,' Nombre: ',i.nombre, ' Numero: ',i.numero, ' Edad: ',i.edad, ' Dni: ',i.dni);
		
	end;
end;

procedure deBinarioATextoNoDNI (var arch: archivo; var archTXT2: Text);
var
	i:empleado;
begin
	while not EOF (arch) do begin
		read (arch, i);
		if i.dni = 00 then begin
			WriteLn (archTXT2,'Apellido: ',i.apellido,' Nombre: ',i.nombre, ' Numero: ',i.numero, ' Edad: ',i.edad, ' Dni: ',i.dni);
		end;
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
	z: integer;
	archivo_texto: Text;
	archivo_texto2: Text;
begin
	mostrarOpciones();
	readln (opcion);
	seCreo:= False;
	encontre:= false;
	while opcion <> 00 do begin
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
		end
		else if opcion = 6 then begin
			if seCreo = True then begin
				writeln ('Ingrese el codigo de empleado');
				readln (z); 
				encontre := buscarNombre2 (z, archivo_logico);
				if encontre = True then begin
					writeln ('El empleado ya existe');
				end
				else
					writeln ('Ingrese los datos del empleado');
					leerEmpleado (e);
					if z <> e.numero then
						writeln ('Los codigos no coinciden')
					else
						write (archivo_logico, e);
			end
			else
				writeln ('El archivo no se Creo');
		end
		else if opcion = 7 then begin
			if seCreo = True then begin
				writeln ('Ingrese el codigo de empleado');
				readln (z); 
				encontre := buscarNombre2 (z, archivo_logico);
				if encontre = False then begin
					writeln ('El empleado no existe');
				end
				else begin
					read (archivo_logico, i);
					writeln ('Ingrese la nueva edad');
					readln (z);
					i.edad := z;
					write (archivo_logico, i);
				end;
			end	
			else
				writeln ('El archivo no se Creo');
		end
		else if opcion = 8 then begin
			if seCreo = True then begin
				nombre:= 'todos_empleados.txt';
				assign (archivo_texto, nombre);
				Rewrite (archivo_texto);
				seek (archivo_logico, 0);
				deBinarioATexto (archivo_logico, archivo_texto);
				Close (archivo_texto);
			end
			else
				writeln ('El archivo Binario no se Creo');
		end
		else
			if opcion = 9 then begin
				if seCreo = True then begin
					nombre:= 'faltaDNIEmpleado.txt';
					assign (archivo_texto2, nombre);
					Rewrite (archivo_texto2);
					seek (archivo_logico, 0);
					deBinarioATextoNoDNI (archivo_logico, archivo_texto2);
					Close (archivo_texto2);
				end
				else
					writeln ('El archivo binario no se Creo');
			end;
		mostrarOpciones();
		readln (opcion);
	end;
	if ((seCreo = true) and (opcion = 00)) then begin
		Close (archivo_logico);
		writeln ('Se cerro el archivo');
	end;

end.
	


