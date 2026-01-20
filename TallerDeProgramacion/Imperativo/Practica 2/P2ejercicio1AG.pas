program P2ejercicio1AE;
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

//posible pregunta, no es muy necesaria
procedure ImprimirdigitosVector (v:Vdnumeros; dimL:integer);
var
	dig:integer;
begin
	if dimL<>0 then begin
		
		while v[dimL] <> 0 do begin
			dig:=(v[dimL] mod 10);
			writeln ('la cifra es ', dig);
			v[dimL]:=(v[dimL] div 10);
			
		end;
		ImprimirDigitosVector (v,dimL-1);
	end;
end;
var
v:Vdnumeros;
dimL:integer;
i:integer;

BEGIN
randomize;
dimL:=0;
i:=0;	

cargarVector (v,dimL,i);



imprimirdigitosVector (v, dimL);

END.
