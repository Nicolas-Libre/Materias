program Practica5ej4;
type

reclamo = record
codigo:integer;
anio:integer;
tipo: integer;
dni:integer;
end;

auxR = record
codigo:integer;
anio:integer;
tipo:integer;
cant:integer;
end;

listaR=^nodoL;
nodoL=record
dato:auxR;
sig:listaR;
end;

info=record
dni:integer;
listaReclamos: listaR;
cant:integer;
end;

arbol=^nodoA;
nodoA=record
dato:info;
hd:arbol;
hi:arbol;
end;

listaCodigos=^nodoLC;
nodoLC=record
dato:integer;
sig:listaCodigos;
end;

procedure leerReclamo (var r:reclamo);
begin
	writeln ('Ingrese el codigo');
	readln (r.codigo);
	if r.codigo <> 0 then begin
		writeln ('Ingrese el dni');
		readln (r.dni);
		writeln ('Ingrese el anio');
		readln (r.anio);
		writeln ('Ingrese el tipo');
		readln (r.tipo);
	end;
end;


procedure agregarAdelante (var L:listaR; r:reclamo);
var
	nuevo:listaR;
begin
	new (nuevo);
	nuevo^.dato.codigo:=r.codigo;
	nuevo^.dato.tipo:=r.tipo;
	nuevo^.dato.anio:=r.anio;
	nuevo^.sig:=L;
	L:=nuevo;
end;


procedure generarArbol (var a:arbol; r:reclamo);

begin
	if a= nil then begin
		new (a);
		a^.dato.dni:=r.dni;
		agregarAdelante (a^.dato.listaReclamos, r);
		a^.dato.cant:=a^.dato.cant +1;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if r.dni > a^.dato.dni then 
			generarArbol (a^.hd,r)
		else
			if r.dni < a^.dato.dni then
				generarArbol (a^.hi,r)
			else begin
				agregarAdelante (a^.dato.listaReclamos,r);
				a^.dato.cant:=a^.dato.cant +1;
			end;
	end;
end;

procedure cargarDatos (var a:arbol);
var
	r:reclamo;
begin
	leerReclamo (r);
	while r.codigo <> 0 do begin
		generarArbol (a,r);
		leerReclamo (r);
	end;
end;

procedure ImprimirLista (L:listaR);
begin
	while L <> nil do begin
		writeln ('codigo = ', L^.dato.codigo);
		writeln ('anio = ', L^.dato.anio);
		writeln ('tipo = ', L^.dato.tipo);
		L:=L^.sig;
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a <> nil then begin
		writeln ('');
		writeln ('DNI = ', a^.dato.dni);
		ImprimirLista (a^.dato.listaReclamos);
		writeln ('cantidad de reclamos = ', a^.dato.cant);
		writeln ('');
		ImprimirArbol (a^.hi);
		ImprimirArbol (a^.hd);
	end;
end;

function retornarCant (a:arbol; dni:integer) : integer;
begin
	if a = nil then 
		retornarCant:=-1
	else begin
		if dni = a^.dato.dni then
			retornarCant:=a^.dato.cant
		else
			if dni > a^.dato.dni then
				retornarCant:= retornarCant (a^.hd,dni)
			else
				retornarCant:= retornarCant (a^.hi,dni);
	end;
end;

procedure cantEntreDniS (a:Arbol; dni1:integer; dni2:integer; var cant:integer);
begin
	if a <> nil then begin
		if ((a^.dato.dni >= dni1) and (a^.dato.dni <= dni2)) then begin
			cant:=cant + a^.dato.cant;
			cantEntreDniS (a^.hi,dni1,dni2,cant);
			cantEntreDniS (a^.hd,dni1,dni2,cant);
		end
		else
			if dni2 < a^.dato.dni then
				cantEntreDniS (a^.hi,dni1,dni2,cant)
			else
				if dni1 > a^.dato.dni then
					cantEntreDniS (a^.hd,dni1,dni2,cant);
	end;
end;


procedure agregarAdelante2 (var LC:listaCodigos; cod:integer);
var
	nuevo:listaCodigos;
begin
	new (nuevo);
	nuevo^.dato:=cod;
	nuevo^.sig:=LC;
	LC:=nuevo;
end;

procedure buscarEnLista (L:listaR; var LC:listaCodigos; anio:integer);
begin
	while L <> nil do begin
		if L^.dato.anio = anio then
			agregarAdelante2 (LC,L^.dato.codigo);
		L:=L^.sig;
	end;
end;

procedure generarListaCodigos (a:arbol; var LC:listaCodigos; anio:integer);
var
	L:listaR;
begin
	if a <> nil then begin
		L:= a^.dato.listaReclamos;
		buscarEnLista (L,LC,anio);
		generarListaCodigos(a^.hd,LC,anio);
		generarListaCodigos (a^.hi,LC,anio);
	end;
end;

procedure ImprimirListaCodigos (LC:listaCodigos);
begin
	while LC <> nil do begin
		writeln ('codigos = ');
		writeln (LC^.dato);
		writeln ('');
		LC:=LC^.sig;
	end;
end;
	

var
	a:arbol;
	cantidadR:integer;
	dni:integer;
	cantEntre2:integer;
	dni1,dni2:integer;
	anioBuscado:integer;
	LC:listaCodigos;
begin	
	a:=nil;
	cargarDatos (a);
	ImprimirArbol (a);
	dni:=2;
	cantEntre2:=0;
	cantidadR:= retornarCant (a,dni);
	writeln ('reclamos del dni ingresado = ', cantidadR);
	dni1:=2;
	dni2:=8;
	cantEntreDniS (a,dni1,dni2,cantEntre2);
	writeln ('reclamos entre los dnis ingresados = ', cantEntre2);
	LC:=nil;
	anioBuscado:=6;
	generarListaCodigos (a,LC,anioBuscado);
	ImprimirListaCodigos(LC);
end.








