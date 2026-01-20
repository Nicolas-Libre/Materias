program P5ejercicio4;
type
reclamo = record
	codigo:integer;
	dni:integer;
	anio:integer;
	tipo:integer;
end;


lista =^nodoL;
nodoL = record
	datoL:reclamo;
	
	sig:lista;
end;

lista2=^nodoL2;
nodoL2 = record
	datoL2:integer;
	sig:lista2;
end;

arbol = ^nodo;
nodo = record
	dato:lista;
	cant:integer;
	HD,HI:arbol;
end;




procedure leerReclamo (var r:reclamo);
begin
	writeln ('ingrese el codigo ');
	readln (r.codigo);
	if r.codigo <> 0 then begin
		writeln ('ingrese ingrese el dni ');
		readln (r.dni);
		writeln ('ingrese el anio');
		readln (r.anio);
		writeln ('ingrese el tipo ');
		readln (r.tipo);
	end;
end;

procedure AgregarAdelante (var L:lista; r:reclamo; c:integer);
var
nuevo:lista;
begin
	new (nuevo);
	nuevo^.datoL:=r;

	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure cargarArbol (var a:arbol; r:reclamo);

begin
	if a = nil then begin;
		new (a);
		a^.dato:=nil;
		a^.cant:=1;
		AgregarAdelante (a^.dato, r,a^.cant);
		a^.HD:=nil;
		a^.HI:=nil;
	end
	else
		if a^.dato^.datoL.dni = r.dni then begin
			a^.cant:=a^.cant+1;
			AgregarAdelante (a^.dato,r,a^.cant);
		end
		else
		if r.dni  < a^.dato^.datoL.dni then 
			cargarArbol (a^.HI,r)
		else
			cargarArbol (a^.HD,r);
end;


function puntoB (a:arbol; DNIbuscado:integer):integer;
begin
	if a= nil then
		puntoB:=0
		else
			if a^.dato^.datoL.DNI= DNIbuscado then begin
				puntoB:=puntoB (a^.HD,DNIbuscado) + puntoB (a^.HI,DNIbuscado) + a^.cant;
			end
			else
			if DNIbuscado < a^.dato^.datoL.DNI then
				puntoB:=puntoB (a^.HI,DNIbuscado)
			else
				puntoB:=puntoB(a^.HD,DNIbuscado);

			
end;
			


function PuntoC (a:arbol; DNImayor:integer; DNImenor:integer):integer;
begin
	if a = nil then 
		PuntoC:=0
	else
		if (DNImenor <= a^.dato^.datoL.dni) and (DNImayor >= a^.dato^.datoL.dni) then begin
			PuntoC:= PuntoC (a^.HD,DNImayor,DNImenor) + PuntoC (a^.HI,DNImayor,DNImenor) + a^.cant;
		end
		else
			PuntoC:= PuntoC (a^.HD,DNImayor,DNImenor) + PuntoC (a^.HI,DNImayor,DNImenor);
end;

procedure AgregarAdelante2 (cod:integer; var L2:lista2);
var
nuevo2:Lista2;
begin
	new (nuevo2);
	nuevo2^.datoL2:=cod;
	nuevo2^.sig:=L2;
	L2:=nuevo2;
end;

	
procedure PuntoD (var L2:lista2; a:arbol; ANIObuscado:integer);
begin
	if a<> nil then begin
		if a^.dato^.datoL.anio=ANIObuscado then begin
			AgregarAdelante2 (a^.dato^.datoL.codigo, L2);
		end;
		PuntoD (L2,a^.HD,ANIObuscado);
		PuntoD (L2,a^.HI,ANIObuscado);
	end;
end; 
	
procedure ImprimirLista (L:lista);
begin
	while L<> nil do begin
		writeln ('el codigo es ', L^.datoL.codigo);
		writeln ('el dni es ', L^.datoL.dni);
		writeln ('el anio es ', L^.datoL.anio);
		writeln ('el tipo es ', L^.datoL.tipo);

		L:=L^.sig;
	end;
end;
procedure ImprimirArbol (a:arbol);
begin
	if a <> nil then begin
		ImprimirArbol (a^.HD);
		ImprimirLista (a^.dato);
		writeln ('la cant es ', a^.cant);
		ImprimirArbol (a^.HI);
	end;
end;
procedure ImprimirLista2 (L2:lista2);
begin
	while L2<> nil do begin
		writeln ('el codigo es ', L2^.datoL2);
		L2:=L2^.sig;
	end;
end;

var
a:arbol;
r:reclamo;
B:integer;
C:integer;
L2:lista2;
ANIObuscado:integer;
DNIbuscado:integer;
DNImayor:integer;
DNImenor:integer;
BEGIN
	a:=nil;
	L2:=nil;
	leerReclamo (r);
	while r.codigo <> 0 do begin
		cargarArbol (a,r);
		leerReclamo(r);
	end;
	writeln ('ingrese el DNI a buscar ');
	readln (DNIbuscado);
	B:=puntoB(a,DNIbuscado);
	writeln ('la cantidad es ', B);
	writeln ('ingrese el DNI de limite superior ');
	readln (DNImayor);
	writeln ('ingrese el DNI de limite inferior ');
	readln (DNImenor);
	C:=PuntoC(a,DNImayor,DNImenor);
	writeln ('la cantidad de reclamos entre los dnis es ', C);
	writeln ('ingrese el anio a buscar ');
	readln (ANIObuscado);
	
	PuntoD (L2,a,ANIObuscado);
	ImprimirLista2 (l2);
	ImprimirArbol (a);
	
	
	
END.

