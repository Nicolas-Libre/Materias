program Practica5ej1;
Const
dimF=300;

type


oficina = record
cod:integer;
DNI:integer;
valor:real;
end;


vectorOficina = array [1..dimF] of oficina;


procedure leerOficina (var o:oficina);
begin
	writeln ('ingrese el codigo');
	readln (o.cod);
	if o.cod <> 0 then begin
		writeln ('ingrese el dni');
		readln (o.DNI);
		writeln ('ingrese el valor');
		readln (o.valor);
	end;
end;

procedure cargarVector (var v:vectorOficina; var dimL:integer);
var
	o:oficina;
begin
	leerOficina (o);
	while o.cod <> 0 do begin
		dimL:=dimL+1;
		v[dimL]:=o;
		leerOficina (o);
	end;
end;


procedure ordenarVector (var v:vectorOficina; dimL:integer);
var
	i,j,p:integer;
	item:oficina;
begin
	for i:= 1 to dimL-1 do begin
		p:=i;
		for j:=i+1 to dimL do begin
			if v[j].cod < v[p].cod then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;


procedure ImprimirVector (v:vectorOficina; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do begin
		writeln ('codigo = ',v[i].cod);
		writeln ('DNI = ',v[i].DNI);
		writeln ('valor = ',v[i].valor:2:2);
	end;
end;


function montoTotal (v:vectorOficina; dimL:integer) :real;
begin
	if dimL <> 0 then begin
		montoTotal:= v[dimL].valor + montoTotal(v,dimL-1);
	end
	else
		montoTotal:=0;
end;

var
	v:vectorOficina;
	dimL:integer;
	total:real;
begin
	dimL:=0;
	cargarVector (v,dimL);
	ImprimirVector (v, dimL);
	writeln ('');
	writeln ('');
	writeln ('---------------');
	writeln ('');
	writeln ('');
	ordenarVector (v,dimL);
	ImprimirVector (v, dimL);
	total:= montoTotal (v,dimL);
	writeln ('monto total de expensas = ', total:2:2);
end.
