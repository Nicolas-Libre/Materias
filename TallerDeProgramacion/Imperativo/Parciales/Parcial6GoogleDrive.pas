program Parcial6GoogleDrive;
type
rangoDias=1..7;

alquiler=record
dni:integer;
numeroChasis:integer;
dia:rangoDias;
end;

arbol=^nodo;
nodo=record
numeroChasis:integer;
dni:integer;
hd:arbol;
hi:arbol
end;

vecDias = array [rangoDias] of arbol;

procedure leerAlquiler (var al:alquiler);
begin
	writeln ('ingrese el numero de chasis');
	readln (al.numeroChasis);
	if al.numeroChasis <> 0 then begin
		writeln ('ingrese el dni del cliente');
		readln (al.dni);
		writeln ('ingrese el dia del alquiler');
		readln (al.dia);
	end;
end;

procedure inicializarVector (var v:vecDias);
var
	i:rangoDias;
begin
	for i:=1 to 7 do begin
		v[i]:=nil;
	end;
end;

procedure generarArbol (var a:arbol; dni:integer; numeroChasis:integer);
begin
	if a= nil then begin
		new (a);
		a^.dni:=dni;
		a^.numeroChasis:=numeroChasis;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if numeroChasis > a^.numeroChasis then
			generarArbol (a^.hd,dni,numeroChasis)
		else
			generarArbol (a^.hi,dni,numeroChasis);
	end;
end;


procedure generarVector (var v:vecDias; al:alquiler);
begin
	generarArbol (v[al.dia],al.dni,al.numeroChasis);
end;

procedure cargarDatos (var v:vecDias);
var
	al:alquiler;
begin
	leerAlquiler (al);
	while al.numeroChasis <> 0 do begin
		generarVector (v,al);
		leerAlquiler(al);
	end;
end;

function buscarEnArbol (a:arbol; unDni:integer) : integer;
begin
	if a=nil then
		buscarEnArbol:=0
	else begin
		if a^.dni = unDni then begin
			buscarEnArbol:= 1 + buscarEnArbol (a^.hd,unDni) + buscarEnArbol (a^.hi,unDni);
		end
		else
			buscarEnArbol:= buscarEnArbol (a^.hd,unDni) + buscarEnArbol (a^.hi,unDni);
	end;
end;

function buscarEnVector (v:vecDias; unDni:integer) : integer;
var
	i:rangoDias;
	cant:integer;
begin
	cant:=0;
	for i:=1 to 7 do begin
		cant:= cant + buscarEnArbol(v[i],unDni);
	end;
	buscarEnVector:=cant;
end;

procedure retornarCantEnXDia (a:arbol; n1:integer; n2:integer; var cant:integer) ;
begin
	if a <> nil then begin
		if ((a^.numeroChasis <= n2) and (a^.numeroChasis >= n1)) then begin
			cant:=cant+1;
			retornarCantEnXDia (a^.hd,n1,n2,cant);
			retornarCantEnXDia (a^.hi,n1,n2,cant);
		end
		else 
			if a^.numeroChasis < n1 then
				retornarCantEnXDia (a^.hd,n1,n2,cant)
			else
				if a^.numeroChasis > n2 then
					retornarCantEnXDia (a^.hi,n1,n2,cant);
	end;
end;

procedure retornarCantEnVector (v:vecDias; D:rangoDias; n1:integer; n2:integer; var cant:integer);
begin
	retornarCantEnXDia (v[D],n1,n2,cant);
end;



var
	v:vecDias;
	cantAlquileresDelDni:integer;
	dniABuscar:integer;
	n1,n2:integer;
	diaABuscar:integer;
	cantAlEnDia:integer;
begin
	inicializarVector(v);
	cargarDatos (v);
	dniABuscar:=2;
	cantAlquileresDelDni:= buscarEnVector (v,dniABuscar);
	writeln ('El dni ingresado tiene ', cantAlquileresDelDni, ' alquileres');
	n1:=2;
	n2:=8;
	diaABuscar:=3;
	cantAlEnDia:=0;
	retornarCantEnVector (v,diaABuscar,n1,n2,cantAlEnDia);
	writeln ('los alquileres en el dia ingresado son ', cantAlEnDia, ' alquileres');
end.

