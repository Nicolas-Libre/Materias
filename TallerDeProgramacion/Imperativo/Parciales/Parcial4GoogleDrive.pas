program Parcial4GoogleDrive;
type

rangoMes=1..12;

compra= record
codigoCli:integer;
nFactura:integer;
mes:rangoMes;
montoGastado:real;
end;

vectorMes= array [rangoMes] of real;

arbol=^nodo;
nodo=record
cliente:integer;
dato:vectorMes;
hd:arbol;
hi:arbol;
end;

procedure leerCompra (var c:compra);
begin
	writeln ('ingrese el codigo del cliente');
	readln (c.codigoCli);
	if c.codigoCli<> 0 then begin
		writeln ('ingrese el numero de la factura');
		readln (c.nFactura);
		writeln ('ingrese el mes');
		readln (c.mes);
		writeln ('ingrese el monto gastado');
		readln (c.montoGastado);
	end;
end;


procedure inicializarVector (var v:vectorMes);
var
	i:rangoMes;
begin
	for i:=1 to 12 do begin
		v[i]:=0;
	end;
end;


procedure sumarEnVector (var v:vectorMes; mes:rangoMes; monto:real);
begin
	v[mes]:=v[mes] + monto;
end;

procedure generarArbol (var a:arbol; c:compra);
begin
	if a= nil then begin
		new (a);
		a^.cliente:=c.codigoCli;
		inicializarVector (a^.dato);
		sumarEnVector (a^.dato,c.mes,c.montoGastado);
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if c.codigoCli = a^.cliente then begin
			sumarEnVector (a^.dato, c.mes, c.montoGastado);
		end
		else 
			if c.codigoCli < a^.cliente then
				generarArbol (a^.hi,c)
			else
				generarArbol (a^.hd,c);
	end;
end;


procedure cargarDatos (var a:arbol);
var
	c:compra;
begin
	leerCompra(c);
	while c.codigoCli <> 0 do begin
		generarArbol(a,c);	
		leerCompra (c);
	end;
end;


function maxEnVector (v:vectorMes): rangoMes;
var	
	maxMes:rangoMes;
	maxCant:real;
	i:rangoMes;
begin
	maxCant:=0;
	for i:=1 to 12 do begin
		if v[i] > maxCant then begin
			maxCant:=v[i];
			maxMes:=i;
		end;
	end;
	maxEnVector:=maxMes
end;

function maxMes (a:Arbol; cli:integer) : integer;
begin
	if a=nil then
		maxMes:=0
	else begin
		if a^.cliente = cli then
			maxMes:=maxEnVector (a^.dato)
		else
			if cli > a^.cliente then
				maxMes:=maxMes(a^.hd,cli)
			else
				maxMes:=maxMes (a^.hi,cli);
	end;
end;


function noGastoEnMes(a:arbol; mes:rangoMes) : integer;
begin
	if a=nil then
		noGastoEnMes:=0
	else begin
		if a^.dato[mes] = 0 then
			noGastoEnMes:= 1 + noGastoEnMes (a^.hd,mes) + noGastoEnMes (a^.hi,mes)
		else
			noGastoEnMes:= noGastoEnMes (a^.hd,mes) + noGastoEnMes (a^.hi,mes);
	end;
end;
			
			
procedure ImprimirVector (v:vectorMes);
var
	i:rangoMes;
begin
	for i:=1 to 12 do begin
		writeln ('en el mes ', i, ', gasto ', v[i]:2:2);
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		ImprimirArbol (a^.hi);
		writeln ('Cliente= ', a^.cliente);
		ImprimirVector (a^.dato);


		ImprimirArbol (a^.hd);
	end;
end;

var
	a:arbol;
	clienteABuscar:integer;
	mayorMes:rangoMes;
	cantSinGastar:integer;
	mesSinGastar:rangoMes;
begin
	a:=nil;
	cargarDatos(a);
	ImprimirArbol (a);
	clienteABuscar:=2;
	mayorMes:=maxMes (a,clienteABuscar);
	writeln ('el mes que mas gasto el cliente con codigo ', clienteABuscar, ' es el mes ', mayorMes);
	mesSinGastar:=5;
	cantSinGastar:= noGastoEnMes (a,mesSinGastar);
	writeln ('cantidad de clientes que no gastaron en el mes ', mesSinGastar, ' = ', cantSinGastar);
	
end.






