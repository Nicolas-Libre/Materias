program Practica1Ej7;
type
novela = record
	codigo: integer;
	nombre: string;
	genero: string;
	precio: real;
end;

archivo = file of novela;
procedure mostrarOpciones();
begin
	writeln ('1- Crear archivo Binario');
	writeln ('2- Agregar Novela');
	writeln ('3- Editar novela');
	writeln ('4- Salir');
	writeln ('');
end;

procedure generarArchivo (var arch: archivo; var archTXT: text);
var
	n:novela;
begin
	Reset (archTXT);
	while not EOF (archTXT) do begin
		Readln (archTXT, n.codigo, n.precio,n.genero);
		Readln (archTXT, n.nombre);
		write (arch, n);
	end;
	Close (archTXT);
end;

procedure leerNovela (var n:novela);
begin
	writeln ('Ingrese el nombre de la novela');
	readln (n.nombre);
	writeln ('Ingrese el codigo de la novela');
	readln (n.codigo);
	writeln ('Ingrese el genero de la novela');
	readln (n.genero);
	writeln ('Ingerese el precio de la novela');
	readln (n.precio);
end;

function buscarNombre (cod: integer; var arch:archivo) : boolean;
var
	encontre:boolean;
	n: novela;
begin
	encontre:=False;
	while not EOF (arch) and encontre = False do begin
		read (arch, n);
		if n.codigo = cod then begin
			encontre:= True;
		end
	end;
	buscarNombre:=encontre;
end;
		
procedure agregarNovela (var arch: archivo);
var
	n:novela;
	encontre: boolean;
begin
	writeln ('Ingrese los datos de la novela');
	leerNovela(n);
	encontre:= buscarNombre (n.codigo, arch);
	if encontre = False then begin
		write (arch, n);
		writeln ('La novela se agrego porque no existia');
	end
	else
		writeln ('La novela ya existe');
end;
procedure modificarNovela (var arch:archivo);
var
	n:novela;
	encontre: boolean;
begin
	writeln ('Ingrese los datos modificados de la novela existente');
	leerNovela(n);
	encontre:= buscarNombre (n.codigo, arch);
	if encontre = True then begin
		write (arch,n);
		writeln ('La novela se modifico con exito');
	end
	else
		writeln ('La novela no existe');
end;

var
	arch: archivo;
	archTXT: text;
	nomArch: string;
	o: integer;
	seCreo: boolean;
begin
	mostrarOpciones();
	readln (o);
	seCreo:= False;
	while o <> 4 do begin
		if o = 1 then begin
			writeln ('Ingrese el nombre del archivo');
			readln (nomArch);
			assign (arch, nomArch);
			Rewrite (arch);
			generarArchivo (arch, archTXT);
			Close (arch);
			seCreo:=True;
		end
		else
			if o = 2 then begin
				if seCreo = True then begin
					Reset (arch);
					agregarNovela (arch);
					Close (arch);
				end
				else
					writeln ('El archivo no se creo');
			end
		else 
			if seCreo = True then begin
				Reset (arch);
				modificarNovela (arch);
				Close (arch);
			end
			else
				writeln ('El archivo no se creo');
		mostrarOpciones();
		readln (o);

	end;



end.
