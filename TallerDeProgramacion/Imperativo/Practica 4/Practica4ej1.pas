program Practica4ej1;
type

producto =record
codigo:integer;
cantTotal:integer;
montoTotal:real;
end;

venta=record
codigoV:integer;
codigoP:integer;
cantUni:integer;
precioUni:real;
end;

arbol=^nodo;
nodo=record
dato:producto;
hi:arbol;
hd:arbol;
end;

procedure leerVenta (var v:venta);
begin
	writeln ('ingrese el codigo de venta');
	readln (v.codigoV);
	if v.codigoV<> 0 then begin
		writeln ('ingrese el codigo de producto');
		readln (v.codigoP);
		writeln ('ingrese el cantidades vendidas del producto ');
		readln (v.cantUni);
		writeln ('ingrese el monto por producto ');
		readln (v.precioUni);
	end;
end;


procedure armarPro (var p:producto; v:venta);
begin
	p.codigo:=v.codigoP;
	p.cantTotal:=v.cantUni;
	p.montoTotal:= v.cantUni * v.precioUni;
end;

procedure generarArbol (var a:arbol; v:venta);
var
	p:producto;
begin
	if a= nil then begin
		new(a);
		armarPro (p,v);
		a^.dato:=p;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if v.codigoP = a^.dato.codigo then begin
			a^.dato.cantTotal:=a^.dato.cantTotal + v.cantUni;
			a^.dato.montoTotal:=a^.dato.montoTotal + (v.cantUni * v.precioUni);
		end
		else
			if v.codigoP < a^.dato.codigo then
				generarArbol (a^.hi,v)
			else
				generarArbol (a^.hd,v);
	end;
end;


procedure cargarDatos (var a:arbol);
var
	v:venta;
begin
	leerVenta (v);
	while v.codigoV <> 0 do begin
		generarArbol (a,v);
		leerVenta (v);
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		ImprimirArbol (a^.hi);
		writeln ('codigo = ',a^.dato.codigo);
		writeln ('monto total = ',a^.dato.montoTotal:2:2);
		writeln ('cant total = ', a^.dato.cantTotal);
		ImprimirArbol (a^.hd);
	end;
end;


function minimo (a:arbol; min:integer) : integer;
begin
	if a = nil then 
		minimo:=min
	else begin
		if a^.hi = nil then begin
			min:=a^.dato.codigo;
			minimo:=min
		end
		else
			minimo (a^.hi,min);
	end;
end;
	
	
function cantMenores (a:arbol; x:integer) : integer;
begin
	if a = nil then
		cantMenores:= 0
	else begin
		if a^.dato.codigo < x then begin

			cantMenores:= cantMenores (a^.hi,x) + cantMenores (a^.hd,x) + 1;
		end
		else
			cantMenores:=cantMenores (a^.hi,x);
	end;
end;
	
	
function montoTotal2Valores (a:arbol; min:integer; max:integer) : real;
begin
	if a= nil then
		montoTotal2Valores:=0
	else begin
		if ((a^.dato.codigo > min) and (a^.dato.codigo < max)) then begin
			montoTotal2Valores:= a^.dato.montoTotal + montoTotal2Valores (a^.hi,min,max) + montoTotal2Valores (a^.hd,min,max);
		end
		else
			if a^.dato.codigo <= min then
				montoTotal2Valores:= montoTotal2Valores (a^.hd,min,max)
			else
				if a^.dato.codigo >= max then
					montoTotal2Valores:= montoTotal2Valores (a^.hi,min,max);
	end;
end;
	
var
	a:arbol;
	min:integer;
	cantMin:integer;
	total:real;
begin
	cargarDatos (a);
	ImprimirArbol (a);
	min:= minimo (a,9999);
	if min= 9999 then
		writeln ('arbol vacio')
	else
		writeln ('el codigo minimo es ', min);
	cantMin:= cantMenores (a,5);
	writeln ('codigos menores al codigo ingresado = ', cantMin);
	total:=montoTotal2Valores (a,2,8);
	writeln ('monto total entre los valores ingreados = ', total:2:2);
end.







