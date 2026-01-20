program Parcial1GoogleDrive;
type

rangoSucursal=1..5;

venta=record
codigo:integer;
dni:integer;
sucursal:rangoSucursal;
montoGastado:real;
end;


info=record
sucursal:integer;
montoGastado:real;
end;

vecInfo= array [rangoSucursal] of real;


arbol=^nodo;
nodo=record
dni:integer;
dato:vecInfo;
hd:arbol;
hi:arbol;
end;


procedure leerVenta (var v:venta) ;
begin
	writeln ('ingrese el codigo de venta');
	readln (v.codigo);
	if (v.codigo<>0) then begin
		writeln ('ingrese el dni del cliente');
		readln (v.dni);
		writeln ('ingrese la sucursal de venta');
		readln (v.sucursal);
		writeln ('ingrese el monto Gastado');
		readln (v.montoGastado);
	end;
end;




procedure InicializarVector (var v:vecInfo);
var
	i:integer;
begin
	for i:=1 to 5 do begin
		v[i]:=0;
	end;
end;

procedure sumarEnVector (var v:vecInfo; pos: integer; monto:real);
begin
	v[pos]:=v[pos] + monto;
end;

procedure generarArbol (var a:arbol; v:venta);
begin
	if a=nil then begin
		new (a);
		InicializarVector(a^.dato);
		a^.dni:=v.dni;
		sumarEnVector (a^.dato, v.sucursal, v.montoGastado);
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if v.dni = a^.dni then begin
			sumarEnVector (a^.dato, v.sucursal, v.montoGastado);
		end
		else
			if v.dni> a^.dni then
				generarArbol(a^.hd,v)
			else
				if v.dni < a^.dni then
					generarArbol(a^.hi,v);
	end;
end;
			
		


			

function noGasto (a:Arbol; sucu:integer) : integer;
var
	cant:integer;
begin
	if a=nil then
		noGasto:=0
	else begin
		cant:=0;
		if a^.dato[sucu] = 0 then
			cant:=cant+1;
		noGasto:= cant+ noGasto (a^.hi,sucu) + noGasto (a^.hd,sucu);
	end;
end;



function sumarVec(v:vecInfo) : real;
var 
	i:integer;
	cant:real;
begin
	cant:=0;
	for i:=1 to 5 do begin
		cant:=cant+v[i];
	end;
	sumarVec:=cant;
end;

function totalGastado (a:Arbol; unDni:integer) : real;
begin
	if a=nil then
		totalGastado:=0
	else begin
		if a^.dni = unDni then begin
			totalGastado:= sumarVec(a^.dato);
		end
		else
			if unDni > a^.dni then
				totalGastado:=totalGastado (a^.hd,unDni)
				
			else
				totalGastado:=totalGastado (a^.hi,unDni);
	end;
end;
			
			
procedure ImprimirVector (v:vecInfo);
var
	i:integer;
begin
	for i:= 1 to 5 do begin
		writeln ('sucursal = ', i, ', monto Gastado= ', v[i]:2:2);
	end;
end;

procedure ImprimirArbol (a:Arbol);
begin
	if a<> nil then begin
		writeln ('cliente = ', a^.dni);
		ImprimirVector (a^.dato);
		ImprimirArbol(a^.hi);
		ImprimirArbol(a^.hd);
	end;
end;
			
procedure cargarDatos (var a:arbol);
var
	v:venta;
begin	
	leerVenta (v);
	while (v.codigo <> 0) do begin
		generarArbol (a,v);
		leerVenta(v);
	end;
end;


var
	a:arbol;
	cantNoGastaron:integer;
	gastoX:real;
begin
	a:=nil;
	cargarDatos(a);
	ImprimirArbol(a);
	cantNoGastaron:=noGasto (a,2);
	writeln ('clientes que no gastaron en la sucursal ingreada= ', cantNoGastaron);
	gastoX:=totalGastado(a,1);
	writeln ('el cliente ingresado gasto= ', gastoX:2:2);

end.





