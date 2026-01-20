program practica3ej3;
type
	novela = record
		cod: integer;
		genero: string[30];
		nombre: string [30];
		duracion: integer;
		director: string [30];
		precio: real;
	end;
archivoNov= file of novela; 
procedure mostrarMenu;
begin
	writeln('1- Crear el archivo');
	writeln('2- Modificar el archivo');
	writeln('3- Mostrar el archivo ');
	writeln('4- Fin');
end;

procedure mostrarMenuMod;
begin
	writeln('1- Dar de alta una novela');
	writeln('2- Modificar una novela');
	writeln('3- Eliminar una novela');
end;

procedure leerNovela (var n:novela);
begin
	writeln ('Ingrese el codigo de la novela');
	readln (n.cod);
	if (n.cod <>-1) then begin
		writeln ('Ingrese genero de la novela ');
		readln (n.genero);
		writeln ('Ingrese nombre de la novela ');
		readln (n.nombre);
		writeln ('Ingrese la duracion de la novela');
		readln (n.duracion);
		writeln ('Ingrese el director de la novela ');
		readln (n.director);
		writeln ('Ingrese el precio de la novela');
		readln (n.precio);
	end;
end;

procedure leerNovela2 (n:novela);
begin
	writeln ('Ingrese el genero de la novela ');
	readln (n.genero);
	writeln ('Ingrese el nombre de la novela ');
	readln (n.nombre);
	writeln ('Ingrese la duracion de la novela ');
	readln (n.duracion);
	writeln ('Ingrese el director de la novela ');
	readln (n.director);
	writeln ('Ingrese el precio de la novela	');
	readln (n.precio);
end;
procedure crearArchivo (var arch: archivoNov);
var
	n:novela;
	nombre: string [30];
begin
	writeln ('Ingrese el nombre del archivo');
	readln (nombre);
	assign (arch, nombre);
	reWrite (arch);
	n.cod:= 0;
	n.genero:= ''; 
	n.nombre:= '' ;		
	n.duracion:= 0 ;
	n.director:='' ;
	n.precio:=0 ;
	write (arch, n);
	leerNovela (n);
	while (n.cod <> -1) do begin
		write (arch, n);
		leerNovela(n);
	end;
	close (arch);
end;

procedure hacerAlta (var arch: archivoNov);
var
	nLeer:novela;
	nDato: novela;
begin
	reset (arch);
	read (arch, nDato);
	leerNovela(nLeer);
	if nDato.cod = 0 then begin
		seek (arch,fileSize(arch));
		write (arch, nLeer);
	end
	else begin
		seek (arch,(nDato.cod * -1));
		read (arch, nDato);
		seek (arch, filePos(arch) -1);
		write (arch, nLeer);
		seek (arch, 0);
		write (arch, nDato);
	end;
	close (arch);
end;

procedure buscarNovela (var arch: archivoNov; var encontre:boolean; cod: integer);
var
	aux: novela;
begin
	seek (arch, 1);
	while ((not (EOF(arch))) and (not encontre)) do begin
		read (arch, aux);
		if (aux.cod = cod) then begin
			encontre := true;
		end;
	end;
end;
		
	

procedure modNovela (var arch: archivoNov);
var
	n:novela;
	encontre: boolean;
begin
	reset (arch);
	writeln ('Ingrese el codigo de la novela');
	readln (n.cod);
	encontre:=false;
	buscarNovela (arch, encontre,  n.cod);
	if (encontre) then begin
		leerNovela2(n);
		seek (arch, filePos(arch) -1);
		write (arch, n);
	end
	else
		writeln ('El codigo no existe');
end;

procedure hacerBaja (var arch: archivoNov);
var
	cod:integer;
	novCabe:novela;
	encontre: boolean;
begin
	reset (arch);
	encontre := false;
	read (arch, novCabe);
	writeln ('Ingrese el codigo de la novela a eliminar');
	readln (cod);
	buscarNovela (arch, encontre, cod);
	if (encontre = true) then begin
		seek (arch, filepos(arch)-1);
		write (arch, novCabe);
		novCabe.cod := (filepos(arch)-1) * -1;
		seek (arch, 0);
		write (arch, novCabe);
	end;
	close (Arch);
end;

procedure imprimirNovela (n:novela);
begin
	writeln ('El codigo de la novela es: ', n.cod);
	writeln ('El genero de la novela es: ', n.genero);
	writeln ('El nombre de la novela es: ', n.nombre);
	writeln ('El duracion de la novela es: ', n.duracion);
	writeln ('El director de la novela es: ', n.director);
	writeln ('El precio de la novela es: ', n.precio);
end;


procedure imprimirArchivo (var arch: archivoNov);
var
	n:novela;
begin
	seek (arch, 1);
	while (not (EOF(arch))) do begin
		read (arch, n);	
		if (n.cod < 1) then begin
			writeln ('Novela Eliminada');
		end
		else begin
			imprimirNovela (n);
		end;
	end;
end;

var
	o: integer;
	seCreo: boolean;
	arch: archivoNov;
	modificaciones: integer;
begin
	writeln('Ingrese la opcion deseada');
	mostrarMenu;
	readln (o);
	seCreo:= False;
	while (o <> 4) do begin 
		if (o = 1) then begin
			if (seCreo = False) then begin
				crearArchivo(arch);
				seCreo:=True;
			end
			else begin
				writeln ('El archivo ya se creo');
			end;
		end
		else if (o = 2) then begin
			if seCreo = True then begin
				mostrarMenuMod;
				readln (modificaciones);
				if (modificaciones = 1) then begin
					hacerAlta(arch);
				end
				else if (modificaciones = 2) then begin
					modNovela(arch);
				end
				else if (modificaciones = 3) then begin
					hacerBaja(arch);
				end
				else writeln ('Opcion invalida');
			end
			else begin
				writeln ('El archivo no se creo')
			end;
		end
		else if (o=3) then begin
			if (seCreo = True) then begin
				imprimirArchivo (arch);
			end
			else begin
				writeln ('El archivo no se creo')
			end;
		end
		else if (o < 1) or (o > 4) then begin
			writeln ('La opcion ingresada no es valida');
		end;
		mostrarMenu;
	end;
end.
