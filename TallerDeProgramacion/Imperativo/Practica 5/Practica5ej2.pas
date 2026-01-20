program Practica5ej2;
type
rangoAnio=1..2018;


auto = record
patente:integer;
anio:rangoAnio;
marca:string;
modelo:integer;
end;


arbolPatente =^nodoP;
nodoP=record
dato:auto;
hd:arbolPatente;
hi:arbolPatente;
end;

auxAuto= record
patente:integer;
anio:rangoAnio;
modelo:integer;
end;

listaAuto=^nodoL;
nodoL = record
dato:auxAuto;
sig:listaAuto;
end;

arbolMarca=^nodoM;
nodoM=record
marca:string;
dato:listaAuto;
hd:arbolMarca;
hi:arbolMarca
end;

auto2= record
marca:string;
patente:integer;
modelo:integer;
end;

listaAnio=^nodo;
nodo=record
dato:auto2;
sig:listaAnio;
end;

arbolAnio=^nodoA;
nodoA=record
anio:rangoAnio;
dato:listaAnio;
hd:arbolAnio;
hi:arbolAnio;
end;

procedure leerAuto (var au:auto);
begin
	writeln ('ingrese la marca');
	readln (au.marca);
	if au.marca <> 'MMM' then begin
		writeln ('ingrese la patente');
		readln (au.patente);
		writeln ('ingrese el anio');
		readln (au.anio);
		writeln ('ingrese el modelo');
		readln (au.modelo);
	end;
end;

procedure generarArbolP (var aP:arbolPatente; au:auto);
begin
	if aP = nil then begin
		new (aP);
		aP^.dato:=au;
		aP^.hd:=nil;
		aP^.hi:=nil;
	end
	else begin
		if au.patente < aP^.dato.patente then
			generarArbolP (aP^.hi,au)
		else
			generarArbolP (aP^.hd,au);
	end;
end;


procedure agregarAdelante (var L:listaAuto; au:auto);
var
	nuevo:listaAuto;
begin
	new (nuevo);
	nuevo^.dato.patente:=au.patente;
	nuevo^.dato.anio:=au.anio;
	nuevo^.dato.modelo:=au.modelo;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure generarArbolM (var aM: arbolMarca; au:auto);
begin
	if aM = nil then begin
		new (aM);
		aM^.marca:=au.marca;
		aM^.dato:=nil;
		agregarAdelante (aM^.dato,au);
		aM^.hi:=nil;
		aM^.hd:=nil;
	end
	else begin
		if aM^.marca < au.marca then begin
			generarArbolM (aM^.hi,au);
		end
		else 
			if aM^.marca > au.marca then begin
				generarArbolM (aM^.hd,au);
			end
			else
				agregarAdelante (aM^.dato,au);
	end;
end;

procedure cargarDatos (var aP:arbolPatente; var aM:arbolMarca);
var
	au:auto;
begin
	leerAuto (au);
	while au.marca <> 'MMM' do begin
		generarArbolP (aP,au);
		generarArbolM (aM,au);
		leerAuto (au);
	end;
end;


procedure ImprimirArbolP (aP:arbolPatente);
begin
	if aP <> nil then begin
		ImprimirArbolP (aP^.hi);
		writeln ('patente = ', aP^.dato.patente);
		writeln ('marca = ', aP^.dato.marca);
		writeln ('modelo = ', aP^.dato.modelo);
		writeln ('anio = ', aP^.dato.anio);
	
		ImprimirArbolP (aP^.hd);
	end;
end;

procedure ImprimirLista (L:listaAuto);
begin
	while L<> nil do begin
		writeln ('patente = ',L^.dato.patente);
		writeln ('modelo = ',L^.dato.modelo);
		writeln ('anio = ',L^.dato.anio);
		L:=L^.sig;
	end;
end;

procedure ImprimirArbolM (aM:arbolMarca);
begin
	if aM <> nil then begin
		writeln('------');
		writeln ('marca = ', aM^.marca, ', autos: ');
		writeln('');
		ImprimirLista (aM^.dato);
		writeln('');
		ImprimirArbolM (aM^.hi);
		ImprimirArbolM (aM^.hd);
	end;
end;

function cantMarca (aP:arbolPatente; m:string) : integer;
begin
	if aP = nil then
		cantMarca:=0
	else begin
		if aP^.dato.marca=m then begin
			cantMarca:= 1 + cantMarca (aP^.hi,m) + cantMarca (aP^.hd,m);
		end
		else 
			cantMarca:= cantMarca (aP^.hi,m) + cantMarca (aP^.hd,m);
	end;
end;

