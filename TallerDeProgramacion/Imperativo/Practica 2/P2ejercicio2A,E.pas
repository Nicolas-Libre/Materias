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
	x:=(random (20-10+1) +10);
	
	If x<> 10 then begin
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
// preguntar funcion
// si no es el primer elemento
// la funcion devuelve siempre false
function Encontre (L:lista; a:integer) :boolean;
var
aux:boolean;
begin
	if (L <> nil) then begin
		if L^.dato <> a then begin
			aux:=false;
			encontre (L^.sig,a);
		end;
	end
	else 
		aux:=true;
	encontre:=aux;
	
end;
	
		
var
	L:lista;


	a:integer;
BEGIN
	randomize;
	readln (a);
	cargarLista (L);
	ImprimirLista (L);
	writeln (encontre (L,a));
	
	
END.

