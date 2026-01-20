program Practica5ej3;
type

rangoRubro=1..10;

producto = record
rubro:rangoRubro;
codigo:integer;
stock:integer;
precio:integer;
end;

pAux= record
codigo:integer;
stock:integer;
precio:integer;
end;




arbol=^nodoA;
nodoA=record
dato:pAux;
hd:arbol;
hi:arbol;
end;

vectorArbol = array [rangoRubro] of arbol;

prodCodMax=record
codMax:integer;
stockMax:integer;
end;
vectorCodMax = array[rangoRubro] of prodCodMax;


procedure leerProducto (var p:producto);
begin
	writeln ('ingrese el codigo');
	readln (p.codigo);
	if p.codigo <> 0 then begin
		writeln ('ingrese el rubro');
		readln (p.rubro);
		writeln ('ingrese el stock');
		readln (p.stock);
		writeln ('ingrese el precio por unidad');
		readln (p.precio);
	end;
end;

procedure generarArbol (var a:arbol; p:pAux);
begin	
	if a=nil then begin
		new (a);
		a^.dato:=p;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if p.codigo <= a^.dato.codigo then 
			generarArbol (a^.hi,p)
		else
				generarArbol (a^.hd,p)
	end;
end;

procedure InicializarVector (var v:vectorArbol);
var
	i:integer;
begin
	for i:=1 to 10 do begin
		v[i]:=nil;
	end;
end;

procedure cargarVector (var v:vectorArbol);
var
	p:producto;
	aux:paux;
begin
	leerProducto (p);
	while p.codigo <> 0 do begin
		aux.codigo:=p.codigo;
		aux.stock:=p.stock;
		aux.precio:=p.precio;
		generarArbol (v[p.rubro],aux);
		leerProducto(p);
	end;
end;

function BuscarCodigo (a:Arbol;c:integer): boolean;
begin
	if a = nil then
		BuscarCodigo:=false
	else begin
		if a^.dato.codigo = c then
			BuscarCodigo:= true
		else
			if c > a^.dato.codigo then
				BuscarCodigo:=BuscarCodigo (a^.hd,c)
			else
				BuscarCodigo:= BuscarCodigo (a^.hi,c);
	end;
end;

function BuscarB (v:vectorArbol; r:integer; c:integer) : boolean;
begin
	BuscarB:=BuscarCodigo (v[r], c);
end;
		
		
procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		writeln ('codigo = ',a^.dato.codigo);
		writeln ('stock= ',a^.dato.stock);
		writeln ('precio= ',a^.dato.precio);
		writeln ('');
		ImprimirArbol (a^.hi);
		ImprimirArbol (a^.hd);
	end;
end;

procedure ImprimirVector (v:vectorArbol);
var
	i:integer;
begin
	for i:=1 to 10 do begin
		writeln ('rubro= ',i);
		writeln ('');
		ImprimirArbol (v[i]);
		writeln ('---------');
	end;
end;

procedure calcularMaximo (a:arbol; var p:prodCodMax);
begin
	if a<> nil then begin
			p.codMax:=a^.dato.codigo;
			p.stockMax:=a^.dato.stock;
			calcularMaximo (a^.hd,p);
	end;
end;
		
procedure cargarMax (v:vectorArbol; var vC: vectorCodMax);
var
	p:prodCodMax;
	i:integer;
begin
	for i:= 1 to 10 do begin
		p.codMax:=-1;
		p.stockMax:=0;
		calcularMaximo (v[i],p);
		vC[i]:=p;
	end;
end;

procedure ImprimirVectorCod (vC:vectorCodMAx);
var
	i:integer;
begin
	for i:=1 to 10 do begin
		writeln ('rubro= ', i);
		writeln ('');
		if vC[i].codMax = -1 then
			writeln ('vacio')
		else begin
			writeln ('codigo mas grande = ', vC[i].codMAx);
			writeln ('stock mas grande = ', vC[i].stockMax);
			writeln ('');
		end;
	end;
end;
var
	v:vectorArbol;
	esta:boolean;
	vC:vectorCodMax;

begin
	InicializarVector (v);
	cargarVector (v);
	ImprimirVector (v);
	esta:=BuscarB (v,2,2);
	writeln (esta);
	cargarMax (v,vC);
	ImprimirVectorCod (vC);
	
	
end.



