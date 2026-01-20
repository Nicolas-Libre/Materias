program Practica2ej1;
Const
dimF=9;
type

VectorInteger= array [1..dimF] of integer;



procedure random15 (var v:VectorInteger; var dimL:integer);
var
	x:integer;
begin
	x:= Random (146);
	x:=x+10;
	if ((dimL<dimF) and (x<>20)) then begin
		dimL:=dimL+1;
		v[dimL]:=x;
		random15 (v,dimL);
	end;
end;

procedure ImprimirVector (v:VectorInteger; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do begin
		writeln ('numero generado es ', v[i]);
	end;
end;

procedure ImprimirVectorR (v:VectorInteger; dimL:integer);
begin
	if (dimL<>0) then begin
		writeln ('numero generado es ', v[dimL]);
		ImprimirVector (v,(dimL-1));
	end;
end;

function devolverSuma (v:VectorInteger; dimL:integer) : integer;
begin
	if dimL = 0 then
		devolverSuma:=0
	else
		devolverSuma:= v[dimL] + devolverSuma (v,dimL-1);
		
	
end;

function devolverMaximo (v:VectorInteger;dimL:integer; nMax:integer) : integer;
begin
	if (dimL = 0) then
		devolverMaximo:=nMax
	else begin
		if (v[dimL] > nMax) then 
			nMax:=v[dimL];
		devolverMaximo:= devolverMaximo (v,dimL-1,nMax);
	end;
end;

function devolverSumaPar (v:VectorInteger; dimL:integer) : integer;
begin
	if dimL=0 then 
		devolverSumaPar:=0
	else
		if ((v[dimL]mod 2)=0) then begin
			devolverSumaPar:= v[dimL] + devolverSumaPar (v,dimL-1);
		end
		else
			devolverSumaPar:= 0 + devolverSumaPar (v,dimL-1);
	end;

function EncontrarValor (v:VectorInteger; dimL:integer; x:integer) : boolean;
begin
	if (dimL = 0) then
		EncontrarValor:=false
	else
		if (v[dimL] = x) then 
			EncontrarValor:=true
		else
			EncontrarValor:= EncontrarValor (v,dimL-1,x);
	end;




procedure ImprimirDigitos (v:VectorInteger; dimL:integer);
var
	dig:integer;
	n:integer;
begin
	if dimL> 0 then begin
		dig:=v[dimL];
		while (dig <> 0) do begin
			n:=dig mod 10;
			dig:=dig div 10;
			writeln (n);
			
		end;
		writeln ('---');
		ImprimirDigitos (v,dimL-1);
	end;
end;

var
	v:VectorInteger;
	dimL:integer;
	Max:integer;
	suma:integer;
	Encontre:boolean;
begin
	Randomize;
	dimL:=0;

	random15 (v,dimL);
	writeln('la dimL es igual a ', dimL);
	ImprimirVector (v,dimL);
	writeln('');
	writeln ('');
	writeln ('-----------------------');
	writeln('');
	writeln ('');
	max:=devolverMaximo (v,dimL,0);
	writeln ('el maximo es ', max);
	suma:= devolverSumaPar (v,dimL);
	writeln ('la suma de los numero es ', suma);
	Encontre:=EncontrarValor (v,dimL,124);

	if Encontre then
		writeln ('El valor se encontro')
	else
		writeln ('No se encontro');
	ImprimirDigitos (v,dimL);

end.



	
