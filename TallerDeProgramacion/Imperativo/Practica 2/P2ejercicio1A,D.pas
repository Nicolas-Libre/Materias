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

procedure ImprimirVector (v:Vdnumeros; dimL:integer);
begin

	if (dimL <>0) then begin
		writeln (v[dimL]);
		imprimirVector (v,dimL-1);
	end;
end;
procedure ImprimirVectorSumaPar (v:Vdnumeros; dimL:integer; var suma:integer);
begin

	if (dimL <>0) then begin
		if (v[dimL] mod 2=0) then
			suma:=suma+v[dimL];
		ImprimirVectorSumaPar (v,dimL-1,suma);
	end;
end;
var
v:Vdnumeros;
dimL:integer;
i:integer;
suma:integer;

BEGIN
randomize;
dimL:=0;
i:=0;	
suma:=0;
cargarVector (v,dimL,i);
imprimirVector (v, dimL);
imprimirVectorSumaPar (v, dimL, suma);
writeln (suma);
END.

