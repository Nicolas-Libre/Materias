program P4ejercicio3;
type
Pvendido = record
	codigo:integer;
	UnidadesVendidas:integer;
	montoTotal:real;
end;

Venta =record
	codigoV:integer;
	codprodVendido:integer;
	cantUniVendidas:integer;
	PrecioUnitario:real;
end;

arbol=^nodo;
nodo =record
dato:Pvendido;
HI,HD:arbol;
end;

procedure leerVenta (var v:venta);
begin
	writeln ('ingrese el codigo de venta (-1 para terminar)');
	readln (v.codigoV);
	if v.codigoV >-1 then begin
		writeln ('ingrese el codigo del productovendido');
		readln (v.codprodVendido);
		writeln ('ingrese las unidades vendidas');
		readln (v.cantUniVendidas);
		writeln ('ingrese el preico por unidad');
		readln (v.PrecioUnitario);
	end;
end;
procedure armarproducto (var P:Pvendido; v:venta);
begin
	p.codigo:=v.codigoV;
	p.unidadesVendidas:=v.cantUniVendidas;
	p.montoTotal:=(v.PrecioUnitario * v.cantUniVendidas);
end;




procedure GenerarArbol (var a:arbol; v:venta);
var
p:Pvendido;
begin
	if a=nil then begin
		new (a);
		armarproducto (p,v);
		a^.dato:=p;
		a^.HD:=nil;
		a^.HI:=nil;
	end
	else begin
		if (v.codprodvendido = a^.dato.codigo) then begin
			a^.dato.UnidadesVendidas:=(a^.dato.UnidadesVendidas + v.cantUniVendidas);
			a^.dato.montoTotal:= a^.dato.montoTotal + (v.PrecioUnitario*v.cantUniVendidas);
		end
		
		else begin
		if (p.codigo <=a^.dato.codigo) then begin
			GenerarArbol (a^.HI,v);
		end
		else 
			GenerarArbol (a^.HD,v);
		end;
	end;
end;

procedure CodigoMaxUni (a:arbol; var MaxCod:integer; var MaxUni:integer);
begin
	if (a <> nil) then begin
		if (a^.dato.UnidadesVendidas > MaxUni) then begin
			MaxCod:= a^.dato.codigo;
			MaxUni:=a^.dato.UnidadesVendidas;
		end;
		CodigoMaxUni (a^.HI, MaxCod,MaxUni);
		CodigoMaxUni (a^.HD,MaxCod,MaxUni);
	end;
end;
			
function MenoresqueX (a:arbol; x:integer): integer;
begin
	if a = nil then 
		MenoresqueX:=0
		else begin
			if (a^.dato.codigo < x) then begin
				MenoresqueX:=(MenoresqueX (a^.HI,x) + 1+MenoresqueX (a^.HD,x));
			end
		else begin
			MenoresqueX:=MenoresqueX (a^.HI,x);
		end;
	end;
end;
	
function MontoTotalentreByC (a:arbol; B:integer; C:integer): real;
begin
	if a = nil then begin
		MontoTotalentreByC :=0;
	end
	else begin
		if (a^.dato.codigo > B) and (a^.dato.codigo < C) then begin
			MontoTotalentreByC:= a^.dato.montoTotal + MontoTotalentreByC(a^.HI,B,C)+ MontoTotalentreByC (a^.HD,B,C);
		end
		else begin

			MontoTotalentreByC:= MontoTotalentreByC (a^.HD,B,C);
			MontoTotalentreByC:= MontoTotalentreByC (a^.HI,B,C);
		end;
	end;
end;

procedure ImprimirArbol (ar:arbol);

begin
	if ar <> nil then begin
		imprimirArbol(ar^.HD);
		writeln ('el codigo es ', ar^.dato.codigo);
		writeln ('las unidades vendidas son ',ar^.dato.UnidadesVendidas);
		writeln ('el monto total es ',(ar^.dato.montoTotal):2:2);

		ImprimirArbol(ar^.HI);
	end;
end;


var
a:arbol;
v:venta;
MaxCod:integer;
MaxUni:integer;
B:integer;
C:integer;
x:integer;
z:integer;
i:real;
BEGIN
	a:=nil;
	
	leerVenta (v);
	while (v.codigoV <> -1) do begin
		GenerarArbol (a,v);
		leerVenta (v);
	end;
	ImprimirArbol (a);
	
	CodigoMaxUni (a,MaxCod,MaxUni);
	writeln ('El codigo con mas unidades es ', MaxCod);
	writeln ('con un total de ', MaxUni); writeln ('unidades vendidas');
	writeln ('');
	writeln ('ingrese el valor a evaluar ');
	readln (x);
	z:= MenoresqueX (a,x);
	writeln ('la cantidad de codigos menores que el valor ingresado son ', z);
	writeln ('ingrese el limite inferior ');
	readln (B);
	writeln ('ingrese el limite superior ');
	readln (C);
	
	i:= MontoTotalentreByC (a,B,C);
	writeln ('el punto monto total entre los 2 valores ingresados es igual a ', i:2:2);

END.

