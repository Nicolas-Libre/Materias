program P2ejercicio1;
type
Vdnumeros= array [1..15] of integer;


procedure CargarVector (var v:Vdnumeros; var dimL:integer; var i:integer);
var
x:integer;
begin
	dimL:=dimL+1;
	i:=i+1;

	x:= random (157-10)+9;
	
	v[i]:=x;
	if (x <> 20) and (dimL <15) then
		CargarVector (v,dimL,i);
end;


procedure ImprimirVector (v:Vdnumeros; dimL:integer; var i2:integer);
begin
	i2:=i2+1;
	if (v[i2] <> 20) and (dimL <15) then
		writeln (v[i2]);
		imprimirVector (v,dimL,i2);
end;
var
v:Vdnumeros;
dimL:integer;
i:integer;
i2:integer;
BEGIN
randomize;
dimL:=0;
i:=0;	
i2:=0;
cargarVector (v,dimL,i);
imprimirVector (v, dimL,i2);
END.

