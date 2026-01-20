program P2Ejercicio3A;
const
dimf=20;
type

Vrandom= array [1..dimF] of integer;

procedure CargarVector (var v:Vrandom;  i:integer; dimF:integer);
var
	x:integer;

begin
	i:=i+1;
	
	if i <=dimF then begin
		x:=random (1550-300+1)+300;
		v[i]:=x;
		
		cargarVector (v, i, dimF);
	end;
	
end;
	
procedure ordenarVector (var v:Vrandom; dimF:integer);
var
i:integer;
pos:integer;
j:integer;
item:integer;
begin
	
	for i:= 1 to dimF-1 do begin
		pos:=i;
		for j:= i+1 to dimF do begin
			if v[j] < v[pos] then begin
				pos:=j;
			end;
		end;
		item:=v[pos];
		v[pos]:=v[i];
		v[i]:=item;
	end;
		
end;
procedure ImprimirVector (v:Vrandom; dimF:integer);
var
i:integer;
begin
	for i:= 1 to dimF do begin
		writeln (v[i]);
	end;
end;
var
v:Vrandom;
i:integer;
BEGIN
	randomize;
	i:=0;
	cargarVector (v, i, dimF);
	ordenarVector (v, dimF);
	ImprimirVector(v, dimF);
	
END.

