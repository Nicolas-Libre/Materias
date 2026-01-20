program Parcial8GoogleDrive;
Const
	maxGenero=7;
type

rangoGenero=1..maxGenero;

libro=record
isbn:integer;
codigo:integer;
genero:rangoGenero
end;

info=record
codigo:integer;
cantLibros:integer;
end;

arbol=^nodo;
nodo=record
dato:info;
hd:arbol;
hi:arbol;
end;

regVector=record
genero:rangoGenero;
cant:integer;
end;

vecLibros = array [rangoGenero] of regVector;

procedure leerLibro (var l:libro);
begin
	writeln ('ingrese el isbn');
	readln (l.isbn);
	if l.isbn<> 0 then begin
		writeln ('ingrese el codigo');
		readln (l.codigo);
		writeln ('ingrese el genero');
		readln (l.genero);
	end;
end;


procedure inicializarVector (var v:vecLibros);
var
	i:rangoGenero;
begin
	for i:=1 to maxGenero do begin
		v[i].genero:=i;
		v[i].cant:=0;
	end;
end;

procedure generarArbol (var a:arbol; codigo:integer);
begin
	if a=nil then begin
		new (a);
		a^.dato.codigo:= codigo;
		a^.dato.cantLibros:=1;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if codigo = a^.dato.codigo then begin
			a^.dato.cantLibros:= a^.dato.cantLibros + 1;
		end
		else if codigo > a^.dato.codigo then
			generarArbol (a^.hd,codigo)
		else
			generarArbol (a^.hi,codigo);
	end;
end;


procedure sumarVector (var v:vecLibros; pos:rangoGenero);
begin
	v[pos].cant:= v[pos].cant + 1;
end;


procedure cargarDatos (var a:arbol; var v:vecLibros);
var
	l:libro;
begin
	leerLibro(l);
	while l.isbn <> 0 do begin
		generarArbol (a,l.codigo);
		sumarVector (v,l.genero);
		leerLibro(l);
	end;
end;


function cantTotal (a:arbol; n1:integer; n2:integer) : integer;
begin
	if a=nil then begin
		cantTotal:=0;
	end
	else begin
		if (a^.dato.codigo >=n1) and (a^.dato.codigo <= n2) then begin
			cantTotal:= ( a^.dato.cantLibros + cantTotal(a^.hi,n1,n2) + cantTotal(a^.hd,n1,n2));
		end
		else if (a^.dato.codigo < n1) then begin
			cantTotal:= cantTotal (a^.hd,n1,n2);
		end
		else
			cantTotal:= cantTotal(a^.hi,n1,n2);
	end;
end;
 
procedure ordenarVector (var v:vecLibros; var mayorGenero:rangoGenero);
var
	i,j,p:integer;
	item:regVector;
begin
	for i:=1 to maxGenero-1 do begin
		p:=i;
		for j:=i+1 to maxGenero do begin
			if v[j].cant > v[p].cant then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
	mayorGenero:=v[1].genero;
end;


//modulos extra
procedure ImprimirVector (v:vecLibros);
var
	i:rangoGenero;
begin
	for i:=1 to maxGenero do begin
		writeln ('genero: ', v[i].genero);
		writeln ('cantidad de libros: ', v[i].cant);
	end;
end;

procedure ImprimirArbol (a:Arbol);
begin
	if a<> nil then begin
		ImprimirArbol (a^.hi);
		writeln ('codigo = ', a^.dato.codigo);
		writeln ('cantidad de libros ', a^.dato.cantLibros);

		ImprimirArbol (a^.hd);
	end;
end;
var
	a:arbol;
	v:vecLibros;
	mayorGenero:rangoGenero;
	librosTotales:integer;
	n1,n2:integer;
begin
	a:=nil;
	inicializarVector(v);
	cargarDatos (a,v);
	//ImprimirVector(v);
	mayorGenero:=1;
	writeln ('------------------------------------------------------------');
	ordenarVector (v, mayorGenero);
	//ImprimirVector(v);
	n1:=2;
	n2:=8;
	librosTotales:=cantTotal(a,n1,n2);
	ImprimirArbol (a);
	writeln ('el genero con mas cantidad de libros es el genero ', mayorGenero);
	writeln ('la cantidad total de libros entre los dos valores ingresados es ',  librosTotales);
end.



