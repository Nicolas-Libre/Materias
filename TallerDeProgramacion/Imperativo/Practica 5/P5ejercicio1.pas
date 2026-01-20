program P5ejercicio1;
const
dimF=300;
type
rangoOficina=1..dimF;

oficina = record
	codigo:integer;
	DNI:integer;
	valorExpensa:integer;
end;



Voficina= array [rangoOficina] of oficina;



procedure leerOficina (var o:oficina);
begin
	writeln ('ingrese el codigo (0paraterminar)');
	readln (o.codigo);
	if o.codigo <> 0 then begin
		writeln ('ingrese el DNI ');
		readln (o.DNI);
		writeln ('ingrese el valor de su expensa ');
		readln (o.valorExpensa);
	end;
end;

procedure CargarVector (var v:Voficina; o:oficina; var dimL:integer);
begin
	v[dimL]:=o;
end;
	
procedure OrdenarVector (var v:Voficina; dimL:integer);
var
i,j,p:integer;
item:oficina;
begin
	for i:= 1 to dimL-1 do begin
		p:=i;
		for j:= i+1 to dimL do begin
			if v[j].codigo < v[p].codigo  then begin
				p:=j;;
			end;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;
				
function MontoTotalExpensas (v:Voficina; dimL:integer):real;

begin
	if dimL=0 then begin
		MontoTotalExpensas:=0;
	end
	else begin
		MontoTotalExpensas:=MontoTotalExpensas (v,dimL-1) + v[dimL].valorExpensa;
	end;
end;

procedure ImprimirVector (v:Voficina; dimL:integer);
var
i:integer;
begin
	for i:=1 to dimL do begin
		writeln ('el codigo es ', v[i].codigo);
		writeln ('el dni es ', v[i].DNI);
		writeln ('el valor de su expensa es ', v[i].valorExpensa);
	end;
end;
var
o:oficina;
v:Voficina;
dimL:integer;
x:real;


BEGIN
	dimL:=0;
	leerOficina (o);
	while o.codigo <> 0 do begin
		dimL:=dimL+1;
		CargarVector (v,o,dimL);
		leerOficina (o);
	end;
	OrdenarVector (v,dimL);
	ImprimirVector (v,dimL);
	x:= MontoTotalExpensas (v,dimL);
	writeln ('el monton total es ', x:2:2);
	
END.

