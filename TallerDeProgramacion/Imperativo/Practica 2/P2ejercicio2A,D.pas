program P2ejercicio2A;
type
lista=^nodo;
nodo=record
	dato:integer;
	sig:lista;
end;
procedure cargarLista (var L:lista);
var
nuevo:lista;
x:integer;
begin
	x:=random (200-100+1) +100;
	
	If x<> 100 then begin
		new(nuevo);
		
		nuevo^.dato:=x;
		nuevo^.sig:=L;
		L:=nuevo;
		cargarLista (L);
	
	end;
	
end;

Procedure ImprimirLista (L:lista);
begin
	if L<>nil then begin
		writeln(L^.dato);
		L:=L^.sig;
		imprimirLista(L);
	end;
end;

procedure Minimo (L:lista; var min:integer);
begin
	If L<>nil then begin
		if L^.dato < min then
			min :=L^.dato;
		L:=L^.sig;
		minimo (L, min);
	end;
end;

var
	L:lista;
	min:integer;
BEGIN
	randomize;
	min:=9999;
	cargarLista (L);
	ImprimirLista (L);
	minimo (L, min);
	writeln( 'el minimo es ', min);
	
END.

