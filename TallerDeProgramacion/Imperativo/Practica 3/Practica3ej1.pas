program Practica3ej1;
type


socio=record
num:integer;
nombre:string;
edad:integer;
end;

arbol=^nodo;
nodo=record
hd:arbol;
hi:arbol;
dato:socio;
end;


procedure leerSocio (var s:socio);
begin
	writeln ('Ingrese el numero de socio');
	readln (s.num);
	if s.num <> 0 then begin
		writeln ('Ingrese el nombre del socio');
		readln (s.nombre);
		writeln ('Ingrese la edad del socio');
		readln (s.edad);
	end;
end;

procedure generarArbol (var a:arbol; s:socio);
begin
	if a=nil then begin
		new (a);
		a^.dato:=s;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else if s.num <= a^.dato.num then begin
			generarArbol (a^.hi,s);
		end
		else
			generarArbol (a^.hd,s);
end;
		


procedure cargarDatos (var a:arbol);
var
	s:socio;
begin
	leerSocio(s);
	while s.num <>0 do begin
		generarArbol (a,s);
		leerSocio(s);
	end;
end;




function mayorEdad (a:arbol; nMax:integer) : integer;
begin
	if a = nil then
		mayorEdad:=nMax
	else begin
		if a^.dato.edad > nMax then
			nMax:=a^.dato.edad;
		mayorEdad:= mayorEdad (a^.hd,nMax);
	end;
end;

procedure aumentarEdad (var a:arbol; var cant:integer);
begin
	if a<> nil then begin
		if (a^.dato.edad mod 2)=1 then begin
			a^.dato.edad:=a^.dato.edad+1;
			cant:=cant+1;
		end;
		aumentarEdad (a^.hi,cant);
		aumentarEdad (a^.hd,cant);
	end;
end;

function buscarNombre (a:arbol; n:string) : boolean;
begin
	if a = nil then
		buscarNombre:=false
	else
		if a^.dato.nombre = n then
			buscarNombre:=true
		else begin
			buscarNombre:= buscarNombre (a^.hd,n) or buscarNombre (a^.hi,n);
		end;
end;

procedure cantSocios (a:arbol; var cSocios:integer) ;
begin
	if a<> nil then begin
		
		cSocios:=cSocios+1;
		cantSocios (a^.hd,cSocios);
		cantSocios (a^.hi,cSocios);
	end;
end;

procedure promedioEdad (a:arbol; var cantE:integer; var sumaE:integer);
begin
	if a <> nil then begin
		cantE:=cantE+1;
		sumaE:=sumaE + a^.dato.edad;
		promedioEdad (a^.hd,cantE,sumaE);
		promedioEdad (a^.hi,cantE,sumaE);
	end;
end;

procedure ImprimirArbolCreciente(a:arbol);
begin
	if a <> nil then begin
		ImprimirArbolCreciente (a^.hi);
		writeln ('numero = ',a^.dato.num);
		writeln ('nombre = ',a^.dato.nombre);
		writeln ('edad = ',a^.dato.edad);
		ImprimirArbolCreciente (a^.hd);
	end;
end;
procedure ImprimirArbolDecreciente (a:arbol);
begin
	if a <> nil then begin
		ImprimirArbolDecreciente (a^.hd);
		ImprimirArbolDecreciente (a^.hi);
		writeln ('numero = ',a^.dato.num);
		writeln ('nombre = ',a^.dato.nombre);
		writeln ('edad = ',a^.dato.edad);
	end;
end;



var
a:arbol;
//maxEdad:integer;
//nMax:integer;
//cant:integer;
nombre:string;
encontre:boolean;
cSocios:integer;
cantE:integer;
sumaE:integer;
prom:real;
begin
	cargarDatos (a);
	//nMax:=0;
	//cant:=0;
	//maxEdad:= mayorEdad (a,nMax);
	ImprimirArbolCreciente (a);
	//writeln ('la edad mas grande es ', maxEdad);
	//aumentarEdad (a,cant);
	//ImprimirArbolCreciente (a);
	//writeln ('se aumento la edad a ', cant, ' socios');
	
	readln (nombre);
	encontre:= buscarNombre (a,nombre);
	if encontre = true then
		writeln ('el nombre esta en el arbol')
	else
		writeln ('el nombre NO esta en el arbol');
	cSocios:=0;
	cantSocios (a,cSocios);
	writeln ('socios = ', cSocios);
	sumaE:=0;
	cante:=0;
	promedioEdad (a,cantE,sumaE);
	prom:=sumaE/cantE;
	writeln ('el promedio es ', prom:2:2);
	
	
end.
