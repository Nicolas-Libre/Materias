program Practica1ej5;
type
celular = record
	codigo: integer;
	nombre: String;
	desc: String;
	marca: String;
	precio: real;
	stockMinimo: integer;
	stockActual: integer;
end;

archivo = file of celular;
procedure leerCelular (var c:celular);
begin
	writeln ('Ingrese Nombre');
	readln (c.nombre);
	if c.nombre <> 'xxx' then begin
		writeln ('Ingrese Codigo');
		readln (c.codigo);
		writeln ('Ingrese una Descripcion');
		readln (c.desc);
		writeln ('Ingrese una Marca');
		readln (c.marca);
		writeln ('Ingrese un Precio');
		readln (c.precio);
		writeln ('Ingrese Stock Minimo');
		readln (c.stockMinimo);
		writeln ('Ingrese el Stock Actual');
		readln (c.stockActual);
	end;
end; 

procedure imprimirCelular (c:celular);
begin
	writeln('Nombre: ', c.nombre);
	writeln('Codigo: ', c.codigo);
	writeln('Descripcion: ', c.desc);
	writeln('Marca: ', c.marca);
	writeln('Preico: ', c.precio);
	writeln('Stock Minimo: ', c.stockMinimo);
	writeln('Stock Disponible: ', c.stockActual);
end;
procedure mostrarOpciones();
begin
	writeln('1- Crear nuevo archivo binario');
	writeln('2- Mostrar celulares con stock menor al minimo ');
	writeln('3- Mostrar celulares ');
	writeln('4- Exportar archivo generado a "celulares.txt" ');
	writeln('5- Salir');
end;
procedure crearArchivo (nomArch:string; var carga:Text; var arch: archivo);
var
	c:celular;
begin
	Reset (carga);
	while not EOF (carga) do begin
		Readln (carga, c.nombre, c.codigo, c.desc, c.marca, c.precio, c.stockMinimo, c.stockActual);
		write (arch, c)
	end;
	writeln ('Se cargo el archivo');
	Close (carga);
end;
procedure imprimirMenorStock (var arch:archivo);
var
	c:celular;
begin
	Reset (arch);
	while not EOF (arch) do begin
		read (arch, c);
		if c.stockActual < c.stockMinimo then begin
			imprimirCelular(c);
		end;
	end;
	Close (arch);
end;

procedure mostrarCelCadena(var arch:archivo);
var
	cadena:string;
	c:celular;
	encontre: boolean;
begin
	encontre := False;
	writeln ('Ingrese una cadena a buscar');
	readln (cadena);
	Reset (arch);
	while not EOF (arch) do begin
		read (arch, c);
		if cadena = c.desc then begin
			imprimirCelular(c);
			encontre:= True;
		end;
	end;
	if encontre = False then
		writeln ('Las descripciones no coinciden con ningun celular');
	Close (arch);
end;
procedure exportarBinarioATexto (var arch_text: Text; var arch: archivo);
var
	c:celular;
begin
	while not EOF (arch) do begin
		read (arch,c);
		Writeln (arch_text,'Codigo: ',c.codigo,' Precio: ',c.precio,' Marca: ',c.marca);
		Writeln (arch_text,'Stock Disponible: ',c.stockActual,' Stock Minimo: ',c.stockMinimo,' Descripcion: ', c.desc);
		writeln (arch_text,'Nombre: ',c.nombre);
	end;
end;

var
	o:integer;
	nomArch: string;
	carga: Text;
	arch: archivo;
	seCreo: boolean;
	arch_Text: Text;

begin
	mostrarOpciones();
	seCreo:= False;
	writeln ('Ingrese la accion a realizar ');
	readln (o);
	while o <> 5 do begin
		if o = 1 then begin
			assign (carga, 'celulares.txt');
			writeln ('Ingrese el nombre del archivo');
			readln (nomArch);
			assign (arch, nomArch);
			Rewrite(arch);
			crearArchivo(nomArch, carga, arch);
			Close (arch);
			seCreo:= True;
		end
		else 
			if o = 2 then begin
				if seCreo = True then begin
					imprimirMenorStock (arch);
				end
				else begin
					writeln ('El archivo no se creo');
				end;
			end
		else 
			if o = 3 then begin
				if seCreo = True then begin
					mostrarCelCadena (arch);
				end
				else begin
					writeln ('El archivo no se creo');
				end;
			end
		else 
			if seCreo = True then begin
				assign (arch_Text, 'celulares.txt');
				Rewrite (arch_text);
				exportarBinarioATexto (arch_Text, arch);
			end
			else begin
				writeln ('El archivo no se creo');
			
		
		end;
		mostrarOpciones();
		writeln ('Ingrese la accion a realizar ');
		readln(o)
	end;
	
end.
