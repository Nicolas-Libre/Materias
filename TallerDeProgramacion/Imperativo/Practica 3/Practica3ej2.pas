program Practica3ej2;


type




venta = record
	codigo:integer;
	fecha:integer;
	cant:integer;
end;

producto = record
	codigo:integer;
	cantTotal:integer;
end;

arbol=^nodo;
nodo=record
dato:venta;
hd:arbol;
hi:arbol;
end;

arbolii=^nodoii;
nodoii=record
dato:producto;
hd:arbolii;
hi:arbolii;
end;

ventaAux= record
fecha:integer;
cant:integer;
end;

lista=^nodoL;
nodoL=record
dato:ventaAux;
sig:lista;
end;

arboliii=^nodoiii;
nodoiii=record
cod:integer;
dato:lista;
hd:arboliii;
hi:arboliii;
end;

procedure ventaAleatoria (var v:venta);
begin
	v.codigo:= random (4);
	if (v.codigo <> 0) then begin
		v.fecha:= random (11);
		v.cant:= random (11);
	end;
end;



procedure generarArboli (var a:arbol; v:venta);
begin
	if a=nil then begin
		new (a);
		a^.dato:=v;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else
		if v.codigo >= a^.dato.codigo then
			generarArboli (a^.hd,v)
		else
			generarArboli (a^.hi,v);
end;
		



procedure generarArbolii (var aii:arbolii; codigo:integer; cant:integer);
begin
	if aii=nil then begin
		new (aii);
		aii^.dato.codigo:= codigo;
		aii^.dato.cantTotal:=cant;
		aii^.hd:=nil;
		aii^.hi:=nil;
	end
	else begin
			if codigo > aii^.dato.codigo then begin
				generarArbolii (aii^.hd,codigo,cant);
			end
			else begin
				if codigo < aii^.dato.codigo then begin
					generarArbolii (aii^.hi,codigo,cant);
				end
				else
					if codigo = aii^.dato.codigo then
						aii^.dato.cantTotal:= aii^.dato.cantTotal + cant;
				
			end;
		end;
	end;	





procedure AgregarAdelante (var L:lista; fecha:integer; cant:integer);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato.fecha:=fecha;
	nuevo^.dato.cant:=cant;
	nuevo^.sig:=L;
	L:=nuevo;
end;





procedure generarArboliii (var aiii:arboliii; v:venta);
begin
	if aiii= nil then begin
		new (aiii);
		aiii^.cod:=v.codigo;
		AgregarAdelante (aiii^.dato,v.fecha,v.cant);
		aiii^.hd:=nil;
		aiii^.hi:=nil;
	end
	else begin
		if aiii^.cod=v.codigo then
			AgregarAdelante (aiii^.dato,v.fecha,v.cant)
		else
			if v.codigo< aiii^.cod then
				generarArboliii (aiii^.hi,v)
			else
				generarArboliii (aiii^.hd,v);	
	end;	
end;

procedure CargarDatos (var a:arbol; var aii:arbolii; var aiii:arboliii);
var
	v:venta;
begin
	ventaAleatoria (v);
	while (v.codigo <> 0)  do begin
		generarArboli (a,v);
		generarArbolii (aii,v.codigo,v.cant);
		generarArboliii (aiii,v);
		ventaAleatoria (v);
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a <> nil then begin
		ImprimirArbol (a^.hd);
		writeln ('codigo= ', a^.dato.codigo);
		writeln ('fecha = ', a^.dato.fecha);
		writeln ('cant = ', a^.dato.cant);
		ImprimirArbol (a^.hi);
	end;
	
end;

procedure ImprimirArbolii (aii:arbolii);
begin
	if aii <> nil then begin
		ImprimirArbolii (aii^.hd);
		writeln ('codigo= ', aii^.dato.codigo);
		writeln ('cant = ', aii^.dato.cantTotal);
		ImprimirArbolii (aii^.hi);
	end;
	
end;

procedure ImprimirLista (L:lista);
begin
	while L<> nil do begin
		writeln ('fecha =', L^.dato.fecha);
		writeln ('cant= ',L^.dato.cant);
		L:=L^.sig;
	end;
end;
procedure ImprimirArboliii (aiii:arboliii);
begin
	if aiii <> nil then begin
		ImprimirArboliii (aiii^.hi);
		writeln ('codigo= ', aiii^.cod);
		ImprimirLista (aiii^.dato);
		ImprimirArboliii (aiii^.hd);
	end;
	
end;
var
	a:arbol;
	aii:arbolii;
	aiii:arboliii;
begin
	randomize;
	a:=nil;
	aii:=nil;
	aiii:=nil;
	CargarDatos (a,aii,aiii);
	ImprimirArbol (a);
	writeln ('');
	writeln ('');
	writeln ('--------------');
	writeln ('');
	writeln ('');
	ImprimirArbolii (aii);
	writeln ('');
	writeln ('');
	writeln ('--------------');
	writeln ('');
	writeln ('');
	ImprimirArboliii (aiii);
end.

