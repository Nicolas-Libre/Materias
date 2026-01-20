program Practica1ej4;
Const
dimF=30;
type
rangoRubro=1..8;
producto =record
	codigo:integer;
	rubro:rangoRubro;
	precio: real;
end;


Lista=^nodo;
nodo=record
dato:producto;
sig:Lista;
end;

VectorRubro3 = array [1..dimF] of producto;

procedure leerProducto (var p:producto);
begin
	writeln ('ingrese el codigo');
	readln (p.codigo);
	writeln ('ingrese el rubro (1-8)');
	readln (p.rubro);
	writeln ('ingrese el precio');
	readln (p.precio);
end;

procedure InsertarOrdenado (var L:lista; p:producto);
var
	act,ant,nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato:=p;
	act:=L;
	ant:=L;
	while ((act<>nil) and (p.codigo < act^.dato.codigo) and (p.rubro = act^.dato.rubro)) do begin
		ant:=act;
		act^.sig:=act^.sig;
	end;
	if act=ant then begin
		L:=nuevo;
	end
	else
		ant^.sig:=nuevo;
	nuevo^.sig:=act;
end;

procedure generarLista (var L:lista);
var
p:producto;
begin
	leerProducto (p);
	while p.precio <>0 do begin
		InsertarOrdenado (L,p);
		leerProducto (p);
	end;
end;

procedure generarVector (L:lista; var v:VectorRubro3; var dimL:integer);
var
	fin:boolean;
begin
	fin:=false;
	while fin =false do begin
		if L=nil then begin
			fin:=true;
		end
		else begin
			if (L^.dato.rubro=3) then begin
				dimL:=dimL+1;
				v[dimL]:=L^.dato;
			end;
			if ((dimL=dimF) or (L^.dato.rubro =4)) then
				fin:=true
			else
				L:=L^.sig;
		end;
	end;
end;

procedure OrdenarVector (var v:VectorRubro3; dimL:integer);
var
	i,j,p:integer;
	item:producto;
begin
	for i:=1 to dimL-1 do begin
		p:=i;
		for j:=i+1 to dimL do begin
			if v[j].precio < v[p].precio then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;
		
			

procedure ImprimirLista (L:lista);
begin
	if L<>nil then begin
		writeln ('el codigo es ', L^.dato.codigo);
		writeln ('el rubro es ', L^.dato.rubro);
		writeln ('el precio es ', L^.dato.precio:2:2);
		L:=L^.sig;
		ImprimirLista (L);
	end;
end;

procedure ImprimirVector (v:VectorRubro3; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do begin
		writeln ('el precio del producto ', i, ' es ', v[i].precio:2:2);
	end;
end;

var
L:lista;
v: VectorRubro3;
dimL:integer;
begin
	dimL:=0;
	L:=nil;
	generarLista (L);
	ImprimirLista (L);
	generarVector (L,v,dimL);
	ImprimirVector (v,dimL);
	OrdenarVector (v,dimL);
	ImprimirVector (v,dimL);
	
end.
