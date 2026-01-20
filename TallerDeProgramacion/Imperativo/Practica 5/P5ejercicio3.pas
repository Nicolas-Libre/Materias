program P5ejercicio3;
type
rangorubro=1..10;
producto=record
	codigo:integer;
	rubro:rangorubro;
	stock:integer;
	precioUnitario:integer;
end;
arbol=^nodo;
nodo=record
	dato:producto;
	HD,HI:arbol;
end;

Vrubro=array [rangorubro] of arbol;

procedure leerProducto (var p:producto);
begin
	writeln ('ingrese el codigo del producto ');
	readln (p.codigo);
	if p.codigo<>0 then begin
		writeln ('ingrese el rubro del producto');
		readln (p.rubro);
		writeln ('ingrese el stock');
		readln (p.stock);
		writeln ('ingrese el precio por unidad');
		readln (p.precioUnitario);
	end;
end;

procedure GenerarArbol (var a:arbol; p:producto);
begin
	if a=nil then begin
		new (a);
		a^.dato:=p;
		a^.HD:=nil;
		a^.HI:=nil;
	end
	else
		if p.codigo <= a^.dato.codigo then begin
			GenerarArbol (a^.HI,p);
		end
		else
			GenerarArbol (a^.HD,p);
		
end;

procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		ImprimirArbol (a^.HD);
		writeln ('el codigo es ', (a^.dato.codigo));
		writeln ('el rubro es ', (a^.dato.rubro));
		writeln ('el stock es ', (a^.dato.stock));
		writeln ('el precio por unidad es ', (a^.dato.precioUnitario));
		ImprimirArbol (a^.HI);
	end;
end;

procedure ImprimirVector (v:Vrubro);
var
i:integer;
begin
	for i:= 1 to 10 do begin
		ImprimirArbol (v[i]);
	end;
end;


function puntoB (v:Vrubro; x:integer; z:integer): boolean;
begin
		if v[x]^.dato.codigo = z then
			puntoB:=true
		else
			puntoB:=false;
end;

var
a:arbol;
p:producto;
v:Vrubro;
B:boolean;
x:integer;
z:integer;
BEGIN

	leerProducto (p);
	GenerarArbol (a,p);
	while p.codigo <> 0 do begin
		leerProducto(p);
		GenerarArbol (v[p.rubro],p);
	end;
	writeln ('ingrese el rubro donde buscar');
	readln (x);
	writeln ('ingrese el codigo a buscar');
	readln (z);
	B:=puntoB(v,x,z);
	if B= true then
		writeln ('el codigo ingresado si se encuentra en el rubro ingresado')
	else
		writeln ('el codigo ingresado no se encunetra en elk rubro ingresadi)');
	ImprimirVector (v);
END.

