program ParcialWspTurnoK2024;
Const
	maxGen=15;
type

rangoGenero = 1..maxGen;

libro = record
isbn:integer;
anio:integer;
codAutor:integer;
codGenero:rangoGenero
end;

auxLibro =record
isbn:integer;
anio:integer;
codGenero:rangoGenero;
end;

lista= ^nodoL;
nodoL=record
dato:auxLibro;
sig:lista;
end;

info =record
codAutor:integer;
L:lista;
end;

arbol=^nodo;
nodo=record
dato:info;
hd:arbol;
hi:arbol;
end;

aux2=record
codAutor:integer;
cantlibros:integer;
end;

lista2=^nodoL2;
nodoL2=record
dato:aux2;
sig:lista2;
end;

procedure leerLibro (var l:libro) ;
begin
	writeln ('ingrese el isbn');
	readln (l.isbn);
	if (l.isbn <> 0) then begin
		writeln ('ingrese el codigo de autor');
		readln (l.codAutor);
		writeln ('ingrese el anio');
		readln (l.anio);
		writeln ('ingrese el genero');
		readln (l.codGenero);
	end;
end;


procedure agregarAdelante (var L:lista; aux:auxLibro);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato:=aux;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarArbol (var a:arbol; l:libro);
var
	aux:auxLibro;
begin
	if a=nil then begin
		new (a);
		a^.dato.codAutor:=l.codAutor;
		a^.dato.L:=nil;
		aux.codGenero:=l.codGenero;
		aux.anio:=l.anio;
		aux.isbn:=l.isbn;
		agregarAdelante (a^.dato.L, aux);
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if l.codAutor = a^.dato.codAutor then begin
			aux.codGenero:=l.codGenero;
			aux.anio:=l.anio;
			aux.isbn:=l.isbn;
			agregarAdelante (a^.dato.L,aux);
		end
		else 
			if l.codAutor > a^.dato.codAutor then
				generarArbol (a^.hd,l)
			else
				generarArbol (a^.hi,l);
	end;
end;
			
procedure cargarDatos (var a:arbol);
var
	l:libro;
begin
	leerLibro (l);
	while l.isbn <> 0 do begin
		generarArbol (a,l);
		leerLibro(l);
	end;
end;

procedure recorrerListaYSumar (L:lista; var cant:integer);
begin
	while L<> nil do begin
		cant:=cant+1;
		L:=L^.sig;
	end;
end;

procedure agregarAdelante2 (var L2:lista2; codYCant:aux2);
var
	nuevo:lista2;
begin
	new (nuevo);
	nuevo^.dato:=codYCant;
	nuevo^.sig:=L2;
	L2:=nuevo;
end;
procedure retornarL2 (a:arbol; var L2:lista2; cod:integer);
var
	codYCant:aux2;
begin
	if (a<> nil) then begin
		if a^.dato.codAutor > cod then begin
			codYCant.codAutor:=a^.dato.codAutor;
			codYCant.cantLibros:=0;
			recorrerListaYSumar (a^.dato.L, codYCant.cantLibros);
			agregarAdelante2 (L2,codYCant);
			retornarL2 (a^.hi,L2,cod);
			retornarL2 (a^.hd,L2,cod);
		end
		else
			retornarL2 (a^.hd,L2,cod);
	end;
end;
		

procedure maxCantYcod (L2:lista2; var maxCod:integer; var maxCant:integer);
begin
	if L2 <> nil then begin
		if L2^.dato.cantLibros > maxCant then begin
			maxCod:= L2^.dato.codAutor;
			maxCant:=L2^.dato.cantLibros;
		end;
		maxCantYcod (L2^.sig,maxCod,maxCant);
	end;
end;


var
	a:arbol;
	L2:lista2;
	cod:integer;
	maxCod:integer;
	maxCant:integer;
begin
	a:=nil;
	L2:=nil;
	cargarDatos (a);
	cod:=3;
	maxCod:=0;
	maxCant:=0;
	retornarL2 (a,L2,cod);
	maxCantYcod (L2,maxCod,maxCant);
	writeln ('el codigo con mas cantidad fue el ', maxCod ,', con cantidad igual a ', maxCant);
end.


