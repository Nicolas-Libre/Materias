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
var
v:Vdnumeros;
dimL:integer;
i:integer;

procedure ImprimirVector (v:Vdnumeros; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do begin
		writeln(v[i]);
	end;
end;
BEGIN
randomize;
dimL:=0;
i:=0;	
cargarVector (v,dimL,i);
imprimirVector (v, dimL);
END.

