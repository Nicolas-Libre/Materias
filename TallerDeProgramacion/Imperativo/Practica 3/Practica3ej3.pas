program Practica3ej3;
type
rangoFecha= 1..31;
rangoNota= 1..10;

alumno= record
legajo:integer;
materia:string;
fecha:rangoFecha;
nota:rangoNota
end;

finals= record
materia:string;
fecha:rangoFecha;
nota:rangoNota;
end;

lista=^nodo;
nodo=record
	dato:finals;
	sig:lista;
end;

arbol=^nodoA;
nodoA=record
legajo:integer;
dato:lista;
hd:arbol;
hi:arbol;
end;


listaProm =^nodoProm;
nodoProm=record
legajo:integer;
prom:real;
sig:listaProm;
end;


procedure leerAlumno (var al:alumno);
begin
	writeln ('ingrese su legajo');
	readln (al.legajo);
	if al.legajo <> 0 then begin
		writeln ('ingrese su materia');
		readln (al.materia);
		writeln ('ingrese la fecha');
		readln (al.fecha);
		writeln ('ingrese su nota');
		readln (al.nota);
	end;
end;

procedure AgregarAdelante (var L:lista; materia:string; fecha:rangoFecha; nota: rangoNota);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato.materia:=materia;
	nuevo^.dato.fecha:=fecha;
	nuevo^.dato.nota:=nota;
	nuevo^.sig:=L;
	L:=nuevo;
end;


procedure generarArbol (var a:arbol; al:alumno);

begin
	if a=nil then begin
		new (a);
		a^.legajo:=al.legajo;
		AgregarAdelante (a^.dato,al.materia, al.fecha, al.nota);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if al.legajo<a^.legajo then
			generarArbol (a^.hi,al)
		else
			if al.legajo>a^.legajo then
				generarArbol (a^.hd,al)
			else
				AgregarAdelante (a^.dato,al.materia,al.fecha,al.nota);
end;

procedure cargarDatos (var a:arbol);
var
	al:alumno;
begin
	leerAlumno (al);
	while al.legajo <>  0 do begin
		generarArbol (a,al);
		leerAlumno (al);
	end;
end;


procedure ImprimirLista (L:lista);
begin
	while L<> nil do begin
		writeln ('materia = ',L^.dato.materia);
		writeln ('fecha = ',L^.dato.fecha);
		writeln ('nota = ',L^.dato.nota);
		L:=L^.sig;
	end;
end;
procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		writeln ('legajo = ', a^.legajo);
		ImprimirLista (a^.dato);
		ImprimirArbol (a^.hi);
		ImprimirArbol (a^.hd);
	end;
end;

function legajoImpar (a:arbol) : integer;
begin
	if a = nil then
		legajoImpar:=0
	else
		if ((a^.legajo mod 2) =1) then begin
			legajoImpar:= legajoImpar(a^.hd) + legajoImpar (a^.hi) + 1;
		end
		else
			legajoImpar:= legajoImpar(a^.hd) + legajoImpar (a^.hi) ;
end;
	
function chequearLista (L:lista; cant:integer) : integer;
begin
	if L = nil then
		chequearLista:=cant
	else
		if L^.dato.nota >= 4 then begin
			cant:=cant+1;
			chequearLista:= chequearLista (L^.sig,cant);
		end
		else
			chequearLista:= chequearLista (L^.sig,cant);
end;
	
	
procedure finalesAprobados (a:arbol);
var
	cant:integer;
begin
	if a <> nil then begin
		cant:= chequearLista (a^.dato,0);
		writeln ('alumno = ', a^.legajo, ', finales aprobados= ', cant);
		finalesAprobados (a^.hd);	
		finalesAprobados (a^.hi);
	end;
end;
		
		
function calcularPromedio (L:lista; prom:real; cantFinales:integer) : real;
begin
	if L = nil then
		calcularPromedio:=(prom/cantFinales)
	else begin
		cantFinales:=cantFinales+1;
		prom:= prom + L^.dato.nota;
		calcularPromedio:=calcularPromedio (L^.sig,prom,cantFinales);
	end;
end;
		
	
procedure AgregarAdelanteProm (var LP:listaProm; p:real; leg:integer);
var
	nuevo:listaProm;
begin
	new (nuevo);
	nuevo^.prom:=p;
	nuevo^.legajo:=leg;
	nuevo^.sig:=LP;
	LP:=nuevo;
end;
procedure listaPromedios (a:arbol; var LP:listaProm; x:real);
var
	p:real;
begin
	if a <> nil then begin
		p:=calcularPromedio (a^.dato,0,0);
		if p > x then
			AgregarAdelanteProm (LP,p,a^.legajo);
		listaPromedios (a^.hd,LP,x);
		listaPromedios (a^.hi,LP,x);
	end;
end;

procedure ImprimirListaProm (LP:listaProm);
begin
	while LP <> nil do begin
		writeln ('legajo = ',LP^.legajo);
		writeln ('supero el promedio con un promedio igual a ', LP^.prom:2:2);
		LP:=LP^.sig;
	end;
end;

var
a:arbol;
cantImpar:integer;
LP: listaProm;
begin
	a:=nil;
	cargarDatos (a);
	ImprimirArbol (a);
	cantImpar:=legajoImpar(a);
	writeln ('legajos impares = ', cantImpar);
	finalesAprobados (a);
	listaPromedios (a,LP,6);
	ImprimirListaProm (LP);
end.