procedure cantMarca2 (aM:arbolMarca; m2:string; var cant:integer);
begin
	if aM <> nil then begin
		while aM^.dato <> nil do begin
			if aM^.marca = m2 then 
				cant:=cant+1;
			aM^.dato:=aM^.dato^.sig;
		end;
		cantMarca2 (aM^.hi,m2,cant);
		cantMarca2 (aM^.hd,m2,cant);
	end;
end;

procedure agregarAdelante2 (var L:listaAnio; au:auto);
var
	nuevo:listaAnio;
begin
	new (nuevo);
	nuevo^.dato.patente:=au.patente;
	nuevo^.dato.modelo:=au.modelo;
	nuevo^.dato.marca:=au.marca;
	nuevo^.sig:=L;
	L:=nuevo;
end;

procedure agregarArbolA (var aA:arbolAnio; au:auto);
begin
	if aA=nil then begin
		new (aA);
		aA^.anio:=au.anio;
		aA^.dato:=nil;
		agregarAdelante2 (aA^.dato,au);
		aA^.hd:=nil;
		aA^.hi:=nil;
	end
	else begin
		if au.anio < aA^.anio then
			agregarArbolA (aA^.hi,au)
		else
			if au.anio > aA^.anio then
				agregarArbolA (aA^.hd,au)
			else
				agregarAdelante2 (aA^.dato,au);
	end;
end;

procedure generarArbolA (var aA:arbolAnio; aP:arbolPatente);
begin
	if aP <> nil then begin
		agregarArbolA (aA,aP^.dato);
		generarArbolA (aA,aP^.hi);
		generarArbolA (aA,aP^.hd);
	end;
end;
procedure ImprimirLista2 (L:listaAnio);
begin
	while L <> nil do begin
		writeln ('patente = ', L^.dato.patente);
		writeln ('modelo = ', L^.dato.modelo);
		writeln ('marca = ', L^.dato.marca);
		L:=L^.sig;
	end;
end;

procedure ImprimirArbolA (aA:arbolAnio);
begin
	if aA <> nil then begin
		writeln ('anio = ', aA^.anio, ', autos: ');
		writeln ('');
		ImprimirLista2 (aA^.dato);
		writeln ('-----------');
		ImprimirArbolA (aA^.hi);
		ImprimirArbolA (aA^.hd);
	end;
end; 



function devolverModelo (aP:arbolPatente; p:integer) : integer;
begin
	if aP = nil then
		devolverModelo:=-1
	else begin
		if aP^.dato.patente=p then
			devolverModelo:=aP^.dato.modelo
		else
			if p > aP^.dato.patente then
				devolverModelo:= devolverModelo (aP^.hd,p)
			else
				if p < aP^.dato.patente then
					devolverModelo:= devolverModelo (aP^.hi,p);
	end;
end;

procedure BuscarPatente (L:listaAuto;  p:integer; var modelo2:integer; var sigo:boolean);
begin
	while (L <> nil) and (not sigo) do begin
		if (L^.dato.patente= p) then begin
			modelo2:=L^.dato.modelo;
			sigo:=true;
		end
		else
			L:=L^.sig;
	end;
end;
procedure devolverModelo2 ( aM:arbolMarca; p:integer; var modelo2:integer; var sigo:boolean);
begin
	if (aM <> nil) and (not sigo) then begin
		BuscarPatente (aM^.dato, p, modelo2,sigo);
		if (not sigo) then begin
			devolverModelo2 (aM^.hi,p, modelo2, sigo);
			devolverModelo2 (aM^.hd,p, modelo2, sigo);
		end;
	end;
end;

var
aP:arbolPatente;
aM:arbolMarca;
autosMarca:integer;
autosMarca2:integer;
aA:arbolAnio;
modelo:integer;
modelo2:integer;
sigo:boolean;
p:integer;
begin
	aP:=nil;
	aM:=nil;
	autosMarca:=0;
	cargarDatos (aP,aM);
	//ImprimirArbolP (aP);
	writeln('');
	writeln('');
	writeln('--------------');
	writeln('');
	writeln('');
	autosMarca:= cantMarca (aP,'2');
	writeln ('autos de la marca ingresada = ', autosMarca);
	ImprimirArbolM (aM);
	cantMarca2 (aM,'4', autosMarca2);
	writeln ('autos de la marca ingresada2 = ', autosMarca2);
	generarArbolA (aA,aP);
	//ImprimirArbolA (aA);
	modelo := devolverModelo (aP,2);
	writeln ('el modelo de la patente ingresada es = ', modelo);
	sigo:=false;
	readln (p);
	modelo2:=0;
	devolverModelo2 (aM,p,modelo2, sigo);
	if sigo then begin
		writeln ('el modelo 2 de la patente ingresada es = ', modelo2);
	end
	else
		writeln ('no se encontro');
end.

