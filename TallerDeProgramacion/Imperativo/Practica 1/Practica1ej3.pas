program Practica1ej3;
Const
dimF=8;
type

VectorMaxCod = array [1..dimF] of integer;

pelicula = record
codigo:integer;
genero: integer;
puntaje:real;
end;

lista =^nodo;
nodo=record
dato:pelicula;
sig:lista;
end;

procedure leerPelicula (var p:pelicula);
begin
	writeln ('ingrese el codigo');
	readln (p.codigo);
	if p.codigo <> -1 then begin
		writeln ('ingrese el genero');
		readln (p.genero);
		writeln ('ingrese el puntaje');
		readln (p.puntaje);
	end;
end;

procedure InsertarOrdenado (var L:lista; p:pelicula);
var
	nuevo:lista;
	act,ant:lista;
begin
	act:=L;
	ant:=L;
	new (nuevo);
	nuevo^.dato:=p;
	while ((act<>nil) and (p.genero < act^.dato.genero)) do begin
		ant:=act;
		act:=act^.sig;
	end;
	if act=ant then
		L:=nuevo
	else
		ant^.sig:=nuevo;
	nuevo^.sig:=act;
end;

procedure cargarLista (var L:lista);
var
	p:pelicula;
begin
	leerPelicula (p);
	while (p.codigo <>-1) do begin
		InsertarOrdenado (L,p);
		leerPelicula (p);
	end;
end;

procedure actualizarMax (var codMax:integer; var puntajeMax:real; cod:integer; puntaje:real);
begin
	if puntaje>puntajeMax then begin
		codMax:=cod;
		puntajeMax:=puntaje;
	end;
end;

procedure inicializarVector (var v:VectorMaxCod);
var
	i:integer;
begin
	for i:=1 to dimF do begin
		v[i]:=0;
	end;
end;
procedure cargarVector (var v:VectorMaxCod; L:lista; var dimL:integer);
var
	i:integer;
	codMax:integer;
	puntajeMax:real;
begin
	while (L<>nil) do begin
		i:=L^.dato.genero;
		codMax:=-1;
		puntajeMax:=-1;
		while ((L<>nil) and (L^.dato.genero =i)) do begin
			actualizarMax (codMax,puntajeMax, L^.dato.codigo, L^.dato.puntaje);
			L:=L^.sig;
		end;
		v[i]:=codMax;
		dimL:=dimL+1;
	end;
end;

// no se puede ordenar por puntaje ya que el vector solo tiene codigo.
procedure OrdenarVector (var v:VectorMaxCod; dimL:integer);
var
	i,j,p,item:integer;
begin
	for i:=1 to dimL-1 do begin
		p:=i;
		for j:= i+1	 to dimL do begin
			if v[j]<v[p] then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;

procedure ImprimirLista (L:lista);
begin
	if (L<>nil) then begin
		writeln ('el codigo es ', L^.dato.codigo);
		writeln ('el genero es ', L^.dato.genero);
		writeln ('el puntaje es ',(L^.dato.puntaje):2:2);
		L:=L^.sig;
		ImprimirLista (L);
	end;
end;

procedure ImprimirVector (v:VectorMaxCod; dimL:integer);
begin
	writeln ('el codigo con menor puntaje es ', v[1]);
	writeln ('el codigo con mayor puntaje es ', v[dimL]);
end;

var
	L:lista;
	v:VectorMaxCod;
	dimL:integer;
begin
	dimL:=0;
	L:=nil;
	cargarLista (L);
	inicializarVector (v);
	cargarVector (v,L,dimL);
	ImprimirLista (L);
	OrdenarVector (v,dimL);
	ImprimirVector (v,dimL);
end.
	





