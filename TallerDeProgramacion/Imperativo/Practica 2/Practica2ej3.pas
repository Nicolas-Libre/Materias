program Practica2ej3;
Const
dimF=20;

type

VectorInteger= array [1..dimF] of integer;



procedure generarVector (var v:VectorInteger; dimL:integer);
var
	x:integer;
begin
	if dimL > 0 then begin
		x:= random (1251) + 300;
		v[dimL]:=x;
		generarVector (v,dimL-1);
	end;
end;

procedure ordenarVector (var v:VectorInteger; dimL:integer);
var
	i,j,p,item:integer;
begin
	for i:=1 to dimL-1 do begin
		p:=i;
		for j:=i+1 to dimL do begin
			if v[j] < v[p] then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;

procedure ImprimirVector (v:VectorInteger; dimL:integer);
begin
	if dimL>0 then begin
		writeln ('numero = ', v[dimL]);
		ImprimirVector (v,dimL-1);
	end;
end;

var
	v:VectorInteger;
	dimL:integer;
begin
	dimL:=dimF;
	generarVector (v,dimL);
	ImprimirVector (v,dimL);
	writeln ('');
	writeln ('');
	writeln ('---------------');
	writeln ('');
	writeln ('');
	ordenarVector (v,dimL);
	ImprimirVector (v,dimL);
end.


