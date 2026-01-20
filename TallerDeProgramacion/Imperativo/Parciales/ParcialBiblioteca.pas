program ParcialBiblioteca;
type
rangoGenero=1..15;


libro=record
ISBN:integer;
anioEdicion:integer;
codigoAutor:integer;
codigoGen:rangoGenero;
end;

libroAux=record
ISBN:integer;
anioEdicion:integer;
codigoGen:rangoGenero;
end;

lista =^nodoL;
nodoL=record
dato:libroAux;
sig:lista;
end;

info=record
codigoAutor:integer;
cantLibros:integer;
end;

lista2=^nodoL2;
nodoL2=record
dato:info;
sig:lista2;
end;


arbol=^nodo;
nodo=record
codigoAutor:integer;
dato:lista;
hd:arbol;
hi:arbol;
end;


procedure leerLibro (var li:libro);
begin
	writeln ('ingrese el ISBN');
	readln (li.ISBN);
	if (li.ISBN <> 0 ) then begin
		writeln ('ingrese el codigo de autor');
		readln (li.codigoAutor);
		writeln ('ingrese el anio de edicion');
		readln (li.anioEdicion);
		writeln ('ingrese el codigo de genero');
		readln (li.codigoGen);
		
	end;
end;


procedure AgregarAdelante (var L:lista; liAux:libroAux);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato:=liAux;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarArbol(var a:arbol; li:libro);
var
	liAux:libroAux;
begin
	if a = nil then begin
		new (a);
		a^.codigoAutor:= li.codigoAutor;
		a^.dato:= nil;
		liAux.ISBN:= li.ISBN;
		liAux.anioEdicion:= li.anioEdicion;
		liAux.codigoGen:=li.codigoGen;
		AgregarAdelante(a^.dato, liAux);
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if (li.codigoAutor = a^.codigoAutor  ) then begin
			AgregarAdelante (a^.dato,liAux);
		end
		else 
			if (li.codigoAutor < a^.codigoAutor) then begin
				generarArbol(a^.hi,li);
			end
			else
				generarArbol(a^.hd,li);
	end;
end;


procedure cargarDatos (var a:arbol);
var
	li:libro;
begin
	leerLibro(li);
	while (li.ISBN <> 0) do begin
		generarArbol (a,li);
		leerLibro(li);
	end;
end;

procedure contarLibrosLista (L:lista; var cant:integer);
begin
	while L<> nil do begin
		cant:=cant+1;
		L:=L^.sig;
	end;
end;


procedure AgregarAdelante2 (var L2:lista2; inf: info);
var
	nuevo:lista2;
begin
	new (nuevo);
	nuevo^.dato:=inf;
	nuevo^.sig:=L2;
	L2:=nuevo;
end;

procedure generarLista2 (a:arbol; cod:integer; var L2:lista2);
var
	cant:integer;
	inf:info;
begin
	if (a<>nil) then begin
		if (a^.codigoAutor>cod) then begin
			cant:=0;
			contarLibrosLista (a^.dato,cant);
			inf.cantLibros:= cant;
			inf.codigoAutor:=a^.codigoAutor;
			AgregarAdelante2 (L2,inf);
		end;
		if (a^.hi <> nil) then begin
			if (a^.hi^.codigoAutor > cod) then 
				generarLista2 (a^.hi,cod,L2);
		end;
		generarLista2(a^.hd,cod,L2);
	end;
end;



procedure ImprimiL2 (L2:lista2);
begin
	while L2<> nil do begin
		writeln ('auto= ', L2^.dato.codigoAutor);
		writeln ('cant libros= ', L2^.dato.cantLibros);
		L2:=L2^.sig
	end;
end;

procedure retornarMax (L2:lista2; var codMax:integer; var cantMax:integer);
begin
	if L2 <> nil then begin
		if (L2^.dato.cantLibros> cantMax) then begin
			cantMax:=L2^.dato.cantLibros;
			codMax:=L2^.dato.codigoAutor;
		end;
		retornarMax (L2^.sig, codMax,cantMax);
	end;
end;


procedure ImprimirLista (L:lista);
begin
	while L<>nil do begin
		writeln ('el ISBN es ', L^.dato.ISBN);
		writeln ('el anio de edicion es ',L^.dato.anioEdicion);
		writeln ('el codigo genero es ', L^.dato.codigoGen);
		L:=L^.sig;
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		ImprimirArbol (a^.hi);
		writeln ('autor= ', a^.codigoAutor);
		ImprimirLista (a^.dato);
		
		ImprimirArbol (a^.hd);
	end;
end;

var
	a:arbol;
	L2:lista2;
	cod:integer;
	codMax:integer;
	cantMax:integer;
begin
	a:=nil;
	L2:=nil;
	cod:=2;
	codMax:=0;
	cantMax:=0;
	cargarDatos (a);
	ImprimirArbol(a);
	generarLista2 (a,cod,L2);
	ImprimiL2(L2);
	
	retornarMax (L2,codMax,cantMax);
	writeln ('el codigo con mas libros es ', codMax, ' con una cantidad de libros igual a ', cantMax);
end.
