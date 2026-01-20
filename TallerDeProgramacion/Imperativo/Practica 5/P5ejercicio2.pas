program P5ejercicio2;
type
rangoFabri=2010..2018;
auto=record
	patente:integer;
	anoFabri:rangoFabri;
	marca:string;
	modelo:integer;
end;

arbolA=^nodoA;
nodoA=record
	dato:auto;
	HD,HI:arbolA;
end;

ListaAutos=^nodoL;
nodoL=record
	auxau:auto;
	sig:ListaAutos;
end;

arbolB=^nodoB;
nodoB=record
	dato:ListaAutos;
	HD,HI:arbolB;
end;


procedure leerAuto (var au:auto);
begin
	writeln ('ingrese la marca ');
	readln (au.marca);
	if au.marca <> 'MMM' then begin
		writeln ('ingrese la patente');
		readln (au.patente);
		writeln ('ingrese el año de fabricacion (entre 2010 y 2018)');
		readln (au.anoFabri);
		writeln ('ingrese el modelo');
		readln (au.modelo);
	end;
end;

procedure GenerarArbolA (var a:arbolA; au:auto);
begin
	if a = nil then begin
		new (a);
		a^.dato:=au;
		a^.HD:=nil;
		a^.HI:=nil;
	end
	else begin
		if au.patente < a^.dato.patente then begin
			GenerarArbolA (a^.HI,au);
		end
		else
			GenerarArbolA (a^.HD,au);
	end;
end;
			
procedure AgregarAdelante (var L:listaAutos; au:auto);
var
nuevo:ListaAutos;
begin
	new (nuevo);
	nuevo^.auxau:=au;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure GenerarArbolB (var arB:arbolB; au:auto);

begin
	if arB = nil then begin
		new (arB);
		arB^.dato:=nil;
		AgregarAdelante (arB^.dato,au);
		arB^.HD:=nil;
		arB^.HI:=nil;
	end
	else begin
		if (arB^.dato^.auxau.marca = au.marca) then begin
			AgregarAdelante (arB^.dato,au);
		end;
		if (au.patente < arB^.dato^.auxau.patente) then begin
			GenerarArbolB (arB^.HI,au);
		end
		else
			GenerarArbolB (arB^.HD,au);
	end;
end;

procedure CargarDatos (var arA:arbolA; var arB:arbolB);
var
au:auto;
begin
	leerAuto (au);
	while au.marca <> 'MMM' do begin
		GenerarArbolA (arA,au);
		GenerarArbolB (arB,au);
		leerAuto (au);
	end;
end;


function AutosdeMarca (arA:arbolA; x:string): integer;
begin
	if arA = nil then 
		AutosdeMarca:=0
	else
		if x = arA^.dato.marca then
			AutosdeMarca:= AutosdeMarca (arA^.HD,x) + AutosdeMarca (arA^.HI,x)+1
		else
			AutosdeMarca:=AutosdeMarca (arA^.HD,x) + AutosdeMarca (arA^.HI,x);
end;
function AutosdeMarcaB (arB:arbolB; i:string):integer;
begin
	if arB = nil then
		AutosdeMarcaB:=0
	else
		if arB^.dato^.auxau.marca = i then
			AutosdeMarcaB:= AutosdeMarcaB (arB^.HD,i) + 1 + AutosdeMarcaB (arB^.HI,i)
		else
			AutosdeMarcaB:=AutosdeMarcaB (arB^.HD,i) + AutosdeMarcaB (arB^.HI,i);
end;


function devolverPatente (arA:arbolA; z:integer): integer;
begin
	if arA = nil then
		devolverPatente:=0
	else
		if arA^.dato.patente=z then
			devolverPatente:= devolverPatente (arA^.HD,z) + arA^.dato.modelo + devolverPatente (arA^.HI,z)
		else
			devolverPatente:= devolverPatente (arA^.HD,z) + devolverPatente (arA^.HI,z);
end;


function devolverPatenteB (arB:arbolB; p:integer): integer;
begin
	if arB = nil then
		devolverPatenteB:=0
	else
		if arB^.dato^.auxau.patente = p then
			devolverPatenteB:= devolverPatenteB (arB^.HD,p) + devolverPatenteB (arB^.HI,p) + arB^.dato^.auxau.modelo
		else
			devolverPatenteB:= devolverPatenteB (arB^.HD,p) + devolverPatenteB (arB^.HI,p);
end;

procedure ImprimirArbol (a:arbolA);
begin
	if a <> nil then begin
		ImprimirArbol (a^.HD);
		writeln ('la patenete es ', a^.dato.patente);
		writeln ('el año de fabricacion es ', a^.dato.anoFabri);
		writeln ('la marca es  ', a^.dato.marca);
		writeln ('el modelo es ', a^.dato.modelo);
		ImprimirArbol (a^.HI);
	end;
end;

var
arA:ArbolA;
arB:arbolB;
x:string;
i:string;
z:integer;
v:integer;
p:integer;
n:integer;
BEGIN
	arA:=nil;
	arB:=nil;
	CargarDatos (arA,arB);
	writeln ('ingrese la marca a buscar en A');
	readln (x);
	writeln ('ingrese la marca a buscar en B');
	readln (i);
	writeln ('la cantidad de autos de la marca ingresada es ', (AutosdeMarca (arA,x)));
	writeln ('la cantidad de autos de la marca ingresada es ', (AutosdeMarcaB (arB,i)));
	
	writeln ('ingrese la patente a buscar en A ');
	readln (z);
	v:=devolverPatente (arA,z);
	if v=0 then
		writeln ('la patente no se encuentra ')
	else begin
		writeln ('el modelo de la patente ingresada es ', v);
	end;
	writeln ('ingrese la patente a buscar en B ');
	readln (p);
	n:= devolverPatenteB (arB,p);
	if n=0 then
		writeln ('la patente no se encuentra ')
	else
		writeln ('el modelo de la patente ingresada es ', n);
	
	ImprimirArbol (arA);
	
END.

