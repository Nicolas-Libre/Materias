program Parcial3GoogleDrive;
Const
	dimF=12;
type

rangoMes=1..dimF;
rangoChar='L'..'P';


atencion=record
matricula:integer;
dni:integer;
mes: rangoMes;
diagnostico: rangoChar;
end;


lista=^nodoL;
nodoL=record
codDiagnostico:String;
sig:lista;
end;

arbol=^nodo;
nodo=record
dni:integer;
dato:lista;
hd:arbol;
hi:arbol;
end;


vecAtenciones= array [rangoMes] of arbol;

procedure leerAtencion (var at:atencion);
begin
	writeln ('ingrese su matricula');
	readln (at.matricula);
	if at.matricula<>0 then begin
		writeln ('ingrese su dni');
		readln (at.dni);
		writeln ('ingrese el mes');
		readln (at.mes);
		writeln ('ingrese el diagnostico');
		readln (at.diagnostico);
	end;
end;


procedure AgregarAdelante (var L:lista; diag:String);
var
	nuevo:lista;
begin
	new (nuevo);
	nuevo^.codDiagnostico:=diag;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarArbol (var a:arbol; dni:integer; diag:string);
begin
	if a=nil then begin
		new (a);
		a^.dni:=dni;
		a^.dato:=nil;
		AgregarAdelante (a^.dato, diag);
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else begin
		if dni > a^.dni then
			generarArbol (a^.hd,dni,diag)
		else
			if dni < a^.dni then
				generarArbol (a^.hi,dni,diag)
			else
				AgregarAdelante (a^.dato,diag);
	end;
end;

procedure inicializarVector (var v:vecAtenciones);
var
	i:rangoMes;
begin
	for i:=1 to dimF do begin
		v[i]:=nil;
	end;
end;

procedure hacerVector (var v:vecAtenciones; at:atencion);
begin
	generarArbol (v[at.mes], at.dni, at.diagnostico);
end;
		

procedure cargarDatos (var v:vecAtenciones);
var
	at:atencion;
begin
	leerAtencion (at);
	while (at.matricula <> 0) do begin
		hacerVector (v,at);
		leerAtencion (at);
	end;
end;


procedure contarLista (L:lista; var cant:integer);
begin
	while L<> nil do begin
		cant:=cant+1;
		L:=L^.sig;
	end;
end;

procedure contarArbol (a:arbol; var cant:integer);
begin
	if a<> nil then begin	
		contarLista (a^.dato,cant);
		contarArbol(a^.hi,cant);
		contarArbol (a^.hd,cant);
	end;
end;
		


procedure maxMes (v: vecAtenciones; var mayorMes:rangoMes);
var
	i:rangoMes;
	maxCant:integer;
	cant:integer;
begin
	maxCant:=0;
	for i:= 1 to dimF do begin
		cant:=0;
		contarArbol (v[i], cant);
		if cant> maxCant then begin
			maxCant:=cant;
			mayorMes:=i;
		end;
	end;
end;


procedure buscarEnArbol (a:arbol; unDni:integer; var encontre:boolean);
begin
	if a<> nil then begin
		if a^.dni = unDni then
			encontre:=true
		else
			if unDni > a^.dni then
				buscarEnArbol (a^.hd,unDni,encontre)
			else
				buscarEnArbol (a^.hi,unDni,encontre);
	end;
end;

function recibirPaciente (v:vecAtenciones; unDni: integer): boolean;
var
	ok:boolean;
	i:rangoMes;
begin
	ok:=false;
	i:=1;
	while ((ok=false) and (i < dimF)) do begin
		buscarEnArbol (v[i], unDni, ok);
		if ok=false then
			i:=i+1;
	end;
	recibirPaciente:=ok;
end;


procedure ImprimirLista (L:lista);
begin
	while L <> nil do begin
		writeln ('Diagnosticos = ', L^.codDiagnostico);
		L:=L^.sig;
	end;
end;

procedure ImprimirArbol (a:arbol);
begin
	if a<> nil then begin
		writeln ('DNI= ', a^.dni);
		ImprimirLista (a^.dato);
		ImprimirArbol (a^.hi);
		ImprimirArbol (a^.hd);
	end;
end;

procedure ImprimirVector (v:vecAtenciones);
var
	i:rangoMes;
begin
	for i:= 1 to dimF do begin
		if v[i] <> nil then begin
			writeln('--------------');
			writeln ('Mes: ', i);
			writeln('--------------');
			ImprimirArbol(v[i]);
		end
		else begin
			writeln('--------------');
			writeln ('el mes ', i, ' esta vacio');
			writeln('--------------');
		end;
	end;
end;


var
	v:vecAtenciones;
	mayorMes:rangoMes;
	encontreDni:boolean;
begin
	inicializarVector (v);
	cargarDatos(v);
	ImprimirVector (v);
	mayorMes:=1;
	maxMes(v,mayorMes);
	writeln ('el mes con mas atenciones fue el mes ', mayorMes);
	encontreDni:=recibirPaciente(v,2);
	if encontreDni=false then
		writeln ('no se encontro')
	else
		writeln ('se encontro')


end.










