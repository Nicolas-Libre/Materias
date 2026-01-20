program Practica1ej1;
type
rangoCod= 0..15;
rangoCant= 1..99;
venta = record
dia:string;
codigo: rangoCod;
cant: rangoCant;
end;

ArregloVentas = array [1..4] of venta;
	
ListaPar =^nodo;
nodo = record
dato:venta;
sig:ListaPar;
end;
procedure leerVenta (var v:venta);
begin
	writeln ('ingrese el codigo');
	readln (v.codigo);
	if (v.codigo <>0) then begin
		writeln ('ingrese el dia');
		readln (v.dia);
		writeln ('ingrese la cant');
		readln (v.cant);
	end;
end;



procedure cargarDatos (var A: ArregloVentas; var dimL:integer);
var
	v:venta;
begin
	leerVenta (v);
	while (v.codigo <>0) and (dimL<4) do begin
		dimL:=dimL+1;
		A[dimL]:=v;
		if (dimL<4) then
			leerVenta (v);
	end;
end;
procedure OrdenarVector (var A:ArregloVentas; dimL:integer);
var
	i,j,p:integer;
	item:venta;
begin
	for i:= 1 to (dimL-1) do begin
		p:=i;
		for j:= (i+1) to dimL do begin
			if (A[j].codigo < A[p].codigo) then begin
				p:=j;
			end;
		end;
		item:= A[p];
		A[p]:=A[i];
		A[i]:=item;
	end;
end;

procedure AgregarAdelante (var L:ListaPar; v:venta);
var
	nuevo:ListaPar;
begin
	new (nuevo);
	nuevo^.dato:= v;
	nuevo^.sig:=L;
	L:=nuevo;
end;
procedure cargarLista (var L: ListaPar; A:ArregloVentas; auxDimL:integer; dimL:integer; var tot:integer);
begin
	if (auxDimL <= dimL) then begin
		tot:=tot+ A[auxDimL].cant;
		if ((A[auxdimL].codigo mod 2)=0) then begin
			AgregarAdelante (L,A[auxDimL]);
		end;
		auxDimL:=auxDimL+1;
		cargarLista (L,A,auxDimL,dimL,tot);
	end;
end;
procedure ImprimirVector (A: ArregloVentas; dimL:integer);
begin
	if (dimL<>0) then begin
		writeln (' el codigo es ' ,A[dimL].codigo);
		writeln (' el dia es ', A[dimL].dia);
		writeln (' la cantidad es ', A[dimL].cant);
		dimL:=dimL-1;
		ImprimirVector (A,dimL);
	end;
end;

procedure ImprimirListaYTot (L: ListaPar);
begin
	if (L <> nil) then begin
		writeln (' el codigo par es ' ,L^.dato.codigo);
		writeln (' el dia es ', L^.dato.dia);
		writeln (' la cantidad es ', L^.dato.cant);
		L:=L^.sig;
		ImprimirListaYTot (L)
	end;
end;
	
var
	A:ArregloVentas;
	dimL:integer;
	tot:integer;
	auxDimL:integer;
	L: ListaPar;
begin
	L:=nil;
	dimL:=0;
	auxDimL:=1;
	tot:=0;
	cargarDatos (A, dimL);
	OrdenarVector (A,dimL);
	cargarLista (L,A,auxDimL,dimL,tot);
	ImprimirListaYTot (L);
	writeln (' la cantidad total es ', tot);
end.
