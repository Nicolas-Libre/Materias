program Practica4ej4;


type

rangoDia=1..31;
rangoMes= 1..12;

prestamo= record
ISBN:integer;
socio:integer;
dia: rangoDia;
mes:rangoMes;
cantDiasPrestados:integer;
end;

arbol=^nodo;
nodo=record
dato:prestamo;
hd:arbol;
hi:arbol;
end;
presAux=record
socio:integer;
dia: rangoDia;
mes:rangoMes;
cantDiasPrestados:integer;
end;

listaPres=^nodoL;
nodoL=record
dato:presAux;
sig:listaPres;
end;

arbolISBN=^nodoISBN;
nodoISBN=record
ISBN:integer;
dato:listaPres;
hdISBN:arbolISBN;
hiISBN:arbolISBN;
end;


procedure leerPrestamo (var p:prestamo);
begin
	writeln ('ingrese el ISBN');
	readln (p.ISBN);
	if p.ISBN <>0 then begin
		writeln ('ingrese el socio');
		readln (p.socio);
		writeln ('ingrese el dia ');
		readln (p.dia);
		writeln ('ingrese el mes');
		readln (p.mes);
		writeln ('ingrese los dias que lo tuvo');
		readln (p.cantDiasPrestados);
	end;
end;

procedure generarArbol (var a:arbol; p:prestamo);
begin
	if a = nil then begin
		new (a);
		a^.dato:=p;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if (p.ISBN < a^.dato.ISBN)  then
			generarArbol (a^.hi,p)
		else
			generarArbol (a^.hd,p);
	end;
end;

procedure agregarAdelante (var L:listaPres; p:prestamo);
var
	nuevo:listaPres;
begin
	new (nuevo);
	nuevo^.dato.socio:=p.socio;
	nuevo^.dato.dia:=p.dia;
	nuevo^.dato.mes:=p.mes;
	nuevo^.dato.cantDiasPrestados:=p.cantDiasPrestados;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarArbolISBN (var aISBN: arbolISBN; p: prestamo);
begin
	if aISBN=nil then begin
		new (aISBN);
		aISBN^.ISBN:=p.ISBN;
		aISBN^.dato:=nil;
		agregarAdelante (aISBN^.dato,p);
		aISBN^.hdISBN:=nil;
		aISBN^.hiISBN:=nil;
	end
	else begin
			if p.ISBN< aISBN^.ISBN  then
				generarArbolISBN (aISBN^.hiISBN,p)
			else
				if p.ISBN > aISBN^.ISBN then
					generarArbolISBN (aISBN^.hdISBN,p)
				else 
					if p.ISBN=aISBN^.ISBN then begin
						agregarAdelante (aISBN^.dato,p);
					end;
					
	end;
end;


procedure ImprimirArbol (a:arbol);
begin
	if a <> nil then begin
		ImprimirArbol (a^.hi);
		writeln ('ISBN = ', a^.dato.ISBN);
		writeln ('socio = ', a^.dato.socio);
		writeln ('dia = ', a^.dato.dia);
		writeln ('mes = ', a^.dato.mes);
		writeln ('cantidad de dias prestado = ', a^.dato.cantDiasPrestados);
		
		ImprimirArbol (a^.hd);
	end;
end;

procedure ImprimirLista (L:listaPres);
begin
	while (L <> nil) do begin
		writeln ('socio = ',L^.dato.socio);
		writeln ('dia = ',L^.dato.dia);
		writeln ('mes = ',L^.dato.mes);
		writeln ('dias prestado ',L^.dato.cantDiasPrestados);
		L:=L^.sig;
	end;
end;
procedure ImprimirArbolISBN (aISBN:arbolISBN);
begin
	if aISBN <> nil then begin
		ImprimirArbolISBN(aISBN^.hiISBN);
		writeln ('ISBN = ', aISBN^.ISBN);
		ImprimirLista (aISBN^.dato);
		writeln ();
		ImprimirArbolISBN(aISBN^.hdISBN);
	end;
end;


function mayor (a:arbol) : integer;
begin
	if a^.hd <> nil then
		mayor:=mayor (a^.hd)
	else
		if a <> nil then
			mayor:=a^.dato.ISBN
		else
			mayor:=-1;
end;

function menor (a:arbol): integer;
begin
	if a^.hi <> nil then
		menor:=menor (a^.hi)
	else
		if a <> nil then
			menor:=a^.dato.ISBN
		else
			menor:=-1;
end;



procedure cargarDatos (var a:arbol; var aISBN:arbolISBN);
var
	p:prestamo;
begin
	leerPrestamo (p);
	while p.ISBN <> 0 do begin
		generarArbol (a,p);
		generarArbolISBN (aISBN,p);
		leerPrestamo (p);
	end;
end;

function prestamosSocio (a:arbol; socio:integer) : integer;
begin
	if a = nil then
		prestamosSocio:=0
	else begin
		if a^.dato.socio= socio then begin
			prestamosSocio:=prestamosSocio (a^.hd,socio) + prestamosSocio (a^.hi,socio) + 1;
		end
		else
			prestamosSocio:=prestamosSocio (a^.hd,socio) + prestamosSocio (a^.hi,socio);
	end;
end;


procedure prestamosSocio2 (aISBN: arbolISBN; socio:integer; var cant:integer);
begin
	if aISBN <> nil then begin
		while aISBN^.dato <> nil do begin
			if aISBN^.dato^.dato.socio = socio then 
				cant:=cant+1;
			aISBN^.dato:=aISBN^.dato^.sig;
		end;
	
	prestamosSocio2 (aISBN^.hdISBN,socio,cant);
	prestamosSocio2 (aISBN^.hiISBN,socio,cant);
	end;
end;
				
var
	a:arbol;
	aISBN:arbolISBN;
	max:integer;
	min:integer;
	cantPres:integer;
	cantPres2:integer;
begin
	a:=nil;
	aISBN:=nil;
	cargarDatos (a,aISBN);
	//ImprimirArbol (a);
	ImprimirArbolISBN (aISBN);
	max:=mayor (a);
	if max= -1 then
		writeln ('no se encuentra')
	else
		writeln ('el ISBN mas grande es el ', max);
	min:=menor (a);
	if min= -1 then
		writeln ('no se encuentra')
	else
		writeln ('el ISBN mas chico es el ', min);
		
	cantPres:=prestamosSocio(a,5);
	if cantPres = 0 then
		writeln ('no se encuentra')
	else
		writeln (' prestamos del socio ingresado = ', cantPres);
	cantPres2:=0;
	prestamosSocio2 (aISBN,4, cantPres2);
	if cantPres2= 0 then 
		writeln ('no se encuentra')
	else
		writeln ('prestamos del socio ingresado en el otro arbol = ', cantPRes2);
	
end.
