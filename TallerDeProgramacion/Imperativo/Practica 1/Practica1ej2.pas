program Practica1ej2;
Const
dimF=300;
type 
oficina = record
id: integer;
DNI: integer;
valor: real;
end;


VectorOficinas = array [1..dimF] of oficina;




procedure LeerOficina (var o:oficina);
begin
	writeln ('ingrese su id ');
	readln (o.id); 
	if (o.id <> -1) then begin
		writeln ('ingrese su dni');
		readln (o.DNI);
		writeln ('ingrese su valor de expensa');
		readln (o.valor);
	end;
end;

procedure InicializarVector (var v:VectorOficinas);
var
	i:integer;
begin
	for i:=1to dimF do begin
		v[i].id:=0;
		v[i].DNI:=0;
		v[i].valor:=-1;
	end;
end;
procedure CargarDatos (var v:VectorOficinas; var dimL: integer);
var
	o:oficina;
begin
	LeerOficina (o);
	while ((o.id <>-1) and (dimL <dimF)) do begin
		dimL:=dimL+1;
		v[dimL]:=o;
		if (dimL < dimF) then
			LeerOficina (o);
	end;
end;

procedure OrdenarInsercion (var v: VectorOficinas; dimL:integer);
var
	i,j:integer;
	actual:oficina;
begin
	for i:= 2 to dimL do begin
		actual:=v[i];
		j:=i-1;
		while ((j>0) and (v[j].id > actual.id)) do begin
			v[j+1]:=v[j];
			j:=j-1
		end;
		v[j+1]:=actual;
	end;
end;

procedure ImprimirVector (v: VectorOficinas; dimL:integer);
begin
	if (dimL<>0) then begin
		writeln (' id ', v[dimL].id);
		writeln (' DNI ', v[dimL].DNI);
		writeln (' valor ', (v[dimL].valor):2:2);
		dimL:=dimL-1;
		ImprimirVector (v,dimL);
	end;
end;
// Programa principal
var
	v:VectorOficinas;
	dimL:integer;
begin
	dimL:=0;
	InicializarVector (v);
	CargarDatos (v,dimL);
	OrdenarInsercion (v,dimL);
	ImprimirVector (v,dimL)
end.
