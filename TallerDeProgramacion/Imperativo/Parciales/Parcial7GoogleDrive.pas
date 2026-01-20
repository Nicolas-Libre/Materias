program Parcial7GoogleDrive;
Const
dimF=8;
type

rangoMaterial=1..dimF;

artesania= record
id:integer;
dni:integer;
material: rangoMaterial;
end;

arbol=^nodo;
nodo=record
dni:integer;
cant:integer;
hd:arbol;
hi:arbol;
end;

regVector = record
material:rangoMaterial;
cantMaterial:integer;
end;

vecMateriales = array [rangoMaterial] of regVector;


procedure leerArtesania ( var ar:artesania);
begin
	writeln ('ingrese el dni');
	readln (ar.dni);
	if ar.dni <> 0 then begin
		writeln ('ingrese el id');
		readln (ar.id);
		writeln ('ingrese el material');
		readln (ar.material);
	end;
end;

procedure InicializarVector (var v:vecMateriales);
var
	i:rangoMaterial;
begin
	for i:=1 to dimF do begin
		v[i].material:=i;
		v[i].cantMaterial:=0;
	end;
end;



procedure generarArbol (var a:Arbol; dni:integer);
begin
	if a = nil then begin
		new (a);
		a^.dni:=dni;
		a^.cant:=a^.cant+1;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if dni = a^.dni then begin
			a^.cant:=a^.cant+1;
		end
		else 
			if dni > a^.dni then
				generarArbol(a^.hd,dni)
			else
				generarArbol (a^.hi,dni);
	end;
end;

procedure generarVector (var v:vecMateriales; pos:integer);
begin
	v[pos].cantMaterial:= v[pos].cantMaterial + 1;
end;

procedure cargarDatos (var a:arbol; var v:vecMateriales);
var
	ar:artesania;
begin
	leerArtesania(ar);
	while ar.dni <> 0 do begin
		generarArbol (a,ar.dni);
		generarVector (v,ar.material);
		leerArtesania(ar);
	end;
end;


function cantMenorDni (a:arbol; unDni:integer) : integer;
begin
	if a=nil then
		cantMenorDni:= 0
	else begin
		if a^.dni < unDni then begin
			cantMenorDni:= 1+ cantMenorDni (a^.hi,unDni) + cantMenorDni (a^.hd,unDni);
		end
		else 
			if unDni >= a^.dni then
				cantMenorDni (a^.hi,unDni)
	end;
end;


procedure ordenarVector (var v:vecMateriales; var maxMaterial:integer);
var
	i,j,p:integer;
	item:regVector;
begin
	for i:= 1 to dimF-1 do begin
		p:=i;
		for j:=i+1 to dimF do begin
			if v[j].cantMaterial < v[p].cantMaterial then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
	maxMaterial:=v[dimF].material;
end;

//modulos extras//
procedure ImprimirVector(v:vecMateriales);
var
	i:rangoMaterial;
begin
	for i:=1 to dimF do begin
		writeln ('material= ', v[i].material);
		writeln ('cantidad de artesanias= ', v[i].cantMaterial);
	end;
end;

var
	v:vecMateriales;
	a:arbol;
	cantidadDnisChicos:integer;
	maxMaterial:integer;
begin
	a:=nil;
	InicializarVector(v);
	cargarDatos (a,v);
	maxMaterial:=0;
	ImprimirVector (v);
	cantidadDnisChicos:= cantMenorDni(a,5);
	writeln('-----------------------');
	ordenarVector(v,maxMaterial);
	ImprimirVector(v);
	writeln ('cantidad de Dnis menores al ingresado = ', cantidadDnisChicos);
	writeln ('material con mas cantidad de artesanias = ', maxMaterial);


end.
