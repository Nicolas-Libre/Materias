
program P3Ejercicio3;
type
final=record
codigo:integer;
nota:integer;
end;

Listafinales=^nodoL;
nodoL=record
	dato:final;
	sig:listafinales
end;

alumno =record
	legajo:integer;
	fecha:integer;
	finales:listafinales;
end;

Listapromedios=^nodoP;
nodoP=record
	promedioSupero:real;
	legajoSupero:integer;
	sig:Listapromedios;
end;

arbol=^nodo;
nodo =record
	dato:alumno;
	HD,HI:arbol;
end;

procedure leerfinal (var f:final);
begin
	writeln('ingrese el codigo de materia ');
	readln (f.codigo);
	if (f.codigo <> 0) then begin
		writeln('ingrese la nota');
		readln (f.nota);
	end;
end;

procedure AgregarAdelante2 (var L2:Listapromedios; PS:real; LS:integer);
var
nuevo:listapromedios;
begin
	new (nuevo);
	nuevo^.promedioSupero:=PS;
	nuevo^.legajoSupero:=LS;
	nuevo^.sig:=L2;
	L2:=nuevo;
end;
procedure AgregarAdelante (var L:Listafinales; f:final);
var
nuevo:listafinales;
begin
	new (nuevo);
	nuevo^.dato:=f;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure leerAlumno (var a:alumno);
var
f:final;
begin
	writeln ('Ingrese el legajo sin el numero despues de la barra');
	readln (a.legajo);
	if (a.legajo <> 0) then begin
		writeln ('Ingrese la fecha');
		readln (a.fecha);
		a.finales:=nil;
		leerfinal (f);
		while f.codigo <> 0  do begin
			AgregarAdelante (a.finales,f);
			leerfinal (f);
		end;
	end;
end;


	
procedure GenerarArbol (var ar:arbol; a:alumno);
begin
	if (ar = nil) then begin
		new (ar);
		ar^.dato:=a;
		ar^.HI:=nil;
		ar^.HD:=nil;
	end
	else 
		if (a.legajo <= ar^.dato.legajo) then begin
			GenerarArbol (ar^.HI,a);
		end
		else
			GenerarArbol (ar^.HD,a);
end;

procedure NumeroLegajoImpar (ar:arbol; var x:integer);
begin
	if ar<> nil then begin
		NumeroLegajoImpar (ar^.HI, x);
		if (ar^.dato.legajo mod 2)= 1 then begin
			x:=x+1;
		end;
		NumeroLegajoImpar (ar^.HD, x);
			
	end;
end;

function FinalesAprobados (L:listafinales):integer;
var
x:integer;
begin
	x:=0;
	while (L<> nil) do begin
		if (L^.dato.nota >= 4) then begin
			x:=(x +1);
		end;
		L:=L^.sig;
	end;
	FinalesAprobados:=x;
end;
		
procedure AlumnosAprobados (ar:arbol);

begin
	if (ar <> nil) then begin
		
		AlumnosAprobados (ar^.HI);
		writeln ('el alumno ', ar^.dato.legajo);
		writeln ('aprobo ', FinalesAprobados (ar^.dato.finales) ); writeln ('finales');
		
		AlumnosAprobados (ar^.HD)
	end;
end;


function calcularPromedio (L:listafinales) :real;
var
suma:integer;
total:integer;
begin
	suma:=0;
	total:=0;
	while L <> nil do begin
		suma:=suma + L^.dato.nota;
		total:=total + 1;
		L:=L^.sig;
	end;
	if (total > 0) then begin
		calcularPromedio:=suma/total;
	end
	else
		calcularPromedio:=0;
end;

procedure calcularMaximo (ar:arbol; i:real; var L2:listapromedios);
var
auxProm:real;
begin
	if (ar <> nil) then begin
		auxProm:= calcularPromedio (ar^.dato.finales);
		if (auxProm > i) then begin
			AgregarAdelante2 (L2, auxProm, ar^.dato.legajo);
		end;
		calcularMaximo (ar^.HI,i,L2);
		calcularMaximo (ar^.HD,i,L2);
	end;
end;
		
procedure ImprimirLista (var L2:Listapromedios);
begin
	while L2<> nil do begin
		writeln ('el legajo es ', L2^.legajoSupero);
		writeln ('con promedio de ', L2^.promedioSupero:2:2);
		L2:=L2^.sig;
	end;
end;		
var
a:alumno;
ar:arbol;
x:integer;
i:real;
L2:listapromedios;

BEGIN
	x:=0;
	ar:=nil;
	
	leerAlumno (a);
	while (a.legajo <> 0) do begin
		GenerarArbol (ar, a);
		leerAlumno (a);
	end; 
	
	NumeroLegajoImpar (ar, x);
	writeln ('el numero de legajos impares es ', x);
	AlumnosAprobados (ar);	
	writeln();
	writeln('ingrese el promedio a superar');
	readln (i);
	L2:=nil;
	calcularMaximo (ar,i,L2);
	ImprimirLista(L2);
	
END.

