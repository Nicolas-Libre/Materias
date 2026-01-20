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
		if v.codprodvendido = a^.dato.codigo then begin
			a^.dato.UnidadesVendidas:=(a^.dato.UnidadesVendidas + v.cantUniVendidas);
			a^.dato.montoTotal:= a^.dato.montoTotal + (v.PrecioUnitario*v.cantUniVendidas);
		end
		
		else begin
		if p.codigo <=a^.dato.codigo then begin
			GenerarArbol (a^.HI,v);
		end
		else 
			GenerarArbol (a^.HD,v);
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

BEGIN
	a:=nil;
	leerVenta (v);
	while (v.codigoV <> -1) do begin
		GenerarArbol (a,v);
		leerVenta (v);
	end;
	ImprimirArbol (a);
	
		
	


END.

