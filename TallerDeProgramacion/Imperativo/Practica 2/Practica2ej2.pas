program Practica2ej2;


type


lista=^nodo;
nodo=record
dato:integer;
sig:lista;
end;


procedure AgregarAdelante (var L:lista; x:integer);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato:=x;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarLista (var L:lista);
var
	x:integer;
begin
	x:= (random (11));
	x:=x +10;
	if (x <> 10) then begin
		AgregarAdelante (L,x);
		generarLista (L);
	end
end;

procedure ImprimirLista (L:lista);
begin
	if (L<> nil) then begin
		writeln ('numero = ', L^.dato);
		L:=L^.sig;
		ImprimirLista (L);
	end;
end;

procedure ImprimirInverso (L:lista);
begin
	if L<> nil then begin
		ImprimirInverso (L^.sig);
		writeln ('numero = ', L^.dato);
	end;
end;

function Minimo (L:lista; nMin:integer) : integer;
begin
	if (L= nil) then
		Minimo:=nMin
	else begin
		if (L^.dato < nMin) then begin
			nMin:=L^.dato;
		end;
		Minimo:= Minimo (L^.sig,nMin);
	end;
end;

function Encontre (L:lista; z:integer) : boolean;
begin
	if L = nil then
		Encontre:= false
	else
		if z = L^.dato then
			Encontre:=true
		else
			Encontre:=Encontre (L^.sig,z);
end;
		
var

L:lista;
z:integer;
nMin:integer;
esta:boolean;
nChico:integer;
begin
	Randomize;
	L:=nil;
	generarLista (L);
	ImprimirLista (L);
	writeln ('');
	writeln ('');
	writeln ('------------');
	writeln ('');
	writeln ('');
	nMin:=201;
	z:=12;
	nChico:= Minimo (L,nMin);
	writeln ('el numero mas chico es el ', nChico);
	esta:= Encontre (L, z);
	if esta=true then
		writeln ('el valor ', z, ' esta en la lista')
	else
		writeln ('el valor ', z, ' NO esta en la lista');
		
	ImprimirInverso (L);
end.
