program Parcial5GoogleDrive;
type
rangoDia=1..30;

envio=record
cliente:integer;
dia:rangoDia;
codigoPostal:integer;
peso:real;
end;

auxEnvio= record
cliente:integer;
dia:rangoDia;
peso:real;
end;

lista =^nodoL;
nodoL=record
dato:auxEnvio;
sig:lista;
end;


arbol=^nodo;
nodo=record
codigoPostal:integer;
dato:lista;
hd:arbol;
hi:arbol;
end;





procedure leerEnvio (var e:envio);
begin
	writeln ('ingrese el codigo de cliente');
	readln (e.cliente);
	if e.cliente <> 0 then begin
		writeln ('ingrese el dia');
		readln (e.dia);
		writeln ('ingrese el codigo postal');
		readln (e.codigoPostal);
		writeln ('ingrese el peso del paquete');
		readln (e.peso);
	end;
end;


procedure AgregarAdelante (var L:lista; envioAux:auxEnvio);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.dato:=envioAux;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarArbol (var a:arbol; e:envio);
var
	envioAux:auxEnvio;
begin
	if a=nil then begin
		new (a);
		a^.codigoPostal:=e.codigoPostal;
		envioAux.cliente:=e.cliente;
		envioAux.peso:=e.peso;
		envioAux.dia:=e.dia;
		a^.dato:=nil;
		AgregarAdelante (a^.dato,envioAux);
	end
	else begin
		if a^.codigoPostal = e.codigoPostal then begin
			envioAux.cliente:=e.cliente;
			envioAux.peso:=e.peso;
			envioAux.dia:=e.dia;
			AgregarAdelante (a^.dato,envioAux);
		end
		else 
			if e.codigoPostal < a^.codigoPostal then
				generarArbol(a^.hi,e)
			else
				generarArbol (a^.hd,e);
	end;
end;


procedure buscarLista (a:arbol; codPos:integer; var L2:lista);
begin
	if a <> nil then begin
		if codPos = a^.codigoPostal then begin
			L2:=a^.dato;
		end
		else begin
			if codPos>a^.codigoPostal then
				buscarLista(a^.hd,codPos,L2)
			else
				buscarLista (a^.hi,codPos,L2);
		end;
	end;
end;
	
	
	

	
procedure retornarMaxYMin (var codMax:integer; var codMin:integer; pesoMax:real;pesoMin:real; L2:lista);
begin
	if L2<> nil then begin
		if L2^.dato.peso > pesoMax then begin
			pesoMax:= L2^.dato.peso;
			codMax:=L2^.dato.cliente;
		end;
		if L2^.dato.peso < pesoMin then begin
			pesoMin:= L2^.dato.peso;
			codMin:=L2^.dato.cliente;
		end;
		retornarMaxYMin (codMax,codMin,pesoMax,pesoMin,L2^.sig);	
	end;
end;


procedure cargarDatos (var a:arbol);
var
	e:envio;
begin
	leerEnvio(e);
	while e.cliente <>0 do begin
		generarArbol(a,e);
		leerEnvio(e);
	end;
end;

procedure ImprimirLista (L:lista);
begin
	writeln ('Envios:');
	while L<>nil do begin
		writeln ('cliente = ', L^.dato.cliente);
		writeln ('dia = ',L^.dato.dia);
		writeln ('peso = ',L^.dato.peso:2:2);
		L:=L^.sig;
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a <> nil then begin
		ImprimirArbol(a^.hi);
		writeln ('codigoPostal= ', a^.codigoPostal);
		ImprimirLista (a^.dato);
		ImprimirArbol (a^.hd);
	end;
end;
var
	a:arbol;
	L2:lista;
	codPosABuscar:integer;
	codMax:integer;
	codMin:integer;
begin
	a:=nil;
	L2:=nil;
	cargarDatos(a);
	//ImprimirArbol (a);
	codPosABuscar:=2;
	buscarLista (a,codPosABuscar,L2);
	ImprimirLista (L2);
	retornarMaxYMin (codMax,codMin,0,99999,L2);
	writeln ('el codigo de cliente con mayor peso es ', codMax);
	writeln ('el codigo de cliente con menor peso es ', codMin);
end.
	

