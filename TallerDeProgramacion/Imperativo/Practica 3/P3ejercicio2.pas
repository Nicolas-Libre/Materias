program P3ejercicio1;
type
venta = record
	codigo:integer;
	fecha:integer;
	cant:integer;
end;

arbol1 =^nodo;
nodo =record
	dato:venta;
	HD:arbol1;
	HI:arbol1;
end;


arbol2 =^nodo2;
nodo2=record
	codigo:integer;
	cantTotal:integer;
	HD:arbol2;
	HI:arbol2;
end;

listaV=^nodoL;
nodoL=record
	dato:venta;
	sig:listaV;
end;
arbol3=^nodo3;
nodo3=record
	codigo:integer;
	listaV:listaV;
	HD,HI:arbol3;
end;


procedure VentaRandom (var v:venta);
begin
	
	v.codigo:=random (100);
	v.fecha:=random (31);
	v.cant:=random (100);
end;
procedure AgregaralArbolUNO (var a1:arbol1; v:venta);
begin
	if a1=nil then begin
		new (a1);
		a1^.dato.codigo:= v.codigo;
		a1^.dato.fecha:=v.fecha;
		a1^.dato.cant:=v.cant;
		a1^.HD:=nil;
		a1^.HI:=nil;
	end
	else 
	if (a1^.dato.codigo >= v.codigo) then begin
		AgregaralArbolUNO (a1^.HD,v);
	end
	else begin
		AgregaralArbolUNO (a1^.HI,v);
	end;
end;	

procedure AgregaralArbolDOS (var a2:arbol2; v:venta);
begin
	if a2=nil then begin
		new (a2);
		a2^.codigo:=v.codigo;
		a2^.cantTotal:=v.cant;
		a2^.HD:=nil;
		a2^.HI:=nil;
	end
	else 
	if (a2^.codigo = v.codigo) then begin
		a2^.cantTotal:=a2^.cantTotal + v.cant
	end
	else
	if (a2^.codigo >= v.codigo) then begin
		AgregaralArbolDOS (a2^.HD,v);
	end
	else begin
		AgregaralArbolDOS (a2^.HI,v);
	end;
end;	

procedure AgregarAdelante (var L:listaV; v:venta);
var
nuevo:listaV;
begin
	new (nuevo);
	nuevo^.dato:=v;
	nuevo^.sig:=L;
	L:=nuevo;
end;

	
procedure AgregaralArbolTRES (var a3:arbol3; v:venta);
begin
	if a3=nil then begin
		new (a3);
		AgregarAdelante (a3^.ListaV,v);
		a3^.codigo:=v.codigo;
		a3^.HD:=nil;
		a3^.HI:=nil;
	end
	else
	if a3^.codigo=v.codigo then begin
		AgregarAdelante (a3^.ListaV,v)
	end
	else
	if (a3^.codigo >= v.codigo) then begin
		AgregaralArbolTRES (a3^.HD,v);
	end
	else begin
	AgregaralArbolTRES (a3^.HI,v);
	end;
end;	

function Buscarfecha (a1:arbol1; x:integer) : integer;
begin
	If a1<>nil then begin
		if a1^.dato.fecha=x then begin
			Buscarfecha:=a1^.dato.cant + Buscarfecha (a1^.HI,x) + Buscarfecha (a1^.HD,x);
		end
		else
		Buscarfecha:= Buscarfecha (a1^.HI,x) + Buscarfecha (a1^.HD,x);
	end;
end;
			
	
var
a1:arbol1;
a2:arbol2;
a3:arbol3;
v:venta;
x:integer;
z:integer;
BEGIN
	randomize;
	VentaRandom (v);
	
	while (v.codigo <> 0) do begin
		AgregaralArbolUNO (a1, v);
		AgregaralArbolDOS (a2,v);
		AgregaralArbolTRES(a3,v);
		VentaRandom (v);
	end;
writeln ('ingrese la fecha a buscar ');
readln (x);
z:= Buscarfecha(a1,x);
writeln('la cantidad de elementos en la fecha es ', z);


	

	
END.

