program P4ejercicio4;
type
prestamo = record
	ISBN: integer;
	Nsocio:integer;
	dia:integer;
	diasPrestados:integer;
end;

Lista=^nodoL;
nodoL=record
	ISBN:integer;
	cantVeces:integer;
	sig:Lista;
end;

arbol=^nodo;
nodo=record
dato:prestamo;
HD,HI:arbol;
end;


procedure leerPrestamo (var p:prestamo);
begin
	writeln ('ingrese el ISBN');
	readln (p.ISBN);
	if p.ISBN <> 0  then begin
		writeln ('ingrese el numero de socio');
		readln (p.Nsocio);
		writeln ('ingrese el dia');
		readln (p.dia);
		writeln ('ingrese lods dias prestados');
		readln (p.diasPrestados);
	end;
end;

procedure GenerarArbol (var a:arbol; p:prestamo);
begin
	if a=nil then begin
		new (a);
		a^.dato:=p;
		a^.HD:= nil;
		a^.HI:= nil;
	end
	else begin
		if p.ISBN >= a^.dato.ISBN then begin
			GenerarArbol (a^.HD,p);
		end
		else
			GenerarArbol (a^.HI,p);
	end;
end;
		

procedure CargarDatos (var a:arbol);
var
p:prestamo;
begin
		leerPrestamo (p);
		while p.ISBN <> 0 do begin
			GenerarArbol (a,p);
			leerPrestamo (p);
		end;
end;

function retornarMaximoISBN (a:arbol):integer;
begin
	if a = nil then begin
		retornarMaximoISBN:=0;
	end
	else begin
		if a^.HD = nil then begin
			retornarMaximoISBN:=a^.dato.ISBN;
		end
		else
		retornarMaximoISBN:=retornarMaximoISBN (a^.HD);
	end;
end;


function retornarPrestamoSocio (a:arbol; i:integer): integer;
begin
	if a = nil then begin
		retornarPrestamoSocio:=0;
	end
	else begin
		if a^.dato.Nsocio = i then begin
			retornarPrestamoSocio:= retornarPrestamoSocio (a^.HI,i) + retornarPrestamoSocio (a^.HD,i) + 1;
		end
		else begin
			retornarPrestamoSocio:=retornarPrestamoSocio (a^.HI,i) + retornarPrestamoSocio (a^.HD,i);
		end;
	end;
end;



procedure InsertarOrdenado (var L:lista; ISBN:integer; cant:integer);
var
act:lista;
ant:lista;
nuevo:lista;
begin
	new (nuevo);
	nuevo^.ISBN:=ISBN;
	nuevo^.cantVeces:=cant;
	act:=L;
	ant:=L;
	while act<> nil do begin
		ant:=act;
		act:=act^.sig;
	end;
	if act=ant then
		L:=nuevo
	else
		ant^.sig:=nuevo;
	nuevo^.sig:=act;
end;

procedure GenerarLista (a:arbol; var x:integer; var L:lista);

begin
	
	if (a <> nil) then begin
		if a^.HD <> nil then begin
			if (a^.dato.ISBN = a^.HD^.dato.ISBN) then begin
				x:=x+1;
			end
			else begin
				InsertarOrdenado (L,a^.dato.ISBN,x);
			end;
		GenerarLista (a^.HD,x,L);
		InsertarOrdenado (L,a^.dato.ISBN,x);
		GenerarLista (a^.HI,x,L);

		end;
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a<>nil then begin
		ImprimirArbol (a^.HD);
		writeln ('el ISBN es ', a^.dato.ISBN);
		writeln ('el numero de socio es ', a^.dato.Nsocio);
		writeln ('el dia es ', a^.dato.dia);
		writeln ('los dias prestados fueron ', a^.dato.diasPrestados);
		ImprimirArbol (a^.HI);
	end;
end;

procedure ImprimirLista (L:lista);
begin
	while (L<>nil) do begin 
		writeln ('el ISBN ',L^.ISBN);
		writeln ('fue prestado una cantidad de veces igual a ', L^.cantVeces);
		L:=L^.sig;
	end;
end;

var
a:arbol;
x:integer;
i:integer;
prestamoSocio:integer;
L:lista;
z:integer;
BEGIN
		a:=nil;
		CargarDatos (a);
		ImprimirArbol(a);
		x:=retornarMaximoISBN (a);
		writeln ('el maximo ISBN es ', x);
		writeln ('ingrese el Numero de socio a evaluar');
		readln (i);
		prestamoSocio:= retornarPrestamoSocio (a, i);
		if PrestamoSocio=0 then 
			writeln ('el socio no se encuentra')
		else
		
			writeln ('la cantidad de prestamos del socio evaluado es ', prestamoSocio);
		z:=1;
		L:=nil;
		GenerarLista (a,z,L);
		
		ImprimirLista (L);
		
		
			
END.

