program Practica2ej6;
Const
valor_alto = 9999999;

type
paraDet = record
	cod_loc: integer;
	cod_cepa: integer;
	cant_act: integer;
	cant_nuevos: integer;
	cant_recu: integer;
	cant_dead: integer;
end;

paraMas = record;
	dato: paraDet;
	nom_loc: string[30];
	nom_cepa: string [30];
end;

detalle = file of paraDet;
maestro = file of paraMas;
det_ar = array [1..10] of detalle;
regis = array [1..10] of paraDet;

procedure leer (var det: detalle; var info: paraDet);
begin
	if (not(EOF(det))) then begin
		read (det, info);
	end
	else
		info.cod_loc:= valor_alto;
end;

procedure buscarMinimo (var regiD: regis; pos:integer);
var
	i:integer;
	min: integer;
begin
	min:= valor_alto;
	for i:= 1 to 10 do begin
		if regiD[i].cod_loc < min then begin
			min:= regiD[i].cod_loc;
			pos:=i;
		end;
	end;
end;

procedure minimo (var detalles: det_ar; var regiD: regis; var min: paraDet);
var
	i:integer;
begin
	buscarMinimo (regiD, i);
	min:= regiD[i];
	leer (detalles[i], regiD[i]);
end;


var
	detalles: det_ar;
	regiD: regis;
	mas: maestro;
	regiM: paraMas;
	i:integer;
	min : paraDet;
begin
	assign (mas, 'master');
	reset (mas);
	
	for i:= 1 to 10 do begin
		assign (detalles[i], 'det' +i);
		reset (detalles[i]);
		leer (detalles[i], regiD[i]);
	end;
	minimo (detalles, regiD, min);
	while (min.cod_loc <> valor_alto) do begin
		read (mas, regiM);
		while (min.cod_loc <> regiM.dato.cod_loc) and (min.cod_cepa <> regiM.dato.cod_cepa) do begin
			read (mas, regiM);
		end;
		while (min.cod_loc = regiM.dato.cod_loc) and (min.cod_cepa = regiM.dato.cod_cepa) do begin
			regiM.dato.cant_dead:= regiM.dato.cant_dead + min.cant_dead;
			regiM.dato.cant_recu:= regiM.dato.cant_recu + min.cant_recu;
			regiM.dato.cant_act:= min.cant_act;
			regiM.dato.cant_nuevos:= min.cant_nuevos;
			minimo (detalles, regiD, min);
		end;
		write (mas, regiM);
	end;
end.
		






